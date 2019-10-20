package com.java8.features.methodref;

import java.util.ArrayList;
import java.util.List;

public class MethodReference {

	public static void main(String[] args) {
		//Constructor Reference
		NewStringList listCreator =  ArrayList<String>::new;
		List<String> numbers = listCreator.create();
		
		//Static Method Reference
		StringValue str = String::valueOf;
		
		numbers.add(str.asString(123));
		numbers.add(str.asString(456));
		numbers.add(str.asString(789));
		
		//Instance method reference
		numbers.forEach(System.out::println);
	}
	
	interface StringValue {
		String asString(int i);
	}
	
	interface NewStringList {
		List<String> create();
	}

}
