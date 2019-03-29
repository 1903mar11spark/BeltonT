package com.revature.example;

import java.lang.reflect.*;
import java.util.Arrays;

import com.revature.transport.Chairlift;

public class SecondFriday {

	public static void main(String[] args) {
	
		reflectingOnChairlifts();
	}

	static void reflectingOnChairlifts() {
		try {
			
			Class cliftClass = Class.forName("com.revature.transport.Chairlift");
			System.out.println(cliftClass.getSimpleName());
			
			Field[] clFields = cliftClass.getDeclaredFields();
			System.out.println(Arrays.toString(clFields));
			
			Chairlift cl = (Chairlift) cliftClass.newInstance();
			Field gondolaCount = cliftClass.getDeclaredField("gondalaCount");
			gondolaCount.setAccessible(true);
			gondolaCount.set(cl, 3);
			System.out.println(cl);
			
		}catch (ClassNotFoundException e) {
			e.getStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
}
