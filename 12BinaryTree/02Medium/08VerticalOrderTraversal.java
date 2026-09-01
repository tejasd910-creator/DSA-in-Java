import java.util.*;

//   Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    class Node {
        int row, col, val;

        Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Node> nodes = new ArrayList<>();

        dfs(root, 0, 0, nodes);

        // Sort by column, then row, then value
        Collections.sort(nodes, (a, b) -> {
            if (a.col != b.col)
                return Integer.compare(a.col, b.col);

            if (a.row != b.row)
                return Integer.compare(a.row, b.row);

            return Integer.compare(a.val, b.val);
        });

        int prevCol = Integer.MIN_VALUE;

        for (Node node : nodes) {
            if (node.col != prevCol) {
                result.add(new ArrayList<>());
                prevCol = node.col;
            }

            result.get(result.size() - 1).add(node.val);
        }

        return result;
    }

    private void dfs(TreeNode root, int row, int col, List<Node> nodes) {
        if (root == null)
            return;

        nodes.add(new Node(row, col, root.val));

        dfs(root.left, row + 1, col - 1, nodes);
        dfs(root.right, row + 1, col + 1, nodes);
    }
}