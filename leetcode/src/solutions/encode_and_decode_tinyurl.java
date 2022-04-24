package solutions;

import java.util.HashMap;
import java.util.Map;

public class encode_and_decode_tinyurl {
	public class Codec {
		Map<String, String> map = new HashMap<>();
		
	    // Encodes a URL to a shortened URL.
	    public String encode(String longUrl) {
	    	String hash = Integer.toString(longUrl.hashCode(), 64);
	        map.put(hash, longUrl);
	        
	        return hash;
	    }

	    // Decodes a shortened URL to its original URL.
	    public String decode(String shortUrl) {
	        return map.get(shortUrl);
	    }
	}

}
