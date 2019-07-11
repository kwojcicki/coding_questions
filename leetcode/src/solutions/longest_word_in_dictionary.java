package solutions;

import java.util.HashSet;
import java.util.Set;

public class longest_word_in_dictionary {
	public String longestWord(String[] words) {
		Set<String> wordSet = new HashSet<String>();
		for(String w: words) wordSet.add(w);

		String longest = "";

		for(int i = 0; i < words.length; i++) {

			String current = words[i];
			while(current.length() > 0) {
				if(wordSet.contains(current)) {
					current = current.substring(0, current.length() - 1);
				} else {
					break;
				}
			}

			if(current.length() == 0) {
				if(words[i].length() > longest.length() || (longest.length() == words[i].length() && longest.compareTo(words[i]) > 0)) {
					longest = words[i];
				}
			}

		}

		return longest;
	}
}