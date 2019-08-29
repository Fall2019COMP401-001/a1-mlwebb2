package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int count = scan.nextInt();	// first input will be an integer indicating the total number of customers
		
		// int[] values = new int[count];
		
		String[] fName = new String[count]; // first name of each customer
		
		String[] lName = new String[count]; // last name of each customer
		
		for (int x = 0; x < count; x++) {
			
			fName[x] = scan.next();
			lName[x] = scan.next();
			int foodCount = scan.nextInt();
			
			int[] itemCount = new int[foodCount];
			double[] foodPrice = new double[foodCount];
			String[] foodName = new String[foodCount];
			
			for (int y = 0; y < foodCount; y++) {
				
				itemCount[y] = scan.nextInt();
				foodName[y] = scan.next();
				foodPrice[y] = scan.nextDouble();
			}
			
			double total = calculateTotal(itemCount, foodPrice);
			
			System.out.println(fName[x].charAt(0) + ". " + lName[x] + ": " + String.format("%.2f", total));
		}
		
		scan.close();
		
	}

	public static double calculateTotal(int[] itemCount, double[] foodPrice) {
		double total = 0;
		for (int x = 0; x < itemCount.length; x++) {
			double num = itemCount[x] * foodPrice[x];
			total += num;
		}
		return total;
	}
}
