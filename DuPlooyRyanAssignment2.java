/*Ryan Du Plooy
 * Data Structures and Algorithms (T/R)
 * Assignment #2
 * Due 9/10/2021
 * This assignment is about practicing working inheritance, polymorphism, as well as reading from files.
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;


public class DuPlooyRyanAssignment2 {

	public static void main(String[] args) throws IOException{
		File actFile = new File("Actors.txt");
		Scanner actReader = new Scanner(actFile);
		
		int actSize = actReader.nextInt();
		Actor[] castArray = new Actor[actSize];
		int i = 0;
		while(actReader.hasNextLine()) {
			String tempType = actReader.next();
			if(tempType.equals("Hero")){
				Hero newHero = new Hero(actReader.nextLine());
				castArray[i] = newHero;
				i++;
			}
			else if (tempType.equals("Villain")){
				Villain newVillain= new Villain(actReader.nextLine());
				castArray[i] = newVillain;
				i++;
			}
			else if (tempType.equals("Monster")){
				Monster newMonster= new Monster(actReader.nextLine());
				castArray[i] = newMonster;
				i++;
			}
			else if (tempType.equals("Droid")){
				Droid newDroid= new Droid(actReader.nextLine());
				castArray[i] = newDroid;
				i++;
			}
			else {
				System.out.println(actReader.next());
			}
		}
		
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Actor Name\tType\tMotto To Live By");
		System.out.println("----------------------------------------------------------------------------");
		for (int j = 0; j < castArray.length; j++) {
			if (castArray[j].getName().length() >= 8) {
				System.out.println(castArray[j].getName() + "\t" + castArray[j].getType() + "\t" + castArray[j].motto());
			}
			else {
				System.out.println(castArray[j].getName() + "\t\t" + castArray[j].getType() + "\t" + castArray[j].motto());
			}
			
		}
		System.out.println("\n--------------------------------------------");
		System.out.println("CS1450 Heroes and Villain Movie");
		System.out.println("--------------------------------------------");
		Movie newMovie = new Movie();
		newMovie.selectCast(castArray);
		newMovie.printMovieDetails();
		actReader.close();
	}
	
	
	
	

}
class Actor{
	protected String name;
	protected String type;
	
	public Actor(){
		
	}
	
	public Actor(String type, String name) {
		type = this.type;
		name = this.name;
	}
	
	public String motto() {
		return ("I'm and actor!");
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getType() {
		return this.type;
	}
}

class Hero extends Actor{
	public Hero(String name){
		type = "Hero";
		this.name = name;
		
	}
	public String motto() {
		return ("To the rescue!  KAPOW!! BAM!! POW!!");
	}
	
}

class Villain extends Actor{
	public Villain(String name){
		type = "Villain";
		this.name = name;
	}
	public String motto() {
		return ("You’ll never stop me!  Haaaaaaa!");
	}
}

class Monster extends Actor{
	public Monster(String name){
		type = "Monster";
		this.name = name;
	}
	public String motto() {
		return ("RRAAAUUGGHH GRROWR!!!");
	}
}

class Droid extends Actor{
	public Droid(String name){
		type = "Droid";
		this.name = name;
	}
	public String motto() {
		return ("Beep Beep Bloop Boop Beep!");
	}
}

class Movie extends Actor{
	private int numHeros;
	private int numVillains;
	private Actor[] actorsInMovie;
	
	public Movie(){
		
	}
	
	public void selectCast(Actor[] actors) {
		for (int i = 0; i < actors.length; i++) {
			if(actors[i] instanceof Hero) {
				numHeros++;
			}
			else if (actors[i] instanceof Villain) {
				numVillains++;
			}
		}
		actorsInMovie = new Actor[numHeros + numVillains]; // Set size of actorsInMovie array
		int count = 0;
		
		for (int i = 0; i < actors.length; i++) {
			if(actors[i] instanceof Hero) {
				this.actorsInMovie[count] = actors[i];
				count++;
			}
			else if (actors[i] instanceof Villain) {
				this.actorsInMovie[count] = actors[i];
				count++;
			}
		}
	}
	public void printMovieDetails() {
		System.out.println("\n--------------------------------------------");
		System.out.println("CS1450 Heroes and Villain Movie");
		System.out.println("--------------------------------------------");
		
		System.out.println("Number of Heroes:\t" + numHeros);
		System.out.println("Number of Villains:\t" + numVillains + "\n");
		
		for(int i = 0; i < actorsInMovie.length; i++) {
			System.out.println(actorsInMovie[i].getType() + "\t" + "---\t" + actorsInMovie[i].getName());
		}
	}
	
}
