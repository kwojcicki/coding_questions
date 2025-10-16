package solutions;

public class smallest_missing_non_negative_integer_after_operations {
    public int findSmallestInteger(int[] nums, int value) {
        int[] mod = new int[value];
        for(int i: nums){
            mod[Math.floorMod(i, value)]++;
        }

        int minIdx = 0;
        for(int i = 0; i < mod.length; i++){
            if(mod[i] < mod[minIdx]){
                minIdx = i;
            }
        }

        // System.out.println(Arrays.toString(mod));
        return value * mod[minIdx] + minIdx;
    }
}
