package dateien;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programm {
	
	public static void main(String[] args) throws IOException {
		List<String> raumIds = new ArrayList<>();
		raumIds.add("AR42DEF34"); // Sind richtig
		raumIds.add("R657gfhg");

		raumIds.add("FFFFF"); // Sind falsch
		raumIds.add("FAAAA");
		raumIds.add("FBBBB");

		
		File datei = new File(".", "schatzkarte.txt");
		datei.createNewFile();
		System.out.println(datei.getAbsolutePath());
		
		Collections.shuffle(raumIds);
		
		
		try (FileWriter writer = new FileWriter(datei)) {
			for (String raumId : raumIds) {
				writer.write(raumId);
				writer.write("\n");
			}
		}
		
	}
	
	
}
