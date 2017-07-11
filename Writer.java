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
	// Creates an a FileWriter variable named fileWriter
	private FileWriter fileWriter;
	// Creates an a BufferedWriter variable named buffWriter
	private BufferedWriter buffWriter;
	// Creates an a Properties variable named props
	private Properties props;

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
	 * This method takes the keys and values of the properties f, converts them
	 * to strings and has them passed to the writeFile method
	 */
	public void log() {
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

	/**
	 * This method accepts the property keys and values from other methods in
	 * other classes
	 * 
	 * @param properties
	 */
	public void setProperties(Properties properties) {
		// Sets the properties passed through equal to props
		this.props = properties;
	}
}
