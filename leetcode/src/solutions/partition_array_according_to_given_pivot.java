package solutions;

class partition_array_according_to_given_pivot {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ret = new int[nums.length];
        int ptr = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < pivot) ret[ptr++] = nums[i];
        }

        ptr = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] > pivot) ret[ptr--] = nums[i];
        }

        while(ptr >= 0 && ret[ptr] == 0) ret[ptr--] = pivot;

        return ret;
    }
}
