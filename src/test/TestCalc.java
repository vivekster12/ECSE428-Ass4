package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import postalRateCalculator.PostalRateCalculator;

public class TestCalc {
	String [] input1;
	String [] input2;
	PostalRateCalculator PRC;

	@Before
	public void setUp (){
		input1 = new String [] {"h2x2y6","h2x2y6","0.0","0.0","0.0", "0.0","Xpress"};
		input2 = new String [] {"h2s4e6","sdf","0.0","0.0","0.0", "0.0","Regular"};
		
		PRC = new PostalRateCalculator();
	}
	
	// test 1
	@Test
	public void testNumParam() {
		boolean actValid = false;
		actValid = PRC.checkNumParam(input1);
		assertTrue(actValid);
		actValid = PRC.checkNumParam(input2);
		assertTrue(actValid);
	}	
	
	// test 2
	@Test
	public void testPostalCode(){
		boolean actValid = false;
		actValid = PRC.checkValidPostalCode(input1[0]);
		assertTrue(actValid);
		actValid = PRC.checkValidPostalCode(input1[1]);
		assertTrue(actValid);
		actValid = PRC.checkValidPostalCode(input2[0]);
		assertTrue(actValid);
		actValid = PRC.checkValidPostalCode(input2[1]);
		assertFalse(actValid);
	}
	
	// test 3
	@Test
	public void testLengthParam(){
		boolean actValid = false;
		actValid = PRC.checkValidLengthParam(input1[2]);
		assertTrue(actValid);
		actValid = PRC.checkValidLengthParam(input2[2]);
		assertTrue(actValid);
	}
	
	// test 4
	@Test
	public void testWidthParam(){
		boolean actValid = false;
		actValid = PRC.checkValidWidthParam(input1[3]);
		assertTrue(actValid);
		actValid = PRC.checkValidWidthParam(input2[3]);
		assertTrue(actValid);
	}
	
	// test 5
	@Test
	public void testHeightParam(){
		boolean actValid = false;
		actValid = PRC.checkValidHeightParam(input1[4]);
		assertTrue(actValid);
		actValid = PRC.checkValidHeightParam(input2[4]);
		assertTrue(actValid);
	}
	
	// test 6
	@Test
	public void testWeigthParam(){
		boolean actValid = false;
		actValid = PRC.checkValidWeightParam(input1[5]);
		assertTrue(actValid);
		actValid = PRC.checkValidWeightParam(input2[5]);
		assertTrue(actValid);
	}
	
	// test 7
	@Test
	public void testPostalType(){
		boolean actValid = false;
		// valid = Regular, Xpress, Priority
		actValid = PRC.checkValidPostalType(input1[6]);
		assertTrue(actValid);
		actValid = PRC.checkValidPostalType(input2[6]);
		assertTrue(actValid);
	}
	
	// test 8
	@Test
	public void testInput(){
		boolean actValid = false;
		actValid = PRC.checkValidInput(input1);
		assertTrue(actValid);
		actValid = PRC.checkValidInput(input2);
		assertFalse(actValid);
	}
	
}
