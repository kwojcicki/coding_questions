package solutions;

public class make_array_elements_equal_to_zero {
    public int countValidSelections(int[] nums) {
        int sum = 0;
        for(int i: nums) sum += i;

        int curr = 0;
        int ret = 0;
        for(int i: nums){
            curr += i;
            sum -= i;
            if(i != 0) continue;
            if(curr == sum) ret += 2;
            else if(curr + 1 == sum) ret += 1;
            else if(sum + 1 == curr) ret += 1;
        }


        return ret;
    }
}
