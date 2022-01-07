package solutions;

public class linked_list_random_node {
	class Solution { 
		private ListNode head;
		private int length = 0;
		public Solution(ListNode head) {
			this.head = head;
			
			ListNode tmp = head;
			while(tmp != null) {
				this.length++;
				tmp = tmp.next;
			}
		}

		public int getRandomNumber(int min, int max) {
		    return (int) ((Math.random() * (max - min)) + min);
		}
		
		public int getRandom() {
			int idx = getRandomNumber(0, this.length); 
			
			ListNode tmp = head;
			
			while(idx != 0) {
				idx--;
				tmp = tmp.next;
			}
			
			return tmp.val;
		}
	}
	
	class Solution1 { 
		private ListNode head;
		public Solution1(ListNode head) {
			this.head = head;
		}

		public int getRandomNumber(int min, int max) {
		    return (int) ((Math.random() * (max - min)) + min);
		}
		
		public int getRandom() {
			int n = 1;
			ListNode ret = head;
			ListNode tmp = head;
			
			while(tmp != null) {
				if(getRandomNumber(0, n + 1) == 0) {
					ret = tmp;
					n++;
				}
				
				tmp = tmp.next;
			}
			
			return ret.val;
		}
	}
}
