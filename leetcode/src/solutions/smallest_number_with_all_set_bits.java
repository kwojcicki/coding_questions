package solutions;

public class smallest_number_with_all_set_bits {
    public int smallestNumber(int n) {
        int ret = 1;
        while(ret < n){
            ret = (ret << 1) | 1;
        }
        return ret;
    }
}
