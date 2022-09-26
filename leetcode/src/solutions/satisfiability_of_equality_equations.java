package solutions;

import java.util.Arrays;

public class satisfiability_of_equality_equations {
    public boolean equationsPossible(String[] equations) {
        int[] v = new int[26];
        Arrays.fill(v, -1);
        for(String ss: equations) {
        	char[] s = ss.toCharArray();
        	boolean eq = s[1] == '=';
        	if(!eq || s[0] == s[3]) continue;
        	System.out.println("i: " + ss + " " + Arrays.toString(v));
        	int a = get(v, s[0] - 'a');
        	int b = get(v, s[3] - 'a');
        	if(a == b) continue;
        	set(v, a, b);
        }
        
        for(String ss: equations) {
        	char[] s = ss.toCharArray();
        	boolean eq = s[1] == '=';
        	if(eq) continue;
        	System.out.println(ss + " " + Arrays.toString(v));
        	
            if(s[0] == s[3]) return false;
        	int a = get(v, s[0] - 'a');
        	System.out.println("second: " + (s[3] - 'a') + " " + v[s[3] - 'a']);
        	int b = get(v, s[3] - 'a');
        	if(a == b) return false;
        }
        
    	return true;
    }
    
    public int get(int[] v, int i) {
    	if(v[i] == -1) return i;
    	return get(v, v[i]);
    }
    
    public void set(int[] v, int a, int b) {
    	if(v[a] == -1) {
            v[a] = b;
            return;
        }
    	set(v, v[a], b);
    }
    
    public static void main(String[] args) {
    	satisfiability_of_equality_equations t = new satisfiability_of_equality_equations();
    	System.out.println(t.equationsPossible(
    			new String[] {"f==b","c==b","c==b","e!=f"}));
    }
}
