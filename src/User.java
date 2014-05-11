public class User {
	private String name;
	private double CO2Consumed;
	private double CO2Goal;

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public double getCO2Consumed() {
		return CO2Consumed;
	}

	public double getCO2Goal() {
		return CO2Goal;
	}

	public void addCO2Consumed(double CO2Consumed) {
		if (CO2Consumed < 0) {
			throw new IllegalArgumentException("Can't consume negative CO2.");
		}

		this.CO2Consumed += CO2Consumed;
	}

	public void setCO2Goal(double CO2Goal) {
		this.CO2Goal = CO2Goal;
	}
}
