package solutions;

public class make_two_arrays_equal_by_reversing_subarrays {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] cnt = new int[1001];
        for(int i: target) cnt[i]++;
        for(int i: arr){
            if(--cnt[i] < 0) return false;
        }
        return true;
    }
}
