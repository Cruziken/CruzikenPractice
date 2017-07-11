package Fizzbuzz;

import java.util.LinkedHashMap;
import java.util.Properties;

/**
 * This class assigns the values to variables necessary for the completion of
 * the FizzBuzz problem
 *
 */
public class Variables {
	// Creates an integer called max_int
	private int max_int;
	// Creates a integer called lower_divisor
	private int lower_divisor;
	// Creates a integer called upper_divisor
	private int upper_divisor;
	// Creates a String called lower_divisor_label
	private String lower_divisor_label;
	// Creates a String integer called upper_divisor_label
	private String upper_divisor_label;
	// Creates a properties variable called props
	private Properties props;

	/**
	 * This method accepts the property keys and values from other methods in
	 * other classes
	 * 
	 * @param propy
	 */
	
	public void getProps(Properties propy) {
		// Sets the properties passed through equal to props
		this.props = propy;
	}
	public void getVars(int max_inter, int lower_div, int upper_div, String lower_divisor_lab,
			String upper_divisor_lab){
		this.max_int= max_inter;
		this.lower_divisor= lower_div;
		this.upper_divisor= upper_div;
		this.lower_divisor_label = lower_divisor_lab;
		this.upper_divisor_label = upper_divisor_lab;
	}
	/**
	 * This method assigns values to the variables used in the LogicController
	 * class,passes these variables to the Logic Controller, and calls the test
	 * method within LogicController to start the FizzBuzz solution
	 * @param properties 
	 */
	public void setVars() {
		// Creates an instance of LogicController to access those methods
		LogicController myLogicController = new LogicController();
		// Creates a LinkedHash map that will store the keys and values of propy
		LinkedHashMap<String, String> mymap = new LinkedHashMap<String, String>();
		// For as long as there are keys to convert to string in the file, call
		// them key)
		for (String key : this.props.stringPropertyNames()) {
			// For each key converted, get its key
			String value = this.props.getProperty(key);
			// Puts the keys and values into the LinkedHashMap
			mymap.put(key, value);
		}
		// Assigns max_int the value of the key "max_int"
		max_int = intIt(mymap.get("max_int"));
		// Assigns lower_divisor the value of the key "lower_divisor"
		lower_divisor = intIt(mymap.get("lower_divisor"));
		// Assigns upper_divisor the value of the key "upper_divisor"
		upper_divisor = intIt(mymap.get("upper_divisor"));
		// Assigns lower_divisor_label the value of the key
		// "lower_divisor_label"
		lower_divisor_label = (mymap.get("lower_divisor_label"));
		// Assigns upper_divisor_label the value of the key
		// "upper_divisor_label"
		upper_divisor_label = (mymap.get("upper_divisor_label"));
		// Passes the variable values to the test method in LogicController and
		// calls the method
		//myLogicController.run(max_int, lower_divisor, upper_divisor, lower_divisor_label, upper_divisor_label);
	}

	/**
	 * Method that makes Integers out of numbers that are Strings
	 * 
	 * @param keys
	 * @return
	 */
	public int intIt(String assign) {
		// Returns back the value in integer form of a string
		return Integer.valueOf(assign);
	}
}
