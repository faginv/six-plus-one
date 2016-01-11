package vazio.fagin.sixplusone;

import static org.junit.Assert.*;

import org.junit.Test;

public class SixPlusOneCollectionSpec {

	@Test
	public void whenGiveSixPlusOneThenAddItInSixPlusOneCollection() {
		int[] sixNumbers = {1, 3, 4, 6, 9, 37};
		int bonusNumber = 2;
		SixPlusOne sixPlusOne = new SixPlusOne(sixNumbers, bonusNumber);
		SixPlusOneCollection sixPlusOneCollection = new SixPlusOneCollection();
		sixPlusOneCollection.add(sixPlusOne);
		assertEquals(sixPlusOneCollection.getSixPlusOnes().get(0), sixPlusOne);
	}
}
