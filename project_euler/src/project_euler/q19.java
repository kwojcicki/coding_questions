package project_euler;

public class q19 {

	/**
	 *
You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
	 */
	public static void main(String[] args) {

		int count = 0;
		
		int start = 1;
		
		//jan 31
		//feb 28/29
		//march 31
		//april 30
		//may 31
		//june 30
		//july 31
		//august 31
		//september 30
		//october 31
		//nvoember 30
		//december 31
		
		
		
		for(int i = 1; i <= 100; i++) {
			
			int[] days;
			
			if(i % 4 == 0 ) {
				days = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			} else {
				days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31};
			}
			
			for(int x: days) {
				if(start == 6) {
					count++;
				}
				
				start += x;
				start %= 7;
			}
			
			System.out.println(count + " " + start);
			
		}
		
		
		System.out.println(count);
	}

}
