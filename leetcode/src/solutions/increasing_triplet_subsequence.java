package solutions;

public class increasing_triplet_subsequence {
	public boolean increasingTriplet(int[] nums) {
		if(nums.length < 3) return false;
		
		int a1 = Integer.MAX_VALUE, a2 = Integer.MAX_VALUE;
		for(int i: nums) {
			if(i <= a1) a1 = i;
			else if(i <= a2) a2 = i;
			else return true;
		}
		
		
		return false;
	}
	
	public boolean increasingTriplet1(int[] nums) {

		if(nums.length < 3) return false;

		Integer minA1 = null, minA2 = null, minB = null;

		for(int i: nums) {
			// System.out.println(i + " " + minA1 + " " + minA2 + " " + minB);
			if(minA1 == null) {
				minA1 = i; continue;
			} else if(minA2 == null && i > minA1) {
				minA2 = i; continue;
			} else if(minA2 == null && i < minA1){
				minA1 = i; continue;
			}

			if(minA2 != null && i > minA2) return true;
			else if(minB == null) {
				if(minA2 != null && minA2 > i && minA1 < i) minA2 = i;
				else if(i != minA1 && minA2 != null && minA2 > i) minB = i; 
				continue;
			} else if(minA2 == null && i == minA1) continue;
			else if(i < minA2 && minB != null) {
				minA1 = minB;
				minA2 = i;
				minB = null;
				continue;
			} else if(minB != null && i < minB) {
				minB = i;
				continue;
			}

		}

		return false;
	}
}
