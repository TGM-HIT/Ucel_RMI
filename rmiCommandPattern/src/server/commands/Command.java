package server.commands;

import java.io.Serializable;

/**
 * Dieses Interface gibt den grundlegenden Aufbau eines Commands vor
 * 
 * @author Johannes Ucel
 * @version 03. Apr. 2016
 *
 */
public interface Command extends Serializable {

	/**
	 * Führt etwas aus
	 */
	public void execute();
}
