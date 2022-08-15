package solutions;

import java.util.HashMap;
import java.util.Map;

public class roman_to_integer {
    public int romanToInt(String s) {
        int ret = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int prev = 1;
        for(int i = s.length() - 1; i >= 0; i--) {
        	int val = map.get(s.charAt(i));
        	ret += (val >= prev ? val : - val);
        	prev = val;
        }
        return ret;
    }
}
