package solutions;

import java.util.Arrays;

public class rotating_the_box {
    public char[][] rotateTheBox(char[][] box) {
char[][] ret = new char[box[0].length][box.length];
        
        for(int i = 0; i < box.length; i++) {
        	int spot = box[i].length - 1;
        	for(int j = box[i].length - 1; j >= 0; j--) {
                // System.out.println(i + " " + j);
                // System.out.println(spot + " " + (box.length - i - 1));
                // System.out.println("---");
        		ret[j][box.length - i - 1] = '.';
        		if(box[i][j] == '#') {
        			ret[spot][box.length - i - 1] = '#';
        			spot = spot - 1;
        		} else if(box[i][j] == '*') {
        			spot = j - 1;
        			ret[j][box.length - i - 1] = '*';
        		}
        	}
        }
        
        // for(char[] c: ret) {
        // 	System.out.println(Arrays.toString(c));
        // }
        
        return ret;
    }
}
