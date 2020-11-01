package solutions;

public class convert_binary_number_in_a_linked_list_to_integer {
	
	class Point {
		int x1, x2;
		public Point(int x1, int x2) {
			this.x1 = x1;
			this.x2 = x2;
		}
	}
	
    public int getDecimalValue(ListNode head) {
        int ret = 0;
        
        while(head != null) {
        	ret = ret * 2 + head.val;
        	head = head.next;
        }
        
        return ret;
    }
	
    public int getDecimalValue1(ListNode head) {
        return get(head).x1;
    }
    
    public Point get(ListNode head) {
    	if(head == null) {
    		return new Point(0, 0);
    	}
    	
    	Point x = get(head.next);
    	
    	//return new Point((int)Math.pow(2, x.x2) * head.val + x.x1, x.x2 + 1);
        x.x1 += (int)Math.pow(2, x.x2) * head.val;
        x.x2 += 1;
        return x;
    }
}
