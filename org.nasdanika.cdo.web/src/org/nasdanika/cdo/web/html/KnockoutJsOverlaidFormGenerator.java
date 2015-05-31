package org.nasdanika.cdo.web.html;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.nasdanika.core.Context;
import org.nasdanika.html.FontAwesome.Spinner;
import org.nasdanika.html.Form;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Tag;
import org.nasdanika.html.UIElement;
import org.nasdanika.html.UIElementFilter;

public class KnockoutJsOverlaidFormGenerator {
	
	private KnockoutJsFormGeneratorBase<?, ?> formGenerator;
	private String onSubmitted;
	private String cancelHandler;
	private HTMLFactory htmlFactory;
	private String objectPath;

	protected KnockoutJsOverlaidFormGenerator(
			KnockoutJsFormGeneratorBase<?,?> formGenerator, 
			HTMLFactory htmlFactory,
			String objectPath,
			String onSubmitted, 
			String cancelHandler) {
		this.formGenerator = formGenerator;
		this.htmlFactory = htmlFactory;
		this.objectPath = objectPath;
		this.onSubmitted = onSubmitted;
		this.cancelHandler = cancelHandler;
	}
	 
	public KnockoutJsOverlaidFormGenerator(
		EOperation eOperation, 
		HTMLFactory htmlFactory,
		String objectPath,
		String onSubmitted, 
		String cancelHandler) {
		this(
				new KnockoutJsEOperationFormGenerator(eOperation, "model", "submitHandler",	cancelHandler==null ? null : "cancelHandler"),
				htmlFactory,
				objectPath,
				onSubmitted, 
				cancelHandler);
	}
	 
	public KnockoutJsOverlaidFormGenerator(
		EClass eClass, 
		HTMLFactory htmlFactory,
		String objectPath,
		String onSubmitted, 
		String cancelHandler) {
		this(
				new KnockoutJsEClassFormGenerator(eClass, "model", "submitHandler",	cancelHandler==null ? null : "cancelHandler"),
				htmlFactory,
				objectPath,
				onSubmitted, 
				cancelHandler);
	}
	
	public interface OverlaidFormContainer extends UIElement<Tag> {
		
		Form getForm();
		
	}
	
	private class OverlaidFormContainerImpl extends UIElementFilter<Tag> implements OverlaidFormContainer {

		private Form form;
		private HTMLFactory htmlFactory;

		OverlaidFormContainerImpl(Tag target, HTMLFactory htmlFactory, Form form) {
			super(target);
			this.htmlFactory = htmlFactory;
			this.form = form;
		}

		@Override
		public Form getForm() {
			return form;
		}
		
		@Override
		public String toString() {
			if (getId()==null) {
				id("overlaidFormContainer_"+htmlFactory.nextId());
			}
			return super.toString();
		}
		
	}
	
	public OverlaidFormContainer generateOverlaidFormContainer(Object... overlayContent) throws Exception {
		Form form = formGenerator.generateForm(htmlFactory);
		final Tag containerDiv = htmlFactory.div(htmlFactory.overlay(overlayContent).style("display", "none"), form);
		containerDiv.content(new Object() {
			
			@Override
			public String toString() {
				KnockoutJsOverlaidFormModuleGenerator<Context, Object> generator = new KnockoutJsOverlaidFormModuleGenerator<>();
				String script;
				try {
					script = generator.execute(
							null, 
							objectPath, 
							formGenerator.generateModel(),
							containerDiv.getId(),
							onSubmitted,
							cancelHandler);
					return htmlFactory.tag(Tag.TagName.script, script).toString();
				} catch (Exception e) {
					e.printStackTrace();
					return e.toString();
				}
			}
			
		});
		
		return new OverlaidFormContainerImpl(containerDiv, htmlFactory, form);
	}
	
	public OverlaidFormContainer generateSpinnerOverlaidFormContainer(Spinner spinner) throws Exception {
		Form form = formGenerator.generateForm(htmlFactory);
		final Tag containerDiv = htmlFactory.div(htmlFactory.spinnerOverlay(Spinner.spinner).style("display", "none"), form);
		containerDiv.content(new Object() {
			
			@Override
			public String toString() {
				KnockoutJsOverlaidFormModuleGenerator<Context, Object> generator = new KnockoutJsOverlaidFormModuleGenerator<>();
				String script;
				try {
					script = generator.execute(
							null, 
							objectPath, 
							formGenerator.generateModel(),
							containerDiv.getId(),
							onSubmitted,
							cancelHandler);
					return htmlFactory.tag(Tag.TagName.script, script).toString();
				} catch (Exception e) {
					e.printStackTrace();
					return e.toString();
				}
			}
			
		});
		
		return new OverlaidFormContainerImpl(containerDiv, htmlFactory, form);
	}

}
