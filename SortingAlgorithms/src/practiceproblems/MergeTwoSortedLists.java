package practiceproblems;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				list1.next = mergeTwoLists(list1.next, list2);
				return list1;
			} else {
				list2.next = mergeTwoLists(list1, list2.next);
				return list2;
			}
		}
		if (list1 == null) {
			return list2;
		} else {
			return list1;
		}
	}
	
	public static void main(String[] args) {
		ListNode list = new ListNode();
		list.val = 1;
		list.next = list;
		list.next.val = 2;
		MergeTwoSortedLists meg = new MergeTwoSortedLists();
		//list = meg.mergeTwoLists([1,2,4],[1,3,4]);
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}