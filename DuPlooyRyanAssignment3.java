/*Ryan Du Plooy
 * Data Structures and Algorithms (T/R)
 * Assignment #3
 * Due 9/16/2021
 * This assignment is about working with interfaces, arraylists, and abstract classes in order to display and test multiple situations regarding a file.
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DuPlooyRyanAssignment3 {

	public static void main(String[] args) throws IOException{
		File birdFile = new File("Birds.txt");
		Scanner birdReader = new Scanner(birdFile);
		
		int birdCount = birdReader.nextInt();
		ArrayList<Bird> birdsList = new ArrayList<Bird>();
		
		// Determining what object to create based on the first word of each line and then creating said object with the rest of the information on each line.
		for (int i = 0; i < birdCount; i++) {
			String tempType = birdReader.next();
			if(tempType.equals("penguin")) {
				String name = birdReader.next();
				int runSpeed = birdReader.nextInt();
				int swimSpeed = birdReader.nextInt();
				Penguin newPenguin = new Penguin(name, runSpeed, swimSpeed);
				
				
				birdsList.add(newPenguin);
				birdReader.nextLine();
				
			}
			else if (tempType.equals("ostrich")) {
				String name = birdReader.next();
				int runSpeed = birdReader.nextInt();
				int swimSpeed = birdReader.nextInt();
				Ostrich newOstrich = new Ostrich(name, runSpeed, swimSpeed);
				
				
				birdsList.add(newOstrich);
				birdReader.nextLine();
				
			}
			else if (tempType.equals("sootytern")){
				String name = birdReader.next();
				int runSpeed = birdReader.nextInt();
				birdReader.nextInt();
				int flySpeed = birdReader.nextInt();
				SootyTern newSootyTern= new SootyTern(name, runSpeed, flySpeed);
				
				
				birdsList.add(newSootyTern);
				birdReader.nextLine();
				
			}
			else if (tempType.equals("loon")){
				String name = birdReader.next();
				birdReader.nextInt();
				int swimSpeed = birdReader.nextInt();
				int flySpeed = birdReader.nextInt();
				Loon newLoon= new Loon(name, flySpeed, swimSpeed);
				
				
				birdsList.add(newLoon);
				birdReader.nextLine();
				
			}
				
			}
			// Executing displayBirds(), findSwimmers(), and swimmingRace() and printing lines to match the desired output
		displayBirds(birdsList);
		ArrayList<Bird> Swimmers = findSwimmers(birdsList);
		System.out.println("------------------------------------------------------------------");
		System.out.println("BIRDS THAT CAN SWIM");
		System.out.println("------------------------------------------------------------------");
		System.out.println("Bird\t\tType\t\tSwimming Speed");
		System.out.println("------------------------------------------------------------------");
		for (int i = 0; i < Swimmers.size(); i++) {
			System.out.printf("%s\t\t%s\t\t%d", Swimmers.get(i).getName(), Swimmers.get(i).getType(), ((Swimmer) Swimmers.get(i)).swim());
			System.out.println();
		}
		Bird winner = swimmingRace(Swimmers);
		System.out.println("------------------------------------------------------------------");
		System.out.println("SWIMMING RACE");
		System.out.println("------------------------------------------------------------------");
		System.out.println("Swimming birds get ready ... get set ... go!");
		System.out.printf("The winner is %s the %s swimming at %d mph", winner.getName(), winner.getType(), ((Swimmer)winner).swim());
		
		birdReader.close();
		} // end of main
	
	// displayBirds function which will check the object type and print the corresponding information for all objects in the arraylist
	public static void displayBirds(ArrayList<Bird> birds) {
		System.out.println("Birds and Abilities");
		System.out.println("------------------------------------------------------------------");
		for (int i = 0; i < birds.size(); i++) {
			System.out.println(birds.get(i).getName() + " is a " + birds.get(i).getType());
			birds.get(i).strangeFact();
			if (birds.get(i) instanceof Penguin || birds.get(i) instanceof Ostrich) {
				System.out.println("Swim Speed: " + ((Swimmer) birds.get(i)).swim() + "\tRun Speed: " + ((Runner) birds.get(i)).run() + "\tFlying Altitude: 0");
				System.out.println();
			}
			else if (birds.get(i) instanceof SootyTern) {
				System.out.println("Swim Speed: 0" + "\tRun Speed: " + ((Runner) birds.get(i)).run() + "\tFlying Altitude: " + ((Flyer) birds.get(i)).fly());
				System.out.println();
			}
			else if (birds.get(i) instanceof Loon) {
				System.out.println("Swim Speed: " + ((Swimmer) birds.get(i)).swim() + "\tRun Speed: 0" + "\tFlying Altitude: " + ((Flyer) birds.get(i)).fly());
				System.out.println();
			}
			
	}

}
	// findSwimmers function will check an arraylist for every instance of a swimmer and then return all swimmers in a new arraylist
	public static ArrayList<Bird> findSwimmers(ArrayList<Bird> birds){
		ArrayList<Bird> Swimmers = new ArrayList<Bird>();
		for (int i = 0; i < birds.size(); i++) {
			if (birds.get(i) instanceof Swimmer) {
				Swimmers.add(birds.get(i));
			}
		}
		return Swimmers;
	}
	
	// swimmingRace will check an arraylist of swimmers and return the swimmer that returns the highest swim value
	public static Bird swimmingRace(ArrayList<Bird> swimmingBirds) {
		Bird currentWinner = null;
		int max = ((Swimmer) swimmingBirds.get(0)).swim();
		
		for(int i = 0; i < swimmingBirds.size(); i++) {
			if (((Swimmer) swimmingBirds.get(i)).swim() > max) {
				currentWinner = swimmingBirds.get(i);
			}
		}
		return currentWinner;
	}
}

// Abstract swimmer interface
interface Swimmer{
	public abstract int swim();
}

// Abstract runner interface
interface Runner{
	public abstract int run();
}

// Abstract Flyer interface
interface Flyer{
	public abstract int fly();
}

// Abstract Bird superclass
abstract class Bird{
	
	private String type;
	private String name;
	
	public void setType(String type) {
		this.type = type;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return this.type;
	}
	public String getName() {
		return this.name;
	}
	
	public abstract void strangeFact();
	
}
// Penguin class
class Penguin extends Bird implements Swimmer, Runner{
	private int runSpeed;
	private int swimSpeed;
	public Penguin(String name, int runSpeed, int swimSpeed) {
		super();
		this.setName(name);
		this.setType("Penguin");
		this.runSpeed = runSpeed;
		this.swimSpeed = swimSpeed;
	}
	
	public int swim() {
		return swimSpeed;
	}
	
	public int run() {
		return runSpeed;
	}
	
	public void strangeFact() {
		System.out.println("I can’t fly but I’m the fastest swimmer and deepest diver and can stay underwater up to 20 minutes.");
	}
}
// Ostrich class
class Ostrich extends Bird implements Swimmer, Runner{
	private int runSpeed;
	private int swimSpeed;
	public Ostrich(String name, int runSpeed, int swimSpeed) {
		super();
		this.setName(name);
		this.setType("Ostrich");
		this.runSpeed = runSpeed;
		this.swimSpeed = swimSpeed;
	}
	
	public int swim() {
		return swimSpeed;
	}
	
	public int run() {
		return runSpeed;
	}
	
	public void strangeFact() {
		System.out.println("Who needs flying when you’re the biggest bird on earth! I can be up to 9 feet tall and weigh up to 300 pounds – bring it on!");
	}
}
// Sooty Tern class
class SootyTern extends Bird implements Runner, Flyer{
	private int runSpeed;
	private int flySpeed;
	public SootyTern(String name, int runSpeed, int flySpeed) {
		super();
		this.setName(name);
		this.setType("Sooty Tern");
		this.runSpeed = runSpeed;
		this.flySpeed = flySpeed;
	}
	
	public int fly() {
		return flySpeed;
	}
	
	public int run() {
		return runSpeed;
	}
	
	public void strangeFact() {
		System.out.println("Strange as it may sound, I spend most of my life at sea and I can't swim but I can nap while flying!");
	}
}
// Loon class
class Loon extends Bird implements Swimmer, Flyer{
	private int flySpeed;
	private int swimSpeed;
	public Loon(String name, int flySpeed, int swimSpeed) {
		super();
		this.setName(name);
		this.setType("Loon");
		this.flySpeed = flySpeed;
		this.swimSpeed = swimSpeed;
	}
	
	public int swim() {
		return swimSpeed;
	}
	
	public int fly() {
		return flySpeed;
	}
	
	public void strangeFact() {
		System.out.println("My legs are so far back on my body that I cannot walk on land, so I push myself along the ground on my chest.");
	}
}
