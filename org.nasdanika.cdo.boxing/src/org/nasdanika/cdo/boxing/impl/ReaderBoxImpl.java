/**
 */
package org.nasdanika.cdo.boxing.impl;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.boxing.BoxingException;
import org.nasdanika.cdo.boxing.BoxingPackage;
import org.nasdanika.cdo.boxing.ReaderBox;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reader Box</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.boxing.impl.ReaderBoxImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReaderBoxImpl extends CDOObjectImpl implements ReaderBox {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReaderBoxImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BoxingPackage.Literals.READER_BOX;
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
	public String getValue() {
		return (String)eGet(BoxingPackage.Literals.READER_BOX__VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		eSet(BoxingPackage.Literals.READER_BOX__VALUE, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Reader get(Context context) {
		return new StringReader(getValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void set(Reader value, Context context) {
		StringWriter sw = new StringWriter();
		try {
			try {
				try {
					char[] cbuf = new char[4096];
					int l;
					while ((l=value.read(cbuf))!=-1) {
						sw.write(cbuf, 0, l);
					}
				} finally {
					value.close();
				}
			} finally {
				sw.close();
			}
			setValue(sw.toString());
		} catch (IOException e) {
			throw new BoxingException(e);
		}
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
			case BoxingPackage.READER_BOX___GET__CONTEXT:
				return get((Context)arguments.get(0));
			case BoxingPackage.READER_BOX___SET__OBJECT_CONTEXT:
				set((Reader)arguments.get(0), (Context)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //ReaderBoxImpl
