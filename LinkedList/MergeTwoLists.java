package LinkedList;

public class MergeTwoLists {

    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }


        //  https://leetcode.com/problems/merge-two-sorted-lists/

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Take two lists and initialize them with a dummy value. 
              	ListNode result = new ListNode(0);
        		ListNode temp = result;

                // Same logic as merge sort's merge function. (SORT TWO SORTED ARRAYS.)
        		while(l1 != null && l2 != null) {
        			if(l1.val <= l2.val) {
        				temp.next = l1;
        				l1 = l1.next;
        			}else {
        				temp.next = l2;
        				l2 = l2.next;
        			}
        			temp = temp.next;
        		}

                // ADD WHATEVER IS LEFT AS THE NEXT POINTER IN THE TEMP LINKEDLIST
        		if(l1 != null) {
        			temp.next = l1;
        		}else if(l2 != null) {
        			temp.next = l2;
        		}

                // OUR HEAD STARTS WITH A DUMMY VALUE, SO RETURN HEAD.NEXT
        		return result.next;
           }
}
