package solutions;

public class search_in_rotated_sorted_array_ii {
	   public boolean search(int[] nums, int target) {
           int start = 0, end = nums.length - 1;

while(start <= end) {

// to avoid duplicates
 while (start < end && nums[start] == nums[start + 1])
   ++start;
 while (start < end && nums[end] == nums[end - 1])
   --end;

int mid = start + (end - start) / 2;
//System.out.println("start: " + start + " mid: " + mid + " end: " + end);
if(nums[mid] == target) {
	return true;
} else if(nums[mid] >= nums[start]){
   
   if(target > nums[mid] || target < nums[start]) start = mid + 1;
   else end = mid - 1;
   
} else {
   
   if(target >= nums[start] || target < nums[mid]) end = mid - 1;
   else start = mid + 1;
   
}

}

return false;
}
}
