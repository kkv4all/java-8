package com.java8.features.stringjoiner;

import java.util.StringJoiner;

public class StringJoinerTest {

	public static void main(String[] args) {
		//Simple Example
		simpleStringJoiner();
		//Adding Prefix and Suffix
		addingPrefixAndSuffix();
		//Merge Two StringJoiner
		mergeStringJoiners();
	}

	private static void simpleStringJoiner() {
		StringJoiner joinNames = new StringJoiner(","); // passing comma(,) as delimiter   

		// Adding values to StringJoiner  
		joinNames.add("Rahul");  
		joinNames.add("Raju");  
		joinNames.add("Peter");  
		joinNames.add("Raheem");  

		System.out.println(joinNames);
	}

	private static void addingPrefixAndSuffix() {
		StringJoiner joinNames = new StringJoiner(",", "[", "]");   // passing comma(,) and square-brackets as delimiter   

		// Adding values to StringJoiner  
		joinNames.add("Rahul");  
		joinNames.add("Raju");  
		joinNames.add("Peter");  
		joinNames.add("Raheem");  

		System.out.println(joinNames);  
	}

	private static void mergeStringJoiners() {
		StringJoiner joinNames = new StringJoiner(",", "[", "]");   // passing comma(,) and square-brackets as delimiter   

		// Adding values to StringJoiner  
		joinNames.add("Rahul");  
		joinNames.add("Raju");  

		// Creating StringJoiner with :(colon) delimiter  
		StringJoiner joinNames2 = new StringJoiner(":", "[", "]");  // passing colon(:) and square-brackets as delimiter   

		// Adding values to StringJoiner  
		joinNames2.add("Peter");  
		joinNames2.add("Raheem");  

		// Merging two StringJoiner  
		StringJoiner merge = joinNames.merge(joinNames2);   
		System.out.println(merge);
	}
}
