/**
 * 
 */
package spiel.dungeon;

/**
 * @author Dennis
 *
 */
public class Monster extends Auffindbar {

	private static final int WUERFEL_SEITEN = 20;

	/**
	 * 
	 * @param raumnummer
	 */
	public Monster(int raumnummer) {
		super(raumnummer);
	}

	@Override
	public void auffinden(Spieler spieler) {
		System.out.println("Ein wildes Monster ist erschienen, was möchtest du tun?");
		double kosten = this.raumnummer * Zufall.zufallMitGenauigkeitZwei(1.0, 2.0);
		System.out.println("Die Bestechung würde " + kosten + " Gold kosten.");
		
		boolean bestechung = spieler.bestichtMonster(); 
		
		if (spieler.hatGeld(kosten) && bestechung) {
			// Geld abziehen
			spieler.zieheGoldAb(kosten);
		} else {
			int wuerfelMonster = Zufall.wuerfeln(WUERFEL_SEITEN);
			int wuerfelSpieler = Zufall.wuerfeln(WUERFEL_SEITEN);
			
			System.out.println("Das Monster hat eine  " + wuerfelMonster + " gewürfelt!");
			System.out.println("Du hast eine  " + wuerfelSpieler + " gewürfelt!");
			
			if (wuerfelMonster <= wuerfelSpieler) {
				spieler.erhalteGold(this.raumnummer * Zufall.zufallMitGenauigkeitZwei(0.5, 1.5));
			} else {
				spieler.schaden(this.raumnummer * Zufall.zufallMitGenauigkeitZwei(1.0, 2.0));
			}
		}
		
		
		
	}

}
