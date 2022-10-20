import java.util.Random;

public class Fish extends SeaFood {

	public Fish(int index, String type, double weight, double price) {
		super(index, type, weight, price);
		type = "fish";
		weight = 10;
	}

	public double fishWeight() {
		// im going based off of cod because thats my favorite fish, cod which is typically around 6-12 pounds
		Random rng = new Random();
		double weight = rng.nextDouble(6, 12);
		return weight;

	}

	// going under the assumption cod is 12.99 per pound
	public double fishPrice(double weight) {
		double price = weight * 12.99;
		return price;
	}

}
