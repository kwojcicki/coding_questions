package solutions;

public class add_digits {
    public int addDigits(int num) {
        while(num >= 10) {
    		int tmp = 0;
    		while(num >= 10) {
    			tmp += num % 10;
    			num /= 10;
    		}
                    
    		num = tmp + num;
    	}
    	return num;
    }
}
