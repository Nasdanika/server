package org.nasdanika.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Base class for commands which does nothing in ``close()`` and returns true from
 * ``canExecute()``. Also provides ``bind()`` methods.
 * @author Pavel
 *
 * @param <C>
 * @param <T>
 * @param <R>
 */
public abstract class AbstractCommand<C extends Context, T, R> implements Command<C,T,R> {

	@Override
	public void close() throws Exception {
		// NOP		
	}

	@Override
	public boolean canExecute() {
		return true;
	}
	
	public AbstractCommand<C,T,R> bind(@SuppressWarnings("unchecked") final T... boundArgs) {
		return new AbstractCommand<C,T,R>() {

			@SuppressWarnings("unchecked")
			@Override
			public R execute(C context, T... args) throws Exception {
				T[] joinedArgs = (T[]) new Object[boundArgs.length+args.length];
				System.arraycopy(boundArgs, 0, joinedArgs, 0, boundArgs.length);
				System.arraycopy(args, 0, joinedArgs, boundArgs.length, args.length);
				return AbstractCommand.this.execute(context, joinedArgs);
			}
		};
	}

	public AbstractCommand<C,T,R> bind(final Map<Integer, T> boundArgs) {
		return new AbstractCommand<C,T,R>() {

			@SuppressWarnings("unchecked")
			@Override
			public R execute(C context, T... args) throws Exception {
				int bIdx = -1;
				for (Integer idx: boundArgs.keySet()) {
					if (idx>bIdx) {
						bIdx = idx;
					}
				}
				List<T> joinedArgs = new ArrayList<>();
				int aIdx = 0;
				for (int idx=0; idx<=bIdx; ++idx) {
					if (boundArgs.containsKey(idx)) {
						joinedArgs.add(boundArgs.get(idx));
					} else if (aIdx<args.length) {
						joinedArgs.add(args[aIdx++]);
					} else {
						joinedArgs.add(null);
					}						
				}
				while (aIdx<args.length) {
					joinedArgs.add(args[aIdx++]);
				}
				return AbstractCommand.this.execute(context, (T[]) joinedArgs.toArray(new Object[joinedArgs.size()]));
			}
		};
				
	}

}
