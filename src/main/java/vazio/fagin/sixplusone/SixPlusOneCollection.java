package vazio.fagin.sixplusone;

import java.util.ArrayList;

public class SixPlusOneCollection {

	ArrayList<SixPlusOne> sixPlusOnes;
	
	public SixPlusOneCollection() {
		sixPlusOnes = new ArrayList<>();
	}
	
	public void add(SixPlusOne sixPlusOne) {
		sixPlusOnes.add(sixPlusOne);
	}
	
	public ArrayList<SixPlusOne> getSixPlusOnes() {
		return sixPlusOnes;
	}
}
