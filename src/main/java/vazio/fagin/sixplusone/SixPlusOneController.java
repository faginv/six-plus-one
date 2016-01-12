package vazio.fagin.sixplusone;

import java.util.Scanner;

public class SixPlusOneController {

	SixPlusOneCollection sixPlusOneCollection;
	
	Scanner scanner;
	
	public SixPlusOneController() {
		sixPlusOneCollection = new SixPlusOneCollection();
		SixPlusOne sixPlusOne = new SixPlusOne();
		sixPlusOneCollection.add(sixPlusOne);
		
		scanner = new Scanner(System.in);
	}
	
	public void displayBonusNumberPrompt() {
		String bonusNumberPrompt = "Enter a bonus number: ";
		System.out.print(bonusNumberPrompt);
	}

	public void validateBonusNumberRange(int bonusNumber) throws Exception {
		if(bonusNumber < 1 || bonusNumber > SixPlusOne.BONUS_NUMBER_MAX) {
			throw new Exception("Out of range");
		}		
	}

	public void validateNumber(String nonNumeric) throws NumberFormatException {		
		Integer.parseInt(nonNumeric);		
	}

	public void storeBonusNumberInSixPlusOne(int bonusNumber) {	
		sixPlusOneCollection.getSixPlusOnes().get(0).setBonusNumber(bonusNumber);
	}

	public int readBonusNumberInSixPlusOne() {		
		return sixPlusOneCollection.getSixPlusOnes().get(0).getBonusNumber();
	}

	public void displaySixNumbersPrompt() {
		String sixNumbersPrompt = "Enter six numbers: ";
		System.out.print(sixNumbersPrompt);
	}
	
	public void validateSixNumberRange(int bonusNumber) throws Exception {
		if(bonusNumber < 1 || bonusNumber > SixPlusOne.SIX_NUMBERS_POOL_MAX) {
			throw new Exception("Out of range");
		}		
	}

	public void storeSixNumbersInSixPlusOne(int[] sixNumbers) {
		sixPlusOneCollection.getSixPlusOnes().get(0).setSixNumbers(sixNumbers);
	}

	public int[] readSixNumbersInSixPlusOne() {
		return sixPlusOneCollection.getSixPlusOnes().get(0).getSixNumbers();
	}

	public int getKeyValue() {
		int keyValue = scanner.nextInt();
		return keyValue;
	}

	
}
