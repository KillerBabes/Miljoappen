import java.io.*;
import java.util.*;

public class Read {
	private ArrayList<Product> mat;
	private ArrayList<Product> transport;
	private ArrayList<Product> boende;
	private ArrayList<Product> ovrigt;

	public static void main(String[] args) {
		Read r = new Read();

		System.out.println("Mat: " + r.getMat());
		System.out.println("Transport: " + r.getTransport());
		System.out.println("Boende: " + r.getBoende());
		System.out.println("Övrigt: " + r.getOvrigt());
	}

	public Read() {
		BufferedReader file = null;
		mat = new ArrayList<Product>();
		transport = new ArrayList<Product>();
		boende = new ArrayList<Product>();
		ovrigt = new ArrayList<Product>();

		try {
			file = new BufferedReader(new InputStreamReader(new FileInputStream("../res/CO2.db"), "UTF-8"));
		} catch (FileNotFoundException e) {
			System.err.println("error: File \"../res/CO2.db\" not found.");
			System.exit(1);
		} catch (UnsupportedEncodingException e) {
			System.err.println("error: Unsupported encoding \"UTF-8\".");
			System.exit(1);
		}

		try {
			String line = null;

			for (line = file.readLine().trim();
			     line != null;
			     line = file.readLine().trim()) {
				if (line.startsWith("//")) {
					continue;
				}

				String[] fields = line.split(":");

				if (fields[0].trim().equalsIgnoreCase("mat")) {
					mat.add(new Product(fields[1], Double.parseDouble(fields[2])));
				} else if (fields[0].trim().equalsIgnoreCase("transport")) {
					transport.add(new Product(fields[1], Double.parseDouble(fields[2])));
				} else if (fields[0].trim().equalsIgnoreCase("boende")) {
					boende.add(new Product(fields[1], Double.parseDouble(fields[2])));
				} else if (fields[0].trim().equalsIgnoreCase("övrigt")) {
					ovrigt.add(new Product(fields[1], Double.parseDouble(fields[2])));
				}
			}

		} catch (IOException e) {
			System.err.println("error: " + e);
			System.exit(1);
		}

		if (file != null) {
			try {
				file.close();
			} catch (IOException e) {
				System.err.println("error: " + e);
			}
		}
	}

	public ArrayList<Product> getMat() {
		return mat;
	}

	public ArrayList<Product> getTransport() {
		return transport;
	}

	public ArrayList<Product> getBoende() {
		return boende;
	}

	public ArrayList<Product> getOvrigt() {
		return ovrigt;
	}
}
