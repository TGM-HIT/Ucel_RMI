package calculation;

import java.math.BigDecimal;

/**
 * Dieses Interface gibt eine Methode zum Berechnen und eine zum Zur�ckgeben des
 * Ergebnisses vor
 * 
 * @author Johannes Ucel
 * @version 03. Apr. 2016
 *
 */
public interface Calculation {

	/**
	 * Berechnet PI
	 */
	public void calculate();

	/**
	 * Gibt das Ergebnis zur�ck
	 * 
	 * @return gibt das Ergebnis als BigDecimal zur�ck
	 */
	public BigDecimal getResult();
}
