import java.io.*;
import java.util.*;

public class Items {
	private HashMap<String, ArrayList<Item>> categories;

	public static void main(String[] args) {
		Items items = new Items();

		for (String s : items.getCategories()) {
			System.out.println(s + ": " + items.getItems(s));
		}
	}

	public Items() {
		categories = new HashMap<String, ArrayList<Item>>();

		BufferedReader file = null;

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

			for (line = file.readLine();
			     line != null;
			     line = file.readLine()) {
				line = line.trim();

				if (line.startsWith("//") || line.isEmpty()) {
					continue;
				}

				String[] fields = line.split(":");

				if (!categories.containsKey(fields[0].trim())) {
					categories.put(fields[0].trim(), new ArrayList<Item>());
				}

				categories.get(fields[0].trim()).add(new Item(fields[1].trim(), Double.parseDouble(fields[2].trim())));
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

	public ArrayList<String> getCategories() {
		ArrayList<String> a = new ArrayList<String>();

		for (String s : categories.keySet()) {
			a.add(s);
		}

		Collections.sort(a, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});

		return a;
	}

	public ArrayList<Item> getItems(String category) {
		ArrayList<Item> a = new ArrayList<Item>(categories.get(category));

		Collections.sort(a, new Comparator<Item>() {
			@Override
			public int compare(Item i1, Item i2) {
				return i1.getName().compareTo(i2.getName());
			}
		});

		return a;
	}
}
