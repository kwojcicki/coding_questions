package solutions;

public class take_k_of_each_character_from_left_and_right {
    public int takeCharacters(String s, int k) {
        char[] cs = s.toCharArray();
    	int ret = cs.length;
    	int[] count = new int[3];
    	
    	for(char c: cs) count[c - 'a']++;
    	
    	if(count[0] < k || count[1] < k || count[2] < k) return -1;
    	
    	int right = cs.length - 1;
    	for(int i = cs.length - 1; i >= 0; i--) {
    		if(--count[cs[i] - 'a'] < k) {
    			while(count[cs[i] - 'a'] < k) count[cs[right--] - 'a']++;
    		}
            int left = i - 1;
            int actualRight = right + 1;
            // System.out.println(left + " " + actualRight + " " + (left + cs.length - actualRight));
    		ret = Math.min(ret, left + 1 + cs.length - actualRight);
    	}
    	
    	return ret;
    }
}
