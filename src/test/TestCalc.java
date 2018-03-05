package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import postalRateCalculator.PostalRateCalculator;

public class TestCalc {
	String [] input1;
	String [] input2;
	String [] input3;
	
	String [] input_a;
	String [] input_b;
	String [] input_c;
	
	String [] input_d;
	String [] input_e;
	String [] input_f;
	
	String [] input_g;
	String [] input_h;
	String [] input_i;
	PostalRateCalculator PRC;

	@Before
	public void setUp (){
		// param testing
		input1 = new String [] {"h2x2y6","h2x2y6","12.0","134.0","0.0", "29.0","Xpress"};
		input2 = new String [] {"h2s4e6","sdf","0.0","0.0","0.0", "0.0","Regular"};
		input3 = new String [] {"h2s4e6","h2x2y6","23.0","233.0","65.0", "344.0","Regular"};
		
		// calc rate tests for differnt weights and postal types
		input_a = new String [] {"h2x2y6","h2x2y6","12.0","134.0","0.0", "3.932","Regular"};
		input_b = new String [] {"h2x2y6","h2x2y6","12.0","134.0","0.0", "13.932","Regular"};
		input_c = new String [] {"h2x2y6","h2x2y6","12.0","134.0","0.0", "23.932","Regular"};
		
		input_d = new String [] {"h2x2y6","h2x2y6","12.0","134.0","0.0", "3.932","Xpress"};
		input_e = new String [] {"h2x2y6","h2x2y6","12.0","134.0","0.0", "13.932","Xpress"};
		input_f = new String [] {"h2x2y6","h2x2y6","12.0","134.0","0.0", "23.932","Xpress"};
		
		input_g = new String [] {"h2x2y6","h2x2y6","12.0","134.0","0.0", "3.932","Priority"};
		input_h = new String [] {"h2x2y6","h2x2y6","12.0","134.0","0.0", "13.932","Priority"};
		input_i = new String [] {"h2x2y6","h2x2y6","12.0","134.0","0.0", "23.932","Priority"};
		
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
		actValid = PRC.checkNumParam(input3);
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
		actValid = PRC.checkValidPostalCode(input3[0]);
		assertTrue(actValid);
		actValid = PRC.checkValidPostalCode(input3[1]);
		assertTrue(actValid);
	}
	
	// test 3
	@Test
	public void testLengthParam(){
		boolean actValid = false;
		actValid = PRC.checkValidLengthParam(input1[2]);
		assertTrue(actValid);
		actValid = PRC.checkValidLengthParam(input2[2]);
		assertTrue(actValid);
		actValid = PRC.checkValidLengthParam(input3[2]);
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
		actValid = PRC.checkValidWidthParam(input3[3]);
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
		actValid = PRC.checkValidHeightParam(input3[4]);
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
		actValid = PRC.checkValidWeightParam(input3[5]);
		assertFalse(actValid);
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
		actValid = PRC.checkValidPostalType(input3[6]);
		assertTrue(actValid);
	}
	
	// test 8
	@Test
	public void testValidInput(){
		boolean actValid = false;
		actValid = PRC.checkValidInput(input1);
		assertTrue(actValid);
		actValid = PRC.checkValidInput(input2);
		assertFalse(actValid);
		actValid = PRC.checkValidInput(input3);
		assertFalse(actValid);
	}
		
	// test 9
	@Test
	public void testCalcRate_w1_t1(){
		assertEquals(1.8,PRC.calcRate(input_a),0.1);
	}
	// test 10
	@Test
	public void testCalcRate_w2_t1(){
		assertEquals(2.95,PRC.calcRate(input_b),0.1);
	}
	// test 11
	@Test
	public void testCalcRate_w3_t1(){
		assertEquals(4.10,PRC.calcRate(input_c),0.1);
	}
	
	// test 12
	@Test
	public void testCalcRate_w1_t2(){
		assertEquals(2.8,PRC.calcRate(input_d),0.1);
	}
	// test 13
	@Test
	public void testCalcRate_w2_t2(){
		assertEquals(3.95,PRC.calcRate(input_e),0.1);
	}
	// test 14
	@Test
	public void testCalcRate_w3_t2(){
		assertEquals(5.10,PRC.calcRate(input_f),0.1);
	}
	
	// test 15
	@Test
	public void testCalcRate_w1_t3(){
		assertEquals(3.8,PRC.calcRate(input_g),0.1);
	}
	// test 16
	@Test
	public void testCalcRate_w2_t3(){
		assertEquals(4.95,PRC.calcRate(input_h),0.1);
	}
	// test 17
	@Test
	public void testCalcRate_w3_t3(){
		assertEquals(6.10,PRC.calcRate(input_i),0.1);
	}
	
}
