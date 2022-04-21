package solutions;

import java.util.HashMap;
import java.util.Map;

public class design_file_system {
	class FileSystem {
		
		Map<String, Integer> map = new HashMap<>();
		public FileSystem() {

		}

		public boolean createPath(String path, int value) {
			String parent = path.substring(0, path.lastIndexOf("/"));

			if( (parent.equals("/") || map.containsKey(parent) || parent.isEmpty()) && !map.containsKey(path)) {
				map.put(path, value);
				return true;
			}

			return false;
		}

		public int get(String path) {
			return map.getOrDefault(path, -1);
		}
	}
}
