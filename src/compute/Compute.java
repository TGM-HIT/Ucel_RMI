package compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Definiert den Remote - Accessible Part
 * 
 * @author Johannes Ucel
 * @version 01. Apr. 2016
 *
 */
public interface Compute extends Remote {
	<T> T executeTask(Task<T> t) throws RemoteException;
}