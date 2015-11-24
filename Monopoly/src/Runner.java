import java.util.*;
public class Runner {
	static Scanner player = new Scanner(System.in);
	static ArrayList<Square> board = new ArrayList<Square>();
	public static void main(String[] args) {
		makeSquare();
		play();
	}
	public static void play() {
		int dice1;
		int dice2;
		int roll;
		int position = 0;
		while(true) {
			System.out.println("\nRoll Dice");
			if(player.hasNextLine()) {
				player.nextLine();
				dice1 = (int)(Math.random()*6 + 1);
				dice2 = (int)(Math.random()*6 + 1);
				roll = dice1 + dice2;
				position = (position + roll)%40;
				System.out.println("You rolled " + roll + "\tYou landed on " + board.get(position).getName());
			}
		}
	}
	public static void makeSquare() {
		board.add(new Nonpurchaseable("Go", 0));
		board.add(new Colored("Mediterranean Avenue", 1, 60, false));
		board.add(new Nonpurchaseable("Community Chest", 2));
		board.add(new Colored("Baltic Avenue", 3, 60, false));
		board.add(new Nonpurchaseable("Income Tax", 4));
		board.add(new Noncolored("Reading Railroad", 5, 200, false));
		board.add(new Colored("Oriental Avenue", 6, 100, false));
		board.add(new Nonpurchaseable("Chance", 7));
		board.add(new Colored("Vermont Avenue", 8, 100, false));
		board.add(new Colored("Connecticut Avenue", 9, 120, false));
		board.add(new Nonpurchaseable("Jail", 10));
		board.add(new Colored("St. Charles Place", 11, 140, false));
		board.add(new Noncolored("Electic Company", 12, 150, false));
		board.add(new Colored("States Avenue", 13, 140, false));
		board.add(new Colored("Virginia Avenue", 14, 160, false));
		board.add(new Noncolored("Pennsylvania Railroad", 15, 200, false));
		board.add(new Colored("St. James Place", 16, 180, false));
		board.add(new Nonpurchaseable("Community Chest", 17));
		board.add(new Colored("Tennesse Avenue", 18, 180, false));
		board.add(new Colored("New York", 19, 200, false));
		board.add(new Nonpurchaseable("Parking", 20));
		board.add(new Colored("Kentucky Avenue", 21, 220, false));
		board.add(new Nonpurchaseable("Chance", 22));
		board.add(new Colored("Indiana Avenue", 23, 220, false));
		board.add(new Colored("Illinois Avenue", 24, 240, false));
		board.add(new Noncolored("B & O Railroad", 25, 200,false));
		board.add(new Colored("Atlantic Avenue", 26, 260, false));
		board.add(new Colored("Ventura Avenue", 27, 260, false));
		board.add(new Noncolored("Water Works", 28, 150, false));
		board.add(new Colored("Market Gardens", 29, 280, false));
		board.add(new Nonpurchaseable("Go To Jail", 30));
		board.add(new Colored("Pacific Avenue", 31, 300, false));
		board.add(new Colored("North Carolina Avenue", 32, 300,false));
		board.add(new Nonpurchaseable("Community Chest", 33));
		board.add(new Colored("Pennsylvania Avenue", 34, 320, false));
		board.add(new Noncolored("Short Line", 35, 200, false));
		board.add(new Nonpurchaseable("Chance", 36));
		board.add(new Colored("Park Place", 37, 350, false));
		board.add(new Nonpurchaseable("Luxary Tax", 38));
		board.add(new Colored("Boardwalk", 39, 400, false));
	} 
}
