package solutions;

public class find_lucky_integer_in_an_array {
    public int findLucky(int[] arr) {
        // 1 <= arr[i] <= 500
        int[] cnt = new int[501];
        
        for(int i: arr) {
        	cnt[i]++;
        }
        
        for(int i = cnt.length - 1; i > 0; i--) {
        	if(cnt[i] == i) return i;
        }
        
        return -1;
    }
}
