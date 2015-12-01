import java.util.*;
public abstract class Square {
	protected String name;
	protected int index;
	protected boolean canBuy;
	public abstract String getName();
	public int getIndex() {
		return index;
	}
	public boolean getCanBuy() {
		return canBuy;
	}
	
	//Not sure
	protected boolean purchased;
	public boolean getPurchased() {
		return purchased;
	}
	public void setPurchased(boolean purchased) {
		this.purchased = purchased;
	}
	protected int price;
	public int getPrice() {
		return price;
	}
}
