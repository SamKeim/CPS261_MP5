package singleDigits;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountSingleDigits {
	public static void main(String[] args) {
		// using streams, write a program that generates 100 random integers between 0 and 9 and display count of each
		Random rand = new Random();
		rand
			.ints(0, 10)
			.limit(100)
			.mapToObj(Integer::valueOf)
			.collect(Collectors.groupingBy(e -> e, Collectors.counting()))
			.forEach((k, v) -> System.out.printf("Count of %d: %d\n", k, v));
//		Stream.generate(() -> rand.nextInt(10)).limit(100).collect(Collectors.groupingBy(e -> e, Collectors.counting())).forEach((k, v) -> System.out.println(k + " : " + v));
	}
}
