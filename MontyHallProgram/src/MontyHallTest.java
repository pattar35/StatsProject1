public class MontyHallTest {

	public static void main(String[] args) {
		MontyHall door = new MontyHall();
		System.out.println("when changing doors your win percentage was: " + door.ChangingDoors());
		System.out.println("when not changing doors your win percentage was: " + door.notChangingDoors());

	}

}
