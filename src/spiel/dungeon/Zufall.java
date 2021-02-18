package spiel.dungeon;

public class Zufall {

	private static double zufall(double min, double max) {
		return min + (Math.random()) * (max - min);
	}
	
	public static double zufallMitGenauigkeitZwei(double min, double max) {
		return ((int) (zufall(min, max) * 100.0)) / 100.0;
	}
	
	public static int wuerfeln(int seiten) {
		return ((int) zufall(0, seiten)) + 1;
	}
	
}
