package solutions;

public class the_two_sneaky_numbers_of_digitville {
    public int[] getSneakyNumbers(int[] nums) {
        int[] ret = new int[]{ 0, 0 };
        int idx = 0;

        for(int i: nums){
            int realIndex = i < 0 ? i + 1000 : i;
            int otherNumber = nums[realIndex];
            if(otherNumber < 0){
                ret[idx] = realIndex;
                idx++;
                if(idx == 2) return ret;
            } else {
                nums[realIndex] -= 1000;
            }
        }

        return ret;
    }
}
