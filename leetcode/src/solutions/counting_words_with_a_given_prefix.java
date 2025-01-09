package solutions;

import java.util.Arrays;

public class counting_words_with_a_given_prefix {
    public int prefixCount(String[] words, String pref) {
        return Arrays.stream(words)
        		.mapToInt(w -> w.startsWith(pref) ? 1 : 0)
        		.sum();
    }
}
