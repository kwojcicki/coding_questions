package solutions;

import java.util.Arrays;

public class can_make_arithmetic_progression_from_sequence {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for(int i = 2; i < arr.length; i++){
            if(arr[i] - arr[i - 1] != diff) return false;
        }
        return true;
    }
}
