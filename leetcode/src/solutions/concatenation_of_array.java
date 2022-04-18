package solutions;

public class concatenation_of_array {
    public int[] getConcatenation(int[] nums) {
        int[] ret = new int[nums.length * 2];
        
        for(int i = 0; i < nums.length * 2; i++) {
        	ret[i] = nums[i % nums.length];
        }
        
        return ret;
    }
}
