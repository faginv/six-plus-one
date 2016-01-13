package vazio.fagin.sixplusone;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import org.junit.rules.ExpectedException;

public class SixPlusOneControllerSpec {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	private SixPlusOneController sixPlusOneController;
	
	@Rule	
	public ExpectedException exception = ExpectedException.none();
	
	@Rule
	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	@Before
	public void setup() {	
		System.setOut(new PrintStream(outContent));
		sixPlusOneController = new SixPlusOneController();
	}
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}
	
	@Test
	public void whenStartThenAskEnteringOneNumber() {
		String bonusNumberPrompt = "Enter a bonus number: ";		
		sixPlusOneController.displayBonusNumberPrompt();
		assertEquals(bonusNumberPrompt, outContent.toString());
	}
	
	@Test
	public void whenBonusNumber1OutOfRangeThenException() throws Exception {
		int outOfRangeBonusNumber = 0;
		exception.expect(Exception.class);		
		sixPlusOneController.validateBonusNumberRange(outOfRangeBonusNumber);		
	}
	
	@Test
	public void whenBonusNumber2OutOfRangeThenException() throws Exception {
		int outOfRangeBonusNumber = 11;
		exception.expect(Exception.class);		
		sixPlusOneController.validateBonusNumberRange(outOfRangeBonusNumber);		
	}
	
	@Test
	public void whenNonNumericCharThenException() {
		String nonNumeric = "a";
		exception.expect(Exception.class);		
		sixPlusOneController.validateNumber(nonNumeric);		
	}
	
	@Test
	public void whenRightNumberThenStoreSixPlusOneBonusNumber() {
		int bonusNumber = 1;
		sixPlusOneController.storeBonusNumberInSixPlusOne(bonusNumber);
		assertEquals(bonusNumber, sixPlusOneController.getSixPlusOnes().get(0).getBonusNumber());
	}
	
	@Test
	public void whenStartThenAskEnteringSixNumbers() {
		String sixNumbersPrompt = "Enter six numbers: ";
		sixPlusOneController.displaySixNumbersPrompt();
		assertEquals(sixNumbersPrompt, outContent.toString());
	}
	
	@Test
	public void whenNumber1OutOfRangeThenException() throws Exception {
		int outOfRangeNumber = 0;
		exception.expect(Exception.class);
		sixPlusOneController.validateSixNumberRange(outOfRangeNumber);		
	}
	
	@Test
	public void whenNumber2OutOfRangeThenException() throws Exception {
		int outOfRangeNumber = 41;
		exception.expect(Exception.class);
		sixPlusOneController.validateSixNumberRange(outOfRangeNumber);		
	}
	
	@Test
	public void whenRightSixNumbersThenStoreSixPlusOneSixNumbers() {
		int[] sixNumbers = {1, 3, 5, 7, 8, 28};
		sixPlusOneController.storeSixNumbersInSixPlusOne(sixNumbers);
		assertEquals(sixNumbers, sixPlusOneController.getSixPlusOnes().get(0).getSixNumbers());
	}
	
	@Test
	public void whenEnterKeyThenGetVariableWithInteger() {
		systemInMock.provideLines("12 11");
		assertEquals(12, sixPlusOneController.getKeyValue());
		assertEquals(11, sixPlusOneController.getKeyValue());
	}
	
	@Test
	public void whenEnterOneNotNumericKeyThenException() {
		systemInMock.provideLines("#");
		exception.expect(Exception.class);		
		sixPlusOneController.getKeyValue();		
	}
	
	@Test
	public void whenEnterBonusNumber1OutOfRangeThenException() throws Exception {
		systemInMock.provideLines("0");
		exception.expect(Exception.class);
		int outOfRangeBonusNumber = sixPlusOneController.getKeyValue();
		sixPlusOneController.validateBonusNumberRange(outOfRangeBonusNumber);		
	}
	
	@Test
	public void whenEnterBonusNumber2OutOfRangeThenException() throws Exception {
		systemInMock.provideLines("11");
		exception.expect(Exception.class);
		int outOfRangeBonusNumber = sixPlusOneController.getKeyValue();
		sixPlusOneController.validateBonusNumberRange(outOfRangeBonusNumber);		
	}
	
	@Test
	public void whenEnterRightNumberThenStoreSixPlusOneBonusNumber() {
		int bonusNumber = 1;
		systemInMock.provideLines("" + bonusNumber);
		int bonusNumberValue = sixPlusOneController.getKeyValue();
		sixPlusOneController.storeBonusNumberInSixPlusOne(bonusNumberValue);
		assertEquals(bonusNumber, sixPlusOneController.getSixPlusOnes().get(0).getBonusNumber());
	}
	
	@Test
	public void whenEnterNumber1OutOfRangeThenException() throws Exception {
		systemInMock.provideLines("0");
		exception.expect(Exception.class);
		int outOfRangeNumber = sixPlusOneController.getKeyValue();
		sixPlusOneController.validateSixNumberRange(outOfRangeNumber);		
	}
	
	@Test
	public void whenEnterNumber2OutOfRangeThenException() throws Exception {
		systemInMock.provideLines("41");
		exception.expect(Exception.class);
		int outOfRangeNumber = sixPlusOneController.getKeyValue();
		sixPlusOneController.validateSixNumberRange(outOfRangeNumber);		
	}
	
	@Test
	public void whenEnterRightSixNumbersThenStoreSixPlusOneSixNumbers() {
		systemInMock.provideLines("1 2 3 4 5 40");
		int[] sixNumbers = new int[6];
		for(int i = 0; i < sixNumbers.length; i++) {
			sixNumbers[i] = sixPlusOneController.getKeyValue();
		}
		sixPlusOneController.storeSixNumbersInSixPlusOne(sixNumbers);		
		assertEquals(sixNumbers, sixPlusOneController.getSixPlusOnes().get(0).getSixNumbers());
	}
	
	@Test
	public void whenEnterRightSixNumbersAndBonusNumberThenStoreSixPlusOneSixNumbersAndBonus() {
		systemInMock.provideLines("1 2 3 4 5 40");
		int[] sixNumbers = new int[6];
		for(int i = 0; i < sixNumbers.length; i++) {
			sixNumbers[i] = sixPlusOneController.getKeyValue();
		}
		systemInMock.provideLines("2");
		int bonusNumber = sixPlusOneController.getKeyValue();
		sixPlusOneController.storeSixNumbersAndBonusInSixPlusOne(sixNumbers, bonusNumber);
		assertEquals(sixNumbers, sixPlusOneController.getSixPlusOnes().get(0).getSixNumbers());
		assertEquals(bonusNumber, sixPlusOneController.getSixPlusOnes().get(0).getBonusNumber());
	}
	
	@Test
	public void whenSixNumbersHaveSameNumbersThenReturnFalse() {
		int[] sixNumbers = {1, 3, 5, 7, 8, 3};
		sixPlusOneController.checkNumbers(sixNumbers);
		assertFalse(sixPlusOneController.checkNumbers(sixNumbers));
	}
}
