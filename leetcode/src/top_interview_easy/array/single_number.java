package top_interview_easy.array;

public class single_number {
	
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
    		result ^= nums[i];
        }
    	return result;
    }
    
}
