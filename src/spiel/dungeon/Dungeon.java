package spiel.dungeon;

import java.util.Arrays;
import java.util.Scanner;

public class Dungeon {
	
	private final Raum[] raeume;
	private final Spieler spieler;
	private int aktuellerRaum = 0;
	
	public Dungeon(int anzahlRaeume) {
		if (anzahlRaeume < 3) {
			throw new RaumAnzahlZuGeringException(anzahlRaeume);
		}
		
		this.raeume = new Raum[anzahlRaeume];

		this.spieler = new Spieler(() ->  {
			long monster = Arrays.stream(this.raeume)
				.skip(aktuellerRaum)
				.filter(raum -> !raum.istSchatz())
				.count();
			
			Arrays.stream(this.raeume).forEach(raum -> {
				System.out.println(raum);
			});
			
			for (Raum raum2 : raeume) {
				System.out.println(raum2);
			}		
			
						
			System.out.println("Es sind noch " + monster + " vor dir!");
		},
		() -> {
			
			long schaetze = Arrays.stream(this.raeume)
				.skip(aktuellerRaum) 
				.filter(raum -> raum.istSchatz())
				.count();
						
			System.out.println("Es sind noch " + schaetze + " vor dir!");
		});
		
		for(aktuellerRaum = 0; aktuellerRaum < anzahlRaeume; aktuellerRaum++) {
			Auffindbar fund = null;
			
			double pSchatz = 0;
			
			pSchatz = generiereWahrscheinlichkeitSchatz(aktuellerRaum);
			
			if (Math.random() < pSchatz) { // Schatz
				fund = new Schatz(aktuellerRaum + 1);
			} else { // Monster
				fund = new Monster(aktuellerRaum + 1);
			}
			
			this.raeume[aktuellerRaum] = new Raum(fund);
		}
	}

	/**
	 * Siehe Aufgabe
	 * 
	 * @param raumIndex
	 * @return Die Wahrscheinlichkeit einen Schatz zu finden 
	 * 	       anhand der Raumnummer und der vorherigen Raeume
	 */
	private double generiereWahrscheinlichkeitSchatz(int raumIndex) {
		double pSchatz = 0.5;
		if (raumIndex >= 3) { // Fuer die ersten drei Raeume, 50/50
			if (!this.raeume[raumIndex - 1].istSchatz() 
					&& !this.raeume[raumIndex - 2].istSchatz()
					&& !this.raeume[raumIndex - 3].istSchatz()) {
				pSchatz = 0.95;
			} else if (!this.raeume[raumIndex - 1].istSchatz() // Fuer andere Raeume entsprechend
					&& !this.raeume[raumIndex - 2].istSchatz()) {
				pSchatz = 0.75;
			}
		}
		return pSchatz;
	}

	private void betreten() {
		Scanner scanner = new Scanner(System.in);
		int besuchteRaeume = 0;
		for (int i = 0; i < raeume.length; i++) {
			System.out.println("Möchtest du den nächsten Raum betreten?");
			this.spieler.gebeEigenschaftenAus();
			scanner.nextLine();
			try {
				this.raeume[i].betreten(this.spieler);
			} catch(Spieler.HatKeinLebenException e) {
				System.out.println("Das Spiel ist vorbei, du hast kein Leben mehr!");
				break;
			}
			besuchteRaeume++;
			System.out.println("");
		}
		
		if (besuchteRaeume == this.raeume.length) {
			System.out.println("Herzlichen Glückwunsch, du hast den Dungeon besiegt!");
		}
		
		scanner.close();
	}
	
	public static void main(String[] args) {
		Dungeon dungeon = new Dungeon(6);
		dungeon.betreten();
	}


	
	
}
