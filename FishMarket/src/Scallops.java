import java.util.Random;

public class Scallops extends SeaFood {
	public Scallops(int index, String type, double weight, double price) {
		super(index, type, weight, price);
	}

	public double ScallopsWeight() {
		// going under the assumption that the person at the fish market is trying to
		// weight out 1 lb of scallops but can be somewhat of either a little bit to
		// much or to little, so the min here is .85lb and the max is 1.15lb
		Random rng = new Random();
		double weight = rng.nextDouble(0.85, 1.15);
		return weight;

	}

	// going under the assumption scallops are 28.99 a lb
	public double ScallopsPrice(double weight) {
		double price = weight * 28.99;
		return price;
	}
}
