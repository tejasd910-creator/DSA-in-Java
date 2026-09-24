
//  Definition for a binary tree node.

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Pair {
    TreeNode node;
    int index;

    Pair(TreeNode _node, int _index) {
        this.node = _node;
        this.index = _index;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int maxWidth = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int minIndex = q.peek().index;
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();
                TreeNode node = curr.node;

                int normalizedIndex = curr.index - minIndex; // indexOfCurrentElement - indexOfFirstElement of same
                                                             // level

                if (i == 0)
                    first = normalizedIndex;
                if (i == size - 1)
                    last = normalizedIndex;

                if (node.left != null)
                    q.offer(new Pair(node.left, 2 * normalizedIndex + 1));
                if (node.right != null)
                    q.offer(new Pair(node.right, 2 * normalizedIndex + 2));
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        return maxWidth;
    }
}