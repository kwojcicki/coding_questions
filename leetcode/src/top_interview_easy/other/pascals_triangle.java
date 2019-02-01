package top_interview_easy.other;

import java.util.ArrayList;
import java.util.List;

public class pascals_triangle {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	
    	if(numRows == 0) {
    		return list;
    	}
    	
    	List<Integer> newList = new ArrayList<Integer>();
    	newList.add(1);
    	
    	list.add(newList);
    	
    	for(int i = 1; i < numRows; i++) {
    		newList = new ArrayList<Integer>();
    		for(int j = 0; j < i + 1; j++) {
    			int sum = 0;
    			if(j - 1 >= 0) sum += list.get(i - 1).get(j - 1);
    			if(j < list.get(i - 1).size()) sum += list.get(i - 1).get(j);
    			newList.add(sum);
    		}
    		list.add(newList);
    	}
    	
    	return list;
    }
}
