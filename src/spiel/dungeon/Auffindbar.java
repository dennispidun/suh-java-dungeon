package spiel.dungeon;

public abstract class Auffindbar {
	
	final int raumnummer;

	/**
	 * @param raumnummer Raumnummer vom auffindbaren Objekt
	 */
	public Auffindbar(int raumnummer) {
		this.raumnummer = raumnummer;
	}
	
	public abstract void auffinden(Spieler spieler);
	

}
