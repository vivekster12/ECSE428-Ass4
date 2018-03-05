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
//		checkValidPostalCode("h2x2y6");
	}
	
	// code for test 1
	public static boolean checkNumParam(String [] args){
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
	public static boolean checkValidLengthParam(String args){
		boolean valid = true;
		double length = Double.parseDouble(args);
		if(length<0 || length >500){
			valid = false;
		}
		return valid;
	}
	
	// code for test 4
	public static boolean checkValidWidthParam(String args){
		boolean valid = true;
		double width = Double.parseDouble(args);
		if(width<0 || width >500){
			valid = false;
		}
		return valid;
	}
	
	// code for test 5
	public static boolean checkValidHeightParam(String args){
		boolean valid = true;
		double height = Double.parseDouble(args);
		if(height<0 || height >500){
			valid = false;
		}
		return valid;
	}
	
	// code for test 6
	public static boolean checkValidWeightParam(String args){
		boolean valid = true;
		double weight = Double.parseDouble(args);
		if(weight<0 || weight >30){
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
	
	// code for test 8
	// test to see if all input parameters are valid 
	public static boolean checkValidInput(String [] args){
		boolean valid = false;
		if(checkNumParam(args)){
			if(checkValidPostalCode(args[0]) && checkValidPostalCode(args[1]) 
					&& checkValidLengthParam(args[2]) && checkValidWidthParam(args[3]) 
					&& checkValidHeightParam(args[4]) && checkValidWeightParam(args[5])
					&& checkValidPostalType(args[6])){
				valid = true;
			}
		}
		return valid;
	}
	
	// calc rate
	public static double calcRate(String [] args){
		// check if valid
		if(!checkValidInput(args)){
			return -1;
		}
		
		double rate = 0.0;
		double weight = Double.parseDouble(args[5]);
		String postalType = args[6].toLowerCase();
		double factor = 0.0;
		
		// check what type of parcel
		// valid arguments
		String [] valid_args = {"regular", "xpress", "priority"};
		
		if(postalType.equals(valid_args[0])){
			factor = 0.0;
		}
		else if (postalType.equals(valid_args[1])){
			factor = 1.0;
		}
		else{
			factor = 2.0;
		}
		
		// check weight category
		if(weight<=5){
			rate = 1.80 + factor;
		}
		else if(weight>5 && weight <=15){
			rate = 2.95 + factor;
		}
		else{
			rate = 4.10 + factor;
		}
		
		return rate;
	}

}




