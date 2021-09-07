public class PurchaseOrder {
    private String itemID;
    private int quantity;
    private double price;

	public PurchaseOrder(String itemID, int quantity, double price) {
		if (itemID == null) {
			throw new NullPointerException();
		}
		this.itemID = itemID;
		this.quantity = quantity;
		this.price = price;
	}
	
	public boolean equals(Object o) {
		if (o instanceof PurchaseOrder) {
			PurchaseOrder other = (PurchaseOrder) o;
			return itemID.equals(other.itemID) && quantity == other.quantity && price == other.price;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return String.format("%s (%d x $%.2f)", itemID, quantity, price);
	}
	
// YOUR CODE GOES HERE
	@Override
	public int hashCode()
	{
		final int HASH_MULTIPLIER = 3;
		int h = 0;

		h = HASH_MULTIPLIER * quantity;
		h = (HASH_MULTIPLIER * h) + price

		for (char charac :: itemID)
		{
			h = (HASH_MULTIPLIER * h) + charac
		}

		return h;
	}
}
