/**
 * 
 */
package spiel.dungeon;

/**
 * @author Dennis
 *
 */
public class Schatz extends Auffindbar {

	/**
	 * @param raumnummer
	 */
	public Schatz(int raumnummer) {
		super(raumnummer);
	}

	@Override
	public void auffinden(Spieler spieler) {
		System.out.println("Du hast einen Schatz gefunden!");
		double gold = this.raumnummer * Zufall.zufallMitGenauigkeitZwei(0, 1);
		spieler.erhalteGold(gold);
	}

}
