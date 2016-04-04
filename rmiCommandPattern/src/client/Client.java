package client;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import calculation.Calculation;
import calculation.PICalc;
import callback.Callback;
import callback.ValueCallback;
import remoteService.DoSomethingService;
import server.commands.CalculationCommand;
import server.commands.Command;
import server.commands.RegisterCommand;
import server.commands.LoginCommand;

/**
 * In dieser Klasse wird eine remote Methoden aufgerufen und das Ergebnis über
 * ein Callback zurückgegeben
 * 
 * @author Johannes Ucel
 * @version 03. Apr. 2016
 *
 */
public class Client {

	/**
	 * @param args
	 *            Startargumente (Anzahl der Nachkommastellen)
	 */
	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
			Registry registry = LocateRegistry.getRegistry(1234);
			DoSomethingService uRemoteObject = (DoSomethingService) registry.lookup("Service");
			System.out.println("Service found");
			ValueCallback<BigDecimal> vc = new ValueCallback<BigDecimal>();
			Callback<BigDecimal> stub = (Callback<BigDecimal>) UnicastRemoteObject.exportObject(vc, 0);
			Calculation picalc = new PICalc(Integer.parseInt(args[0]));
			Command calcCMD = new CalculationCommand(picalc, stub);
			uRemoteObject.doSomething(calcCMD);
			while (System.in.read() != '\n')
				;
			// Testing
			UnicastRemoteObject.unexportObject(uRemoteObject, true);
		} catch (RemoteException re) {
			System.err.println("Service not found?" + " Check your RMI-Registry!");
			System.exit(1);
		} catch (Exception e) {
			System.err.println("Service exception:");
			e.printStackTrace();
			System.exit(1);
		}
	}
}
