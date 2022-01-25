package solutions;

public class valid_mountain_array {
    public boolean validMountainArray(int[] arr) {
        
        if(arr.length < 3) return false;
        
        int i = 1;
        while(i <= arr.length - 1 && arr[i] > arr[i - 1]){
            i++;
        }
        
        if(i > arr.length - 1 || i == 1) return false;
        // System.out.println(i);
        while(i <= arr.length - 1 && arr[i] < arr[i - 1]){
            i++;
        }
        // System.out.println(i);
        return i > arr.length - 1;
    }
}
