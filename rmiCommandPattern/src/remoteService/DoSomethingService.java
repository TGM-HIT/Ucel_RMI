package remoteService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import server.commands.Command;

/**
 * Dieses Interface gibt eine Methode vor, in der ein Befehl ausgeführt werden
 * kann
 * 
 * @author Johannes Ucel
 * @version 03. Apr. 2016
 *
 */
public interface DoSomethingService extends Remote {

	/**
	 * Diese Methode führt ein Befehl (Command) aus
	 * 
	 * @param c
	 *            Ein Befehl
	 * @throws RemoteException
	 */
	public void doSomething(Command c) throws RemoteException;

}
