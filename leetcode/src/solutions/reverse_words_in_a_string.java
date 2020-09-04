package solutions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class reverse_words_in_a_string {
    public static String reverseWords(String s) {
    	Stack<Character> l = new Stack<>(); 
    	StringBuilder ret = new StringBuilder();
    	s = s.trim();
    	
    	for(int i = s.length() - 1; i >= 0; i--) {
    		if(s.charAt(i) == ' ' && !l.isEmpty()) {
    			while(!l.isEmpty()) ret.append(l.pop());
    			ret.append(" ");
    		} else if(s.charAt(i) != ' ') {
    			l.push(s.charAt(i));
    		}
    	}
    	
    	while(!l.isEmpty()) ret.append(l.pop());
    	return ret.toString();
    }
    
    public static String reverseWords1(String s) {
    	s = s.trim();
    	
    	List<String> words = Arrays.asList(s.split("\\s+"));
    	Collections.reverse(words);
    	
    	return String.join(" ", words);
    }
    
    public static void main(String[] args) {
    	System.out.println(reverseWords("the sky is blue"));
    	System.out.println(reverseWords1("the sky is blue"));
    }
}
