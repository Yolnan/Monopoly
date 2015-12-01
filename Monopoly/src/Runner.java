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
		int wallet = 1500;
		while(true) {
			System.out.println("\nRoll Dice");
			if(player.hasNextLine()) {
				player.nextLine();
				dice1 = (int)(Math.random()*6 + 1);
				dice2 = (int)(Math.random()*6 + 1);
				roll = dice1 + dice2;
				if((position + roll) >= 40) {
					wallet += 200;
					System.out.println("You received $200 for passing/landing on go");
					System.out.println("Your balance is $" + wallet);
				}
				position = (position + roll)%40;
				System.out.println("You rolled " + roll + "\tYou landed on " + board.get(position).getName());
				if(board.get(position).getCanBuy() == true) {
					if(board.get(position).getPurchased() == false) {
						System.out.println("Buy " + board.get(position).getName() + " for $" + board.get(position).getPrice());
						System.out.println("Press 1 to buy, enter any other number");
						if(player.nextInt() == 1) {
							if(wallet >= board.get(position).getPrice()) {
								board.get(position).setPurchased(true);
								wallet -= board.get(position).getPrice();
								System.out.println("You bought " + board.get(position).getName());
								System.out.println("Your balance is $" + wallet);
							} else {
								System.out.println("You do not have enough money");
							}
						} 
					}
				} else if(position == 4) {
					if(wallet >= 200) {
						wallet -= 200;
						System.out.println("You paid ($200) Income Tax");
					} else {
						System.out.println("You do not have enough money to pay for Income Tax");
					}
				} else if(position == 38) {
					if(wallet >= 100) {
						wallet -= 100;
						System.out.println("You paid ($100) Luxary Tax");
					} else {
						System.out.println("You do not have enough money to pay for Luxary Tax");
					}
				}
			}
		}
	}
	public static void makeSquare() {
		board.add(new Nonpurchaseable("Go", 0, false));
		board.add(new Colored("Mediterranean Avenue", 1, 60, false, true));
		board.add(new Nonpurchaseable("Community Chest", 2, false));
		board.add(new Colored("Baltic Avenue", 3, 60, false, true));
		board.add(new Nonpurchaseable("Income Tax", 4, false));
		board.add(new Noncolored("Reading Railroad", 5, 200, false, true));
		board.add(new Colored("Oriental Avenue", 6, 100, false, true));
		board.add(new Nonpurchaseable("Chance", 7, false));
		board.add(new Colored("Vermont Avenue", 8, 100, false, true));
		board.add(new Colored("Connecticut Avenue", 9, 120, false, true));
		board.add(new Nonpurchaseable("Jail", 10, false));
		board.add(new Colored("St. Charles Place", 11, 140, false, true));
		board.add(new Noncolored("Electic Company", 12, 150, false, true));
		board.add(new Colored("States Avenue", 13, 140, false, true));
		board.add(new Colored("Virginia Avenue", 14, 160, false, true));
		board.add(new Noncolored("Pennsylvania Railroad", 15, 200, false, true));
		board.add(new Colored("St. James Place", 16, 180, false, true));
		board.add(new Nonpurchaseable("Community Chest", 17, false));
		board.add(new Colored("Tennesse Avenue", 18, 180, false, true));
		board.add(new Colored("New York", 19, 200, false, true));
		board.add(new Nonpurchaseable("Parking", 20, false));
		board.add(new Colored("Kentucky Avenue", 21, 220, false, true));
		board.add(new Nonpurchaseable("Chance", 22, false));
		board.add(new Colored("Indiana Avenue", 23, 220, false, true));
		board.add(new Colored("Illinois Avenue", 24, 240, false, true));
		board.add(new Noncolored("B & O Railroad", 25, 200,false, true));
		board.add(new Colored("Atlantic Avenue", 26, 260, false, true));
		board.add(new Colored("Ventura Avenue", 27, 260, false, true));
		board.add(new Noncolored("Water Works", 28, 150, false, true));
		board.add(new Colored("Market Gardens", 29, 280, false, true));
		board.add(new Nonpurchaseable("Go To Jail", 30, false));
		board.add(new Colored("Pacific Avenue", 31, 300, false, true));
		board.add(new Colored("North Carolina Avenue", 32, 300,false, true));
		board.add(new Nonpurchaseable("Community Chest", 33, false));
		board.add(new Colored("Pennsylvania Avenue", 34, 320, false, true));
		board.add(new Noncolored("Short Line", 35, 200, false, true));
		board.add(new Nonpurchaseable("Chance", 36, false));
		board.add(new Colored("Park Place", 37, 350, false, true));
		board.add(new Nonpurchaseable("Luxary Tax", 38, false));
		board.add(new Colored("Boardwalk", 39, 400, false, true));
	} 
}
