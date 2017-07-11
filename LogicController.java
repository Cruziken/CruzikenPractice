package Fizzbuzz;

/**
 * This class controls the logic for FizzBuzz and sends the output to the
 * console and to a file
 * 
 * @author fz3
 *
 */
public class LogicController {
	/**
	 * Method that runs the logic necessary to solve the FizzBuzz Problem and
	 * passes the content through the Writer class's writeFile method
	 * 
	 * @param max_int
	 * @param lower_divisor
	 * @param upper_divisor
	 * @param lower_divisor_label
	 * @param upper_divisor_label
	 */
	public void run(int max_int, int lower_divisor, int upper_divisor, String lower_divisor_label,
			String upper_divisor_label) {
		// Creates an instance of Writer to access those methods and pass the
		// desired file name
		Writer myWriter = new Writer("C://Users//Public//Valerie.log");

		// Run the loop starting at zero, ending less than max_int, and
		// incrementing by one in subsequent run through
		for (int x = 1; x <= max_int; x++) {

			// If x is divisible by 3 and is by 5 print "fizzbuzz"
			if ((x % (lower_divisor * upper_divisor) == 0)) {
				// Prints off fizzbuzz to console
				myWriter.log(lower_divisor_label + upper_divisor_label);
			}

			// If x is divisible by 3 but not 5 do the following
			else if (x % lower_divisor == 0) {
				// Print out fizz
				myWriter.log(lower_divisor_label);

			}

			// If x is not divisible by 3 but is by 5 print "buzz"
			else if (x % upper_divisor == 0) {
				// Prints off buzz to console
				myWriter.log(upper_divisor_label);
			}
			// If the other conditions aren't met print the number
			else {
				// Prints value of x onto console
				myWriter.log(String.valueOf(x));
			}

		}

		// Closes the writer
		myWriter.closeIt();

	}

	public void run(Object vars) {
		// TODO Auto-generated method stub
		
	}

}
