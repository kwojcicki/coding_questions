package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class palindrome_partitioning {
	
	public List<List<String>> partition(String s) {
		boolean[][] dp = new boolean[s.length()][s.length()];
		
        for(int i = 0; i < s.length(); i++){
            Arrays.fill(dp[i], true);
        }
        
        for(int col = 0; col < s.length(); col++){
            for(int row = 0; row < col; row++){
                dp[row][col] = dp[row + 1][col - 1] && s.charAt(row) == s.charAt(col);
            }
            dp[col][col] = true;
        }
		
		List<List<String>> ret = new ArrayList<>();
		recurse(0, 0, dp, s, ret, new ArrayList<>());
		
		return ret;
	}
	
	public void recurse(int row, int col, boolean[][] dp, String s, List<List<String>> ret, List<String> curr) {
		if(row == dp.length && col == dp.length) {
			ret.add(new ArrayList<>(curr));
			return;
		}
		
		for(int i = col; i < dp.length; i++) {
			if(dp[row][i]) {
				curr.add(s.substring(row, i + 1));
				recurse(i + 1, i + 1, dp, s, ret, curr);
				curr.remove(curr.size() - 1);
			}
		}
	}
	
	public List<List<String>> partition1(String s) {
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
