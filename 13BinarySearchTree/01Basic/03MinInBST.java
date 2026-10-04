
// Definition for Node
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}


class Solution {
    public int minValue(Node root) {
        // code here
        if(root == null) return -1;
        
        while(root.left != null){
            root = root.left;
        }
        
        return root.data;
    }
}