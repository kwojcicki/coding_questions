package solutions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class largest_number {
	public String largestNumber(int[] nums) {
		List<Integer> ret = Arrays.stream(nums).boxed().collect(Collectors.toList());
		ret.sort((a, b) -> {
			char[] as = Integer.toString(a).toCharArray();
			char[] bs = Integer.toString(b).toCharArray();
			
			int length = Math.min(as.length, bs.length);
			
			for(int i = 0; i < length; i++) {
				if(as[i] > bs[i]) {
					return -1;
				} else if(as[i] < bs[i]) {
					return 1;
				}
			}
			
			if(as.length > bs.length) {
				int min = Integer.MIN_VALUE;
				for(int i = 0; i < length; i++) {
					min = Math.max(min, as[i]);
				}
				
				for(int i = length; i < as.length; i++) {
					if(as[i] < min) {
						return 1;
					} else if(as[i] > min) {
						return -1; 
					}
				}
				
				return -1;
			} else if(as.length < bs.length) {
				int min = Integer.MIN_VALUE;
				for(int i = 0; i < length; i++) {
					min = Math.max(min, bs[i]);
				}
				
				for(int i = length; i < bs.length; i++) {
					if(bs[i] < min) {
						return -1;
					} else if(bs[i] > min) {
						return 1;
					}
				}
				
				return 1;
			}
			
			return 0;
		});
		
		System.out.println(ret);
		
		StringBuilder r = new StringBuilder();
		for(int i = 0; i < ret.size();i++) {
			r.append(Integer.toString(ret.get(i)));
		}
		
		while(r.charAt(0) == '0' && r.length() > 1) {
			r = r.deleteCharAt(0);
		}
		
		return r.toString();
	}
}
