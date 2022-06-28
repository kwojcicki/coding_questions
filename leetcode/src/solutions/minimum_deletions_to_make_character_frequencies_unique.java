package solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class minimum_deletions_to_make_character_frequencies_unique {
	public int minDeletions(String s) {
		Set<Integer> set = new HashSet<>();
		int ret = 0;
		int[] count = new int[26];

		for(char c: s.toCharArray()) {
			count[c - 'a']++;
		}

		for(int value: count) {
			ret += value;
			for(int i = value; i >= 0; i--) {
				if(set.add(i)) {
					ret -= i;
					break;
				}
			}
		}

		return ret;
	}

	public int minDeletions1(String s) {
		Set<Integer> set = new HashSet<>();

		return s.chars().
				boxed().
				collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).
				values().
				stream().
				mapToInt(v -> v.intValue()).
				map(v -> v - IntStream.range(0, v).
						map(i -> v - i).
						filter(i -> set.add(i)).
						findFirst().
						orElse(0)).
				reduce((a, b) -> a + b).getAsInt();
	}
}
