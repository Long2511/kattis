/** * OOP Java Project  WiSe 2024/2025

 * Problem: Problem A Sauna
 * Link: https://open.kattis.com/contests/p6fq6m/problems/sauna
 * @author Mac Hai Long
 * @version 1.0, 27/11/2024
 * Status : Accepted
 * Runtime: 	0.93 s
 **/

package Week5.A;

import java.util.Scanner;

public class Sauna {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int count = scanner.nextInt(); //The number of temperature ranges to be read.
		int minTemp = Integer.MIN_VALUE;
		int maxValue = Integer.MAX_VALUE;
		int numberOfDifferences; // the number of valid temperature ranges.

		// count times to read pairs of integers representing the minimum
		// and maximum temperatures of each range.
		for (int i = 0; i < count; i++) {
			int firstValue = scanner.nextInt();
			int secondValue = scanner.nextInt();

			if (firstValue > minTemp) {
				minTemp = firstValue;
			}

			if (secondValue < maxValue) {
				maxValue = secondValue;
			}
		}

		numberOfDifferences = maxValue - minTemp + 1;

		if (numberOfDifferences <= 0) {
			// If numberOfDifferences is less than or equal to 0
			// prints "bad news" indicating no valid temperature range.
			System.out.println("bad news");
		} else {
			//prints the number of valid temperature ranges
			// and the highest minimum temperature.
			System.out.println(numberOfDifferences + " " +minTemp);
		}
	}
}
