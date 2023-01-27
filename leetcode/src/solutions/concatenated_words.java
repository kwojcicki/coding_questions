package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class concatenated_words {
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		List<String> ret = new ArrayList<>();

		Set<String> canBe = new HashSet<>();
		Set<String> cant = new HashSet<>();

		for(String w1: words) canBe.add(w1);
		
		for(String w1: words) {
			int i = 1;
			while(i < w1.length()) {
                if(canBe.contains(w1.substring(0,i)) && helper(w1.substring(i, w1.length()), ret, canBe, cant)){
                    ret.add(w1); break;
                }
                i++;
            }
		}
		return ret;
	}

	public static boolean helper(String curr, List<String> ret, Set<String> canBe, Set<String> cant) {
        if(canBe.contains(curr)) return true;
        if(cant.contains(curr)) return false;
        // System.out.println("trying: " + curr);
		for(int i = 0; i < curr.length(); i++) {
			String w2 = curr.substring(0, i);
			if(canBe.contains(w2)) {
				String w3 = curr.substring(i, curr.length());
				if(helper(w3, ret, canBe, cant)) {
					canBe.add(w3);
					return true;
				} else {
					cant.add(w3);
				}
			}
		}
		return false;
	}
}
