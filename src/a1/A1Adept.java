package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int items = scan.nextInt();
		
		String[] itemNames = new String[items];
		double[] itemPrices = new double[items];
		
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
			int foodCount = scan.nextInt(); //
			
			int[] itemCount = new int[foodCount];
			// double[] foodPrice = new double[foodCount];
			String[] foodName = new String[foodCount];
			
			for (int y = 0; y < foodCount; y++) {
				
				itemCount[y] = scan.nextInt();
				foodName[y] = scan.next();
				
			}
			totals[x] = calculateTotal(itemNames, itemPrices, itemCount, foodName);
		}
		
		int smallest = smallSpender(totals);
		int biggest = bigSpender(totals);
		double average = calculateAverage(totals);
		
		System.out.println("Biggest: " + fName[biggest] + " " + lName[biggest] + " (" + String.format("%.2f", totals[biggest]) + ") ");
		System.out.println("Smallest: " + fName[smallest] + " " + lName[smallest] + " (" + String.format("%.2f", totals[smallest]) + ") ");
		System.out.println("Average: " + String.format("%.2f", average));
		// System.out.println(totals[2]);
		
		scan.close();

	}
	
	static double calculateTotal(String[] itemNames, double[] itemPrices, int[] itemCount, String[] foodName) {
		double total = 0;
		for (int x = 0; x < itemCount.length; x++) {
			for (int y = 0; y < itemNames.length; y++ ) {
				if (foodName[x].equals(itemNames[y])) {
					double num = itemPrices[y] * itemCount[x];
					total += num;
				}
				
			}
		}
		return total;
	}
	
	static double calculateAverage(double[] totals) {
		double average = 0; 
		double sum = 0; 
		for (int x = 0; x < totals.length; x++) {
			double num = totals[x];
			sum += num;
			if (x == totals.length - 1) {
				average = sum / (totals.length);
			}
		}
		return average;
	}

	static int smallSpender(double[] totals) {
		double lowest = totals[0];
		int num = 0;
		for (int x = 0; x < totals.length; x++) {
			if (lowest > totals[x]) {
				lowest = totals[x];
				num = x;
			}
		}
		return num;
	}

	static int bigSpender(double[] totals) {
		double biggest = totals[0];
		int num = 0;
		for (int x = 0; x < totals.length; x++) {
			if (biggest < totals[x]) {
				biggest = totals[x];
				num = x;
			}
		}
		return num;
	}
}
