/**
 * 
 */
package callback;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Generisches Callback Interface, welches einen generischen Typ empf�ngt
 * 
 * @author Johannes Ucel
 * @version 02. Apr. 2016
 *
 */
public interface Callback<T> extends Remote {

	/**
	 * Hier wird ein generischer Typ empfangen
	 * 
	 * @param value
	 *            der empfangene Wert
	 * @throws RemoteException
	 */
	public void receiveValue(T value) throws RemoteException;
}
