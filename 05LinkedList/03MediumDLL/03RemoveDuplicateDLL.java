
class Node{
    int data;
    Node next, prev;
    Node(int x){
        this.data = x;
        this.next = null;
        this.prev = null;
    }
}

class Solution {
    Node removeDuplicates(Node head) {
        
        if (head == null || head.next == null) 
            return head;
        
        Node prev = head;
        Node cur = head.next;
        
        while (cur != null) {
            if (prev.data == cur.data) {
                cur = cur.next;
                
            } else {
                prev.next = cur;
                cur.prev = prev;
                prev = cur;
                cur = cur.next;
            }
        }
        
        prev.next = null;
        
        return head;
    }
}