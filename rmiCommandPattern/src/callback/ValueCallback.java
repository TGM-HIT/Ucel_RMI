/**
 * 
 */
package callback;

import java.rmi.RemoteException;

/**
 * @author Johannes Ucel
 * @version 02. Apr. 2016
 * @param <T>
 *
 */
public class ValueCallback<T> implements Callback<T>{

	/* (non-Javadoc)
	 * @see callback.Callback#receiveValue(java.lang.Object)
	 */
	@Override
	public void receiveValue(T value) throws RemoteException {
		System.out.println(value);
	}
}
