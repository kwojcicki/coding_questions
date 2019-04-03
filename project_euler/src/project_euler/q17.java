package project_euler;

public class q17 {

	/**
	 *
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?


NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. 
The use of "and" when writing out numbers is in compliance with British usage.
	 */
	public static void main(String[] args) {

		int count = 0;

		for(int i = 1; i <= 1000; i++) {
			String s = "";

			if(i <= 20) {
				i -= 1;
				if(i == 0) {
					s = "one";
				} else if(i == 1) {
					s = "two";
				} else if(i == 2) {
					s = "three";
				} else if(i == 3) {
					s = "four";
				} else if(i == 4) {
					s = "five";
				} else if(i == 5) {
					s = "six";
				} else if(i == 6) {
					s = "seven";
				} else if(i == 7) {
					s = "eight";
				} else if(i == 8) {
					s = "nine";
				} else if(i == 9) {
					s = "ten";
				} else if(i == 10) {
					s = "eleven";
				} else if(i == 11) {
					s = "twelve";
				} else if(i == 12) {
					s = "thirteen";
				} else if(i == 13) {
					s = "fourteen";
				} else if(i == 14) {
					s = "fifteen";
				} else if(i == 15) {
					s = "sixteen";
				} else if(i == 16) {
					s = "seventeen";
				} else if(i == 17) {
					s = "eighteen";
				} else if(i == 18) {
					s = "nineteen";
				} else if(i == 19) {
					s = "twenty";
				}
				i += 1;
			} else {

				if(i / 1000 > 0) {
					s += "one thousand";
				}

				if((i%1000) / 100 > 0) {
					if(i / 100 == 9) {
						s += "nine";
					} else if(i / 100 == 8) {
						s += "eight";
					} else if(i / 100 == 7) {
						s += "seven";
					} else if(i / 100 == 6) {
						s += "six";
					} else if(i / 100 == 5) {
						s += "five";
					} else if(i / 100 == 4) {
						s += "four";
					} else if(i / 100 == 3) {
						s += "three";
					} else if(i / 100 == 2) {
						s += "two";
					} else if(i / 100 == 1) {
						s += "one";
					}
					s += " hundred";
				}

				if(i%100 < 21 && i%100 > 0) {
					if(i > 99) {
						s += " and";
					}
					i -= 1;
					if(i%100 == 0) {
						s += "one";
					} else if(i%100 == 1) {
						s += "two";
					} else if(i%100 == 2) {
						s += "three";
					} else if(i%100 == 3) {
						s += "four";
					} else if(i%100 == 4) {
						s += "five";
					} else if(i%100 == 5) {
						s += "six";
					} else if(i%100 == 6) {
						s += "seven";
					} else if(i%100 == 7) {
						s += "eight";
					} else if(i%100 == 8) {
						s += "nine";
					} else if(i%100 == 9) {
						s += "ten";
					} else if(i%100 == 10) {
						s += "eleven";
					} else if(i%100 == 11) {
						s += "twelve";
					} else if(i%100 == 12) {
						s += "thirteen";
					} else if(i%100 == 13) {
						s += "fourteen";
					} else if(i%100 == 14) {
						s += "fifteen";
					} else if(i%100 == 15) {
						s += "sixteen";
					} else if(i%100 == 16) {
						s += "seventeen";
					} else if(i%100 == 17) {
						s += "eighteen";
					} else if(i%100 == 18) {
						s += "nineteen";
					} else if(i%100 == 19) {
						s += "twenty";
					}
					i += 1;
				} else {

					if((i%100) / 10 > 0) {
						if(i > 99) {
							s += " and";
						}
						if((i%100) / 10 == 9) {
							s += "ninety";
						} else if((i%100) / 10 == 8) {
							s += "eighty";
						} else if((i%100) / 10 == 7) {
							s += "seventy";
						} else if((i%100) / 10 == 6) {
							s += "sixty";
						} else if((i%100) / 10 == 5) {
							s += "fifty";
						} else if((i%100) / 10 == 4) {
							s += "forty";
						} else if((i%100) / 10 == 3) {
							s += "thirty";
						} else if((i%100) / 10 == 2) {
							s += "twenty";
						} else if((i%100) / 10 == 1) {
							s += "ten";
						}
					}

					if((i%10) > 0) {
						if(i % 10 == 9) {
							s += "nine";
						} else if(i % 10 == 8) {
							s += "eight";
						} else if(i % 10 == 7) {
							s += "seven";
						} else if(i % 10 == 6) {
							s += "six";
						} else if(i % 10 == 5) {
							s += "five";
						} else if(i % 10 == 4) {
							s += "four";
						} else if(i % 10 == 3) {
							s += "three";
						} else if(i % 10 == 2) {
							s += "two";
						} else if(i % 10 == 1) {
							s += "one";
						}
					}
				}

			}
			System.out.println(s + " " + i);
			count += s.replaceAll(" ", "").length();
		}

		System.out.println(count);
	}

}
