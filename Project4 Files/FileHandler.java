import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Handles inputs from the GUI
 * and outputs them into a .csv file
 */
public class FileHandler {

	private String surveyFile = "survey_results.csv";
	private FileWriter fileOutput;
	private PrintWriter printWriter;
	
	/**
	 * FileHandler Constructor
	 * Creates and opens the survey file
	 * Prints header first
	 */
	public FileHandler() {
		try {
			fileOutput = new FileWriter(surveyFile, true);
			printWriter = new PrintWriter(fileOutput);
			
			printWriter.println("DateTime,FirstName,LastName,PhoneNumber,Email,Sex,Water,Meals,Wheat,Sugar,Dairy,Miles,Weight");
		}catch(IOException e) {
			System.out.println("FileWriting/PrintWriting issue, check FileHandler");
		}
	}
	
	/**
	 * Writes new entries from the user inputed in the GUI
	 * @param surveyData data from the fields in the GUI
	 */
	public void writeResults(String surveyData) {
		printWriter.println(surveyData);
		printWriter.flush();
		
	}
}
