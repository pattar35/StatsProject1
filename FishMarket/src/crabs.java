import java.util.Random;

public class crabs extends SeaFood {
	public crabs(int index, String type, double weight, double price) {
		super(index, type, weight, price);
	}

	// king crabs are around 3-6 pounds, and i used king crabs because it makes the
	// problem easier rather then using blue crabs which are like 2/3 of a pound
	public double crabWeight() {

		Random rng = new Random();
		double weight = rng.nextDouble(3, 6);
		return weight;

	}

	// going under the assumption crab is 3.49 a lb
	public double CrabPrice(double weight) {
		double price = weight * 3.49;
		return price;
	}
}