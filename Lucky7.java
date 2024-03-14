import java.util.*;

class Die {
	private int faceValue;
	private int num_faces;

	public Die(int num_faces) {
		this.num_faces = num_faces;
	}

	public void roll() {
		faceValue = (int)(1 + Math.random() * 6);
	}

	public int getFaceValue() {
		return faceValue;
	}
}

class Person {
	protected Die die1;
	protected Die die2;

	public Person() {
		die1 = new Die(6);
		die2 = new Die(6);
	}

	public void throwDie() {
		die1.roll();
		die2.roll();

		System.out.println(die1.getFaceValue());
		System.out.println(die2.getFaceValue());
		System.out.println();

	}
}

class DiceGame {
	private Person player;
	private int winningNum;

	public DiceGame(int winningNum) {
		this.winningNum = winningNum;
		player = new Person();
	}

	public void play() {
		boolean game = true;
		Scanner input = new Scanner(System.in);

		while (game) {

			try {
				System.out.print("Enter 1 to play or 0 to quit: ");
				int status = input.nextInt();

				if (status == 0) {
					game = false;
				}
				else if (status == 1) {
					player.throwDie();
					if ((player.die1.getFaceValue() + player.die2.getFaceValue()) == winningNum) {
						System.out.println("Congratulations!!!!");
						System.out.println();
					}
					else {
						System.out.println("Sorry you lose!!!!");
						System.out.println();
					}
				}
				else {
					System.out.println("Wrong input....");
					System.out.println();
				}
			}
			catch (InputMismatchException ex) {
				System.out.println("Wrong input....");
				System.out.println();
				input.nextLine();
			}
		}
	}
}

public class Lucky7 {
	public static void main(String[] args) {
		try {
			System.out.println("Welcome to the Lucky 7 game!!!!");

			System.out.println("					       .-------.    _______");
			System.out.println("					      /   o   /|   /\\      \\");
			System.out.println("					     /_______/o|  /o \\  o   \\");
			System.out.println("					     | o     | | /   o\\______\\");
			System.out.println("					     |   o   |o/ \\o   / o    /");
			System.out.println("					     |     o |/   \\o /   o  /");
			System.out.println("					     '-------'     \\/_____o/");

			DiceGame game = new DiceGame(7);
			game.play();
		}
		catch (NoSuchElementException ex) {
			System.out.println("\nWhoops......");
		}
	}
}