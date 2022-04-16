package solutions;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class integer_to_roman {
    public String intToRoman(int num) {
        Map<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        
        StringBuilder ret = new StringBuilder();
        
        for(Map.Entry<Integer, String> entry: map.entrySet()) {
        	if(num / entry.getKey() > 0) {
        		for(int i = 0; i < num / entry.getKey(); i++) ret.append(entry.getValue());
        		num %= entry.getKey();
        	}
        }
        
        return ret.toString();
    }
    
    public static void main(String[] args) {
    	System.out.println(new integer_to_roman().intToRoman(3));
    	System.out.println(new integer_to_roman().intToRoman(58));
    	System.out.println(new integer_to_roman().intToRoman(1994));
    }
}
