package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class find_duplicate_file_in_system {

    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ret = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for(String ss: paths) {
        	String[] s = ss.split(" ");
        	String root = s[0];
        	
        	for(int i = 1; i < s.length; i++) {
        		String fileName = s[i].substring(0, s[i].lastIndexOf('('));
        		String content = s[i].substring(s[i].lastIndexOf('('), s[i].length());
        		map.putIfAbsent(content, new ArrayList<>());
        		map.get(content).add(root + "/" + fileName);
        	}
        }
        
        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
        	if(entry.getValue().size() <= 1) continue;
        	ret.add(entry.getValue());
        }
        
        
        return ret;
    }
}
