package streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Stream {

	public static void main(String[] args) {
		//forEach
		List<Integer> numbers = Arrays.asList(3,2,2,3,7,3,5);
		List<Integer> squares = numbers.stream().map(i->i*i).distinct().collect(Collectors.toList());
		System.out.println(squares);
		
		//filters
		List<String> strings = Arrays.asList("abc","","def","","pqrs","jkl");
		long counts = strings.stream().filter(string -> string.isEmpty()).count();
		System.out.println(counts);
		
		//limit
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);
		
		//sorted
		Random random2 = new Random();
		random2.ints().limit(10).sorted().forEach(System.out::println);
		
		//Parallel processing
		List<String> strings2 = Arrays.asList("abc","","def","","pqrs","jkl");
		long counts2 = strings2.parallelStream().filter(string -> string.isEmpty()).count();
		System.out.println(counts2);
		
		//Collectors
		List<String> allStrings = Arrays.asList("abc","","def","","pqrs","jkl");
		List<String> filtered = allStrings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println(filtered);
		
		//Statastics
		List<Integer> integers = Arrays.asList(3,2,2,3,7,3,5);
		IntSummaryStatistics stats = integers.stream().mapToInt(x->x).summaryStatistics();
		
		System.out.println("List: "+integers);
		System.out.println("Max in List: "+ stats.getMax());
		System.out.println("Min in List: "+ stats.getMin());
		System.out.println("Sum of List: "+ stats.getSum());
		System.out.println("Avg in List: "+ stats.getAverage());
	}
}
