package solutions;

public class apply_operations_to_an_array {
    public int[] applyOperations(int[] nums) {
        int cnt = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == 0) continue;
            cnt++;
            if(nums[i] == nums[i + 1]){
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        cnt += nums[nums.length - 1] != 0 ? 1 : 0;

        int idx = 0;
        for(int i = 0; i < nums.length; i++){
            if(cnt == 0) nums[i] = 0;
            else if(nums[i] != 0){
                nums[idx++] = nums[i];
                if(i != idx - 1) nums[i] = 0;
            }
        }

        return nums;
    }
}
