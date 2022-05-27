package solutions;

public class number_of_steps_to_reduce_a_number_to_zero {
    public int numberOfSteps(int num) {
        int ret = 0;
        
        while(num != 0){
            if(num % 2 == 0){
                num /= 2;
            } else {
                num -= 1;
            }
            ret++;
        }
        
        return ret;
    }
}
