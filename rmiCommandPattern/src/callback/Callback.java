/**
 * 
 */
package callback;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Johannes Ucel
 * @version 02. Apr. 2016
 *
 */
public interface Callback<T> extends Remote {

	public void receiveValue(T value) throws RemoteException;
}
