package solutions;

public class maximum_number_of_vowels_in_a_substring_of_given_length {
    public int maxVowels(String s, int k) {
        int ret = 0;
        char[] c = s.toCharArray();
        int curr = 0;
        
        for(int i = 0; i < k; i++) {
        	if(c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u') {
        		curr++;
        	}
        }
        
        ret = Math.max(ret, curr);
        
        for(int i = k; i < c.length; i++) {
        	if(c[i - k] == 'a' || c[i - k] == 'e' || c[i - k] == 'i' || c[i - k] == 'o' || c[i - k] == 'u') {
        		curr--;
        	}
        	if(c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u') {
        		curr++;
        	}
            ret = Math.max(ret, curr);
        }
        
        return ret;
    }
}
