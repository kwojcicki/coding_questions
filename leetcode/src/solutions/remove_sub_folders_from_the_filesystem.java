package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class remove_sub_folders_from_the_filesystem {
	
	class TrieNode {
		private Map<String, TrieNode> children = new HashMap<>();
		private boolean terminal = false;
		
		public boolean addChild(String[] folders, int index) {
			if(folders.length == index) {
				this.terminal = true;
				return true;
			}
			
			String path = folders[index];
			TrieNode next = children.get(path);
			if(next != null) {
				if(next.terminal) {
					return false;
				}
			} else {
				next = new TrieNode();
				children.put(path, next);
			}
			
			return next.addChild(folders, index + 1);
		}
		
	}
	
    public List<String> removeSubfolders(String[] folder) {
        List<String> ret = new ArrayList<>();
        Arrays.sort(folder, (a,b) -> a.length() - b.length());
        
        TrieNode root = new TrieNode();
        for(String f: folder) {
        	if(root.addChild(f.split("/"), 0)) {
        		ret.add(f);
        	}
        }
        
        return ret;
    }
}
