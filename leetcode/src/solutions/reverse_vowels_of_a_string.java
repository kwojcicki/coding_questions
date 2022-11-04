package solutions;

import java.util.HashSet;
import java.util.Set;

public class reverse_vowels_of_a_string {
    public String reverseVowels(String s) {
    	char[] c = s.toCharArray();
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        
        int left = 0, right = c.length - 1;
        
        while(left < right) {
        	if(!vowels.contains(c[left])) {
        		left++;
        	} else if(!vowels.contains(c[right])) {
        		right--;
        	} else {
        		char tmp = c[left];
        		c[left++] = c[right];
        		c[right--] = tmp;
        	}
        }
        
        return new String(c);
    }
}
