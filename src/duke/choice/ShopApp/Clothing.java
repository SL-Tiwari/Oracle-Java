package duke.choice.ShopApp;

public class Clothing implements Comparable<Clothing> {

	 private String description;
	 private double price;
	 private String size="M";
	 private int quantity=0;
	 private static final double MIN_VAL=10;
	 private static final double TAX_RATE=0.2;
	 
	 
	 
	
	/**
	 * @param description
	 * @param price
	 */
	public Clothing(String description, double price,String size,int quantity) {
		super();
		this.description = description;
		setPrice(price);
		this.size=size;
		this.quantity=quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		description = description;
	}

	public double getPrice() {
		return price + price * TAX_RATE;
	}

	public void setPrice(double price) {		
		
		this.price = price < 10?MIN_VAL:price ;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "\nClothing item desc =" + description + ", price=" + price + ", size=" + size + ", quantity=" + quantity;
	}

	@Override
	public int compareTo(Clothing c) {
		return this.description.compareTo(c.description);
	}

	
}
