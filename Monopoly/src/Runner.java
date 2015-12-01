import java.util.*;
public class Runner {
	static Scanner player = new Scanner(System.in);
	static ArrayList<Square> board = new ArrayList<Square>();
	static ArrayList<String>ownedProp = new ArrayList<String>();
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
						System.out.println("Press 1 to buy, else enter any other number");
						if(player.nextInt() == 1) {
							if(wallet >= board.get(position).getPrice()) {
								board.get(position).setPurchased(true);
								wallet -= board.get(position).getPrice();
								System.out.println("You bought " + board.get(position).getName());
								System.out.println("Your balance is $" + wallet);
								System.out.println("Your Properties:");
								ownedProp.add(new String(board.get(position).getName()));
								for(String a: ownedProp) {
									System.out.println(a);
								}
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
		board.add(new Colored("Swamp", 1, 60, false, true));
		board.add(new Nonpurchaseable("Community Chest", 2, false));
		board.add(new Colored("Yoda's Hut", 3, 60, false, true));
		board.add(new Nonpurchaseable("Docking Tax", 4, false));
		board.add(new Noncolored("Tie Fighter", 5, 200, false, true));
		board.add(new Colored("Echo Base", 6, 100, false, true));
		board.add(new Nonpurchaseable("Chance", 7, false));
		board.add(new Colored("Frozen Plains", 8, 100, false, true));
		board.add(new Colored("North Ridge", 9, 120, false, true));
		board.add(new Nonpurchaseable("Jail", 10, false));
		board.add(new Colored("Lars Homestead", 11, 140, false, true));
		board.add(new Noncolored("Reactor Core", 12, 150, false, true));
		board.add(new Colored("Mos Eisley", 13, 140, false, true));
		board.add(new Colored("Jabba's Palace", 14, 160, false, true));
		board.add(new Noncolored("Millennium Falcon", 15, 200, false, true));
		board.add(new Colored("War Room", 16, 180, false, true));
		board.add(new Nonpurchaseable("Community Chest", 17, false));
		board.add(new Colored("Massassi Temple", 18, 180, false, true));
		board.add(new Colored("Temple Throne Room", 19, 200, false, true));
		board.add(new Nonpurchaseable("Parking", 20, false));
		board.add(new Colored("Lando's Platform", 21, 220, false, true));
		board.add(new Nonpurchaseable("Chance", 22, false));
		board.add(new Colored("Carbon Freezing Chamber", 23, 220, false, true));
		board.add(new Colored("Reactor Control Room", 24, 240, false, true));
		board.add(new Noncolored("X-Wing Fighter", 25, 200,false, true));
		board.add(new Colored("Landing Bay", 26, 260, false, true));
		board.add(new Colored("Throne Room", 27, 260, false, true));
		board.add(new Noncolored("Moisture Farm", 28, 150, false, true));
		board.add(new Colored("Central Control", 29, 280, false, true));
		board.add(new Nonpurchaseable("Go To Jail", 30, false));
		board.add(new Colored("Forest", 31, 300, false, true));
		board.add(new Colored("Shield Generator", 32, 300,false, true));
		board.add(new Nonpurchaseable("Community Chest", 33, false));
		board.add(new Colored("Ewok Village", 34, 320, false, true));
		board.add(new Noncolored("Star Destroyer", 35, 200, false, true));
		board.add(new Nonpurchaseable("Chance", 36, false));
		board.add(new Colored("Monument Square", 37, 350, false, true));
		board.add(new Nonpurchaseable("Bounty", 38, false));
		board.add(new Colored("Imperial Palace", 39, 400, false, true));
	} 
}
