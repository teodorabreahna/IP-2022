/*
	This is the starting point of the application.
 */

package Data_Processing;


import static Data_Processing.GetInput.readingJson;

public class Data_Processing
{
	// This is the starting point of the application.
	public static void main (String args[])
	{
		Data_Processing data_processing = new Data_Processing();
		
		// Run the application.
		data_processing.run();
		readingJson();
	}
	
	
	// Run the application.
	void run ()
	{		
		Processor processor = new Processor(null);
	}
}