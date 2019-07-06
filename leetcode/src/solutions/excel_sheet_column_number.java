package solutions;

public class excel_sheet_column_number {
    public int titleToNumber(String s) {
    	int ret = 0;
    	
    	for(int i = s.length() - 1; i >= 0; i--) {
    		ret += (int)Math.pow(26, (s.length() - 1) - i) * (s.charAt(i) - 'A' + 1);
    	}
    	
    	return ret;
    }
}
