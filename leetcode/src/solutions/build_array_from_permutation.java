package solutions;

public class build_array_from_permutation {
    public int[] buildArray(int[] nums) {
        int[] ret = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            ret[i] = nums[nums[i]];
        }
        
        return ret;
    }
}
