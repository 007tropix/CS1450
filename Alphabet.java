import java.util.Random;

public class Alphabet {

	public static void main(String[] args) {
		char[] alphabet = {
				'a', 'b', 'c', 'd',
				'e', 'f', 'g', 'h',
				'i', 'j', 'k', 'l',
				'm', 'n', 'o', 'p',
				'q', 'r', 's', 't',
				'u', 'v', 'w', 'x',
				'y', 'z'
				};
		
		System.out.println("Regular Order\n");
		printRegular(alphabet);
		
		System.out.println("\nReverse Order\n");
		printReversed(alphabet);
		
		System.out.println("\nShuffled Order\n");
		shuffle(alphabet);
		printRegular(alphabet);
		
		System.out.println("\nSorted Order\n");
		bubbleSort(alphabet);
		printRegular(alphabet);
		
		
		
	}
	
	static void printRegular(char[] alphabet) {
		for (int i = 0; i < alphabet.length; i++) {
			System.out.println(alphabet[i]);
		}
	}
	
	static void printReversed(char[] alphabet) {
		for (int i = alphabet.length-1; i > -1; i--) {
			System.out.println(alphabet[i]);
		}
	}
	
	static void swap(char[] alphabet, int pos1, int pos2) {
		char tempChar;
		tempChar = alphabet[pos1];
		alphabet[pos1] = alphabet[pos2];
		alphabet[pos2] = tempChar;
	}
	
	static void shuffle(char[] alphabet) {
		Random rand = new Random();
		for (int i = 0; i < alphabet.length; i++) {
			swap(alphabet, rand.nextInt(alphabet.length), rand.nextInt(alphabet.length));
		}
	}
	
	static void bubbleSort(char[] alphabet) {
		int length = alphabet.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (alphabet[j] > alphabet[i]) {
					swap(alphabet, j, i);
				}
			}
		}
	}
	
	
}


