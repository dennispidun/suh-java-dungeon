package spiel.dungeon;

import java.util.Scanner;

public class Spieler {

	private double gold;
	private double lebenspunke;
	private Weitsicht monsterZaehlen;
	private Weitsicht schaetzeZaehlen;
	
	/**
	 * @param monsterZaehlen
	 * @param schaetzeZaehlen
	 */
	public Spieler(Weitsicht monsterZaehlen, Weitsicht schaetzeZaehlen) {
		this.gold = 50;
		this.lebenspunke = 0;
		this.monsterZaehlen = monsterZaehlen;
		this.schaetzeZaehlen = schaetzeZaehlen;
	}

	private void setGold(double gold) {
		this.gold = ((int) (gold * 100.0)) / 100.0;
	}
	
	public void erhalteGold(double gold) {
		System.out.println("Du hast " + gold + " Gold erhalten.");
		this.setGold(this.gold + gold);
	}
	
	public void zieheGoldAb(double kosten) {
		if (this.gold < kosten) {
			// Nicht bestechen und angreifen??
		}

		System.out.println("Du hast " + kosten + " Gold bezahlt.");
		
		this.setGold(this.gold - kosten);
	}

	public boolean bestichtMonster() {
		Boolean besticht = null;

		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.println("Möchtest du das Monster bestechen: ja (1), nein (2)");
			System.out.print("Auswahl: ");
			int auswahl = scanner.nextInt();
			if (auswahl == 1) {
				besticht = true;
			} else if (auswahl == 2) {
				besticht = false;
			}
		} while(besticht == null);
		
		return besticht.booleanValue();
	}

	public boolean hatGeld(double kosten) {
		return this.gold >= kosten;
	}

	public void schaden(double lebenspunkte) {
		if (this.lebenspunke <= lebenspunkte) {
			throw new Spieler.HatKeinLebenException();
		}
		
		System.out.println("Du hast " + lebenspunkte + " Schaden erhalten");
	
		this.lebenspunke -= lebenspunkte;
	}

	public void gebeEigenschaftenAus() {
		System.out.println("Du hast: " + this.gold + " Gold und " + this.lebenspunke + "% Leben");
	}

	public class HatKeinLebenException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 6227868394638231184L;
		
	}

	public void weitsehen() {
		boolean monsterZaehlen = false; //benutzer eingabe
		if(monsterZaehlen) {
			this.monsterZaehlen.einsetzen();
		} else {
			this.schaetzeZaehlen.einsetzen();
		}
		
	}
	
}
