import java.util.*;

 //Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
         val = x;
          next = null;
     }
 }

 class Solution {
    public boolean hasCycleI(ListNode head) {
        
        Set<ListNode> set = new HashSet<>();
        ListNode curr = head;
        
        while(curr != null){
            if(set.contains(curr)) return true;

            set.add(curr);
            curr = curr.next;
        }
        return false;
    }

    public boolean hasCycleII(ListNode head) {
        
        ListNode tortoise = head;
        ListNode hare = head;

        while(hare != null && hare.next != null){
            tortoise = tortoise.next;
            hare = hare.next.next;
            
            if(hare == tortoise)  return true;
        }

        return false;
    }
}