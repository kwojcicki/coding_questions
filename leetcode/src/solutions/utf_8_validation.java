package solutions;

public class utf_8_validation {
	public boolean validUtf8(int[] data) {

		if(data == null || data.length == 0) return true;

		int count = 0;
		for(int i = 0; i < data.length; i++) {
			if(count == 0) {
				if(data[i] <= 127) continue;

				for(int b = 7; b >= 1; b--) {
					if((data[i] & 1 << b) == 1 << b) count++;
					else break;
				}

				if((data[i] & 1) != 0 && (data[i] & 1 << 7 - count) != 0) return false;
				if(count > 4 || count <= 1) return false;
			} else if((data[i] & 1 << 7) != 1 << 7 || 
					(data[i] & 1 << 6) != 0){
				return false;
			}
			count--;
		}

		return count == 0;  
	}

	public static void main(String[] args) {
		utf_8_validation test = new utf_8_validation();
		// System.out.println(test.validUtf8(new int[] {197,130,1}));
		// System.out.println(test.validUtf8(new int[] {235,140,4}));
		// System.out.println(test.validUtf8(new int[] {248,130,130,130}));
		System.out.println(test.validUtf8(new int[] {228,189,160,229,165,189,13,10}));
	}
}
