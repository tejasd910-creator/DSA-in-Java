import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        val = value;
    }
}

class Solution {

    // Builds child-to-parent links so fire
    // can also spread upward.
    private void buildParentTrack(
        TreeNode root,
        Map<TreeNode, TreeNode> parentTrack
    ) {
        Queue<TreeNode> nodesQueue =
            new LinkedList<>();

        nodesQueue.offer(root);

        // The root has no parent, so null
        // marks the end of upward movement.
        parentTrack.put(root, null);

        while (!nodesQueue.isEmpty()) {
            TreeNode node =
                nodesQueue.poll();

            if (node.left != null) {
                parentTrack.put(
                    node.left,
                    node
                );

                nodesQueue.offer(node.left);
            }

            if (node.right != null) {
                parentTrack.put(
                    node.right,
                    node
                );

                nodesQueue.offer(node.right);
            }
        }
    }

    // Simulates fire using child
    // and parent connections.
    public int minTime(
        TreeNode root,
        TreeNode target
    ) {
        if (root == null) {
            return 0;
        }

        Map<TreeNode, TreeNode> parentTrack =
            new HashMap<>();

        buildParentTrack(
            root,
            parentTrack
        );

        Queue<TreeNode> nodesQueue =
            new LinkedList<>();

        Set<TreeNode> burned =
            new HashSet<>();

        nodesQueue.offer(target);
        burned.add(target);

        int time = 0;

        while (!nodesQueue.isEmpty()) {
            int levelSize =
                nodesQueue.size();

            // spread records whether fire reaches
            // any new node during this second.
            boolean spread = false;

            // All nodes in this level burn
            // during the same second.
            for (int i = 0; i < levelSize; i++) {
                TreeNode node =
                    nodesQueue.poll();

                if (
                    node.left != null &&
                    !burned.contains(node.left)
                ) {
                    burned.add(node.left);
                    nodesQueue.offer(node.left);
                    spread = true;
                }

                if (
                    node.right != null &&
                    !burned.contains(node.right)
                ) {
                    burned.add(node.right);
                    nodesQueue.offer(node.right);
                    spread = true;
                }

                TreeNode parent =
                    parentTrack.get(node);

                // The stored parent provides
                // the upward spreading direction.
                if (
                    parent != null &&
                    !burned.contains(parent)
                ) {
                    burned.add(parent);
                    nodesQueue.offer(parent);
                    spread = true;
                }
            }

            // Time increases only when at least
            // one additional node catches fire.
            if (spread) {
                time++;
            }
        }

        return time;
    }
}

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        TreeNode target = root.left;

        Solution solution = new Solution();

        System.out.println(
            solution.minTime(root, target)
        );
    }
}