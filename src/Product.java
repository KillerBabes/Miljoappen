public class Product {
	private String description;
	private double carbon;

	public Product(String description, double carbon) {
		this.description = description;
		this.carbon = carbon;
	}

	public String getDescription() {
		return description;
	}

	public double getCarbon() {
		return carbon;
	}

	public String toString() {
		return description;
	}
}
