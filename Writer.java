package Fizzbuzz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Properties;

/**
 * This class gets content from other files and writes it in desired file in
 * addition to printing the content to the console
 *
 */
public class Writer {
	// Creates a FileWriter variable named fileWriter
	private FileWriter fileWriter;
	// Creates a BufferedWriter variable named buffWriter
	private BufferedWriter buffWriter;
	// Creates a Properties variable named props
	private Properties props;
	// Creates a Variables instance named variables
	private Variables variables;

	/**
	 * Method allows the passing of filenames from other classes. Creates a new
	 * File and also creates new instances of fileWriter and buffWriter
	 * 
	 * @param filename
	 */
	public Writer(String filename) {
		// Creates (or gets access to ) a file from this absolute path
		File file = new File(filename);
		// In case there is no file to write to...
		try {
			// Creates a new FileWriter for that file.
			// Without the true you write over it. With it, you append
			fileWriter = new FileWriter(file, true);
			// Creates an instance buffWriter that writes the content from the
			// fileWriter
			buffWriter = new BufferedWriter(fileWriter);
		}
		// ...do this.
		catch (IOException e) {
			// TODO Auto-generated catch block; Throws NullPointerException
			e.printStackTrace();
		}
	}

	/**
	 * Method allows content to be passed into it when accessed by other classes
	 * and methods. This content is then written out to a file and also the
	 * console
	 * 
	 * @param content
	 */
	public void log(String content) {

		// In case no content is there to be read...
		try {
			// buffWriter writes content to file passed from other classes
			buffWriter.write(content);
			// Each time new content is passed, give it a new line
			buffWriter.newLine();
		}
		// ...do this.
		catch (IOException e) {
			// TODO Auto-generated catch block; Throws NullPointerException
			e.printStackTrace();
		}
		// Prints out the content that other classes pass to this method to the
		// console
		System.out.println(content);
	}

	/**
	 * Method closes any implementation of the buffWriter
	 */
	public void closeIt() {
		// Closes the buffWriter if there is something to close.
		try {
			buffWriter.close();
		}
		// If there is nothing to close...
		catch (IOException e) {
			// TODO Auto-generated catch block; Throws NullPointerException
			e.printStackTrace();
		}

	}

	/**
	 * This method takes this specific instance of variables that is passed
	 * through, gets the values associated with the keys in the file, and passes
	 * them through the log(String content) method in Writer
	 */
	/*
	 * public void log(Variables variables) { // Sets the variables equal to
	 * whatever instance of Variables is passed // through this.variables =
	 * variables; // Gets the value associated with the key max_int int
	 * max_int_key = variables.getMax_Int(); // Gets the value associated with
	 * the key lower_divisor int lower_divisor_key =
	 * variables.getLower_Divisor(); // Gets the value associated with the key
	 * upper_divisor int upper_divisor_key = variables.getUpper_Divisor(); //
	 * Gets the value associated with the key lower_divisor_label String
	 * lower_divisor_label_key = variables.getLower_Divisor_Label(); // Gets the
	 * value associated with the key upper_divisor_label String
	 * upper_divisor_label_key = variables.getUpper_Divisor_Label(); // Prints
	 * off "max_int = 100" to another file and the console log("max_int = " +
	 * max_int_key); // Prints off "lower_divisor" = 3" to another file and the
	 * console log("lower_divisor_key = " + lower_divisor_key); // Prints off
	 * "upper_divisor" = 5" to another file and the console
	 * log("upper_divisor_key = " + upper_divisor_key); // Prints off
	 * "lower_divisor_label" = fizz" to another file and the // console
	 * log("lower_divisor_key = " + lower_divisor_label_key); // Prints off
	 * "upper_divisor_label" = buzz" to another file and the // console
	 * log("upper_divisor_key = " + upper_divisor_label_key);
	 * 
	 * //Close the BufferedReader closeIt(); }
	 */
	/*
	 * Alternative method that allows you in main to pass
	 * myWriter.log(myINI.readIt()) instead of myVariables. This permits the
	 * reading of the entire fire without having to explicitly string the
	 * variable names.
	 */
	/**
	 * This method takes the keys and values of the properties f, converts them
	 * to strings and has them passed to the writeFile method
	 */
	public void log(Properties props) {
		
		this.props = props;
		// Creates an instance of StringWriter that is a character stream that
		// collects its output in a string buffer
		StringWriter writer = new StringWriter();
		// In case there is no content in the property file...
		try {
			// Writes the keys and values to the StringWriter
			this.props.store(writer, "");
		}
		// ...Do this
		catch (IOException e) {
			// TODO Auto-generated catch block; Throws NullPointerException
			e.printStackTrace();
		}
		// Takes the StringWriter, returns a string buffer, then finally returns
		// a String named INIcontent
		String INIcontent = writer.getBuffer().toString();
		// Passes the content from the INIfile to the writeFile method
		log(INIcontent);
	}

}
