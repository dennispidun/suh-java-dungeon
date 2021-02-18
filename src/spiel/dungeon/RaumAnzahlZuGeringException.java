/**
 * 
 */
package spiel.dungeon;

/**
 * @author Dennis
 *
 */
public class RaumAnzahlZuGeringException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1915189670438575402L;

	/**
	 * @param message
	 */
	public RaumAnzahlZuGeringException(int anzahlRaeume) {
		super("Die Anzahl (" + anzahlRaeume + ") ist zu gering." 
				+ " Mindestens " + 3 + "  Räume, bittteee.");
		// TODO Auto-generated constructor stub
	}
}
