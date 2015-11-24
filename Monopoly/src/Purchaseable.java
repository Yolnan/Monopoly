import java.util.*;
public abstract class Purchaseable extends Square {
	protected int price;
	protected boolean purchased;
	public String getName() {
		return name;
	}
	public int getIndex() {
		return index;
	}
	public int getPrice() {
		return price;
	}
	public boolean getPurchased() {
		return purchased;
	}
}
