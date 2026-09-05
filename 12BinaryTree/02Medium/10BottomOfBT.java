import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

class Solution {

    static class Pair {
        Node node;
        int hd; // horizontal distance

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        // horizontal distance -> node value
        TreeMap<Integer, Integer> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair current = q.poll();

            Node node = current.node;
            int hd = current.hd;

            // Replace the previous node at this horizontal distance
            map.put(hd, node.data);

            if (node.left != null) {
                q.add(new Pair(node.left, hd - 1));
            }

            if (node.right != null) {
                q.add(new Pair(node.right, hd + 1));
            }
        }

        // TreeMap gives horizontal distances from left to right
        for (int value : map.values()) {
            ans.add(value);
        }

        return ans;
    }
}

