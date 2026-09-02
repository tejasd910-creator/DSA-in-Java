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

class Solution {
    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) return ans;

        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (!map.containsKey(p.hd)) {
                map.put(p.hd, p.node.data);
            }

            if (p.node.left != null) {
                q.offer(new Pair(p.node.left, p.hd - 1));
            }

            if (p.node.right != null) {
                q.offer(new Pair(p.node.right, p.hd + 1));
            }
        }

        ans.addAll(map.values());

        return ans;
    }
}
