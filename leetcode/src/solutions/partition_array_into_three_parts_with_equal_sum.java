package solutions;

public class partition_array_into_three_parts_with_equal_sum {
    public boolean canThreePartsEqualSum(int[] A) {
        
    	int average = 0;
    	for(int i: A) average += i;
    	average /= 3;
    	
    	int parts = 0;
    	int currentSum = 0;
    	for(int i = 0; i < A.length; i++) {
    		currentSum += A[i];
    		if(currentSum == average) {
    			parts++;
    			currentSum = 0;
    		}
    		
    	}
    	
    	return parts == 3;
    }
    
    public static void main(String[] args) {
    	new partition_array_into_three_parts_with_equal_sum().canThreePartsEqualSum(new int[] {0,2,1,-6,6,-7,9,1,2,0,1});
    }
}
