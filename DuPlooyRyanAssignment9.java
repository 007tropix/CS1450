/* Ryan Du Plooy
 * Data Structures and Algorithms (T/R)
 * Assignment #9
 * Due 11/16/2021
 * This assignment is about creating our own single Linked Lists and double Linked Lists
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;



public class DuPlooyRyanAssignment9 {

	public static void main(String[] args) throws IOException{
		ItineraryLinkedList singleList = new ItineraryLinkedList();
		DoubleLinkedList doubleList = new DoubleLinkedList();
		
		
		File itineraryFile = new File("JapanItinerary.txt");
		File updatesFile = new File("JapanItineraryUpdates.txt");
		
		Scanner fileReader = new Scanner(itineraryFile);
		
		// While loop used to load single Linked List with Destination objects from file
		while (fileReader.hasNextLine()) {
			Destination tempDestination = new Destination(fileReader.nextInt(), fileReader.next(), fileReader.next(), fileReader.nextLine());
			singleList.addDestination(tempDestination);
		}
		
		System.out.println("Unsorted Japan Itinerary");
		singleList.printList();
		
		System.out.println("\nSorted Japan Itinerary");
		singleList.bubbleSort();
		singleList.printList();
		
		fileReader = new Scanner(updatesFile);
		
		// While loop used to load doubly Linked List with Destination objects from file & also update single Linked List
		while(fileReader.hasNextLine()) {
			String tempName = fileReader.next();
			Destination tempDestination = new Destination(fileReader.nextInt(), fileReader.next(), fileReader.next(), fileReader.nextLine());
			doubleList.addDestination(tempDestination);
			singleList.updateItinerary(tempName, tempDestination);
		}
		
		System.out.println("\nUpdated Itinerary With Added Adventures");
		singleList.printList();
		
		System.out.println("\nAdventure Destinations in Doubly Linked List - Printed Backwards");
		doubleList.printListBackwards();
		
	}

}

class Destination {
	private int stop;
	private String type;
	private String name;
	private String activity;
	
	public Destination (int stop, String type, String name, String activity) {
		this.stop = stop;
		this.type = type;
		this.name = name;
		this.activity = activity;
	}
	
	public int getStop() {
		return stop;
	}
	
	public void setStop(int stop) {
		this.stop = stop;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getActivity() {
		return activity;
	}
	
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	// Checking the lengths of Destination objects name and type to determine how many tabs are needed for formatting
	@Override
	public String toString() {
		if (name.length() >= 16 && type.length() >= 8) {
			return(name + "\t" + type + "\t" + activity.trim());
		}
		else if (name.length() >= 16 && type.length() < 8) {
			return(name + "\t" + type + "\t\t" + activity.trim());
		}
		else if (name.length() < 16 && type.length() >= 8) {
			return(name + "\t\t" + type + "\t" + activity.trim());
		}
		else {
			return(name + "\t\t" + type + "\t\t" + activity.trim());
		}
	}
} // End of Destination class

class ItineraryLinkedList {
	private Node head;
	private int size;
	
	public ItineraryLinkedList() {
		head = null;
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	// Adds Destination object in new node at the beginning of the Linked List
	public void addDestination(Destination destinationToAdd) {
		Node node = new Node(destinationToAdd);
		node.next = head;
		head = node;
		size++;
	}
	
	// Used to search through the single Linked List and insert correlating Destination object 
	public void updateItinerary(String insertBeforeDestination, Destination adventureDestination) {
		Node current = head;
		Node next = head.next;
		int index = 0;
		while (current.destination.getName().equals(insertBeforeDestination) != true) {
			current = next;
			next = next.next;
			index++;
		}
		Node newNode = new Node(adventureDestination);
		if (index == 0) {
			newNode.next = head;
			head = newNode;
			size++;
		}
		
		else if (index >= size) {
			size++;
		}
		
		else {
			Node previous = head;
			for (int i = 0; i < index - 1; i++) {
				previous = previous.next;
			}
			current = previous.next;
			previous.next = newNode;
			newNode.next = current;
			size++;
		}
		
		
			
	}
	// Bubble sort used to sort the single Linked List using the Destination object's stop value for sorting
	public void bubbleSort() {
		for (int i = 0; i < size; i++) {
			Node current = head;
			Node next = head.next;
			
			for (int j = 0; j < size - 1; j++) {
				if (current.destination.getStop() > next.destination.getStop()) {
					swapNodeData(current, next);
				}
				
				current = next;
				next = next.next;
			}
		}
	}
	
	// Swaps two node's Destination objects
	public void swapNodeData(Node node1, Node node2) {
		Destination temp = node1.destination;
		node1.destination = node2.destination;
		node2.destination = temp;
	}
	
	// Prints the single Linked List to prove that all nodes have been properly connected
	public void printList() {
		System.out.println("\nDestination Name\tType\t\tActivity");
		System.out.println("----------------------------------------------------------------------------------");
		
		Node temp = head;
		while(temp != null) {	
			System.out.println(temp.destination.toString());
			temp = temp.next;
		}
		
	}
	
	private static class Node {
		private Destination destination;
		private Node next;
		
		public Node(Destination destination) {
			this.destination = destination;
			next = null;
		}
	}
} // End of ItineraryLinkedList class

class DoubleLinkedList {
	private Node head;
	private Node tail;
	
	public DoubleLinkedList() {
		head = null;
		tail = null;
	}
	
	// Adds Destination object in new node to the end of the doubly Linked List
	public void addDestination(Destination destination) {
		Node newNode = new Node(destination);
		
		if (tail == null) {
			head = tail = newNode;
			head.previous = null;
			tail.next = null;
		}
		
		else {
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
			tail.next = null;
		}
	}
	
	// Prints the doubly Linked List backwards to prove that the nodes have been properly connected
	public void printListBackwards() {
		System.out.println("\nDestination Name\tType\t\tActivity");
		System.out.println("----------------------------------------------------------------------------------");
		
		Node temp = tail;
		while(temp != null) {	
			System.out.println(temp.destination.toString());
			temp = temp.previous;
		}
	}
	
	private static class Node {
		private Destination destination;
		private Node previous;
		private Node next;
		
		public Node(Destination destination) {
			this.destination = destination;
			previous = null;
			next = null;
		}
	}
} // End of DoubleLinkedList class
