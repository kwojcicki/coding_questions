package solutions;

public class add_digits {
	
    public int addDigits(int num) {
        if(num < 10) return num;
        if(num % 9 == 0) return 9;
    	return num % 9;
    }
	
    public int addDigits1(int num) {
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
