package solutions;

public class palindrome_number {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x == 0) return true;
        
        int check = 0;
        int tmp = x;
        
        while(tmp > 0) {
        	check = check * 10 + tmp % 10;
        	tmp /= 10;
        }
        
        return check == x;
    }
}
