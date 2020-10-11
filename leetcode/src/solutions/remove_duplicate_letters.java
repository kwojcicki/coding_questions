package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class remove_duplicate_letters {
	public String removeDuplicateLetters(String s) {
		StringBuilder ret = new StringBuilder();

		Map<Character, Integer> map = new HashMap<>();
		Set<Character> seen = new HashSet<>();
		Stack<Character> stack = new Stack<>();

		for(int i = 0; i < s.length(); i++) map.put(s.charAt(i), i);

		for(int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);

			if(seen.contains(c)) continue;

			seen.add(c);

			while(!stack.isEmpty()) {
				if(c < stack.peek() && map.get(stack.peek()) > i) {
					seen.remove(stack.pop());
				} else {
					break;
				}
			}

			stack.add(c);

		}

		while(!stack.isEmpty()) ret.append(stack.pop());

		return ret.reverse().toString();
	}
}
