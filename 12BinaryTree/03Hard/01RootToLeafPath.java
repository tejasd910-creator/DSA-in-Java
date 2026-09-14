import java.util.*;


class Node{
    int data;
    Node left;
    Node right;
    Node(int val)
    {
        this.data = val;
        left = null;
        right = null;
    }
}


class Solution {
    public ArrayList<ArrayList<Integer>> paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        
        allPaths(root, path, ans);
        
        return ans;
    }
    
    private void allPaths(Node root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ans){
        if(root == null) return;
        
        path.add(root.data);
        
        if(root.left == null && root.right == null){
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        
        allPaths(root.left, path, ans);
        allPaths(root.right, path, ans);
        
        path.remove(path.size() - 1);
    }
}