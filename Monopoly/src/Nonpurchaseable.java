import java.util.*;
public class Nonpurchaseable extends Square {
	public Nonpurchaseable(String n, int i, boolean cb) {
		name = n;
		index = i;
		canBuy = cb;
	}
	public String getName() {
		return name;
	}
}
