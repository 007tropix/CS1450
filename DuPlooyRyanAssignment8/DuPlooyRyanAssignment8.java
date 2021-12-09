/* Ryan Du Plooy
 * Data Structures and Algorithms (T/R)
 * Assignment #8
 * Due 11/4/2021
 * This assignment is about using ArrayLists, Queues, and Iterators to decode messages
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DuPlooyRyanAssignment8 {

	public static void main(String[] args) throws IOException{
		
		// Creating ArrayLists & Files
		ArrayList<Character> message1 = new ArrayList<Character>();
		ArrayList<Integer> message2 = new ArrayList<Integer>();
		ArrayList<Integer> arrayKey = new ArrayList<Integer>();
		
		File msg1File = new File("arrayMessage1.txt");
		File msg2File = new File("arrayMessage2.txt");
		File arrayKeyFile = new File("arrayKey.txt");
		
		Scanner fileReader = new Scanner(msg1File);
		
		
		// Read characters into message1 ArrayList
		String input = fileReader.next();
		for (int i = 0; i < input.length(); i++) {
			char tempChar = input.charAt(i);
			message1.add(tempChar);
		}
		
		// Read integers into message 2 ArrayList
		fileReader = new Scanner(msg2File);
		while(fileReader.hasNextInt()) {
			int tempInt = fileReader.nextInt();
			message2.add(tempInt);
		}
		
		// Read integers into arrayKey ArrayList
		fileReader = new Scanner(arrayKeyFile);
		while(fileReader.hasNextInt()) {
			int tempInt = fileReader.nextInt();
			arrayKey.add(tempInt);
		}
		
		// Create Iterators
		Iterator<Character> msg1Iterator = message1.iterator();
		Iterator<Integer> msg2Iterator = message2.iterator();
		Iterator<Integer> arrayKeyIterator = arrayKey.iterator();
		
		// Create SecretTranslator Object & decode message
		SecretTranslator translator = new SecretTranslator();
		String translated = translator.decode(msg1Iterator, msg2Iterator, arrayKeyIterator);
		
		System.out.println("The secret string is: " + translated);
		
		// Update files
		msg1File = new File("queueMessage1.txt");
		msg2File = new File("queueMessage2.txt");
		arrayKeyFile = new File("queueKey.txt");
		
		fileReader = new Scanner(msg1File);
		
		// Read characters into message1 ArrayList
		input = fileReader.next();
		for (int i = 0; i < input.length(); i++) {
			char tempChar = input.charAt(i);
			message1.add(tempChar);
		}
		
		// Read integers into message 2 ArrayList
		fileReader = new Scanner(msg2File);
		while(fileReader.hasNextInt()) {
			int tempInt = fileReader.nextInt();
			message2.add(tempInt);
		}
		
		// Read integers into arrayKey ArrayList
		fileReader = new Scanner(arrayKeyFile);
		while(fileReader.hasNextInt()) {
			int tempInt = fileReader.nextInt();
			arrayKey.add(tempInt);
		}
		// Update Iterators
		msg1Iterator = message1.iterator();
		msg2Iterator = message2.iterator();
		arrayKeyIterator = arrayKey.iterator();
		
		translated = translator.decode(msg1Iterator, msg2Iterator, arrayKeyIterator);
		System.out.println("The secret string is: " + translated);
	}

}

// SecretTranslator Class
class SecretTranslator {
private Stack stack = new Stack();

public SecretTranslator() {
	
}

public String decode(Iterator<Character> msg1Iterator, Iterator<Integer> msg2Iterator, Iterator<Integer> keyIterator) {
	
	while (keyIterator.hasNext()) {
		int current = keyIterator.next();
		if (current == 0) {
			stack.push(msg1Iterator.next());
		}
		else {
			int tempInt = msg2Iterator.next();
			stack.push((char) tempInt);
		}
	}
	
	String returnString = "";
	while (!stack.isEmpty()) {
		returnString = returnString + stack.pop();
	}
	return returnString;
	
}

}

// Stack Class
class Stack {
	
	private ArrayList<Character> list = new ArrayList<Character>();
	
	public Stack() {
		
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public int getSize() {
		return list.size();
	}
	
	public void push(Character value) {
		list.add(value);
	}
	
	public char pop() {
		return list.remove(list.size()-1);
	}
	
	
}
