package com.java8.features.func_interface;

public class FunctionalInterfaceTest {

	public static void main(String[] args) {
		//Using Functional Interface
		MyFunction func = ()-> System.out.println("Testing Functional Interface");
		
		func.doSomeThing();
	}
}
/*@FunctionalInterface annotation is used to ensure that the 
 * functional interface can’t have more than one abstract method. 
 * In case more than one abstract methods are present, 
 * the compiler flags an ‘Unexpected @FunctionalInterface 
 * annotation’ message
 */
@FunctionalInterface
interface MyFunction{
	public abstract void doSomeThing();
}
