import java.util.Scanner;

public class QuadraticFormula {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		boolean quadLoop = true;

		while (quadLoop) {
			
			System.out.println("\nInput value for a: ");
			double a = myScanner.nextDouble();

			System.out.println("Input value for b: ");
			double b = myScanner.nextDouble();

			System.out.println("Input value for c: ");
			double c = myScanner.nextDouble();

			double x1 = (-b + Math.sqrt((b * b) - 4 * a * c)) / (2 * a);
			double x2 = (-b - Math.sqrt((b * b) - 4 * a * c)) / (2 * a);

			System.out.printf("\n%s %.3f %s %.3f", "x =", x1, "or", x2);

			System.out.println("\nAgain? (y/n)");
			if (myScanner.next().equals("n")) {
				quadLoop = false;

			}
		}
		myScanner.close();
	}

}
