package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int items = scan.nextInt();
		
		String[] itemNames = new String[items];
		double[] itemPrices = new double[items];
		int[] customersBought = new int[items];
		int[] totalItems = new int[items];
		
		for (int x = 0; x < items; x++) {
			
			itemNames[x] = scan.next();
			itemPrices[x] = scan.nextDouble();
			
		}
		
		int count = scan.nextInt();
		String[] fName = new String[count]; // first name of each customer
		String[] lName = new String[count]; // last name of each customer
		double[] totals = new double[count];
		
		for (int x = 0; x < count; x++) {
			
			fName[x] = scan.next();
			lName[x] = scan.next();
			int foodCount = scan.nextInt();
			
			int[] itemCount = new int[foodCount];
			// double[] foodPrice = new double[foodCount];
			String[] foodName = new String[foodCount];
			
			for (int y = 0; y < foodCount; y++) {
				
				itemCount[y] = scan.nextInt();
				foodName[y] = scan.next();
				
			}
			// totals[x] = calculateTotal(itemNames, itemPrices, itemCount, foodName);
			for (int a = 0; a < itemNames.length; a++) {
				int b = customersWhoBoughtItems(itemNames[a], foodName);
				customersBought[a] = customersBought[a] + b;
			}
			for (int d = 0; d < itemNames.length; d++) {
				int a = countingTotalItems(itemNames[d], itemCount, foodName);
				totalItems[d] = totalItems[d] + a;
			}
			for (int i = 0; i < itemNames.length; i++) {
				if (customersBought[i] == 0) {
					System.out.println("No customers bought " + itemNames[i]);
				} else {
					System.out.println(customersBought[i] + " customers bought " + totalItems[i] + " " + itemNames[i]);
				}
			}
		}
		
	}

	static int countingTotalItems(String storeItem, int[] itemCount, String[] foodName) {
		int totalItems = 0;
		for (int i = 0; i < foodName.length; i++) {
			if (storeItem.contentEquals(foodName[i])) {
				totalItems += itemCount[i];
			}
		}
		return totalItems;
	}

	static int customersWhoBoughtItems(String itemNames, String[] foodName) {
		for (int x = 0; x < foodName.length; x++) {
			if (itemNames.equals(foodName)) {
				return 1;
			}
		}
		return 0;
	}
}
