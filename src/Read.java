import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Read {
	private ArrayList<Product> mat;
	private ArrayList<Product> transport;
	private ArrayList<Product> boende;
	private ArrayList<Product> ovrigt;


	public static void main(String[] args) {
		new Read();
	}

	public Read() {

		BufferedReader file = null;
		try {
			file = new BufferedReader(new InputStreamReader(new FileInputStream("../res/CO2.db"), "UTF-8"));

			String line = file.readLine();  
			System.out.println(file);
			while(line != null) {        
				if(line.startsWith("//")){
					line = file.readLine();                    
					continue;   
				}

				String[] fields = line.split(":");

				if (fields[0].equalsIgnoreCase("mat")) {
					mat.add(new Product(fields[1], Double.parseDouble(fields[2])));
				}
				if (fields[0].equalsIgnoreCase("transport")) {
					transport.add(new Product(fields[1], Double.parseDouble(fields[2])));
				}
				if (fields[0].equalsIgnoreCase("boende")) {
					boende.add(new Product(fields[1], Double.parseDouble(fields[2])));
				}
				if (fields[0].equalsIgnoreCase("övrigt")) {
					ovrigt.add(new Product(fields[1], Double.parseDouble(fields[2])));
				}
				line = file.readLine();
			}

		} catch (Exception e) {
			System.err.printf("%s: %s%n", e);
			System.exit(1);
		}finally{
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					System.err.println("Not possible to close file...");
				}
			}
		}			
	}
}