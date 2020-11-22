package solutions;

import java.util.HashSet;
import java.util.Set;

public class longest_substring_with_at_most_two_distinct_characters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int start = 0;
        int end = 1;
        int max = 1;
        int curr = 1;
        Set<Character> set =  new HashSet<>();
        set.add(s.charAt(0));
        
        while(end < s.length()){
            set.add(s.charAt(end));
            if(set.size() > 2){
                
                
                set.clear();
                end--;
                set.add(s.charAt(end));
                
                curr = 1;
                start = end;
                while(start - 1 >= 0 && s.charAt(start - 1) == s.charAt(end)){
                    start--;
                    curr++;
                }
                
                end++;
                
            } else {
                end++;
                curr++;
                
                max = Math.max(max, curr);
            }
        }
        
        return max;
    }
}
