/*Ryan Du Plooy
 * Data Structures and Algorithms (T/R)
 * Assignment #7
 * Due 10/29/2021
 * This assignment is about working with queues and priority queues in order to modify our assignment 4 code.
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DuPlooyRyanAssignment7 {

	public static void main(String[] args) throws IOException {
		File trainFile = new File("Trains7.txt");
		Scanner trainReader = new Scanner(trainFile);
		
		System.out.println("Loading trains onto tracks in sorting yard...\n");
		Railroad7 myRailroad = new Railroad7(trainReader.nextInt());
		while(trainReader.hasNextLine()) {
			int trackNumber = trainReader.nextInt();
			Train7 newTrain = new Train7(trainReader.nextInt(), trainReader.next(), trainReader.nextInt(), trainReader.next(), trainReader.next());
			myRailroad.addTrainToSortingYard(trackNumber, newTrain);
		}
		
		myRailroad.displaySortingYard();
		
		File railCarFile = new File("RailCars7.txt");
		Scanner railCarReader = new Scanner(railCarFile);
		
		System.out.println("\nLoading rail cars on receiving track...\n");
		while(railCarReader.hasNextLine()) {
			RailCar myRailCar = new RailCar(railCarReader.nextInt(), railCarReader.next(), railCarReader.next());
			myRailroad.addRailCarToReceivingTrack(myRailCar);
		}
		
		myRailroad.displayReceivingTrack();
		
		System.out.println("\nStart railroad yard simulation...\n");
		RailroadController myController = new RailroadController();
		
		myController.moveRailCarsToTrains(myRailroad);
		System.out.println("\n\n\nShow sorting yard with trains and rail cars...");
		myRailroad.displaySortingYard();
		
		System.out.println("\n\nController: Moving trains from sorting yard to departure track");
		System.out.println("--------------------------------------------------------------");
		myController.moveTrainsToDepartureTrack(myRailroad);
		
		System.out.println("\n\nController: Moving trains from departure track to main line - longer trains go first");
		System.out.println("-----------------------------------------------------------------------------------");
		myController.clearedForDeparture(myRailroad);
		
		System.out.println("\n\nShowing sorting yard with no trains...\n");
		myRailroad.displaySortingYard();
		
		System.out.println("\n\nEnd railroad yard simulation...");
		
		trainReader.close();
		railCarReader.close();
		

	} // End of main
}
	class Railroad7 {
		private int numberTracks;
		private Train7[] sortingYard;
		private Queue<RailCar> receivingTrack = new LinkedList<>();
		private PriorityQueue<Train7> departureTrack = new  PriorityQueue<Train7>();
		
		
		public Railroad7(int numberTracks) {
			this.numberTracks = numberTracks;
			sortingYard = new Train7[numberTracks];
		}
		
		public int getNumberTracks() {
			return(this.numberTracks);
		}
		
		public void addTrainToSortingYard(int trackNumber, Train7 train) {
			sortingYard[trackNumber] = train;
		}
		
		public Train7 getTrainInSortingYard(int trackNumber) {
			return(sortingYard[trackNumber]);
		}
		
		// displaySortingYard is used to format and print all current Trains in the sortingYard to console
		public void displaySortingYard() {
			System.out.println("-------------------------------------------------------------------------------------------");
			System.out.println("Track\tEngine\tCompany\t\tRail Cars\tType\t\tDestination");
			System.out.println("-------------------------------------------------------------------------------------------");
			for(int i = 0; i < sortingYard.length; i++) {
				if(sortingYard[i] instanceof Train7) {
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
		
		public boolean isReceivingTrackEmpty() {
			if (receivingTrack.isEmpty()) {
				return true;
			}
			else {
				return false;
			}
		}
		
		public void addRailCarToReceivingTrack(RailCar railcar) {
			receivingTrack.offer(railcar);
		}
		
		public RailCar removeRailCarFromReceivingTrack() {
			RailCar returnCar = receivingTrack.poll();
			return returnCar;
		}
		
		public boolean isDepartureTrackEmpty() {
			if (departureTrack.isEmpty()) {
				return true;
			}
			else {
				return false;
			}
		}
		
		public void addTrainToDepartureTrack(Train7 train) {
			departureTrack.offer(train);
		}
		
		public Train7 removeTrainFromDepartureTrack() {
			Train7 returnTrain = departureTrack.remove();
			return returnTrain;
		}
		
		public int findTrain(RailCar railcar) {
			for (int i = 0; i < this.numberTracks; i++) {
				if (this.getTrainInSortingYard(i) != null){
					if (railcar.getDestination().equals(this.getTrainInSortingYard(i).getDestinationCity()) && railcar.getType().equals(this.getTrainInSortingYard(i).getType())) {
						return i;
					}
				}
			}
			return 0;
		}
		
		public void addRailCarToTrainInSortingYard(RailCar railcar, int trackNumber) {
			sortingYard[trackNumber].addRailCar(railcar);
		}
		
		public void removeTrainFromSortingYard(int trackNumber) {
			sortingYard[trackNumber] = null;
		}
		
		public void displayReceivingTrack() {
			System.out.println("-------------------------------------------------------------------------------------------");
			System.out.println("Number\tType\t\tDestination");
			System.out.println("-------------------------------------------------------------------------------------------");
			Queue<RailCar> tempQueue = new LinkedList<>();
			int size = receivingTrack.size();
			
			for(int i = 0; i < size; i++) {
				RailCar tempCar = receivingTrack.poll();
				tempQueue.offer(tempCar);
				System.out.println(tempCar.toString());
			}
			
			for (int i = 0; i < size; i++) {
				RailCar tempCar = tempQueue.poll();
				receivingTrack.offer(tempCar);
			}
		}
		
		
	} // End of Railroad class
	
	class Train7 implements Comparable<Train7> {
		private int engineNumber;
		private String company;
		private int numberRailCars;
		private String type;
		private String destinationCity;
		private Queue<RailCar> railCars = new LinkedList<>();
		
		public Train7(int engineNumber, String company, int numberRailCars, String type, String destinationCity) {
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
		public int compareTo(Train7 otherTrain) {
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
		
		public void addRailCar(RailCar railcar) {
			railCars.offer(railcar);
			this.numberRailCars++;
		}
	} // End of Train class


	class RailCar {
		private int number;
		private String type;
		private String destination;
		
		public RailCar(int number, String type, String destination) {
			this.number = number;
			this.type = type;
			this.destination = destination;
		}
		
		public int getNumber() {
			return number;
		}
		
		public String getType() {
			return type;
		}
		
		public String getDestination() {
			return destination;
		}
		
		public String toString() {
			if (type.length() > 8) {
				return(number + "\t" + type + "\t" + destination);
			}
			else {
				return(number + "\t" + type + "\t\t" + destination);
			}	
		}
	}
	
	class RailroadController {
		public void moveRailCarsToTrains(Railroad7 railroad) {
			while(!railroad.isReceivingTrackEmpty()) {
				RailCar tempCar = railroad.removeRailCarFromReceivingTrack();
				int location = railroad.findTrain(tempCar);
				railroad.addRailCarToTrainInSortingYard(tempCar, location);
				System.out.printf("\nMoved to sorting track #%d: rail car %d is going to %s (%s)",
						location,
						tempCar.getNumber(),
						tempCar.getDestination(),
						tempCar.getType());
			}
		}
		
		public void moveTrainsToDepartureTrack(Railroad7 railroad) {
			for (int i = 0; i < railroad.getNumberTracks(); i++) {
				if (railroad.getTrainInSortingYard(i) != null) {
					Train7 tempTrain = railroad.getTrainInSortingYard(i);
					railroad.addTrainToDepartureTrack(tempTrain);
					railroad.removeTrainFromSortingYard(i);
					System.out.printf("Moved to departure track: Train %d going to %s (%s)\n", 
							tempTrain.getEngineNumber(),
							tempTrain.getDestinationCity(),
							tempTrain.getType());
				}
			}
		}
		
		public void clearedForDeparture(Railroad7 railroad) {
			while(!railroad.isDepartureTrackEmpty()) {
				Train7 tempTrain = railroad.removeTrainFromDepartureTrack();
				System.out.printf("Train %d with %d rail cars is departing to %s (%s)\n", 
						tempTrain.getEngineNumber(),
						tempTrain.getNumberRailCars(),
						tempTrain.getDestinationCity(),
						tempTrain.getType());
			}
			
		}
	}