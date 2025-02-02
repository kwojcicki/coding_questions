package solutions;

public class check_if_array_is_sorted_and_rotated {
    public boolean check(int[] nums) {
        int smallest = nums[0];
        boolean rotated = false;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i - 1]){
                if(rotated) return false;
                if(nums[i] > smallest) return false;
                rotated = true;
            } else if(rotated && nums[i] > smallest) return false;
        }
        return true;
    }
}
