import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;

public class SalterSmother {
	// the first thing i did was declare all my array lists for the graphs
	ArrayList<Double> numlist = new ArrayList<Double>();
	private ArrayList<String> xvalues = new ArrayList<>();
	private ArrayList<String> yvalues = new ArrayList<>();
	private ArrayList<String> ysalted = new ArrayList<>();
	private ArrayList<Double> ysmoothed = new ArrayList<>();
	private ArrayList<String> smoothed = new ArrayList<>();
	Random rng = new Random();

	public SalterSmother() {

	}

	// i created this void method to initialize the creation of my graph
	public void runner() {
		// created a graph object
		SalterSmother graph = new SalterSmother();
		// took user input to determine how many points the user would like to graph
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the amount of point you would like: ");
		int limit = scn.nextInt();
		// for loop that calls our plot method below and increase our m x and b every
		// point
		for (int i = 0; i < limit; i++) {
			graph.plot(i, i + 2, i + 1);
		}
		// i then called the graph writer method i declared below
		graph.writer();

	}

	// i created a void method called plot that just maps the formula mx+b to my num
	// list array list
	public void plot(double x, double b, double m) {
		double y = (m * x) + b;
		// adds x and y, x first then y
		numlist.add(x);
		numlist.add(y);
	}

	// this prints our original graph data
	// this is a buffer reader method that i based my method off of:
	// https://www.programiz.com/java-programming/bufferedwriter
	public void writer() {
		try {
			// first thing i did was declare my length to a variable called num
			int num = numlist.size();
			FileWriter file = new FileWriter("Graph.csv");
			BufferedWriter output = new BufferedWriter(file);

			// i then added x values and y values to our output to get a cleaner looking
			// file
			output.write("x values " + ", " + "y values");
			// this for loop writes the x and y values to the output file
			for (int i = 0; i < num; i = i + 2) {
				output.write("\n" + numlist.get(i) + ", " + numlist.get(i + 1));
			}
			output.flush();
			output.close();
		}

		catch (Exception e) {
			e.getStackTrace();
		}
	}

	public void Salter() {
		try {
			BufferedReader in = new BufferedReader(new FileReader("Graph.csv"));
			String s;

			// this uses our format from our to string to split on the last comma in each
			// line z
			while ((s = in.readLine()) != null) {
				// this is adding our var to our reader array that we created above
				String[] var = s.split(", ");
				xvalues.add(var[0]);
				yvalues.add(var[1]);
			}
			// this for loop Salts our data
			for (int i = 1; i < yvalues.size(); i++) {
				// i created a rng from 0-6 i included 0 because this would drastically shift
				// our data
				int randomInt = rng.nextInt(6)+1;
				// i saved the y values above as string so i have to parse them to a double to
				// do arithmetic on them
				String y = yvalues.get(i);
				double vals = Double.parseDouble(y);
				// i then added the values to our y salted array, but i also added the values to
				// y smoothed so i did have to parse to numbers from string to double later in
				// the project when i smooth data
				ysalted.add("" + vals * randomInt);
				ysmoothed.add(vals * randomInt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// this method just writes our salted data
	public void writeSaltedGraph() {
		try {
			// set num equal to our length of our values
			int num = xvalues.size();
			FileWriter file = new FileWriter("SalterGraph.csv");
			BufferedWriter output = new BufferedWriter(file);

			// i then added x values and y values to our output to get a cleaner looking
			// file
			output.write("x values " + ", " + "y values");
			// this for loop writes are x and y salted values to our csv file
			for (int i = 1; i < num; i++) {
				output.write("\n" + xvalues.get(i) + ", " + ysalted.get(i - 1));
			}

			// Flushes data to the destination
			output.flush();
			output.close();
		}

		catch (Exception e) {
			e.getStackTrace();
		}
	}

	// this is our smoother method, i want to take the average of the nearest three
	// values and add that average to a new array list
	public void smoother() {
		// first i declared a for loop that run through all our values
		for (int i = 0; i < ysmoothed.size(); i++) {
			// these collection of if statements get the average of the nearest values and
			// adds them to our array smoothed. I have several if statements because when
			// i==0 i need the first three values and when i is at the max length i need the
			// last three values this is because of array bounds.
			if (i == 0) {
				double smoothval = (ysmoothed.get(i) + ysmoothed.get(i + 1) + ysmoothed.get(i + 2)) / 3;
				smoothed.add("" + smoothval);
			}
			if (i > 0 && i != ysmoothed.size() - 1) {
				double smoothval = (ysmoothed.get(i - 1) + ysmoothed.get(i) + ysmoothed.get(i + 1)) / 3;
				smoothed.add("" + smoothval);
			}
			if (i == ysmoothed.size() - 1) {
				double smoothval = (ysmoothed.get(i) + ysmoothed.get(i - 1) + ysmoothed.get(i - 2)) / 3;
				smoothed.add("" + smoothval);
			}
		}
	}

	public void writesmootherGraph() {
		try {
			int num = ysmoothed.size();

			FileWriter file = new FileWriter("SmootherGraph.csv");
			BufferedWriter output = new BufferedWriter(file);

			// i again added "x values" and "y values" to our output to get a cleaner
			// looking
			// file
			output.write("x values " + ", " + "y values");
			// this for loop just writes our values to our new csv file
			for (int i = 0; i < num; i++) {
				output.write("\n" + xvalues.get(i + 1) + ", " + smoothed.get(i));
			}

			output.flush();
			output.close();
		}

		catch (Exception e) {
			e.getStackTrace();
		}
	}
}
