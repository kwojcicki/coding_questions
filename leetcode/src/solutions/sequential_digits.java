package solutions;

import java.util.ArrayList;
import java.util.List;

public class sequential_digits {


	public static List<Integer> sequentialDigits(int low, int high) {
		List<Integer> ret = new ArrayList<>();

		int starting = 0;
		int length = 1;
		int tmp = low;

		while(tmp >= 10) {
			length++;
			tmp /= 10;
		}

		starting = tmp;
		// System.out.println(starting + " " + length);
		while(true) {
			tmp = 0;

			if(length + starting <= 10){
				// System.out.println("------");
				for(int i = 0; i < length; i++) {
					tmp = tmp * 10 + (starting + i);
					// System.out.println(tmp);
				}

				if(tmp >= low && tmp <= high) {
					ret.add(tmp);
				} else if(tmp > high) {
					break;
				}
			} else if(length == 10){
				break;
			}

			starting++;
			if(starting == 10) {
				length++;
				starting = 1;
			}
		}

		return ret;
	}

	public static List<Integer> sequentialDigits1(int low, int high) {

		List<Integer> ret = new ArrayList<>();
		int length = 0;
		int firstDigit = 0;

		int tmpLow = low;
		while(tmpLow > 0) {
			length++;
			firstDigit = tmpLow % 10;
			tmpLow /= 10;
		}

		if(firstDigit > 9 || (firstDigit + length) > 10) { 
			firstDigit = 1;
			length++;
		}

		int curr = generate(firstDigit, length);

		while(curr < low) {
			firstDigit++;
			if(firstDigit > 9 || (firstDigit + length) > 10) { 
				firstDigit = 1;
				length++;
			}
			curr = generate(firstDigit, length);
		}

		while(curr <= high) {
			ret.add(curr);
			firstDigit++;
			if(firstDigit > 9 || (firstDigit + length) > 10) { 
				firstDigit = 1;
				length++;
			}
			curr = generate(firstDigit, length);
		}

		return ret;
	}

	public static int generate(int first, int length) {
		int ret = 0;
		while(length > 0) {
			ret = ret * 10 + first;
			first++;
			length--;
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(sequentialDigits(100, 300));
		System.out.println(sequentialDigits(1000, 13000));
	}
}
