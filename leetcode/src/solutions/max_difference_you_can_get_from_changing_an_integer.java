package solutions;

public class max_difference_you_can_get_from_changing_an_integer {
    public int maxDiff(int num) {
int low = num, high = num;
        
        String number = Integer.toString(num);
        char[] characters = number.toCharArray();
        
        for(char c: characters) {
        	if(c != '9') {
        		high = Integer.parseInt(number.replace(c, '9'));
        		break;
        	}
        }
        
        for(int i = 0; i < characters.length; i++) {
        	char c = characters[i];
        	if(c != '0' && c != characters[0]) {
        		low = Integer.parseInt(number.replace(c, '0'));
        		break;
        	} else if(c != '0' && c != '1') {
        		low = Integer.parseInt(number.replace(c, '1'));
        		break;
        	}
        }
        
        // System.out.println(high + " " + low);
        return high - low;
    }
}
