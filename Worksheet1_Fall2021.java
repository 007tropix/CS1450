// CS1450 Assignment 6 Fall 2021
// Worksheet #1: Stacks
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Worksheet1_Fall2021 {

	public static void main(String[] args) throws IOException {
		
		// Name of file to read from
		final String TRAINS_FILE_NAME = "Worksheet1Trains.txt";	

		// Setup a file reference variable to refer to text file
		File trainsFileName = new File(TRAINS_FILE_NAME);

		// First value in the file tells how many trains are in the file
		Scanner trainsFile = new Scanner (trainsFileName);
		int numTrainsInFile = trainsFile.nextInt();

		//************************
		// Worksheet1 Question #2: 
		// Write the code to create a stack of trains
		// ***********************
		// ADD YOUR CODE HERE
		
		Stack<TrainW1> trainStack = new Stack<>();

		
		
		// Create the train objects from the details provided in the file
		for(int i = 0; i < numTrainsInFile; i++) {
			
			// Read information from file and create a train
			int engineNumber = trainsFile.nextInt();
			String destCity = (trainsFile.nextLine()).trim();

			TrainW1 train = new TrainW1(engineNumber, destCity);		

			// Print the train's details
			System.out.println(train.toString());
	
			// ***********************
			// Worksheet1 Question #3: 
			// What code is needed to add the train to the stack
			//*************************
			// ADD YOUR CODE HERE

			trainStack.push(train);
			
		} // for each train
		

		//***********************
		// Worksheet1 Question #4
		// What code prints the engine number and destination city of each train on the stack.  
		// Look in the file to see the numbers and destination of the trains.
		// Use a while loop to perform this task.
		//***********************
		// ADD YOUR CODE HERE
		System.out.println();
		System.out.println();
		System.out.println("Trains on Stack");
		System.out.println("---------------------------------");
		while (trainStack.isEmpty() == false) {
			System.out.printf("%d\t%s\n", 
					trainStack.peek().getEngineNumber(),
					trainStack.peek().getDestinationCity());
			trainStack.pop();
		}

		
		
		
		
		
		
		//****************************************
		// Worksheet1 Question #6
		// Write one line of code to access the top element on the stack without removing it  
		//****************************************
		// ADD YOUR CODE HERE
		System.out.println();
		System.out.println();
		
		trainStack.peek();
		
		
		
		
	
		trainsFile.close();
		
	} // main

} // Worksheet1


//Class representing the generic stack - named it GenericStackW1 to avoid name clashing issues
class GenericStackW1<E>  {

	private ArrayList<E> list;		// Storage for stack is provided by an ArrayList
	
	public GenericStackW1() {
		list = new ArrayList<>();
	}
	
	public boolean isEmpty (){
		return list.isEmpty();
	}
	
	public int getSize(){
		return list.size();
	}

	// Returns the top element on the top without removing it
	// Since using array list to store elements, this means getting the last element in the array
	public E peek(){
		return list.get(getSize() - 1);
	}
	
	// Removed and returns the top element on the stack 
	// Since using array list to store elements, this means removing the last element in the array
	public E pop(){		
		E value = list.get(getSize()-1);
		list.remove(getSize() - 1);
		return value;
	}

	// Place a new element on the top of the stack
	// Since using array list to store elements, this means adding the element to the array
	public void push(E value){
		list.add(value); 
	}
	
} // GenericStackW1


//Represents a train - named it TrainW1 due to name clashing issues 
class TrainW1 { 
	
	private int engineNumber;			// Train's engine number
	private String destinationCity;		// Train's destination city

	
	public TrainW1 (int engineNumber, String destinationCity) {
		this.engineNumber= engineNumber;
		this.destinationCity = destinationCity;
	}
		
	public int getEngineNumber() {
		return engineNumber;
	}
	
	public String getDestinationCity() {
		return destinationCity;
	}
	
	// Create and returns a string containing train details
	@Override
	public String toString() {
		return String.format("%d\t%-5s", 
							 engineNumber, 
							 destinationCity);
	} // toString
		
} // TrainW1


