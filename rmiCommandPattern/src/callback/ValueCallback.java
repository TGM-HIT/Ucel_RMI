/**
 * 
 */
package callback;

import java.rmi.RemoteException;

/**
 * Diese Klasse gibt einfach den Wert von dem generischen Typen aus
 * 
 * @author Johannes Ucel
 * @version 02. Apr. 2016
 * @param <T>
 *
 */
public class ValueCallback<T> implements Callback<T> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see callback.Callback#receiveValue(java.lang.Object)
	 */
	@Override
	public void receiveValue(T value) throws RemoteException {
		System.out.println(value);
	}
}
