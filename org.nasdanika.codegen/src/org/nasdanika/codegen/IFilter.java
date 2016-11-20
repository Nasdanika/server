package org.nasdanika.codegen;

import org.eclipse.core.runtime.IProgressMonitor;

public interface IFilter<T> {

	T filter(T input, IProgressMonitor monitor) throws Exception;
	
}
