//Structure of Doubly Linked List

class Node
{
    int data;
    Node next;
    Node prev;
}
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {

        if (head == null) return null;

        Node curr = head;

        while (curr != null) {

            if (curr.data == x) {

                // If deleting head
                if (curr.prev == null) {
                    head = curr.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } 
                else {
                    curr.prev.next = curr.next;

                    if (curr.next != null) {
                        curr.next.prev = curr.prev;
                    }
                }
            }

            curr = curr.next;
        }

        return head;
    }
}