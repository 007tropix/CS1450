import java.util.Scanner;

public class PythagoreanTheorem {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		boolean pythLoop = true;

		while (pythLoop) {
			
			System.out.println("Enter 0 for unknown value");
			
			System.out.println("\nInput value for a: ");
			double a = myScanner.nextDouble();

			System.out.println("Input value for b: ");
			double b = myScanner.nextDouble();

			System.out.println("Input value for c: ");
			double c = myScanner.nextDouble();

			if (a == 0) {
				a = Math.sqrt((c*c) - (b*b));
				System.out.printf("\n%s %.3f", "a = ", a);
			}
			
			else if (b == 0) {
				b = Math.sqrt((c*c) - (a*a));
				System.out.printf("\n%s %.3f", "b = ", b);
			}
			
			else {
				c = Math.sqrt((a*a) + (b*b));
				System.out.printf("\n%s %.3f", "c = ", c);
			}

			System.out.println("\nAgain? (y/n)");
			if (myScanner.next().equals("n")) {
				pythLoop = false;

			}
		}
		myScanner.close();
	}

}
