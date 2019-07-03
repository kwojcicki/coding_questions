package solutions;

import java.util.HashSet;

public class goat_latin {
    public String toGoatLatin(String S) {
        StringBuilder sb = new StringBuilder(S.length());
        
        HashSet<Character> vowels = new HashSet<>();
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
        
        int count = 1;
        for(String s: S.split(" ")) {
        	
        	if(vowels.contains(s.charAt(0))){
        		sb.append(s);
        	} else {
        		sb.append(s.substring(1, s.length()));
        		sb.append(s.charAt(0));
        	}

    		sb.append("ma");
    		
    		for(int i = 0; i < count;i++) {
    			sb.append("a");
    		}
    		count++;
    		sb.append(" ");
        	
        }
        
        return sb.substring(0, sb.length() - 1).toString();
    }
}
