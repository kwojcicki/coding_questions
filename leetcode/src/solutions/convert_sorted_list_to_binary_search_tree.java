package solutions;

public class convert_sorted_list_to_binary_search_tree {

	public int length(ListNode head) {
		return head == null ? 0 : length(head.next) + 1;
	}

	public TreeNode sortedListToBST(ListNode head) {
		int length = length(head);

		return generate(head, 0, length);
	}

	public TreeNode generate(ListNode head, int  start, int end) {
		if(head == null ||  start > end || end < start) return null;
		ListNode t = head;
		int mid = (end - start) / 2 + start;
		for(int i = start; i < mid; i++) {
			t = t.next;
		}
		TreeNode newHead = new TreeNode(t.val);
		newHead.left = generate(head, start, mid - 1);
		newHead.right = generate(t.next, mid + 1, end);

		return newHead;
	}
}
