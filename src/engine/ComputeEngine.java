/**
 * 
 */
package engine;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import compute.Compute;
import compute.Task;

/**
 * Implementiert das Compute - Interface, um als Remote Object verwendet werden zu können
 * @author Johannes Ucel
 * @version 01. Apr. 2016
 *
 */
public class ComputeEngine implements Compute {

	public ComputeEngine() {
		super();
	}

	public <T> T executeTask(Task<T> t) {
		return t.execute();
	}

	public static void main(String[] args) {
		// Erstellt und Installiert den SecurityManager
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
			String name = "Compute";
			Compute engine = new ComputeEngine();
			Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);
			//Registry registry = LocateRegistry.getRegistry();
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind(name, stub);
			System.out.println("ComputeEngine bound");
		} catch (Exception e) {
			System.err.println("ComputeEngine exception:");
			e.printStackTrace();
		}
	}
}
