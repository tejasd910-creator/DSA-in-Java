class TreeNode {
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

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode newNode = new TreeNode(val);
        if (root == null)
            return newNode;

        TreeNode rootNode = root;

        while (root.left != null || root.right != null) {
            if (root.val < val) {
                if (root.right == null)
                    break;
                root = root.right;
            } else {
                if (root.left == null)
                    break;
                root = root.left;
            }
        }

        if (root.val < val)
            root.right = newNode;
        else
            root.left = newNode;

        return rootNode;
    }
}