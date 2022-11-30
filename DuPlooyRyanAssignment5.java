/*Ryan Du Plooy
 * Data Structures and Algorithms (T/R)
 * Assignment #5
 * Due 10/8/2021
 * This assignment is about working with Generic classes and being able to work with/sort stacks.
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class DuPlooyRyanAssignment5 {

	public static void main(String[] args) throws IOException {
		int[] values = {8, 17, 62, 4, 6, 2, 42, 10, 3, 7};
		Stack<Integer> myStack = new Stack<>();
		
		for (int i = 0; i < values.length; i++) {
			myStack.push(values[i]);
		}
		
		double average = findAverage(myStack);
		System.out.println("Stack Values After Compute Average");
		PrintStack(myStack);
		System.out.println("\nAverage: " + average);
		
		GenericStack<Integer> numStack = new GenericStack<>();
		File numFile = new File("numbers.txt");
		Scanner genReader = new Scanner(numFile);
		
		while(genReader.hasNextLine()) {
			numStack.push(genReader.nextInt());
		}
		
		System.out.println("\nNumbers from file placed on number stack (unsorted)");
		printStack(numStack);
		
		GenericStack<Integer> sortedStack = new GenericStack<>();
		sortStack(numStack, sortedStack);
		
		System.out.println("\nSorted number stack");
		printStack(sortedStack);
		
		File stringFile = new File("strings.txt");
		
		
		GenericStack<String> stringStack = new GenericStack<>();
		genReader = new Scanner (stringFile);
		
		while(genReader.hasNextLine()) {
			stringStack.push(genReader.next());
		}
		
		System.out.println("\nStrings from file placed on string stack (unsorted)");
		printStack(stringStack);
		
		GenericStack<String> sortedStrings = new GenericStack<>();
		sortStack(stringStack, sortedStrings);
		
		System.out.println("\nSorted string stack");
		printStack(sortedStrings);
		
		displayAppearanceCounts(sortedStrings);
		
		
		
	}
	
	public static double findAverage(Stack<Integer> stack) {
		
		Stack<Integer> tempStack = new Stack<>(); 
		double average = 0;
		int total = 0;
		int count = 0;
		int currentValue = 0;
		
		while (stack.isEmpty() == false) {
			currentValue = stack.pop();
			total = total + currentValue;
			tempStack.push(currentValue);
			count = count + 1;
		}
		
		average = (double) total / count;
		
		while (tempStack.isEmpty() == false) {
			stack.push(tempStack.pop());
		}
		
		return average;
		
		
	}
	
	public static void PrintStack(Stack<Integer> stack) {
		
		Stack<Integer> tempStack = new Stack<>();
		int currentValue = 0;
		
		System.out.println("---------------------------------------------------");
		
		while (stack.isEmpty() == false) {
			currentValue = stack.pop();
			System.out.println(currentValue);
			tempStack.push(currentValue);
		}
		
		while(tempStack.isEmpty() == false) {
			stack.push(tempStack.pop());
		}
	}

	public static <E> void printStack (GenericStack<E> stack) {
		GenericStack<E> tempStack = new GenericStack<>();
		E currentValue;
		
		System.out.println("---------------------------------------------------");
		
		while (stack.isEmpty() == false) {
			currentValue = stack.pop();
			System.out.println(currentValue);
			tempStack.push(currentValue);
		}
		
		while(tempStack.isEmpty() == false) {
			stack.push(tempStack.pop());
		}
	}
	
	public static <E extends Comparable<E>> void sortStack(GenericStack<E> unsortedStack, GenericStack<E> sortedStack) {
		
        while(!unsortedStack.isEmpty())
        {
            
            E temp = unsortedStack.pop();
         
            while(!sortedStack.isEmpty() && sortedStack.peek().compareTo(temp) > 0)
            {
            	unsortedStack.push(sortedStack.pop());
            }
          
            sortedStack.push(temp);
            
        }
		
		
		
		
	}
	
	public static <E extends Comparable<E>> void displayAppearanceCounts(GenericStack<E> stack) {
		GenericStack<E> tempStack = new GenericStack<>();
		while(!stack.isEmpty()) {
			E currentValue = stack.pop();
			tempStack.push(currentValue);
			int appearanceCount = 1;
			boolean done = false;
			
			while(!stack.isEmpty() && done != true) {
				E nextValue = stack.pop();
				tempStack.push(nextValue);
				if(currentValue.compareTo(nextValue) == 1) {
					appearanceCount++;
				}
				else {
					done = true;
				}
				
				
			}
			
			
		}
	}
	
	}


class GenericStack<E> {
	private ArrayList<E> list = new ArrayList<E>();
	
	public GenericStack() {
		
	}
	
	public boolean isEmpty() {
		
		if (list.isEmpty()) {
			return(true);
		}
		else {
			return(false);
		}
	}
	
	public int getSize() {
		return(list.size());
	}
	
	public E peek() {
		return(list.get(list.size() - 1));
	}
	
	public E pop() {
		E tempValue;
		tempValue = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		return(tempValue);
	}
	
	public void push(E value) {
		list.add(value);
	}
}
