package solutions;

public class minimum_element_after_replacement_with_digit_sum {
    public int minElement(int[] nums) {
        int ret = 999999;

        for(int i: nums){
            int curr = 0;
            while(i > 0){
                curr += i % 10;
                i /= 10;
            }
            ret = Math.min(ret, curr);
        }

        return ret;
    }
}
