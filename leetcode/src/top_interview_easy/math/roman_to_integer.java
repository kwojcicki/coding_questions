package top_interview_easy.math;

import java.util.HashMap;
import java.util.Map;

public class roman_to_integer {
	
    public int romanToInt(String s) {
        
    	Map<Character, Integer> map = new HashMap<>();
    	map.put('I', 1);
    	map.put('V', 5);
    	map.put('X', 10);
    	map.put('L', 50);
    	map.put('C', 100);
    	map.put('D', 500);
    	map.put('M', 1000);
    	
    	int count = 0;
    	for(int i = 0; i < s.length(); i++) {
    		if(i + 1 < s.length()) {
    			
    			if(map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
    				count += map.get(s.charAt(i));
    			} else {
    				count -= map.get(s.charAt(i));
    			}
    			
    		} else {
    			count += map.get(s.charAt(i));
    		}
    		
    		System.out.println(count);
    	}
    	
    	return count;
    	
    }
    
    public static void main(String[] args) {
    	roman_to_integer s = new roman_to_integer();
    	
    	System.out.println(s.romanToInt("LVIII"));
    }
}
