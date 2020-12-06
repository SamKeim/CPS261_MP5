package scrabble;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ScrabbleScoreStats {
	static Map<Character, Integer> letterValues = new HashMap<>();

	public static void main(String[] args) {
		
		// Setup
		generateScoreboard();
		String[] words = {"Java", "program", "list", "string", "unix", "hours", "syntax", "error"};
		Map<String, Integer> scoreMap = 
			Stream
			.of(words)
			.collect(Collectors.toMap(k -> k, v -> getWordScore(v.toLowerCase())
					,(v1,v2) ->{ throw new RuntimeException(String.format("Duplicate key for values %s and %s", v1, v2));},
					LinkedHashMap::new
					));
		
		System.out.println("All Words and Scores");
		Stream.of(scoreMap).forEach(System.out::println);
		System.out.println("\n==========");
		
		System.out.println("Three largest Scrabble Scores in list");
		scoreMap
			.entrySet()
			.stream()
			.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
			.limit(3)
			.forEach(System.out::println);
		
		System.out.println("\n==========");
		double averageScore = 
				Stream
					.of(scoreMap.values())
					.flatMap(e -> e.stream())
					.mapToInt(e -> e)
					.average()
					.getAsDouble();
		System.out.printf("The Average Score is : %.3f\n", averageScore);

		System.out.println("\n==========");
		System.out.println("Words higher than average:");
		scoreMap
			.entrySet()
			.stream()
			.filter(e -> (e.getValue() > averageScore))
			.forEach(System.out::println);
		
		System.out.println("\n==========");
		System.out.println("Words lower than average:");
		scoreMap
			.entrySet()
			.stream()
			.filter(e -> (e.getValue() < averageScore))
			.forEach(System.out::println);		
	}
	public static int getWordScore(String word) {
		return word
			.chars()
 			.map(e -> letterValues.get((char)e))
			.sum();
	}
	public static void generateScoreboard(){
		letterValues.put('a', 1);
		letterValues.put('b', 3);
		letterValues.put('c', 3);
		letterValues.put('d', 2);
		letterValues.put('e', 1);
		letterValues.put('f', 4);
		letterValues.put('g', 2);
		letterValues.put('h', 4);
		letterValues.put('i', 1);
		letterValues.put('j', 8);
		letterValues.put('k', 5);
		letterValues.put('l', 1);
		letterValues.put('m', 3);
		letterValues.put('n', 1);
		letterValues.put('o', 1);
		letterValues.put('p', 3);
		letterValues.put('q', 10);
		letterValues.put('r', 1);
		letterValues.put('s', 1);
		letterValues.put('t', 1);
		letterValues.put('u', 1);
		letterValues.put('v', 8);
		letterValues.put('w', 4);
		letterValues.put('x', 8);
		letterValues.put('y', 4);
		letterValues.put('z', 10);
	}
}
