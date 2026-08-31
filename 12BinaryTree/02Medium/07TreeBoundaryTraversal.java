import java.util.*;

//  Node Structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} 

class Solution {
    public ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        // If root itself is a leaf
        if (root.left == null && root.right == null) {
            ans.add(root.data);
            return ans;
        }

        // Add root
        ans.add(root.data);

        // Add left boundary
        Node curr = root.left;
        while (curr != null) {
            if (curr.left != null || curr.right != null) {
                ans.add(curr.data);
            }

            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        // Add all leaf nodes
        addLeaves(root, ans);

        // Add right boundary
        ArrayList<Integer> right = new ArrayList<>();
        curr = root.right;

        while (curr != null) {
            if (curr.left != null || curr.right != null) {
                right.add(curr.data);
            }

            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        // Reverse right boundary
        for (int i = right.size() - 1; i >= 0; i--) {
            ans.add(right.get(i));
        }

        return ans;
    }

    private void addLeaves(Node root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }

        // Leaf node
        if (root.left == null && root.right == null) {
            ans.add(root.data);
            return;
        }

        addLeaves(root.left, ans);
        addLeaves(root.right, ans);
    }
}
