
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Person {
	// this is our userinput method it just simply takes the user input and returns
	// it
	public int userInput() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the amount of people in your class:");
		int people = scn.nextInt();
		// just returning the amount of people in the class for this method
		return people;
	}

	// this is our other user input method it just simply takes the user input and
	// returns it again
	public int userTrials() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the amount of time you would like to run this simulation:");
		int trials = scn.nextInt();
		// this one I'm just returning the amount of trials so i can see how long to run
		// my for loop for
		return trials;
	}

	// for this method all i want to do return a random birthday(mm/dd) however i
	// have to consider that there are a few months that don't have 32 days. I fix
	// this issues by using a few if statements
	public int birthday() {
		Random rng = new Random();
		// i used the rng.nextint()+1 to start at 1 instead of 0 because there is no 0
		// month
		int month = rng.nextInt(12) + 1;
		int day = 0;
		// this accounts for September and November which has 30 days
		if (month == 9 || month == 11) {
			day = rng.nextInt(30) + 1;
		}
		// this accounts for February which only has 28 days in it
		if (month == 2) {
			day = rng.nextInt(28) + 1;
			// ther rest of the months have 32 days
		} else {
			day = rng.nextInt(32) + 1;
		}
		// i then declared the birthday again (mm/dd) and return it. I had to use this
		// weird String.valueof because java is weird and thats the only way i knew how
		// to combine two ints in one line with out adding them
		int birthday = Integer.valueOf(String.valueOf(month) + String.valueOf(day));
		return birthday;
	}

	// this is the method for comparing the birthdays, i just simply wanted the
	// trials and people from our user input above. I then wanted to just run the
	// trials as indicated by our input and create different objects and compare
	// them. if one birthday = another then we add it to the counter.
	public String birthdayComparison(int people, double trials) {
		// created a arraylist to store my birthdays, i also created the birthday obj to
		// call my above methods. i also created the counter variable as well as the
		// boolean variable share to make it easier to determine if someone shares a
		// birthday or not
		Person birthday = new Person();
		ArrayList<Integer> numberSet = new ArrayList<Integer>();
		double counter = 0;
		boolean share = false;
		// this loop just runs the amount of trials that the user inputs
		for (int i = 0; i < trials; i++) {
			// here is were i add all the random birthdays to my numberset. i just call my
			// above .birthday method on as many people that the user inputs.
			for (int j = 0; j < people; j++) {
				numberSet.add(birthday.birthday());
			}
			// this loop checks to see if any 2 birthdays equal one another in the number
			// set we need a nested for loop for this because we have to compare one
			// birthday at a time to each birthday in our list.
			for (int j = 0; j < numberSet.size(); j++) {
				for (int k = j + 1; k < numberSet.size(); k++) {
					// this if statement is just simply if the birthdays do equal on another set the
					// boolean to true
					if (numberSet.get(j).equals(numberSet.get(k))) {
						share = true;
					}
				}
			}
			// this if statement is what determines our counter
			// if the boolean variable is changed to true above then this just adds 1 to our
			// counter and sets it back to false
			if (share == true) {
				counter++;
				share = false;
			}
			// i then clear the numberset so we can use it again for the next trial
			numberSet.clear();
		}
		// returning the ans which is the amount of success over trials
		double ans = (counter / trials)*100;
		return ("Our calculated answer is: " +ans + "%");
	}
}
