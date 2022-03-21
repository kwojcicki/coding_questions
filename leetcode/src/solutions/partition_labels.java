package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class partition_labels {
	

    public static List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
    	List<Integer> ret = new ArrayList<>();
    	
    	for(int i = 0; i < s.length(); i++) {
    		last[s.charAt(i) - 'a'] = i;
    	}
    	
    	int i = 0;
		int l = -1;
    	while(i < s.length()) {
    		int max = last[s.charAt(i) - 'a'];
    		while(i != max) {
    			max = Math.max(last[s.charAt(i) - 'a'], max);
    			i++;
    		}
    		
    		ret.add(i - l);
    		l = i;
            i++;
    	}
    	
    	return ret;
    }
	
    public static List<Integer> partitionLabels1(String S) {
        Map<Character, Integer[]> map = new HashMap<>();
        List<Integer> ret = new ArrayList<>();
        
        for(int i = 0; i < 26; i++) {
        	map.put((char) ('a' + i), new Integer[] { -1, -1});
        }
        
        for(int i = 0; i < S.length(); i++) {
        	if(map.get(S.charAt(i))[0] == -1) {
        		map.get(S.charAt(i))[0] = i;
        	}
    		map.get(S.charAt(i))[1] = i;
        }
        
        int curr = 0;
        int sum = 0;        
        
        for(int i = 0; i < S.length(); i++) {
        	System.out.println(S.charAt(i) + " " + map.get(S.charAt(i))[1] + " " + curr);
        	sum++;
        	
        	if(map.get(S.charAt(i))[0] == map.get(S.charAt(i))[1] && i > curr) {
            	ret.add(1);
            	sum = 0;
            	System.out.println("2");
            } else if(map.get(S.charAt(i))[1] != curr || i != curr) {
        		curr = Math.max(map.get(S.charAt(i))[1], curr);
        		System.out.println("1");
        	} else {
        		ret.add(sum);
        		sum = 0;
        	}
        }
        
        return ret;
    }
    
    public static void main(String[] args) {
    	System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    	System.out.println(partitionLabels("eaaaabaaec"));
    	
    }
}
