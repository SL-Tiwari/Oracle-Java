package duke.choice.ShopApp;

public class Customer {
	String name;
	String size;
	private Clothing items[];
	
	
	public Customer(String name, int measurement) {
		super();
		this.name = name;
		setSize(measurement);
	}

	public void addItems(Clothing item[]) {
		this.items = item;
	}

	public Clothing[] returnItems() {
		return items;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setSize(int size) {
		switch (size) {
		case 1: case 2: case 3:
			setSize("S");
			break;
		case 4: case 5: case 6:
			setSize("M");
			break;
		case 7: case 8: case 9:
			setSize("L");
			break;
		default:
			setSize("XL");
		}

	}
	


	public double getTotalClothingCost() {
		double total = 0;

		for (Clothing clothing : items) {
			total += (clothing.getQuantity() * clothing.getPrice());
		}
		System.out.println("\nTotal price of the purchase is " + total);
		return total;

	}


}
