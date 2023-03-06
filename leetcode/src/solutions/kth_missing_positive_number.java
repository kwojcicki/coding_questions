package solutions;

public class kth_missing_positive_number {
    public int findKthPositive(int[] arr, int k) {
        int i = 1;
        int index = 0;
        while(k > 0){
            if(index < arr.length && arr[index] == i){
                index++;
            } else {
                k--;
            }
            i++;
        }

        return i - 1;
    }
}
