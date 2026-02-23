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

    public ListNode removeNthFromEndII(ListNode head, int n) {
        if (head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = slow;
        int dist = 1;

        while (dist < n) {
            fast = fast.next;
            dist++;
        }
        while (fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if (slow == head)
            return head.next;
        prev.next = slow.next;

        return head;
    }

    public ListNode removeNthFromEndIII(ListNode head, int n) {
        // Dummy node to handle edge cases like removing the first node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // Move first pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both pointers until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the nth node from end
        second.next = second.next.next;

        return dummy.next;
    }
}