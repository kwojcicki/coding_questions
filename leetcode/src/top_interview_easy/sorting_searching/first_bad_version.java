package top_interview_easy.sorting_searching;

public class first_bad_version extends VersionControl{
	/* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */
	public int firstBadVersion(int n) {

		int median = n / 2;
		int left = 1;
		int right = n;
		
		while(left < right) {
			median = left + (right - left) / 2;
			if(isBadVersion(median)) {
				right = median;
			} else {
				left = median + 1;
			}
			
			System.out.println(left + " " +  right);
		}
		
		return left;
	}
	
	public static void main(String[] args) {
		first_bad_version s = new first_bad_version();
		
		System.out.println(s.firstBadVersion(5));
	}
}

class VersionControl {
	public boolean isBadVersion(int i) {
		return i == 3;
	}
}
