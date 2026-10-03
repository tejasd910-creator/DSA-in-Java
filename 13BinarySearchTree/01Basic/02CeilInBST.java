
// Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        left = right = null;
    }
} 

class Solution {
    int findCeil(Node root, int x) {
        // code here
        if(root == null) return -1;
        
        int ceil = Integer.MAX_VALUE;
        
        while(root != null){
            if(x <= root.data && root.data < ceil)
               ceil = root.data;
               
            root = x > root.data ? root.right : root.left;
        }
        
        return ceil == Integer.MAX_VALUE ? -1 : ceil;
    }
}