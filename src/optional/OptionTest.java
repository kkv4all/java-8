 package optional;

import java.util.Optional;

public class OptionTest {
	public static void main(String[] args) {
		Optional<Integer> a = Optional.ofNullable(null);
		Optional<Integer> b = Optional.of(10);
		
		System.out.println("Sum: " + sum(a, b));
	}
	
	public static int sum (Optional<Integer> a, Optional<Integer> b) {
		//isPresent to check value is present or not
		if(!a.isPresent()) {
			System.out.println("First Value is missing.");
		}
		//orElse returns the default value specified if value not present
		//get returns the value, value should be present
		return a.orElse(0) + b.get();
	}
}
