package solutions;

public class count_operations_to_obtain_zero {
    public int countOperations(int num1, int num2) {
        int ret = 0;
        while(num1 > 0 && num2 > 0){
            if(num1 > num2){ 
                num1 -= num2;
            } else {
                num2 -= num1;
            }
            ret++;
        }
        return ret;
    }
}
