import java.util.*;

//   Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    // Collects nodes exactly distance edges
    // below the given subtree root.
    private void collectDown(
            TreeNode node,
            int distance,
            List<Integer> answer) {
        if (node == null ||
                distance < 0) {
            return;
        }

        if (distance == 0) {
            answer.add(node.val);
            return;
        }

        collectDown(
                node.left,
                distance - 1,
                answer);

        collectDown(
                node.right,
                distance - 1,
                answer);
    }

    // Returns the distance from node to target,
    // or -1 when target is absent.
    private int findTarget(
            TreeNode node,
            TreeNode target,
            int K,
            List<Integer> answer) {
        if (node == null) {
            return -1;
        }

        // All descendants exactly K edges
        // below the target are collected here.
        if (node == target) {
            collectDown(
                    node,
                    K,
                    answer);

            return 0;
        }

        int leftResult = findTarget(
                node.left,
                target,
                K,
                answer);

        if (leftResult != -1) {
            int currentDistance = leftResult + 1;

            if (currentDistance == K) {
                answer.add(node.val);
            } else {
                // The right subtree is opposite
                // to the path containing target.
                collectDown(
                        node.right,
                        K - currentDistance - 1,
                        answer);
            }

            return currentDistance;
        }

        int rightResult = findTarget(
                node.right,
                target,
                K,
                answer);

        if (rightResult != -1) {
            int currentDistance = rightResult + 1;

            if (currentDistance == K) {
                answer.add(node.val);
            } else {
                // The left subtree is opposite
                // when target lies on the right.
                collectDown(
                        node.left,
                        K - currentDistance - 1,
                        answer);
            }

            return currentDistance;
        }

        return -1;
    }

    // Finds nodes at distance K without
    // storing explicit parent links.
    public List<Integer> distanceK(
            TreeNode root,
            TreeNode target,
            int K) {
        List<Integer> answer = new ArrayList<>();

        findTarget(
                root,
                target,
                K,
                answer);

        return answer;
    }
}