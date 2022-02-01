import java.util.Scanner;

public class PythagoreanTheorem {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static void main(String[] args) {
		
		Scanner myScanner = new Scanner(System.in);
		boolean pythLoop = true;

		while (pythLoop) {
			
			System.out.println(ANSI_CYAN + "Enter 0 for unknown value" + ANSI_RESET);
			
			System.out.println(ANSI_CYAN + "\nInput value for a: " + ANSI_RESET);
			double a = myScanner.nextDouble();

			System.out.println(ANSI_CYAN + "Input value for b: " + ANSI_RESET);
			double b = myScanner.nextDouble();

			System.out.println(ANSI_CYAN + "Input value for c: " + ANSI_RESET);
			double c = myScanner.nextDouble();

			if (a == 0) {
				a = Math.sqrt((c*c) - (b*b));
				System.out.printf(ANSI_PURPLE + "\n%s %.3f", "a = " + ANSI_RESET, a);
			}
			
			else if (b == 0) {
				b = Math.sqrt((c*c) - (a*a));
				System.out.printf(ANSI_PURPLE + "\n%s %.3f", "b = " + ANSI_RESET, b);
			}
			
			else {
				c = Math.sqrt((a*a) + (b*b));
				System.out.printf(ANSI_PURPLE + "\n%s %.3f", "c = " + ANSI_RESET, c);
			}

			System.out.println("\nAgain? (" + ANSI_GREEN + "y" + ANSI_RESET + "/" + ANSI_RED + "n" + ANSI_RESET + ")");
			if (myScanner.next().equals("n")) {
				pythLoop = false;

			}
		}
		myScanner.close();
	}

}
