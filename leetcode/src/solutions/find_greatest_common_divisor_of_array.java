package solutions;

class find_greatest_common_divisor_of_array {
    public int findGCD(int[] nums) {
        int min = nums[0], max = nums[0];

        for(int i: nums){
            min = Math.min(i, min);
            max = Math.max(i, max);
        }

        return gcd(max, min);
    }

    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
