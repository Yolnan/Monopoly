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
}
