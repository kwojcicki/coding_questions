package solutions;

public class final_value_of_variable_after_performing_operations {
    public int finalValueAfterOperations(String[] operations) {
        int ret = 0;
        for(String oper: operations){
            if(oper.charAt(0) == '-' || oper.charAt(oper.length() - 1) == '-') ret--;
            else ret++;
        }
        return ret;
    }
}
