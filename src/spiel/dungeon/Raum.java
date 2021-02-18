/**
 * 
 */
package spiel.dungeon;

/**
 * @author Dennis
 *
 */
public class Raum {
	
	private final Auffindbar fund;

	public Raum(Auffindbar fund) {
		this.fund = fund;
	}

	public void betreten(Spieler spieler) {
		
		spieler.weitsehen();
		
		fund.auffinden(spieler);
	}

	/**
	 * @return the fund
	 */
	public boolean istSchatz() {
		return this.fund instanceof Schatz;
	}
	

}
