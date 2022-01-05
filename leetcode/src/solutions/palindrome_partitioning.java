package solutions;

import java.util.ArrayList;
import java.util.List;

public class palindrome_partitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> ret = new ArrayList<>();

		helper(s, ret, new ArrayList<>(), "", 0);

		return ret;
	}

	public boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while(start < end) {
			if(s.charAt(start) != s.charAt(end)) return false;
			start++; end--;
		}
		
		return true;
	}
	
	public void helper(
			String s, 
			List<List<String>> ret, 
			List<String> c, 
			String curr, 
			int index) {
		
		if(index == s.length()) {
            if(curr.equals("")){
			    ret.add(new ArrayList<>(c));
            }
			return;
		}
		
		if(isPalindrome(curr + s.charAt(index))) {
			c.add(curr + s.charAt(index));
			helper(s, ret, c, "", index + 1);
			c.remove(c.size() - 1);
			helper(s, ret, c, curr + s.charAt(index), index + 1);
		} else {
			helper(s, ret, c, curr + s.charAt(index), index + 1);
		}
	}
}
