package assignment3;


import java.util.ArrayList;
import java.util.List;

public class RemoveNthNode {

    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }

    public ListNode removeNthFromEndNaive(ListNode head, int n) {
        List<Integer> temp = new ArrayList<>();
        ListNode t = head;
        while(t != null){
            temp.add(t.val);
            t = t.next;
        }
        ListNode result = new ListNode(0);
        ListNode ans = result;
        for(int i = 0; i < temp.size(); i++){
            if(i == temp.size() - n) continue;
            result.next = new ListNode(temp.get(i));
            result = result.next;
        }
        return ans.next;
    }
    
    public ListNode optimal(ListNode head, int n){
        ListNode fast = head, slow = head;
        while(n > 0){
            fast = fast.next;
            n -= 1;
        }
        if(fast == null) return head.next;
        fast = fast.next;
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
