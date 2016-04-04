package server.commands;

import java.io.Serializable;
import java.math.BigDecimal;
import java.rmi.RemoteException;

import calculation.Calculation;
import callback.Callback;

/**
 * Diese Klasse realisiert einen konkreten Calculation Befehl
 * 
 * @author Johannes Ucel
 * @version 03. Apr. 2016
 *
 */
public class CalculationCommand implements Command, Serializable {

	private static final long serialVersionUID = 3202369269194172790L;
	/** Das Calculation Objekt */
	private Calculation calc;
	/** Ein Callback vom Typ BigDecimal */
	private Callback<BigDecimal> callbackCalc;

	/**
	 * Konstruktor erhält die Calculation und den Callback
	 * 
	 * @param calc
	 *            Die Calculation welche ausgeführt werden muss
	 * @param callbackCalc
	 *            Die Callback - Rückgabe
	 */
	public CalculationCommand(Calculation calc, Callback<BigDecimal> callbackCalc) {
		this.calc = calc;
		this.callbackCalc = callbackCalc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.commands.Command#execute()
	 */
	@Override
	public void execute() {
		System.out.println("CalculationCommand called!");
		calc.calculate(); //Ruft die calculate-Methode auf, welche das Ergebnis im Attribut speichert
		try {
			callbackCalc.receiveValue(calc.getResult()); //Ruft das gespeichert Ergebnis auf bzw. holt sich das Ergebnis
		} catch (RemoteException e) {
			System.err.println("Remote Exception beim Empfangen vom Ergebnis");
		}
	}
}
