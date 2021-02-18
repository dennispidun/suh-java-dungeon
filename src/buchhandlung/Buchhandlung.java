package buchhandlung;

public class Buchhandlung {

	public static void main(String[] args) {
		String[] buchstaben = {"A", "B", "C", "Z"};
		
		for (int i = 0; i < 3; i++) {
			System.out.print(buchstaben[(int) (Math.random() * buchstaben.length)]);
		}
		System.out.println();
		System.out.println();

		
		for (int i = 0; i < 3; i++) {
			System.out.print(zufallsZeichen('A', 'Z'));
		}
		
		
	}
	
	private static char zufallsZeichen(char min, char max) {
		return (char) (min + (Math.random()) * (max - min));
	}
	
	
}
