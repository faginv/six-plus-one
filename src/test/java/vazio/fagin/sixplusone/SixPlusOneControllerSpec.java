package vazio.fagin.sixplusone;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SixPlusOneControllerSpec {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Rule	
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setup() {	
		System.setOut(new PrintStream(outContent));		
	}
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}
	
	@Test
	public void whenStartThenAskEnteringOneNumber() {
		String bonusNumberPrompt = "Enter a bonus number: ";
		SixPlusOneController sixPlusOneController = new SixPlusOneController();
		sixPlusOneController.displayBonusNumberPrompt();
		assertEquals(bonusNumberPrompt, outContent.toString());
	}
	
	@Test
	public void whenEnterBonusNumber1OutOfRangeThenException() throws Exception {
		int outOfRangeBonusNumber = 0;
		exception.expect(Exception.class);
		SixPlusOneController sixPlusOneController = new SixPlusOneController();
		sixPlusOneController.validateBonusNumberRange(outOfRangeBonusNumber);		
	}
	
	@Test
	public void whenEnterBonusNumber2OutOfRangeThenException() throws Exception {
		int outOfRangeBonusNumber = 11;
		exception.expect(Exception.class);
		SixPlusOneController sixPlusOneController = new SixPlusOneController();
		sixPlusOneController.validateBonusNumberRange(outOfRangeBonusNumber);		
	}
	
	@Test
	public void whenEnterNonNumericCharThenException() {
		String nonNumeric = "a";
		exception.expect(Exception.class);
		SixPlusOneController sixPlusOneController = new SixPlusOneController();
		sixPlusOneController.validateNumber(nonNumeric);		
	}
	
	@Test
	public void whenEnterRightNumberThenStoreSixPlusOneBonusNumber() {
		int bonusNumber = 1;
		SixPlusOneController sixPlusOneController = new SixPlusOneController();
		sixPlusOneController.storeBonusNumberInSixPlusOne(bonusNumber);
		assertEquals(bonusNumber, sixPlusOneController.readBonusNumberInSixPlusOne());
	}
	
	@Test
	public void whenStartThenAskEnteringSixNumbers() {
		String sixNumbersPrompt = "Enter six numbers: ";
		SixPlusOneController sixPlusOneController = new SixPlusOneController();
		sixPlusOneController.displaySixNumbersPrompt();
		assertEquals(sixNumbersPrompt, outContent.toString());
	}
	
	@Test
	public void whenEnterNumber1OutOfRangeThenException() throws Exception {
		int outOfRangeBonusNumber = 0;
		exception.expect(Exception.class);
		SixPlusOneController sixPlusOneController = new SixPlusOneController();
		sixPlusOneController.validateSixNumberRange(outOfRangeBonusNumber);		
	}
	
	@Test
	public void whenEnterNumber2OutOfRangeThenException() throws Exception {
		int outOfRangeBonusNumber = 41;
		exception.expect(Exception.class);
		SixPlusOneController sixPlusOneController = new SixPlusOneController();
		sixPlusOneController.validateSixNumberRange(outOfRangeBonusNumber);		
	}
	
	@Test
	public void whenEnterRightSixNumbersThenStoreSixPlusOneSixNumbers() {
		int[] sixNumbers = {1, 3, 5, 7, 8, 28};
		SixPlusOneController sixPlusOneController = new SixPlusOneController();
		sixPlusOneController.storeSixNumbersInSixPlusOne(sixNumbers);
		assertEquals(sixNumbers, sixPlusOneController.readSixNumbersInSixPlusOne());
	}
}
