package solutions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class the_k_strongest_values_in_an_array {
    public int[] getStrongest(int[] arr, int k) {
    	Arrays.sort(arr);
    	int median = arr[((arr.length - 1) / 2)];
    	
    	List<Integer> result = Arrays.stream(arr).boxed().collect(Collectors.toList());
    			
    	result.sort((j, i) -> {
    		if(Math.abs(i - median) > Math.abs(j - median)) {
    			return 1;
    		} else if(Math.abs(i - median) == Math.abs(j - median)) {
    			return Integer.compare(i, j);
    		} else {
    			return -1;
    		}
    	}); 
    	
    	return result.subList(0, k).stream().mapToInt(i->i).toArray();
    }
}
