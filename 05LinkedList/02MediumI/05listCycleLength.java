
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Solution {
    public int lengthOfLoop(Node head) {
        // code here
        if (head == null || head.next == null)
            return 0;

        int len = 1;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                Node ptr = slow;
                while (ptr.next != slow) {
                    len++;
                    ptr = ptr.next;
                }
                return len;
            }
        }
        return 0;
    }
}