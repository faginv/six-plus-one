package vazio.fagin.sixplusone;

import java.util.ArrayList;
import java.util.Collections;

public class SixPlusOne {
	
	public static final int SIX_NUMBERS_POOL_MAX = 40;
	public static final int BONUS_NUMBER_MAX = 10;
	
	public static final int SIX_NUMBERS_LENGTH = 6;
	public static final int FIRST_BONUS_NUMBER = 0;
	
	private int[] sixNumbers;
	private int bonusNumber;

	public SixPlusOne() {
		pickSixNumbers(getNumberPool());		
		pickBonusNumber(getBonusPool());		
	}
	
	public SixPlusOne(int[] sixNumbers, int bonusNumber) {
		this.sixNumbers = sixNumbers;
		this.bonusNumber = bonusNumber;
	}

	public int[] getSixNumbers() {		
		return sixNumbers;
	}
	
	private ArrayList<Integer> getNumberPool() {				
		return getIntegerList(SIX_NUMBERS_POOL_MAX);
	}
	
	private void pickSixNumbers(ArrayList<Integer> numbers) {		
		int[] sixNumbers = new int[6];
		for(int i = 0; i < SIX_NUMBERS_LENGTH; i++) {
			sixNumbers[i] = numbers.get(i);
		}
		this.sixNumbers = sixNumbers;
	}
	
	public int getBonusNumber() {		
		return bonusNumber;
	}
	
	private ArrayList<Integer> getBonusPool() {
		return getIntegerList(BONUS_NUMBER_MAX);
	}

	private void pickBonusNumber(ArrayList<Integer> bonus) {		
		this.bonusNumber = bonus.get(FIRST_BONUS_NUMBER);
	}
	
	private ArrayList<Integer> getIntegerList(int max) {
		ArrayList<Integer> integerList = new ArrayList<>();
		for(int i = 0; i < max; i++) {
			integerList.add(i + 1);
		}
		Collections.shuffle(integerList);
		
		return integerList;
	}
	
	public void displaySixNumbers() {
		String displaySixNumbers = "";
		int lastItem = SIX_NUMBERS_LENGTH - 1;
		for(int i = 0; i < SIX_NUMBERS_LENGTH; i++) {
			displaySixNumbers += sixNumbers[i];
			if(i != lastItem) {
				displaySixNumbers += ",";
			}
		}		
		System.out.print(displaySixNumbers);
	}

	public void displayBonusNumber() {
		System.out.print(bonusNumber);		
	}

	public void setSixNumbers(int[] sixNumbers) {
		this.sixNumbers = sixNumbers;
	}

	public void setBonusNumber(int bonusNumber) {
		this.bonusNumber = bonusNumber;
	}

	@Override
	public String toString() {
		String displayString = "Lucky Number: ";
		int lastItem = SIX_NUMBERS_LENGTH - 1;
		for(int i = 0; i < SIX_NUMBERS_LENGTH; i++) {
			displayString += sixNumbers[i];
			if(i != lastItem) {
				displayString += ", ";
			}
		}
		displayString += "   Bonus: " + bonusNumber;
		return displayString;
	}
	
	

	
	

}
