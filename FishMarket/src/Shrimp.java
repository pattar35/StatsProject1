import java.util.Random;

public class Shrimp extends SeaFood {

	public Shrimp(int index, String type, double weight, double price) {
		super(index, type, weight, price);
	}

	// shrimp does not weight a lot per 1 shrimp so im going under the assumption
	// that the market is trying to weight out about 1 pound of shrimp and can be
	// off by a little. So i set the min to .78 and the max to 1.10
	public double ShrimpWeight() {
		Random rng = new Random();
		double weight = rng.nextDouble(0.78, 1.10);
		return weight;

	}

	// going under the assumption crab is 3.49 a lb
	public double ShrimpPrice(double weight) {
		double price = weight * 16.99;
		return price;
	}
}