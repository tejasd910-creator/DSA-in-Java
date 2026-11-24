//  Structure of a Binary Search Tree node
import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
} 

class Solution {
    public Node low = new Node(0);
    public Node high = new Node(0);
    
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        ArrayList<Node> ans = new ArrayList<>();
        
        low.data = Integer.MIN_VALUE;
        high.data = Integer.MAX_VALUE;
        
        findAns(root,low, high, key);
        
        if(low.data == Integer.MIN_VALUE)
          low = null;
        if(high.data == Integer.MAX_VALUE)
          high = null;
          
        ans.add(low);
        ans.add(high);
        
        return ans;
    }
    
    private void findAns(Node root, Node low, Node high, int key){
        if(root == null) return;
        
        if(root.data == key){
            findAns(root.left, low, high, key);
            findAns(root.right, low, high, key);
        }
        
        if(root.data < key){
            low.data = Math.max(root.data, low.data);
            findAns(root.right, low, high, key);
        }
        
        if(root.data > key){
            high.data = Math.min(root.data, high.data);
            findAns(root.left, low, high, key);
        }
        
        return;
    }
}