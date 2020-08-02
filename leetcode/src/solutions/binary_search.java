package solutions;

public class binary_search {

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        
        while(start < end) {
        	int mid = (start + end) / 2;
        	System.out.println(start + " " + mid + " " + end);
        	if(nums[mid] == target) {
        		return mid;
        	}
        	
        	if(nums[mid] < target) {
        		start = mid + 1;
        	} else {
        		end = mid;
        	}
        }
        	
        	
        return -1;
    }
	
	public static void main(String[] args) {
		System.out.println(search(new int[] {-1,0,3,5,9,12}, 9));
		System.out.println(search(new int[] {-1,0,3,5,9,12}, 2));
	}

}
