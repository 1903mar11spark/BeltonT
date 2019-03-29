package com.revature.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.transport.Car;

public class ThirdFriday {

	public static void main(String[] args) {

		String fileName="src/cereal.txt";
		List<Car> cars = new ArrayList<Car>();
		cars.add(new Car(1890, "Model", "A"));
		cars.add(new Car(1895, "Model", "B"));
		cars.add(new Car(1900, "Model", "C"));
		
		//ThirdFriday.serialize(fileName, cars);
		System.out.println(ThirdFriday.deserialize(fileName));
	}
	static void serialize(String fileName, Object o) {
		try {
			FileOutputStream fo = new FileOutputStream(fileName);
			
			ObjectOutputStream out = new ObjectOutputStream(fo);
			out.writeObject(o);
			
			fo.close();
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
	}
	static Object deserialize(String fileName) {
		Object o = null;
		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			
			o = in.readObject();
			in.close();
			fileIn.close();
			
		}catch(Exception e) {
			
		}return o;
	}
}
