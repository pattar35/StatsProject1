
import java.util.Random;

//my thought process for monty hall was to try to keep it as simple as possible and not to over complicate things
//simply put i just wanted to create two randomly generated number 1-3 and then compare these two numbers
//if they equal on another then we selected the correct door when given 3 options
//we are not switching doors in our first method so if the first door we selected is the ans then we can add +1 to our total wins.
public class MontyHall {
	public double notChangingDoors() {
		// first we created a random number generator and we only want random numbers
		// from 1-3
		Random rng = new Random();
		// i then declared a counter i have it set to double so i don't have to
		// concatenate my data later to calculate win percentage
		double counter = 0;

		// this for loop runs 10000 trials and sees how many times our guess is correct
		// and adds it to the counter.
		for (int i = 0; i < 10000; i++) {
			int car = rng.nextInt(3);
			int guess = rng.nextInt(3);
			if (car == guess) {
				counter++;
			} else {

			}
		}
		// i then return the win percentage which is wins/total trials
		double percent = counter / 10000;
		return percent;
	}

	// for this method we are switching doors, my thought process again was to just
	// keep it simple. my thought process was take a guess at one of the three doors
	// and if it doesn't equal the correct door then find an alternative door and if
	// that door doesn't equal the correct guess then we win. i'm going under the
	// assumption that the door they are picking is the door that opens so for
	// example in the first part the first guess is the door they are picking to
	// open and reveal a goat or car

	// i did use a code-snip-it from a monty hall git hub here is the link to that
	// line 69 is the line that i took from there
	// https://gist.github.com/jcchurch/930274
	public double ChangingDoors() {
		// first i just created a few helper variables and our random number generator
		Random rng = new Random();
		double plays = 10000;
		double count = 0;
		int door2;
		// this for loop controls how many times we want to run this trial here it is
		// running 10000 times
		for (int i = 0; i < plays; i++) {
			// this is the first door we are going to reveal
			int door1 = rng.nextInt(3);
			// this is the correct door
			int correctdoor = rng.nextInt(3);
			// this if statement is just saying if door1 is not the correct door, so the
			// car, then do the else statement statistical it should be about 70% percent of
			// the trials
			if (door1 == correctdoor) {

			} else {
				// the line of code i found online when researching that keeps my door2 in the
				// correct range, before i had this code snip-it i had a lot of if statements for
				// different scenarios but this one line take out all the need for those
				// statements.
				door2 = 3 - (door1 - correctdoor);
				// this just says if the second door we open is not the car then it counts as a win so count++
				if (door2 != correctdoor) {
					count++;
				}
			}
		}
		// i then just return the win total over the amount of plays;
		return count / plays;

	}
}