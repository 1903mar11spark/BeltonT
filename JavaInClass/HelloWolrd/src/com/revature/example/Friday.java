package com.revature.example;

import java.util.*;

import com.revature.comparison.KayakLengthCompare;
import com.revature.transport.Kayak;

public class Friday {

	public static void main(String[] args) {
	List<Kayak> kayakList = new ArrayList<>();

			kayakList.add(new Kayak(3.4, "green"));
			kayakList.add(new Kayak(2.0, "blue"));
			kayakList.add(new Kayak(5.6, "red"));
			kayakList.add(new Kayak(4.6, "red"));
			
			//sortWithComparitor(kayakList, new KayakLengthCompare());
			
			
			//Anonymous inner class
		
			Comparator<Kayak> ck = new Comparator<Kayak>() {
				@Override
				public int compare(Kayak arg0, Kayak arg1) {
					//manually boxed
					return arg0.getColor().compareTo(arg1.getColor());
					//return (new Double( arg0.getLength())).compareTo(arg1.getLength());
			}
			};
	
			
			//anonymous inner class to compare
			sortWithComparitor(kayakList, new Comparator<Kayak>() {
			@Override
			public int compare(Kayak arg0, Kayak arg1) {
				//manually boxed
				return arg0.getColor().compareTo(arg1.getColor());
				//return (new Double( arg0.getLength())).compareTo(arg1.getLength());
		}
		});
			
			//comparison with LAMBDAs
			Collections.sort(kayakList, ((Kayak k1, Kayak k2)-> k1.getColor().compareTo(k2.getColor())));
			for(Kayak k: kayakList) {
				System.out.println(k);
			}
			
			
	}
	
	static void sortWithComparable(List<Kayak> kl) {
		Collections.sort(kl);
		for (Kayak k :kl) {
			System.out.println(k);
		}
		
	}
	
	static void sortWithComparitor(List<Kayak> kl, Comparator<Kayak> c) {
		Collections.sort(kl, c);
		for (Kayak k :kl) {
			System.out.println(k);
		}
	}

}
