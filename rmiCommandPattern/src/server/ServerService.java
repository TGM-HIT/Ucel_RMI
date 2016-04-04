package server;

import java.rmi.RemoteException;

import remoteService.DoSomethingService;
import server.commands.Command;

/**
 * Diese Klasse stellt eine Methode zur Verfügung (vom Interface
 * DoSomethingService), welche einen Befehl ausführt
 * 
 * @author Johannes Ucel
 * @version 03. Apr. 2016
 *
 */
public class ServerService implements DoSomethingService {

	/* (non-Javadoc)
	 * @see remoteService.DoSomethingService#doSomething(server.commands.Command)
	 */
	@Override
	public void doSomething(Command c) throws RemoteException {
		c.execute();
	}

}
