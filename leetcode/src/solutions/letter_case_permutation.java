package solutions;

import java.util.ArrayList;
import java.util.List;

public class letter_case_permutation {
    public List<String> letterCasePermutation(String S) {
        List<String> ret = new ArrayList<String>();
        
        recurse(ret, S.toCharArray(), 0);
        
        return ret;
    }
    
    public static void recurse(List<String> ret, char[] S, int index) {
    	
    	if(index == S.length) {
    		ret.add(new String(S));
    		return;
    	}
    	
    	if(Character.isAlphabetic(S[index])) {
    		
    		S[index] = Character.toLowerCase(S[index]);
    		recurse(ret, S, index + 1);
    		
    		S[index] = Character.toUpperCase(S[index]);
    		recurse(ret, S, index + 1);
    		
    	} else {
    		recurse(ret, S, index + 1);
    	}
    }
    
    public static void main(String[] args) {
    	System.out.println(new letter_case_permutation().letterCasePermutation("a1b2"));
    }
}
