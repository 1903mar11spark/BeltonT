package com.revature.comparison;

import java.util.Comparator;

import com.revature.transport.Kayak;

public class KayakLengthCompare implements Comparator<Kayak>{

	@Override
	public int compare(Kayak arg0, Kayak arg1) {
		
		//manually boxed
		return (new Double( arg0.getLength())).compareTo(arg1.getLength());
		
	}
	
	
	
}
