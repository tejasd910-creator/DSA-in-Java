import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

class Pair{
        Node node;
        int col;
        
        Pair(Node _node, int _col){
            this.node = _node;
            this.col = _col;
        }
    }


class Solution {
    // static class Pair{
    //     Node node;
    //     int col;
        
    //     Pair(Node _node, int _col){
    //         this.node = _node;
    //         this.col = _col;
    //     }
    // }
    
    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(root == null)
           return ans;
           
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        q.offer(new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            
            if(!map.containsKey(p.col)){
                map.put(p.col, p.node.data);
            }
            
            if(p.node.left != null){
                q.offer(new Pair(p.node.left, p.col - 1));
            }
            
            if(p.node.right != null){
                q.offer(new Pair(p.node.right, p.col + 1));
            }
            
        }
        ans.addAll(map.values());
        
        return ans;
    }
}
