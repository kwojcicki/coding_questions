package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class repeated_dna_sequences {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> ret = new ArrayList<>();
		if(s == null || s.length() < 10) return ret;

		Map<String, Integer> seen = new HashMap<String, Integer>();
		StringBuilder curr = new StringBuilder(s.substring(0, 10));	
			seen.put(curr.toString(), seen.getOrDefault(curr.toString(), 0) + 1);

		for(int i = 10; i < s.length(); i++) {
			char c = s.charAt(i);
			curr.append(c);
			curr.deleteCharAt(0);
			
			//if(!seen.containsKey(curr.toString()))
				//seen.put(curr.toString(), seen.get);
			//}
			seen.put(curr.toString(), seen.getOrDefault(curr.toString(), 0) + 1);
		}

		return seen.entrySet().stream().filter(i -> i.getValue() > 1).map(i -> i.getKey()).collect(Collectors.toList());
	}
}
