package solutions;

import java.util.Arrays;

public class permutation_in_string {
	public boolean checkInclusion(String s1, String s2) {
        char[] c = new char[26];
        for(char c1: s1.toCharArray()) c[c1 - 'a']++;
        int req = s1.length();

        int start = 0;
        for(int end = 0; end < s2.length(); end++){
            while(c[s2.charAt(end) - 'a'] <= 0 && start < end){
                req++;
                c[s2.charAt(start++) - 'a']++;
            }

            if(c[s2.charAt(end) - 'a'] > 0){
                c[s2.charAt(end) - 'a']--;
                req--;
                if(req == 0) return true;
            } else {
                start = end + 1;
            }
        }

        return false;
    }
	
    public boolean checkInclusion1(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        
        for(char c: s1.toCharArray())
        	c1[c - 'a']++;
        
        for(int i = 0; i < s1.length() - 1; i++) {
        	c2[s2.charAt(i) - 'a']++;
        }
        
        for(int i = s1.length() - 1; i < s2.length(); i++) {
        	c2[s2.charAt(i) - 'a']++;
        	if(Arrays.equals(c1, c2)) return true;
        	c2[s2.charAt(i - s1.length() + 1) - 'a']--;
        }
        
        return false;
    }
}
