import java.util.*;
public class Colored extends Purchaseable {
	private String color;
	public Colored(String n, String c, int i, int p, boolean pur, boolean cb) {
		name = n;
		color = c;
		index = i;
		price = p;
		purchased = pur;
		canBuy = cb;
	}
	
}
