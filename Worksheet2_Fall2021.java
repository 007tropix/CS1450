// CS1450 Assignment 6 Fall 2021
// Worksheet #2: Simple Nested Objects (Queues: not nested in a class and nested in a class)
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS

import java.util.LinkedList;
import java.util.Queue;

public class Worksheet2_Fall2021 {

	public static void main(String[] args) {
		
		//*******************************************
		// Worksheet2 Question #1 
		// Queue in main - queue is NOT nested inside a class
		// Practice creating a queue here and adding the values 30,2,12,4
		//*******************************************
		// ADD CODE HERE

		Queue<Integer> queueNotNested = new LinkedList<>();
		queueNotNested.offer(30);
		queueNotNested.offer(2);
		queueNotNested.offer(12);
		queueNotNested.offer(4);
		
		
		
		
		// Test your queue that is not nested in a class by displaying the values in the queue
		System.out.println("Values in a queue that is not nested in a class");
		int queueLength = queueNotNested.size();
		for (int i = 0; i < queueLength; i++) {
			System.out.println("aQueue[" + i + "] = " + queueNotNested.remove());
		}
		

		//********************************
		// Worksheet2 Question #2
		// See NumericQueue Class below
		//********************************

		
		//********************************
		// Worksheet2 Question #3a 
		// Use this code to test your NumericQueue class.
		// The queue is now nested inside a class called NumericQueue.
		// Create an object of type NumericQueue and add the values 30,2,12,4
		//********************************
		NumericQueueW2 NumericQueue = new NumericQueueW2();
		NumericQueue.offer(30);
		NumericQueue.offer(2);
		NumericQueue.offer(12);
		NumericQueue.offer(4);

		
		
		
		
	
		//********************************
		// Worksheet2 Question #3b
		// Test your nested queue by displaying the values in the queue using a for loop.
		//********************************
		// ADD CODE HERE		
		System.out.println();
		System.out.println("Values in a queue nested in a class");
		int numericQueueLength = NumericQueue.size();
		for (int i = 0; i < numericQueueLength; i++) {
			System.out.println("NumericQueue[" + i + "] = " + NumericQueue.remove());
		}
		
		
		
		
	} // main

} // Worksheet2


//****************************************************
// Worksheet2 Question #2
// This class "contains" a queue of integers. (HAS-A relationship)
// The class will provide methods to access the queue which it contains.
// Write the code for each method.
//****************************************************
class NumericQueueW2 {
	
	private Queue<Integer> numQueue = new LinkedList<>();

	public int size() {
		return numQueue.size();
		

		
	}
	
	public void offer(Integer value) {
		numQueue.offer(value);

		
	}
	
	public Integer remove() {
		return numQueue.remove();

		
	}
	
} // NumericQueueW2
