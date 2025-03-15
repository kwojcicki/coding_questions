package solutions;

public class house_robber_iv {
    public int minCapability(int[] nums, int k) {
        int left = 1, right = 1_000_000_001;
        int ret = 0;
        while(left < right) {
        	int mid = (left + right) / 2;
        	int tmp = 0;
        	for(int i = 0; i < nums.length; i++) {
        		if(nums[i] <= mid) { tmp++; i++; }
        	}
        	// System.out.println(left + " " + right + " " + tmp);
        	if(tmp >= k) {
        		ret = mid;
        		right = mid;
        	} else {
        		left = mid + 1;
        	}
        }
        
        return ret;
    }
}
