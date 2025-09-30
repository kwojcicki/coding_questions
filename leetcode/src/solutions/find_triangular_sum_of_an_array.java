package solutions;

public class find_triangular_sum_of_an_array {
  public int triangularSum(int[] nums) {
      
      for(int i = 0; i < nums.length; i++){
          for(int j = 0; j < nums.length - 1 - i; j++){
              nums[j] = (nums[j] + nums[j + 1]) % 10;
          }
      }

      return nums[0];
  }
}
