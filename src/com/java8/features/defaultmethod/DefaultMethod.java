package defaultmethod;

interface Vehicle {
	default void display() {
		System.out.println("I am Vehicle");
	}
	
	static void blowHorn() {
		System.out.println("Blowing Horn");
	}
}

interface FourWheeler {
	default void display() {
		System.out.println("I am Four Wheeler");
	}
}

class Car implements Vehicle,FourWheeler {

	@Override
	public void display() {
		Vehicle.super.display();
		FourWheeler.super.display();
		System.out.println("I am Car");
		Vehicle.blowHorn();
	}
	
}
public class DefaultMethod {

	public static void main(String[] args) {
		Car car = new Car();
		
		car.display();

	}

}