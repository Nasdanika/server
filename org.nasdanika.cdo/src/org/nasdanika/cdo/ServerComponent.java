package org.nasdanika.cdo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.cdo.server.CDOServerUtil;
import org.eclipse.emf.cdo.server.IRepository;
import org.eclipse.emf.cdo.server.net4j.CDONet4jServerUtil;
import org.eclipse.emf.cdo.spi.server.RepositoryFactory;
import org.eclipse.net4j.ITransportConfigAware;
import org.eclipse.net4j.Net4jUtil;
import org.eclipse.net4j.acceptor.IAcceptor;
import org.eclipse.net4j.buffer.IBufferPool;
import org.eclipse.net4j.jvm.IJVMAcceptor;
import org.eclipse.net4j.jvm.JVMUtil;
import org.eclipse.net4j.tcp.ITCPAcceptor;
import org.eclipse.net4j.tcp.TCPUtil;
import org.eclipse.net4j.tcp.ssl.SSLUtil;
import org.eclipse.net4j.util.container.ContainerUtil;
import org.eclipse.net4j.util.container.IElementProcessor;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.eclipse.net4j.util.security.ChallengeNegotiator;
import org.eclipse.net4j.util.security.INegotiationContext;
import org.eclipse.net4j.util.security.INegotiator;
import org.eclipse.net4j.util.security.Randomizer;
import org.eclipse.net4j.util.security.UserManager;
import org.eclipse.spi.net4j.Acceptor;
import org.osgi.service.component.ComponentContext;

/**
 * CDO Server component.
 * @author Pavel Vlasov
 *
 */
public class ServerComponent {
	
	protected static final String TCP_PREFIX = "tcp:";
	protected static final String SSL_PREFIX = "ssl:";
	protected static final String JVM_PREFIX = "jvm:";

	private static final String ACCEPTORS_PROPERTY = ".acceptors";

	private Collection<IRepository> repositories = new ArrayList<>();
	private Collection<IAcceptor> acceptors = new ArrayList<>();
	private IManagedContainer container;
	
	public void activate(ComponentContext context) {
		container = ContainerUtil.createContainer();
		
//		String tcpLogin = (String) context.getProperties().get("tcp-login");
//		String tcpPassword = (String) context.getProperties().get("tcp-password");
//		
//		// Authentication
//		if (tcpLogin != null && tcpPassword != null) {
//			
//			container.addPostProcessor(new IElementProcessor() {
//	
//				public Object process(
//						IManagedContainer container, 
//						String productGroup, 
//						String factoryType,
//						String description, 
//						Object element) {
//					
//					if (element instanceof ITCPAcceptor && element instanceof ITransportConfigAware) {						
//						ITransportConfigAware acceptor = (ITransportConfigAware) element;
//						INegotiator negotiator = createNegotiator();
//						acceptor.getConfig().setNegotiator(negotiator);
//						IBufferPool bPool = Net4jUtil.createBufferPool();
//						LifecycleUtil.activate(bPool);
//						acceptor.getConfig().setBufferProvider(bPool);
//					}
//					return element;
//				}
//	
//				private INegotiator createNegotiator() {
//					ChallengeNegotiator negotiator = new ChallengeNegotiator() {
//						
//						@Override
//						public void negotiate(INegotiationContext context) {
//							try {
//								// TODO Auto-generated method stub
//								super.negotiate(context);
//							} catch (Exception e) {
//								e.printStackTrace();
//							}
//						}
//						
//						@Override
//						protected void doActivate() throws Exception {
//							// TODO Auto-generated method stub
//							super.doActivate();
//						}
//						
//					};
//					UserManager userManager = new UserManager();
//					userManager.addUser(tcpLogin, tcpPassword.toCharArray());
//					userManager.activate();
//					negotiator.setUserManager(userManager);
//					Randomizer randomizer = new Randomizer();
//					randomizer.activate();
//					negotiator.setRandomizer(randomizer);
//					return negotiator;
//				}
//			});
//		}
		
		Net4jUtil.prepareContainer(container); 
		JVMUtil.prepareContainer(container);
		TCPUtil.prepareContainer(container);
		SSLUtil.prepareContainer(container);
		CDONet4jServerUtil.prepareContainer(container);
		
		LifecycleUtil.activate(container);
		for (IRepository repository: repositories) {
			CDOServerUtil.addRepository(container, repository);
		}
		repositories.clear();
				
		Object ap = context.getProperties().get(ACCEPTORS_PROPERTY);
		if (ap instanceof String) {
			addAcceptor((String) ap);
		} else if (ap instanceof String[]) {
			for (String as: (String[]) ap) {
				addAcceptor(as);
			}
		}
	}

	private void addAcceptor(String acceptorString) {
		String nas = acceptorString.trim();
		if (nas.startsWith(TCP_PREFIX)) {
			ITCPAcceptor acceptor = TCPUtil.getAcceptor(container, nas.substring(TCP_PREFIX.length()));
			LifecycleUtil.activate(acceptor);
			acceptors.add(acceptor);
		} else if (nas.startsWith(SSL_PREFIX)) {
			ITCPAcceptor acceptor = SSLUtil.getAcceptor(container, nas.substring(SSL_PREFIX.length()));
			LifecycleUtil.activate(acceptor);
			acceptors.add(acceptor);
		} else if (nas.startsWith(JVM_PREFIX)) {
			IJVMAcceptor acceptor = JVMUtil.getAcceptor(container, nas.substring(JVM_PREFIX.length()));
			LifecycleUtil.activate(acceptor);
			acceptors.add(acceptor);					
		} else {
			System.err.println("Unsupported acceptor: "+acceptorString);
		}
	}
	
	public void deactivate() {
		for (IAcceptor a: acceptors) {
			LifecycleUtil.deactivate(a);
		}
		LifecycleUtil.deactivate(container);
		container = null;
		repositories.clear();
	}

	public void addRepository(RepositoryProvider provider, Map<?,?> properties) {
		//System.out.println("Add repository: "+provider.getRepository()+" "+properties);
		if (container == null) {
			repositories.add(provider.getRepository());
		} else {
			CDOServerUtil.addRepository(container, provider.getRepository());
		}
	}

	public void removeRepository(RepositoryProvider provider, Map<?,?> properties) {
		if (container == null) {
			repositories.remove(provider.getRepository());
		} else {
		    String productGroup = RepositoryFactory.PRODUCT_GROUP;
		    String type = RepositoryFactory.TYPE;
		    String name = provider.getRepository().getName();

			container.removeElement(productGroup, type, name);
		}
	}

}
