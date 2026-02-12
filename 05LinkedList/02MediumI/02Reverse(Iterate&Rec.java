
// Definition for singly-linked list.
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
    public ListNode reverseListIterative(ListNode head) {
        if(head == null || head.next == null)  return head;

        ListNode prevNode = head;
        ListNode currNode = head.next;
        head.next = null;
        while(currNode != null){
            ListNode temp = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = temp;
        }

        return prevNode;
    }
    public ListNode reverseListRec(ListNode head) {
        if(head == null || head.next == null)  return head;

        ListNode newHead = reverseListRec(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;

    }
}