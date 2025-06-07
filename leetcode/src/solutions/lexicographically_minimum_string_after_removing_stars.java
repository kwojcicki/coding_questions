package solutions;

import java.util.PriorityQueue;
import java.util.Queue;

public class lexicographically_minimum_string_after_removing_stars {
    public String clearStars(String s) {
        char[] str = s.toCharArray();
        Queue<Integer> q = new PriorityQueue<>((a,b) -> 
        	str[a] == str[b] ? b - a : str[a] - str[b]);
        
        for(int i = 0; i < str.length; i++) {
        	char c = str[i];
        	if(c == '*') {
        		str[q.poll()] = '!';
        	} else {
        		q.add(i);
        	}
        }
        
        StringBuilder ret = new StringBuilder();
        for(char c: str) if(c != '!' && c != '*') ret.append(c);
        return ret.toString();
    }
}
