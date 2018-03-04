package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import postalRateCalculator.PostalRateCalculator;

public class TestCalc {
	String [] input;
	String postalCode1;
	String postalCode2;
	double lengthParam1;
	double lengthParam2;
	double lengthParam3;
	PostalRateCalculator PRC;

	@Before
	public void setUp (){
		input = new String [] {"h2x2y6","h2x2y6","0.0","0.0","0.0", "0.0","Xpress"};
		postalCode1 = input[0];
		postalCode2 = input[1];
		lengthParam1 = -1.0;
		lengthParam2 = 15.0;
		lengthParam3 = 600.0;
		PRC = new PostalRateCalculator();
	}
	
	// test 1
	@Test
	public void testInput() {
		boolean actValid = false;
		actValid = PRC.checkValidInput(input);
		assertTrue(actValid);
	}	
	
	// test 2
	@Test
	public void testPostalCode(){
		boolean actValid = false;
		actValid = PRC.checkValidPostalCode(postalCode1);
		assertTrue(actValid);
		actValid = PRC.checkValidPostalCode(postalCode2);
		assertTrue(actValid);
	}
	
	// test 3
	@Test
	public void testLengthParam(){
		boolean actValid = false;
		// lengthParam1 = -1.0
		actValid = PRC.checkValidLengthParam(lengthParam1);
		assertFalse(actValid);
		// lengthParam2 = 15.0
		actValid = PRC.checkValidLengthParam(lengthParam2);
		assertTrue(actValid);
		// lengthParam3 = 600.0
		actValid = PRC.checkValidLengthParam(lengthParam3);
		assertFalse(actValid);
	}
	
	// test 4
	@Test
	public void testWidthParam(){
		boolean actValid = false;
		actValid = PRC.checkValidWidthParam(-13.89);
		assertFalse(actValid);
		actValid = PRC.checkValidWidthParam(234.09);
		assertTrue(actValid);
		actValid = PRC.checkValidWidthParam(834.09);
		assertFalse(actValid);
	}
	
	// test 5
	@Test
	public void testHeightParam(){
		boolean actValid = false;
		actValid = PRC.checkValidHeightParam(-13.89);
		assertFalse(actValid);
		actValid = PRC.checkValidHeightParam(234.09);
		assertTrue(actValid);
		actValid = PRC.checkValidHeightParam(834.09);
		assertFalse(actValid);
	}
	
	// test 6
	@Test
	public void testWeigthParam(){
		boolean actValid = false;
		actValid = PRC.checkValidWeightParam(-13.89);
		assertFalse(actValid);
		actValid = PRC.checkValidWeightParam(23.09);
		assertTrue(actValid);
		actValid = PRC.checkValidWeightParam(834.09);
		assertFalse(actValid);
	}
	
	// test 7
	@Test
	public void testPostalType(){
		boolean actValid = false;
		// valid = Regular, Xpress, Priority
		actValid = PRC.checkValidPostalType("Regular");
		assertTrue(actValid);
		actValid = PRC.checkValidPostalType("Xpress");
		assertTrue(actValid);
		actValid = PRC.checkValidPostalType("Priority");
		assertTrue(actValid);
		actValid = PRC.checkValidPostalType("ajkshdf");
		assertFalse(actValid);
		actValid = PRC.checkValidPostalType("");
		assertFalse(actValid);
	}
	
	// test 8
}
