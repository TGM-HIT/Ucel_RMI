package server.commands;

import java.io.Serializable;
import java.math.BigDecimal;
import java.rmi.RemoteException;

import calculation.Calculation;
import callback.Callback;

public class CalculationCommand implements Command, Serializable {

	private static final long serialVersionUID = 3202369269194172790L;
	private Calculation calc;
	private Callback<BigDecimal> callbackCalc;

	public CalculationCommand(Calculation calc, Callback<BigDecimal> callbackCalc) {
		this.calc = calc;
		this.callbackCalc = callbackCalc;
	}

	@Override
	public void execute() {
		System.out.println("CalculationCommand called!");
		calc.calculate();
		try {
			callbackCalc.receiveValue(calc.getResult());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
