
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class SeaFood {
	//these are all my variables and my two array list's i used 
	private int index;
	private String type;
	private double weight;
	private double price;
	private ArrayList<SeaFood> stuff = new ArrayList<>();
	private ArrayList<String> reader = new ArrayList<>();
	Random rng = new Random();

	// write a method that generates sea food
	// this is our super constructor
	public SeaFood(int index, String type, double weight, double price) {
		this.index = index;
		this.type = type;
		this.weight = weight;
		this.price = price;
	}

	public SeaFood() {

	}

	// i needed to add a method that actually calls all the subclass methods to
	// create to actual sea food
	public void SeaGenerator() {
		// i created a decimalFormat object just to format my object to make it look
		// cleaner
		DecimalFormat df = new DecimalFormat("0.00");
		// this for loop randomly generates all of the sea food objects and adds them to
		// our array list of type sea food
		for (int i = 0; i < 300; i++) {
			// a randomly generator int from 1-4
			int randomInt = rng.nextInt(5);
			// initializing our index
			index++;
			// Different if statements that crate random object based on if 1-2-3-4 was rolled
			// these if statements create objects and calls the sub classes ._____weight
			// method to create a random weight that is relevant to that sea food it then sets
			// the price using the ._____price method
			// this is our crab generator
			if (randomInt == 0) {
				crabs crab = new crabs(index, "Crab", weight, price);
				crab.setWeight(Double.parseDouble(df.format(crab.crabWeight())));
				crab.setPrice(Double.parseDouble(df.format(crab.CrabPrice(crab.getWeight()))));
				stuff.add(crab);
			}
			// our Scallop generator
			if (randomInt == 1) {
				Scallops scall = new Scallops(index, "Scallop", weight, price);
				scall.setWeight(Double.parseDouble(df.format(scall.ScallopsWeight())));
				scall.setPrice(Double.parseDouble(df.format(scall.getWeight())));
				stuff.add(scall);
			}
			//this is our fish generator we have to of them so that more fish are caught and less Scallops and crabs and shrimp
			if (randomInt == 2) {
				Fish fish = new Fish(index, "Fish", weight, price);
				fish.setWeight(Double.parseDouble(df.format(fish.fishWeight())));
				fish.setPrice(Double.parseDouble(df.format(fish.fishPrice(fish.getWeight()))));
				stuff.add(fish);

			}
			if (randomInt == 3) {
				Fish fish = new Fish(index, "Fish", weight, price);
				fish.setWeight(Double.parseDouble(df.format(fish.fishWeight())));
				fish.setPrice(Double.parseDouble(df.format(fish.fishPrice(fish.getWeight()))));
				stuff.add(fish);

			}
			//this is our shrimp generator
			if (randomInt == 4) {
				Shrimp shrimp = new Shrimp(index, "Shrimp", weight, price);
				shrimp.setWeight(Double.parseDouble(df.format(shrimp.ShrimpWeight())));
				shrimp.setPrice(Double.parseDouble(df.format(shrimp.ShrimpPrice(shrimp.getWeight()))));
				stuff.add(shrimp);

			}

		}
	}

	// write a method to export your stuff
	// in class you told us we can just copy the buffer writer so i did that here
	// is the link from the cite i copied it from
	// https://www.programiz.com/java-programming/bufferedwriter
	public void printer() {
		try {
			// Creates a FileWriter
			FileWriter file = new FileWriter("FishMarket.csv");

			// Creates a BufferedWriter
			BufferedWriter output = new BufferedWriter(file);

			// Writes data to the file
			output.write("index, type, weight, price");
			output.write(stuff.toString());

			// Flushes data to the destination
			output.flush();
			output.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	// write a method to import your stuff
	// in class you told us we can just copy the buffer reader and writer so i did
	// that here
	// is the link from the cite i copied it from
	// https://www.geeksforgeeks.org/file-handling-java-using-filewriter-filereader/
	public void importer() {
		try {
			// Creates a File reader

			BufferedReader in = new BufferedReader(new FileReader("FishMarket.csv"));

			String s;
			// this uses our format from our to string to split on the last comma in each
			// line z
			while ((s = in.readLine()) != null) {
				// this is adding our var to our reader array that we created above
				String[] var = s.split(" ,");
				reader.add("\n" + var[0]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// this is just our println to print the imported data i wanted to write a
		// to string but it refused to print when ever i would call the method.
		System.out.println(reader);
	}

	// these are my getters and setters i call several of these through out the
	// project to set and get certain values.
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	// i used this to string to write to our text document in the format required
	// for the csv file
	public String toString() {
		return ("\n" + this.getIndex() + ", " + this.getType() + ", " + this.getWeight() + ", " + this.getPrice()
				+ " ,");
	}

}
