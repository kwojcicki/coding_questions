package solutions;

public class check_if_all_1s_are_at_least_length_k_places_away {
    public boolean kLengthApart(int[] nums, int k) {
        int prev = -k - 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                if(i - prev <= k) return false;
                prev = i;
            }
        }

        return true;
    }
}
