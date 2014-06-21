/**
 */
package org.nasdanika.cdo.boxing.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.CDOViewContext;
import org.nasdanika.cdo.boxing.BoxingException;
import org.nasdanika.cdo.boxing.BoxingPackage;
import org.nasdanika.cdo.boxing.SerializableBox;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Serializable Box</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.boxing.impl.SerializableBoxImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SerializableBoxImpl extends CDOObjectImpl implements SerializableBox {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SerializableBoxImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BoxingPackage.Literals.SERIALIZABLE_BOX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getValue() {
		return (byte[])eGet(BoxingPackage.Literals.SERIALIZABLE_BOX__VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(byte[] newValue) {
		eSet(BoxingPackage.Literals.SERIALIZABLE_BOX__VALUE, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Serializable get(@SuppressWarnings("rawtypes") final CDOViewContext context) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(getValue())) {
				
				{
					enableResolveObject(true);
				}
				
				@Override
				protected Object resolveObject(Object obj) throws IOException {
					if (obj instanceof CDOID) {
						return context.getView().getObject((CDOID) obj);
					}
					return obj;
				}
				
			};
			
			try {
				return (Serializable) ois.readObject();
			} finally {
				ois.close();
			}
		} catch (IOException | ClassNotFoundException e) {
			throw new BoxingException(e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void set(Serializable value, @SuppressWarnings("rawtypes") final CDOViewContext context) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {			
			ObjectOutputStream oos = new ObjectOutputStream(baos) {
				
				{
					enableReplaceObject(true);
				}
				
				@Override
				protected Object replaceObject(Object obj) throws IOException {
					if (obj instanceof CDOObject) {
						CDOID cdoID = ((CDOObject) obj).cdoID();
						if (cdoID!=null) {
							return cdoID;
						}
					}
					
					return obj;
				}
			
			};
			try {
				oos.writeObject(value);
			} finally {
				oos.close();
			}			
		} catch (IOException e) {
			throw new BoxingException(e);
		}
		setValue(baos.toByteArray());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case BoxingPackage.SERIALIZABLE_BOX___GET__CONTEXT:
				return get((CDOViewContext)arguments.get(0));
			case BoxingPackage.SERIALIZABLE_BOX___SET__OBJECT_CONTEXT:
				set((Serializable)arguments.get(0), (CDOViewContext)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //SerializableBoxImpl
