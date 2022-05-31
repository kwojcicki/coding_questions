package solutions;

import java.util.HashSet;
import java.util.Set;

public class check_if_a_string_contains_all_binary_codes_of_size_k {

    public boolean hasAllCodes(String s, int k) {
        if(s.length() < k) return false;
        
        
        Set<Integer> set = new HashSet<>();
        char[] c = s.toCharArray();
        int hash = 0;
        
        for(int i = 0; i < k - 1; i++) {
        	hash = (hash << 1) | (c[i] - '0');
        }
        
        for(int i = k - 1; i < s.length(); i++) {
        	hash = hash & ~(1 << (k - 1));
        	hash = (hash << 1) | (c[i] - '0');
        	set.add(hash);
        }
        
        return set.size() == Math.pow(2, k);
    }
}
