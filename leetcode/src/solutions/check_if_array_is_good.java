package solutions;
class check_if_array_is_good {
    public boolean isGood(int[] nums) {
        boolean ret = false;
        for(int i: nums){
            int j = Math.abs(i) - 1;
            if(j < 0 || j >= nums.length) return false;
            if((nums[j] < 0 || ret) && j == nums.length - 2){
                if(ret) return false;
                ret = true;
            } else if(nums[j] < 0) return false;
            nums[j] = -nums[j];
            // System.out.println(Arrays.toString(nums) + " " + ret);
        }
        return ret;
    }
}
