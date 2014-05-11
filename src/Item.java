public class Item {
	private String name;
	private double CO2;

	public Item(String name, double CO2) {
		this.name = name;
		this.CO2 = CO2;
	}

	public String getName() {
		return name;
	}

	public double getCO2() {
		return CO2;
	}

	public String toString() {
		return name;
	}
}
