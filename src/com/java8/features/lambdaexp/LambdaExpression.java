package com.java8.features.lambdaexp;

public class LambdaExpression {

	public static void main(String[] args) {
		LambdaExpression exp = new LambdaExpression();
		
		MathOperation addition = (a,b)-> a+b;
		MathOperation substration = (a,b)-> a-b;
		MathOperation multiplication = (a,b)-> a*b;
		MathOperation division = (a,b)-> a/b;

		System.out.println("Addtion of 1 and 2:" + exp.operate(1, 2, addition));
		System.out.println("Substration of 5 and 2:" + exp.operate(5, 2, substration));
		System.out.println("Multiplication of 3 and 2:" + exp.operate(3, 2, multiplication));
		System.out.println("Division of 6 and 2:" + exp.operate(6, 2, division));
	}
	
	private int operate(int a, int b, MathOperation operation) {
		return operation.evaluate(a, b);
	}
	
	interface MathOperation {
		int evaluate(int a,int b);
	}
}
