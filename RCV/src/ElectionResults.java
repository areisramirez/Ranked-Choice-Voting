import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ElectionResults {

	public static void main(String[] args) {
	
		// Establish console Scanner for console input
		Scanner console = new Scanner(System.in);
		
		// Determine the file name containing the ballot data
		System.out.print("Ballots file: ");
		String fileName = console.nextLine();

		// Read the file contents into an array.  Each array
		// entry corresponds to a line in the file.
		String[] fileContents = getFileContents(fileName);
		

		// Run any testing code that has been written
		test();

		
		// Your code below here: execute the RCV process,
		// ensuring to make use of the remaining methods
		System.out.println("Vote Tallies");
		
		printCounts(tallies(convert(fileContents)));
		
		
			
		
		    
		}
		
		
	
	
	// this method is for you to write testing code
	// write anything you like here, or nothing at all
	// nothing you write here will be graded
	public static void test() {
		
	}
	

	
	// method name: convert()
	// - input: rawData, an array of String data from the input file
	//   - each String in the array represents one ballot in the election
	//   - a ballot with 2+ candidates will separate each name by a comma
	//   - a ballot with 1 candidate with have the name only, no comma
	//   - candidates are listed in preference order (1st choice,2nd choice,etc.)
	// - action: convert each string in the array to a Ballot object and
	//           create a list of all of the Ballot objects
	// - output: the list of Ballot objects
	public static ArrayList<Ballot> convert(String[] rawData) {
		ArrayList<Ballot> elected = new ArrayList<Ballot>();
		for (String word : rawData) {
			Ballot w = new Ballot();
			w.addCandidate(word);
			elected.add(w);
			
		}
		return elected;
	}


	// methodName: tallies()
	// - input: ballots, a list of Ballot objects representing all election ballots
	// - action: determine the number of votes earned by each candidate
	// - output: a HashMap with candidates as keys and vote counts as values
	public static HashMap<String, Integer> tallies(ArrayList<Ballot> ballots) {
		
		int count = 0;
		
		HashMap<String, Integer> votes = new HashMap<String, Integer>();
		
		for(Ballot list : ballots) {
			while (!(list.isExhausted()) ) {	
				
			}
			
		}
		
		return votes; // delete and replace with your code
	}
	

	// method name: analyze()
	// - inputs:
	//   - tally, a HashMap from candidate name (keys) to vote tally (values)
	//   - total, an int indicating the total number of ballots
	// - action: determine whether there is a winner or loser, and who it is
	// - output: a Result object based on the action above
	public static Result analyze(HashMap<String, Integer> tally, int total) {
		
		int count = 0;
		Result ans = new Result();

		
		for (int value : tally.values()) {
			if (value >= count) {
				count = value;
			}
		
		}
		return ans;
	}
	

	// method name: printCounts()
	// - input: tally, a HashMap from candidate name (keys) to vote tally (values)
	// - action: prints the following information, one line per map key
	//   - candidate name
	//   - a blank space
	//   - number of votes earned
	public static void printCounts(HashMap<String, Integer> tally) {
		
		for (String i : tally.keySet()) {
		 System.out.println(i + " " + tally.get(i));
		}
	}


	// method name: remove()
	// - inputs:
	//   - name, a String indicating a candidate name to remove
	//   - ballots, a list of Ballot objects representing all election ballots
	// - action:
	//   - remove the candidate from each ballot where the candidate appears
	//   - remove all exhausted ballots from the list
	public static void remove(String name, ArrayList<Ballot> ballots) {
		
		for (Ballot theName : ballots) {
			
			Ballot names = theName;
			
			while(!(names.isExhausted())) {
				
				if(theName.getCurrentChoice() == name) {
					theName.removeCandidate(name);
					System.out.print("Remove" + name);
				}
				names.removeCandidate(names.getCurrentChoice());
			}
		}	
	}
			
			
	// method name: printPercentages()
	// - inputs:
	//   - tally, a HashMap from candidate name (keys) to vote tally (values)
	//   - total, an int indicating the total number of ballots
	// - action: prints the following information, one line per map key
	//   - percentage of vote earned, rounded to 1 decimal place
	//   - a blank space
	//   - candidate name
	public static void printPercentages(HashMap<String, Integer> tally, int total) {
		
		for (String key : tally.keySet()) {
			double percentage = (total/tally.get(key)) * 100;
			System.out.print(String.format("%.1f", percentage));
			System.out.println(" " + key);
		}
		
	}


	// methods below here are already complete

	public static String[] getFileContents(String fileName) {

      // first pass: determine number of lines in the file
      Scanner file = getFileScanner(fileName);
      int numLines = 0;
      while (file.hasNextLine()) {
         file.nextLine();
         numLines++;
      }
      
      // create array to hold the number of lines counted
      String[] contents = new String[numLines];
      
      // second pass: read each line into array
      file = getFileScanner(fileName);
      for (int i = 0; i < numLines; i++) {
         contents[i] = file.nextLine();
      }
      
      return contents;
   }
   
   
   public static Scanner getFileScanner(String fileName) {
      try {
         FileInputStream textFileStream = new FileInputStream(fileName);
         Scanner inputFile = new Scanner(textFileStream);
         return inputFile;
      }
      catch (IOException ex) {
         System.out.println("Warning: could not open " + fileName);
         return null;
      }
   }
}
