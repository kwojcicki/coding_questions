package solutions;
class mirror_distance_of_an_integer {
    public int mirrorDistance(int n) {
        int reversed = 0;
        int tmp = n;
        while(tmp > 0){
            reversed = reversed * 10 + tmp % 10;
            tmp /= 10;
        }

        return Math.abs(n - reversed);
    }
}
