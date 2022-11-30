/*Ryan Du Plooy
 * Data Structures and Algorithms (T/R)
 * Assignment #1
 * Due 9/2/2021
 * This assignment is about practicing working with arrays as well as writing and reading from files.
 */

import java.util.Arrays;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class DuPlooyRyanAssignment1 {

	public static void main(String[] args) throws IOException {
		int[] array1 = {13, 18, 1, 4, 8, 16, 11};
		int[] array2 = {9, 10, 5, 12, 3, 7, 14};
		// Start of task1
		System.out.println("Array 1: Original\n------------------");
		for(int i = 0; i < array1.length; i++) {
			System.out.println("array1[" + i + "] = " + array1[i]);
		}
		
		System.out.println("\nArray 2: Original\n------------------");
		for(int i = 0; i < array2.length; i++) {
			System.out.println("array2[" + i + "] = " + array2[i]);
		}
		
		int tempValue; // temporary value used for swapping values between array1 and array2
		for(int i = 0; i < array1.length; i++) {
			if (array1[i] % 2 != 0) { // check to see if current value is odd
				for(int j = 0; j < array2.length; j++) {
					if (array2[j] % 2 == 0) { // check to see if current value is even and should be swapped
						tempValue = array1[i];
						array1[i] = array2[j];
						array2[j] = tempValue;
					}
				}
			}
		}
		
		Arrays.sort(array1); // Sort array 1 by least to greatest
		Arrays.sort(array2); // Sort array 2 by least to greatest
		
		System.out.println("Array 1: Sorted With Even Values\n------------------"); // Print sorted array1 (should be all even)
		for(int i = 0; i < array1.length; i++) {
			System.out.println("array1[" + i + "] = " + array1[i]);
		}
		
		System.out.println("\nArray 2: Sorted With Odd Values\n------------------"); // Print sorted array2 (should be all odd)
		for(int i = 0; i < array2.length; i++) {
			System.out.println("array2[" + i + "] = " + array2[i]);
		}
		// End of task1
		
		// Start of task2
		
		File fileName = new File("assignment1.txt");
		PrintWriter outputFile = new PrintWriter (fileName);
		
		System.out.println("\nFile is in directory: " + fileName.getAbsolutePath() + "\n");
		int index1 = 0;
		int index2 = 0;
		
		while(index1 < array1.length && index2 < array2.length) {
			if (array1[index1] < array2[index2]) { // Check if the current value of array1 is smaller than array2
				System.out.println("Writing to file: " + array1[index1]);
				outputFile.println(array1[index1]);
				index1 = index1 + 1; // Shift index1 up by 1
			}
			else {
				System.out.println("Writing to file: " + array2[index2]); // Check if the current value of array2 is smaller than array1
				outputFile.println(array2[index2]);
				index2 = index2 + 1; // Shift index2 up by 1
			}
		}
		
		while(index1 != array1.length) { // Used for any remaining even integers left in array
			System.out.println("Writing to file: " + array1[index1]);
			outputFile.println(array1[index1]);
			index1 = index1 + 1;
		}
		
		while(index2 != array2.length) { // Used for any remaining odd integers left in array
			System.out.println("Writing to file: " + array2[index2]);
			outputFile.println(array2[index2]);
			index2 = index2 + 1;
		}
		outputFile.close();
		// End of task2
		
		// Start of task3
		Scanner readFile = new Scanner (fileName);
		int[] array3 = new int[array1.length + array2.length];
		for(int i = 0; i < array3.length; i++) {
			array3[i] = readFile.nextInt();
		}
		
		System.out.println("\n\nFinal Array\n------------------");
		for(int i = 0; i < array3.length; i++) {
			System.out.println("finalArray[" + i + "] = " + array3[i]);
		}
		readFile.close();
		// End of task3
	}
}


