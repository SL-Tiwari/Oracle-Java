package duke.choice.ShopApp;

import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.*;


import java.util.Arrays;

public class ShopApp {
	final double pi = 3.14;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final double tax_per = 0.2;
		double total = 0;
		int avg = 0;
		double totalPrice = 0;
		int totalQuantity = 0;

		System.out.println("Welcome to choice Shopping App!!" + "\n");
		Customer c1 = new Customer("Pinky", 12);

		System.out.println("Hello " + c1.name + " your size is " + c1.getSize() + "\n");

		Clothing item1 = new Clothing("Blue Jacket", 20.9, "M", 1);
		Clothing item2 = new Clothing("Orange T-Shirt", 10.5, "S", 2);
		Clothing item3 = new Clothing("Green Scaf", 5, "S", 2);
		Clothing item4 = new Clothing("Blue T-Shirt", 1, "S", 2);

		Clothing[] items = { item1, item2, item3, item4 };
		c1.addItems(items);
		c1.getTotalClothingCost();

		try {
			ItemList list = new ItemList(items);
			Routing routing = Routing.builder().get("/items",list).build();
			ServerConfiguration config = ServerConfiguration.builder().bindAddress(InetAddress.getLocalHost()).port(8088).build();
			WebServer ws = WebServer.create(config , routing);
			ws.start();
			
			
		}
		catch(UnknownHostException ex){
			ex.printStackTrace();
		}
		
		for (Clothing clothing : c1.returnItems()) {
			if (clothing.getSize().equals("S")) {
				totalPrice += clothing.getPrice();
				totalQuantity += clothing.getQuantity();
			}
		}
		
		
		try {
			avg =(totalQuantity==0)? 0: (int)totalPrice / totalQuantity;
			System.out.println("\nAverage of the shopping cart is " +avg);
		}
		catch(ArithmeticException e)
		{
			System.out.println("Dont divide by zero");
		}
		Arrays.sort(c1.returnItems());

		for (Clothing item : c1.returnItems()) {
			System.out.println(item);

		}


	}

}
