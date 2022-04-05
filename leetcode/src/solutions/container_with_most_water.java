package solutions;

public class container_with_most_water {
	
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        while(start < end) {
        	max = Math.max(Math.min(height[start], height[end]) * (end - start), max);
        	if(height[start] > height[end]) {
        		end--;
        	} else {
        		start++;
        	}
        }
        
        return max;
    }
	
	public int maxArea1(int[] height) {
		int start = 0;
		int end = height.length - 1;
		int max = 0;
		while(start < end) {
			max = Math.max(max, Math.min(height[start], height[end]) * (end - start));

			if(height[end] > height[start]) {
				start++;
			} else {
				end--;
			}
		}

		return max;
	}
}
