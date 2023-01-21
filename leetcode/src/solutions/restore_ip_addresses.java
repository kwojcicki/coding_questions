package solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class restore_ip_addresses {
	public List<String> restoreIpAddresses(String s) {
    	Set<String> ret = new HashSet<>();
    	char[] c = s.toCharArray();
    	StringBuilder sb = new StringBuilder();
        int t =  0;
    	for(int i = 0; i < c.length - 3 && i < 3; i++) {
            t = (t * 10) + c[i] - '0';
            if(t > 255) break;
    		sb.append(c[i]);
    		sb.append(".");
    		helper(i + 1, sb, ret, c, 2);
    		sb.deleteCharAt(sb.length() - 1);
            if(t == 0) break;
    	}
    	
    	return ret.stream().collect(Collectors.toList());
    }
    
    public void helper(int i, StringBuilder sb, Set<String> ret, char[] c, int s) {
    	if(s == 0) {
    		if(c[i] == '0' && i < c.length - 1) return;
            int t = 0;
            int j = i;
            while(j < c.length) t = (t * 10) + c[j++] - '0';
            if(t > 255 || t < 0) return;
    		ret.add(sb.toString() + new String(Arrays.copyOfRange(c, i, c.length)));
    		return;
    	}
    	
        int t =  0;
    	for(int j = i; j < c.length - s && j < i + 3; j++) {
            t = (t * 10) + c[j] - '0';
            if(t > 255 || t < 0) break;
    		sb.append(c[j]);
    		sb.append(".");
    		helper(j + 1, sb, ret, c, s - 1);
    		sb.deleteCharAt(sb.length() - 1);
            if(t == 0) break;
    	}

    	while(sb.charAt(sb.length() - 1) != '.') sb.deleteCharAt(sb.length() - 1);
    }
}
