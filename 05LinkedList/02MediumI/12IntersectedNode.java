
//Definition for singly-linked list.
import java.util.*;

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
class Solution {
    // Optimal sol
    public ListNode getIntersectionNodeI(ListNode headA, ListNode headB) {

        ListNode curA = headA;
        ListNode curB = headB;

        while(curA != curB){
            curA = (curA == null) ? headB : curA.next;
            curB = (curB == null) ? headA : curB.next;
        }
        return curA;
    }
    // better sol
        public ListNode getIntersectionNodeII(ListNode headA, ListNode headB) {
        
        Set<ListNode> set = new HashSet<>();

        ListNode curA = headA;
        ListNode curB = headB;

        while(curA != null){
            if(!set.contains(curA))
               set.add(curA);
            curA = curA.next;
        }
        while(curB != null){
            if(set.contains(curB))
               return curB;
            curB = curB.next;
        }

        return null;
    }

}