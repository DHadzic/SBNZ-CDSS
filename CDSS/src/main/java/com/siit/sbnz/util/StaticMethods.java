package com.siit.sbnz.util;

import java.util.ArrayList;

import com.siit.sbnz.facts.FactSymptom;

public class StaticMethods {

	public static ArrayList<String> getSymptoms(ArrayList<?> list){
		ArrayList<String> retVal = new ArrayList<String>();
		
		for (Object o : list) {
			if(o instanceof FactSymptom) {
				retVal.add(((FactSymptom) o).getSymptomId());
			}
		}
		return retVal;
	}
}
