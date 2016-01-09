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
		setSixNumbers(getNumberPool());		
		setBonusNumber(getBonusPool());
		
	}

	public int[] getSixNumbers() {		
		return sixNumbers;
	}
	
	private ArrayList<Integer> getNumberPool() {				
		return getIntegerList(SIX_NUMBERS_POOL_MAX);
	}
	
	private void setSixNumbers(ArrayList<Integer> numbers) {		
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

	private void setBonusNumber(ArrayList<Integer> bonus) {		
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

	
	
	

	
	

}
