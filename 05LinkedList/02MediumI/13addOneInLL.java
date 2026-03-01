
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Solution {
    public Node addOne(Node head) {
        // code here.
        Node cur = head;
        Node ptr = null;

        while (cur != null) {
            if (cur.data != 9)
                ptr = cur;
            cur = cur.next;
        }
        if (ptr == null) {
            Node newHead = new Node(1);
            newHead.next = head;
            head = newHead;
            ptr = head;
        } else {
            ptr.data += 1;
        }

        ptr = ptr.next;
        while (ptr != null) {
            ptr.data = 0;
            ptr = ptr.next;
        }
        return head;
    }
}