package Fizzbuzz;

/**
 * 
 * This class contains the main method that starts the program.
 *
 */
public class GenericFizzBuzz {
	/**
	 * Method calls the step to take to begin the program
	 */
	public static void start() {
		// Creates an instance of INI called myINI
		INIfileLoader myINI = new INIfileLoader();
		Writer myWriter = new Writer("C://Users//Public//Valerie.log");
		LogicController myLogicController = new LogicController();
		Variables myVariables = new Variables();
		myVariables.getProps(myINI.readIt(null));
		myVariables.setVars();
		myWriter.setProperties(myINI.readIt(null));
		myWriter.log();
		myLogicController.setLogic(myVariables.getVars(0, 0, 0, null, null));
		myLogicController.run(myVariables.getVars(0, 0, 0, null, null));
		// log(Variables);
		// log();
		// Calls the readIt method on myINI
		// This will read the text in the INI file and sends the information to
		// other methods that copy the content to another file and the console,
		// as well as sending the content to the Variables
		// class to access some of the keys' values to set equal to variables in
		// order to solve the FizzBuzz problem
		// myINI.readIt();

	}

	/**
	 * Method starts the program
	 */
	public static void main(String[] args) {
		// This Starts the program
		start();
	}

}