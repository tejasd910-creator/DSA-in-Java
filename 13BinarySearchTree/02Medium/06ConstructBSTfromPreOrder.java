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
    private int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int upperBound) {
        if (index == preorder.length || preorder[index] > upperBound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index++]);

        root.left = build(preorder, root.val);
        root.right = build(preorder, upperBound);

        return root;
    }
}