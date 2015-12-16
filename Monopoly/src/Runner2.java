
import java.util.ArrayList;
import java.util.Scanner;
public class Runner2 {
	static Scanner player = new Scanner(System.in);
	static ArrayList<Square> board = new ArrayList<Square>();
	static ArrayList<String>ownedProp = new ArrayList<String>();
	public static void main(String[] args) {
		System.out.println("Enter 1 for Regular Monopoly Board or else enter any other number for Star Wars Monopoly Board");
		if(player.nextInt() == 1) {
			makeSquareStandard();
		} else {
			makeSquareStarWars();
		}
		play();
	}
	public static void play() {
		int dice1;
		int dice2;
		int roll;
		int position = 0;
		int wallet = 1500;
		boolean back = false;
		while(true) {
			System.out.println("\nRoll Dice");
			if(player.hasNextLine()) {
				player.nextLine();
				dice1 = (int)(Math.random()*6 + 1);
				dice2 = (int)(Math.random()*6 + 1);
				roll = dice1 + dice2;
				if((position + roll) >= 40) {
					if(back == false) {
						wallet += 200;
						System.out.println("You received $200 for passing/landing on go");
						System.out.println("Your balance is $" + wallet);
					}
				}
				if(back == false) {
					position = (position + roll)%40;
					if(position == 10) {
						back = true;
					}
				} else {
					if(position - roll < 0) {
						position = position - roll + 40;
					} else {
						position = (position - roll);
					}
					if(position == 10) {
						back = false;
					}
				}
				
				System.out.println("You rolled " + roll + "\tYou landed on " + board.get(position).getName());
				if(board.get(position).getCanBuy() == true) {
					if(((Purchaseable) board.get(position)).getPurchased() == false) {
						System.out.println("Buy " + board.get(position).getName() + " for $" + ((Purchaseable) board.get(position)).getPrice());
						System.out.println("Press 1 to buy, else enter any other number");
						if(player.nextInt() == 1) {
							if(wallet >= ((Purchaseable) board.get(position)).getPrice()) {
								((Purchaseable) board.get(position)).setPurchased(true);
								wallet -= ((Purchaseable) board.get(position)).getPrice();
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
	public static void makeSquareStandard() {
		board.add(new Nonpurchaseable("Go", 0, false));
		board.add(new Colored("Mediterranean Avenue", "Brown", 1, 60, false, true));
		board.add(new Nonpurchaseable("Community Chest", 2, false));
		board.add(new Colored("Baltic Avenue", "Brown", 3, 60, false, true));
		board.add(new Nonpurchaseable("Income Tax", 4, false));
		board.add(new Noncolored("Reading Railroad", 5, 200, false, true));
		board.add(new Colored("Oriental Avenue", "Light blue", 6, 100, false, true));
		board.add(new Nonpurchaseable("Chance", 7, false));
		board.add(new Colored("Vermont Avenue", "Light Blue", 8, 100, false, true));
		board.add(new Colored("Connecticut Avenue", "Light Blue", 9, 120, false, true));
		board.add(new Nonpurchaseable("Jail", 10, false));
		board.add(new Colored("St. Charles Place", "Pink", 11, 140, false, true));
		board.add(new Noncolored("Electric Company", 12, 150, false, true));
		board.add(new Colored("States Avenue", "Pink", 13, 140, false, true));
		board.add(new Colored("Virginia Avenue", "Pink", 14, 160, false, true));
		board.add(new Noncolored("Pennsylvania Railroad", 15, 200, false, true));
		board.add(new Colored("St. James Place", "Orange", 16, 180, false, true));
		board.add(new Nonpurchaseable("Community Chest", 17, false));
		board.add(new Colored("Tennessee Avenue", "Orange", 18, 180, false, true));
		board.add(new Colored("New York Avenue", "Orange", 19, 200, false, true));
		board.add(new Nonpurchaseable("Parking", 20, false));
		board.add(new Colored("Kentucky Avenue", "Red", 21, 220, false, true));
		board.add(new Nonpurchaseable("Chance", 22, false));
		board.add(new Colored("Indiana Avenue", "Red", 23, 220, false, true));
		board.add(new Colored("Illinois Avenue", "Red", 24, 240, false, true));
		board.add(new Noncolored("B & O Railroad", 25, 200,false, true));
		board.add(new Colored("Atlantic Avenue", "Yellow", 26, 260, false, true));
		board.add(new Colored("Ventnor Avenue", "Yellow", 27, 260, false, true));
		board.add(new Noncolored("Water Works", 28, 150, false, true));
		board.add(new Colored("Market Gardens", "Yellow", 29, 280, false, true));
		board.add(new Nonpurchaseable("Go To Jail", 30, false));
		board.add(new Colored("Pacific Avenue", "Green", 31, 300, false, true));
		board.add(new Colored("North Carolina", "Green", 32, 300,false, true));
		board.add(new Nonpurchaseable("Community Chest", 33, false));
		board.add(new Colored("Pennsylvania Avenue", "Green", 34, 320, false, true));
		board.add(new Noncolored("Short Line", 35, 200, false, true));
		board.add(new Nonpurchaseable("Chance", 36, false));
		board.add(new Colored("Park Place", "Dark Blue", 37, 350, false, true));
		board.add(new Nonpurchaseable("Luxary Tax", 38, false));
		board.add(new Colored("Boardwalk", "Dark Blue", 39, 400, false, true));
	} 
	public static void makeSquareStarWars() {
		board.add(new Nonpurchaseable("Go", 0, false));
		board.add(new Colored("Swamp", "Degobah", 1, 60, false, true));
		board.add(new Nonpurchaseable("Community Chest", 2, false));
		board.add(new Colored("Yoda's Hut", "Degobah", 3, 60, false, true));
		board.add(new Nonpurchaseable("Docking Tax", 4, false));
		board.add(new Noncolored("Tie Fighter", 5, 200, false, true));
		board.add(new Colored("Echo Base", "Hoth", 6, 100, false, true));
		board.add(new Nonpurchaseable("Chance", 7, false));
		board.add(new Colored("Frozen Plains", "Hoth", 8, 100, false, true));
		board.add(new Colored("North Ridge", "Hoth", 9, 120, false, true));
		board.add(new Nonpurchaseable("Jail", 10, false));
		board.add(new Colored("Lars Homestead", "Tatooine", 11, 140, false, true));
		board.add(new Noncolored("Reactor Core", 12, 150, false, true));
		board.add(new Colored("Mos Eisley", "Tatooine", 13, 140, false, true));
		board.add(new Colored("Jabba's Palace", "Tatooine", 14, 160, false, true));
		board.add(new Noncolored("Millennium Falcon", 15, 200, false, true));
		board.add(new Colored("War Room", "Yavin 4", 16, 180, false, true));
		board.add(new Nonpurchaseable("Community Chest", 17, false));
		board.add(new Colored("Massassi Temple", "Yavin 4", 18, 180, false, true));
		board.add(new Colored("Temple Throne Room", "Yavin 4", 19, 200, false, true));
		board.add(new Nonpurchaseable("Parking", 20, false));
		board.add(new Colored("Lando's Platform", "Cloud City", 21, 220, false, true));
		board.add(new Nonpurchaseable("Chance", 22, false));
		board.add(new Colored("Carbon Freezing Chamber", "Cloud City", 23, 220, false, true));
		board.add(new Colored("Reactor Control Room", "Death Star", 24, 240, false, true));
		board.add(new Noncolored("X-Wing Fighter", 25, 200,false, true));
		board.add(new Colored("Landing Bay", "Death Star", 26, 260, false, true));
		board.add(new Colored("Throne Room", "Death Star", 27, 260, false, true));
		board.add(new Noncolored("Moisture Farm", 28, 150, false, true));
		board.add(new Colored("Central Core", "Death Star", 29, 280, false, true));
		board.add(new Nonpurchaseable("Go To Jail", 30, false));
		board.add(new Colored("Forest", "Endor", 31, 300, false, true));
		board.add(new Colored("Shield Generator", "Endor", 32, 300,false, true));
		board.add(new Nonpurchaseable("Community Chest", 33, false));
		board.add(new Colored("Ewok Village", "Endor", 34, 320, false, true));
		board.add(new Noncolored("Star Destroyer", 35, 200, false, true));
		board.add(new Nonpurchaseable("Chance", 36, false));
		board.add(new Colored("Monument Square", "Coruscant", 37, 350, false, true));
		board.add(new Nonpurchaseable("Bounty", 38, false));
		board.add(new Colored("Imperial Palace", "Coruscant", 39, 400, false, true));
	} 
}