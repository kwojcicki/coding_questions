package solutions;

public class sign_of_the_product_of_an_array {
	public int arraySign(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		boolean ret = true;
		for(int i: nums){
			if(i == 0) return 0;
			if(i < 0) ret = !ret;
		}
		return ret ? 1 : -1;
	}
}
