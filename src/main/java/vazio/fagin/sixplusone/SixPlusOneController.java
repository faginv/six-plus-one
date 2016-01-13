package vazio.fagin.sixplusone;

import java.util.ArrayList;
import java.util.Scanner;

public class SixPlusOneController {

	SixPlusOneCollection sixPlusOneCollection;
	
	Scanner scanner;
	
	public SixPlusOneController() {
		sixPlusOneCollection = new SixPlusOneCollection();
		
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
		SixPlusOne sixPlusOne = new SixPlusOne();
		sixPlusOne.setBonusNumber(bonusNumber);
		sixPlusOneCollection.add(sixPlusOne);
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
		SixPlusOne sixPlusOne = new SixPlusOne();
		sixPlusOne.setSixNumbers(sixNumbers);
		sixPlusOneCollection.add(sixPlusOne);
	}

	public ArrayList<SixPlusOne> getSixPlusOnes() {
		ArrayList<SixPlusOne> sixPlusOnes = sixPlusOneCollection.getSixPlusOnes();	
		return sixPlusOnes;
	}

	public int getKeyValue() {
		int keyValue = scanner.nextInt();
		return keyValue;
	}

	public void storeSixNumbersAndBonusInSixPlusOne(int[] sixNumbers, int bonusNumber) {
		SixPlusOne sixPlusOne = new SixPlusOne();
		sixPlusOne.setSixNumbers(sixNumbers);
		sixPlusOne.setBonusNumber(bonusNumber);
		sixPlusOneCollection.add(sixPlusOne);		
	}

	public boolean checkNumbers(int[] sixNumbers) {
		for(int i = 0; i < SixPlusOne.SIX_NUMBERS_LENGTH - 1; i++) {
			for(int j = i + 1; j < SixPlusOne.SIX_NUMBERS_LENGTH; j++) {
				if(sixNumbers[i] == sixNumbers[j]) {
					return false;
				}
			}
		}		
		return true;		
	}

	
}
