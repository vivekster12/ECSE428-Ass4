package postalRateCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostalRateCalculator {
	// input variables
	// FROM parameter is only within Canada
	// POSTAL TYPE parameter is [Regular, Xpress, Priority]
	double lenght;
	double width;
	double height;
	double weight;
	
	public static void main (String [] args){
		checkValidPostalCode("h2x2y6");
	}
	
	// code for test 1
	public static boolean checkValidInput(String [] args){
		boolean valid = false;
		
		if(args.length == 7){
			valid = true;
		}
		return valid;
	}
	
	// code for test 2
	public static boolean checkValidPostalCode(String args){
		boolean valid = true;
		
		// correct format of postal code
		String pattern = "[a-z][1-9][a-z][1-9][a-z][1-9]";
		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);
		// Now create matcher object.
		Matcher m = r.matcher(args);
	    
		// check 1: see if right length, check 2: see if right format
		if(args.length()!=6 || !m.find()){
			valid = false;
		}	
		return valid;
	}
	
	// code for test 3
	public static boolean checkValidLengthParam(double args){
		boolean valid = true;
		
		if(args<0 || args >500){
			valid = false;
		}
		return valid;
	}
	
	// code for test 4
	public static boolean checkValidWidthParam(double args){
		boolean valid = true;
		
		if(args<0 || args >500){
			valid = false;
		}
		return valid;
	}
	
	// code for test 5
	public static boolean checkValidHeightParam(double args){
		boolean valid = true;
		
		if(args<0 || args >500){
			valid = false;
		}
		return valid;
	}
	
	// code for test 6
	public static boolean checkValidWeightParam(double args){
		boolean valid = true;
		
		if(args<0 || args >30){
			valid = false;
		}
		return valid;
	}
	
	// code for test 7
	public static boolean checkValidPostalType(String args){
		boolean valid = true;
		String input = args.toLowerCase();
		// valid arguments
		String [] valid_args = {"regular", "xpress", "priority"};
		
		if(!input.equals(valid_args[0]) && !input.equals(valid_args[1]) && !input.equals(valid_args[2])){
			valid = false;
		}
		return valid;
	}
}




