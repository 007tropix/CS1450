/*Ryan Du Plooy
 * Data Structures and Algorithms (T/R)
 * Assignment #4
 * Due 9/28/2021
 * This assignment is about working with Arrays, ArrayLists, and Collections. Also implementing the comparable interface in order to compare and sort Train objects using Collections.
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class DuPlooyRyanAssignment4 {

	public static void main(String[] args) throws IOException{
		File trainFile = new File("Trains.txt");
		Scanner trainReader = new Scanner(trainFile);
		
		Railroad myRailroad = new Railroad(trainReader.nextInt());
		
		// Creating all Train objects from Trains.txt and putting it into the Railroad object.
		while(trainReader.hasNextLine()) {
			int trackNumber = trainReader.nextInt();
			Train newTrain = new Train(trainReader.nextInt(), trainReader.next(), trainReader.nextInt(), trainReader.next(), trainReader.next());
			myRailroad.addTrainToSortingYard(trackNumber, newTrain);
		}
		
		myRailroad.displaySortingYard();
		printTrainReport(myRailroad);
		trainReader.close();
	}
	
	/*
	 * printTrainReport function is used in order to loop through a Railroad object and add each Train object to an ArrayList.
	 * Once the ArrayList has been created then the Trains will be sorted by using Collections.sort and the compareTo method that was
	 * overridden in the Train class.
	 * Then printTrainReport will loop through and print the sorted ArrayList in a formatted way.
	 */
	
	public static void printTrainReport(Railroad railroad) {
		ArrayList<Train> trainList = new ArrayList<Train>();
		
		for (int i = 0; i < railroad.getNumberTracks(); i++) {
			if (railroad.getTrainInSortingYard(i) instanceof Train) {
				trainList.add(railroad.getTrainInSortingYard(i));
			}
		}
		
		System.out.println("*****************************************************************************");
		System.out.println("\t\t\t TRAIN REPORT");
		System.out.println("\t\t(Ordered by Number of Rail Cars");
		System.out.println("*****************************************************************************");
		System.out.println("Engine\tCompany\t\tRail Cars\tType\t\tDeparting To");
		System.out.println("-----------------------------------------------------------------------------");
		
		Collections.sort(trainList);
		
		for (int i = 0; i < trainList.size(); i++) {
			System.out.printf("%d\t%s\t\t%d\t\t%-15s\t%s", 
					trainList.get(i).getEngineNumber(),
					trainList.get(i).getCompany(),
					trainList.get(i).getNumberRailCars(),
					trainList.get(i).getType(),
					trainList.get(i).getDestinationCity());
			System.out.println();
		}
		
		
	}

}
/*
 * The Railroad class is used in order create a railroad object to store the Train objects by using the functions addTrainToSortingYard,
 * getTrainInSortingYard, and can be displayed by using displaySortingYard.
 */

class Railroad {
	private int numberTracks;
	private Train[] sortingYard;
	
	public Railroad(int numberTracks) {
		this.numberTracks = numberTracks;
		sortingYard = new Train[numberTracks];
	}
	
	public int getNumberTracks() {
		return(this.numberTracks);
	}
	
	public void addTrainToSortingYard(int trackNumber, Train train) {
		sortingYard[trackNumber] = train;
	}
	
	public Train getTrainInSortingYard(int trackNumber) {
		return(sortingYard[trackNumber]);
	}
	
	// displaySortingYard is used to format and print all current Trains in the sortingYard to console
	public void displaySortingYard() {
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("Track\tEngine\tCompany\t\tRail Cars\tType\t\tDestination");
		System.out.println("-------------------------------------------------------------------------------------------");
		for(int i = 0; i < sortingYard.length; i++) {
			if(sortingYard[i] instanceof Train) {
				System.out.printf("%d\t%d\t%s\t\t%d\t\t%-15s\t%s", i, 
						sortingYard[i].getEngineNumber(),
						sortingYard[i].getCompany(),
						sortingYard[i].getNumberRailCars(),
						sortingYard[i].getType(),
						sortingYard[i].getDestinationCity());
				System.out.println();
			}
			else {
				System.out.println(i + "\t----\t----\t\t----\t\t----\t\t----");
			}
		}
	}
} // End of Railroad class

/*
 * The Train class is used in order to create Train objects which are then stored in a railroad object.
 * The Train class contains 5 private variables which all have their own respective getters.
 * The Train class also overrides the toString method.
 * The Train class also implements the comparable interface and overrides the compareTo method. 
 */

class Train implements Comparable<Train> {
	private int engineNumber;
	private String company;
	private int numberRailCars;
	private String type;
	private String destinationCity;
	
	public Train(int engineNumber, String company, int numberRailCars, String type, String destinationCity) {
		this.engineNumber = engineNumber;
		this.company = company;
		this.numberRailCars = numberRailCars;
		this.type = type;
		this.destinationCity = destinationCity;
	}
	
	public int getEngineNumber(){
		return(this.engineNumber);
	}
	
	public String getCompany() {
		return(this.company);
	}
	
	public int getNumberRailCars() {
		return(this.numberRailCars);
	}
	
	public String getType() {
		return(this.type);
	}
	
	public String getDestinationCity() {
		return(this.destinationCity);
	}
	
	@Override
	public String toString() {
		return String.format("%d\t%s\t\t%d\t\t%-15s\t%s", engineNumber, company, numberRailCars, type, destinationCity);
	}
	
	@Override
	public int compareTo(Train otherTrain) {
		if (this.getNumberRailCars() > otherTrain.getNumberRailCars()) {
			return -1;
		}
		else if (this.getNumberRailCars() < otherTrain.getNumberRailCars()) {
			return 1;
		}
		else {
			return 0;
		}
	}
} // End of Train class
