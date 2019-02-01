package top_interview_easy.other;

public class missing_number {
    public int missingNumber(int[] nums) {
        int toGet = 0;
        for(int i = 0; i < nums.length + 1; i++) {
        	toGet += i;
        }
        
        for(int num: nums) {
        	toGet -= num;
        }
        
        return toGet;
    }
}
