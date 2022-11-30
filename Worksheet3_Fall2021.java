// CS1450 Assignment 6 Fall 2021
// Worksheet #3: Complicated Nested Objects
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS

import java.util.LinkedList;
import java.util.Queue;

public class Worksheet3_Fall2021 {

	public static void main(String[] args) {

		//**********************************
		// Worksheet3 Railroad Setup 
		//**********************************
		// I'm going to build a railroad and fill it with a bunch of trains by HARD CODING.
		// I'm doing this to test the code.
		
		// Create a railroad object that contains a sorting yard.
		// Remember the sorting yard is an array and each slot represents a track where a train may be.
		// This railroad's sorting yard will have 5 tracks
		int numberTracks = 5;
		RailroadW3 railroad = new RailroadW3(numberTracks);

		System.out.println();
		System.out.println("Hard coding 2 trains to test code");
		System.out.println("---------------------------------");
		System.out.println("8107 will contain 4 rail cars");
		System.out.println("4262 will contain 2 rail cars");
		System.out.println();

		// Hard code 2 trains - hard coding is the way to go when learning!
		// Of course we would not do this in an assignment!  I'm doing it for testing purposes.
		TrainW3 train1 = new TrainW3(8107);      // Train with engine #8107
		TrainW3 train2 = new TrainW3(4262);      // Train with engine #4262
		
		// Add trains to railroad - I'm hard coding the track number for trains for quick setup.
		// Of course we would not do this in a regular assignment - this is just for testing purposes
		railroad.addTrainToSortingYard(1, train1);
		railroad.addTrainToSortingYard(3, train2);
		
		// Add some rail cars to each train
		// Create some rail cars and add them to train 8107 which is on sorting yard track 1
		train1.addRailCar(new RailCarW3(11));
		train1.addRailCar(new RailCarW3(88));
		train1.addRailCar(new RailCarW3(33));
		train1.addRailCar(new RailCarW3(10));
		
		// Create some rail cars and add them to train 4262 which is on sorting yard track 3
		train2.addRailCar(new RailCarW3(60));
		train2.addRailCar(new RailCarW3(18));
	
		// Now the railroad is setup with trains and each train is setup with a queue of "rail cars"
		// Display some information to test the code
		System.out.println();
		System.out.println("Testing code - displaying train information");
		for (int track = 0; track < numberTracks; track++) {
			
			// Get a train out of the sorting yard array 
			TrainW3 aTrain = railroad.getTrainInSortingYard(track);
			
			// If there was a train in the array slot display the number of rail cars in the train's queue
			if (aTrain != null) {
				System.out.print("Train " + aTrain.getEngineNumber());
				System.out.println(" contains " + aTrain.getRailCarsSize() + " rail cars");				
			}
			
		} // for each track
		
		// Testing addRailCarToTrainInSortingYard method in railroad
		// Create a new rail car #99 and add to train on track 1 (8107)
		RailCarW3 aNewRailCar = new RailCarW3(99);
		railroad.addRailCarToTrainInSortingYard(1, aNewRailCar);
		
		// Now the train 8107 should have one more rail car
		// Display some information to test the code
		System.out.println();
		System.out.println("Testing code - train 8107 should now have 5 rail cars");
		for (int track = 0; track < numberTracks; track++) {
			
			// Get a train out of the sorting yard array 
			TrainW3 aTrain = railroad.getTrainInSortingYard(track);
			
			// If there was a train in the array slot display the number of rail cars in the train's queue
			if (aTrain != null) {
				System.out.print("Train " + aTrain.getEngineNumber());
				System.out.println(" contains " + aTrain.getRailCarsSize() + " rail cars");				
			}
			
		} // for each track

		
	} // main

} // Worksheet3


class RailCarW3  {
	
	private int number;			
	
	public RailCarW3 (int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
	
} // RailCar


//*******************************************
// Worksheet3 Question #1
// Write the code for each incomplete method
//*******************************************
class TrainW3 { 
	
	private int engineNumber;	// Train's engine number

	private Queue<RailCarW3> railCars = new LinkedList<>(); // Queue of rail cars 
																// that make up this train

	// Create a train
	public TrainW3 (int engineNumber) {
		this.engineNumber= engineNumber;
	}
		
	public int getEngineNumber() {
		return engineNumber;
	}
		
	public int getRailCarsSize() {
		return railCars.size();
		
		
	}
	
	public void addRailCar (RailCarW3 railCar) {
		railCars.add(railCar);
		
		
	}
	
	public RailCarW3 removeRailCar() {
		return railCars.remove();


	}
	
} // Train


// Represents the Railroad - a little different from assignment 4.  
// The railroad contains a sorting yard that is modeled using an array.
// Each location in the sorting yard contains a train object or null. 
class RailroadW3{

	private TrainW3[] sortingYard; 	// Array of trains that represent the sorting yard
	
	
	public RailroadW3(int numberTracks) {
		sortingYard = new TrainW3[numberTracks]; 
	}

	
	// Add train to a specific track in the sorting yard
	public void addTrainToSortingYard (int trackNumber, TrainW3 train) {
		sortingYard[trackNumber] = train;
	}
	
	
	// Returns the train in the specified track in the sorting yard array.  
	// When a track does NOT contain a train return null.
	public TrainW3 getTrainInSortingYard(int trackNumber) {
		
		// Return the train which could be null if the slot is empty
		// Student Note: When you created the array, Java initialized the array with null values
		return sortingYard[trackNumber];
	}

	
	//********************************
	// Worksheet3 Question #3
	// Add a rail car to a train in the sorting yard on a specific track
	//********************************
	public void addRailCarToTrainInSortingYard(int trackNumber, RailCarW3 railCar) {
		this.getTrainInSortingYard(trackNumber).addRailCar(railCar);
		
		
		
		
	}
	 
} // Railroad