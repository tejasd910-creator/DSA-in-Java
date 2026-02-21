//Definition for singly-linked list.
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
    public ListNode removeNthFromEndI(ListNode head, int n) {
        if (head.next == null)
            return null;

        ListNode curr = head;
        int count = 0, i = 1;

        while (curr != null) {
            count++;
            curr = curr.next;
        }
        if (n == count)
            return head.next;
        curr = head;
        while (i < count - n) {
            curr = curr.next;
            i++;
        }
        ListNode temp = curr.next.next;
        curr.next = temp;

        return head;
    }
}