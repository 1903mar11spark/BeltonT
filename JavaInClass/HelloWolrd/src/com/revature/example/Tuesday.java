package com.revature.example;

import java.util.*;

import com.revature.transport.*; //does nothing, just saves typing

/*
 * import statements:
 * com.revature.transport.*  => every class in that package (single level)
 * 
 * com.revature.car ==>just the car class
 * 
 * static com.revature.otherPackage.classInIt => all static members of that class
 * 
 * static com.revature.otherPackage.classInIn.statisMember => usually constants, just that one
 */

public class Tuesday {
	
	public static void main(String [] args) {
		System.out.println("Hello World");
		funWithTransport();
	}
	
	static void funWithTransport() {
		//using fully qualified class name to refer to kayak
		//this always works
		com.revature.transport.Kayak k1 = new com.revature.transport.Kayak(3.3,"red");
		
		//using import statement
		Kayak k2 = new Kayak(4.5,"blue");
		
		//more vehicles
		Car c1 = new Car(1999,"Mazda","Miata");
		Car c2 = new Car(2018,"Tesla","Model 3");
		
		Chairlift Cl1 = new Chairlift(950,12);
		
		//list of vehicles
		List<Vehicle> vehicles = new ArrayList<>();
		vehicles.add(k2);
		vehicles.add(c1);
		vehicles.add(k1);
		vehicles.add(Cl1);
		vehicles.add(c2);
		
		for (Vehicle v: vehicles) {
			System.out.println(v);//will print out toString methods
			v.move();
			if(v instanceof Steerable) {
				((Steerable) v).turnLeft();
			}
		}
	}

	static void funWithWrapperClasses() {
		
		//integer-valued primitives
		byte b = 5;
		short s = 6;
		int i = 7;
		long l = 8;
		
		Integer j = i; //autoboxing
		b = new Byte((byte) 9); //narrowing conversion - be careful!
		
		//string to number conversions
		
		String str = "55.4";
		Double d = Double.parseDouble(str);
		
		//check type
		System.out.println(d.getClass());
		
		//can also use instanceof
		boolean isDouble = (d instanceof java.lang.Double);
		System.out.println(isDouble);
		
		
	}

}


