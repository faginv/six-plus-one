package vazio.fagin.sixplusone;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SixPlusOneSpec {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private SixPlusOne sixPlusOne;
	
	@Rule	
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setup() {	
		System.setOut(new PrintStream(outContent));
		sixPlusOne = new SixPlusOne();
	}
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}
		
	@Test
	public void whenGuessSixNumbersThenGetSixRandomNumbers() {						
		assertTrue(sixPlusOne.getSixNumbers().length == 6);
	}
	
	@Test
	public void whenGuessBonusNumberThenGetOneBonusNumber() {
		assertTrue(new Integer(sixPlusOne.getBonusNumber()) instanceof Integer);
	}
	
	@Test
	public void whenDisplaySixNumbersThenPrintSixNumbersSeparatedWithComma() {
		sixPlusOne.displaySixNumbers();
		assertEquals(printSixNumbers(), outContent.toString());
	}
	
	private String printSixNumbers() {
		int[] sixNumbers = sixPlusOne.getSixNumbers();
		String printSixNumbers = "";
		int lastItem = SixPlusOne.SIX_NUMBERS_LENGTH - 1;
		for(int i = 0; i < SixPlusOne.SIX_NUMBERS_LENGTH; i++) {
			printSixNumbers += sixNumbers[i];
			if(i != lastItem) {
				printSixNumbers += ",";
			}
		}
		return printSixNumbers;
	}
	
	@Test
	public void whenDisplayBonusNumberThenPrintBonusNumber() {
		sixPlusOne.displayBonusNumber();
		assertEquals(printBonusNumber(), outContent.toString());
	}
	
	private String printBonusNumber() {
		return String.valueOf(sixPlusOne.getBonusNumber());
	}
	
	@Test
	public void whenEnterSixNumbersThenSetSixNumbersOfSixPlusOne() {
		int[] sixNumbers = {1, 2, 3, 4, 5, 40};
		sixPlusOne.setSixNumbers(sixNumbers);
		assertTrue(sixPlusOne.getSixNumbers() == sixNumbers);
	}
	
	@Test 
	public void whenEnterOneBonusNumberThenSetOneBonusNumberOfSixPlusOne() {
		int bonusNumber = 1;
		sixPlusOne.setBonusNumber(bonusNumber);
		assertTrue(sixPlusOne.getBonusNumber() == bonusNumber);
	}
	
	@Test
	public void whenToStringThenReturnSixPlusOneString() {
		int[] sixNumbers = {1, 2, 3, 4, 5, 40};
		sixPlusOne.setSixNumbers(sixNumbers);
		int bonusNumber = 1;
		sixPlusOne.setBonusNumber(bonusNumber);
		assertEquals("Lucky Number: 1, 2, 3, 4, 5, 40   Bonus: 1", sixPlusOne.toString());
	}
}
