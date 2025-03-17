package solutions;

public class number_of_substrings_containing_all_three_characters {
    public int numberOfSubstrings(String s) {
    	int ret = 0;
    	int[] cnt = new int[3];
    	char[] chars = s.toCharArray();
    	int left = 0, right = 0;
    	
    	while(right < s.length()) {
    		cnt[chars[right++] - 'a']++;
    		
    		while(cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
    			ret = ret + 1 + s.length() - right;
    			cnt[chars[left++] - 'a']--;
    		}
    	}
    	
    	return ret;
    }
}
