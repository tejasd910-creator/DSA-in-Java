class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}

class Solution {
    public Node segregateOptimal(Node head) {
        
        // Dummy nodes
        Node zeroDummy = new Node(-1);
        Node oneDummy  = new Node(-1);
        Node twoDummy  = new Node(-1);
        
        // Tails start at dummy
        Node zeroTail = zeroDummy;
        Node oneTail  = oneDummy;
        Node twoTail  = twoDummy;
        
        Node cur = head;
        
        while (cur != null) {
            Node next = cur.next;   // store next
            cur.next = null;        // detach current node without detachment it can create cycle in merging
            
            if (cur.data == 0) {
                zeroTail.next = cur;
                zeroTail = cur;
            } 
            else if (cur.data == 1) {
                oneTail.next = cur;
                oneTail = cur;
            } 
            else {
                twoTail.next = cur;
                twoTail = cur;
            }
            
            cur = next;
        }
        
        // Connect the three lists safely
        zeroTail.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        oneTail.next = twoDummy.next;
        
        // Return correct head
        if (zeroDummy.next != null) return zeroDummy.next;
        if (oneDummy.next != null)  return oneDummy.next;
        return twoDummy.next;
    }

// easy approach but dummy node is better when node rearranging is required
    public Node segregateBrute(Node head) {
        // code here
        int zero = 0, one = 0; 
        Node cur = head;
        
        while(cur != null){
            if(cur.data == 0)
              zero++;
            if(cur.data == 1)
              one++;
            cur = cur.next;
        }
        
        cur = head;
        while(zero != 0){
            cur.data = 0;
            cur = cur.next;
            zero--;
        }
        while(one != 0){
            cur.data = 1;
            cur = cur.next;
            one--;
        }
        while(cur != null){
            cur.data = 2;
            cur = cur.next;
        }
        
        return head;
    }
}