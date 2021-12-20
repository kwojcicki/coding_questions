package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class minimum_absolute_difference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 1; i++){
            if(min > arr[i + 1] - arr[i]){
                min = arr[i+1] - arr[i];
            }
        }
        
        List<List<Integer>> ret = new ArrayList<>();
        
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i + 1] - arr[i] == min){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(arr[i]);
                tmp.add(arr[i+1]);
                ret.add(tmp);
            }
        }
        
        return ret;
    }
}
