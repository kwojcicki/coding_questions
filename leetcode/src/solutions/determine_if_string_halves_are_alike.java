package solutions;

import java.util.Set;

public class determine_if_string_halves_are_alike {
    public boolean halvesAreAlike(String s) {
    	Set<Character> v = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int l = 0, r = s.length() / 2, c = 0;
        while(r < s.length()) {
        	if(v.contains(s.charAt(l++))) c++;
        	if(v.contains(s.charAt(r++))) c--;
        }
        return c == 0;
    }
}
