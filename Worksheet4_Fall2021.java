// CS 1450 Assignment #4 Solution Fall 2021
// Topic: Nested Objects, 2-dimensional Arrays, Comparable, and Collections
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Worksheet4_Fall2021 {

	public static void main(String[] args) {
		
		// Setup some hard coded trains to use in the queue questions.
		// Create two hard coded trains - hard coding is the way to go when learning.
		// Of course we would not do this in an assignment!  I'm doing it for testing purposes.
		TrainW4 train1 = new TrainW4(8107);      // Train with engine #807
		TrainW4 train2 = new TrainW4(4262);      // Train with engine #4262
		
		// Add some rail cars to each train
		// Note this time I'm adding the rail cars with a call to addRailCar method on the train.
		// Create 4 hard coded rail car objects and add them to train 8107's rail cars queue		
		train1.addRailCar(new RailCarW4(11));
		train1.addRailCar(new RailCarW4(12));
		train1.addRailCar(new RailCarW4(62));
		train1.addRailCar(new RailCarW4(81));
		
		// Create 2 hard coded rail car objects and add them to train 4262's rail cars queue
		train2.addRailCar(new RailCarW4(66));
		train2.addRailCar(new RailCarW4(90));
		
		// *************************
		// Worksheet4 Question #3a
		// Write the declaration for a priority queue of trains (TrainW4 objects)
		//**************************
		PriorityQueue<TrainW4> departureTrack = new PriorityQueue<TrainW4>();
		
		
		
		//********************************
		// Worksheet4 Question #3b
		// See Train Class below
		//********************************

		
		// *******************************
		// Worksheet4 Question #3c 
		// Write code to add train1 and train2 to the priority queue
		//********************************
		departureTrack.add(train1);
		departureTrack.add(train2);
		
		
		
		
		System.out.println("Train #1 in priority queue");
		System.out.println("Train #2 in priority queue");


	} // main
	
} // Worksheet4



class RailCarW4  {
	
	private int number;			
	
	public RailCarW4 (int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
	
} // RailCar



class TrainW4 implements Comparable<TrainW4>{ 
	
	private int engineNumber;		// Train's engine number

	private Queue<RailCarW4> railCars = new LinkedList<>();

	
	public TrainW4 (int engineNumber) {
		this.engineNumber= engineNumber;
	}
		
	// ***********************************
	// Worksheet4 Question #3b
	// Copy your answer from Worksheet3 here
	// ***********************************
	public int getRailCarsSize() {
		return railCars.size();


	}
	
	// ***********************************
	// Worksheet4 Question #3b
	// Copy your answer from Worksheet3 here
	// ***********************************
	public void addRailCar(RailCarW4 railCar) {
		railCars.add(railCar);


	}
	
	// ***********************************
	// Worksheet4 Question #3b
	// Copy your answer from Worksheet3 here
	// ***********************************
	public RailCarW4 getRailCar() {
		return railCars.peek();


	}

	// *************************
	// Worksheet4 Question #3g
	// Add the code from question 3g here
	//**************************
	@Override
	public int compareTo(TrainW4 otherTrain) {
		if (this.getRailCarsSize() > otherTrain.getRailCarsSize()) {
			return -1;
		}
		else if (this.getRailCarsSize() < otherTrain.getRailCarsSize()) {
			return 1;
		}
		else {
			return 0;
		}
	}

	
	
	
	
	
	
	
} // Train


