package sort;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SortTwoDimensionalArray {
	public static void main(String[] args) {
		// use streams to write a program that displays
		// the distinct numbers in the array
		// display them in increasing order, separated
		// by one space
		int[][] numberArr =  {{34,89},{56,3},{27,61},{45,8},{45,89}};
		Stream
			.of(numberArr)
			.flatMapToInt(e -> IntStream.of(e))
//			.distinct().sorted()
			.collect(TreeSet::new, Set::add, Set::addAll)
			.forEach(e -> System.out.print(e + " "));
	}
}
