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
//Striver Code

class Tuple {
    TreeNode node;
    int row;
    int col;

    public Tuple(TreeNode _node, int _row, int _col) {
        node = _node;
        row = _row;
        col = _col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(root, 0 ,0));

        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);

            if(node.left != null){
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }
            if(node.right != null){
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> node : ys.values()){
                while(!node.isEmpty()){
                    list.get(list.size() - 1).add(node.poll());
                }
            }
        }

        return list;
    }
}


// AI code
// class Solution {
//     class Node {
//         int row, col, val;

//         Node(int row, int col, int val) {
//             this.row = row;
//             this.col = col;
//             this.val = val;
//         }
//     }

//     List<List<Integer>> result = new ArrayList<>();

//     public List<List<Integer>> verticalTraversal(TreeNode root) {
//         List<Node> nodes = new ArrayList<>();

//         dfs(root, 0, 0, nodes);

//         // Sort by column, then row, then value
//         Collections.sort(nodes, (a, b) -> {
//             if (a.col != b.col)
//                 return Integer.compare(a.col, b.col);

//             if (a.row != b.row)
//                 return Integer.compare(a.row, b.row);

//             return Integer.compare(a.val, b.val);
//         });

//         int prevCol = Integer.MIN_VALUE;

//         for (Node node : nodes) {
//             if (node.col != prevCol) {
//                 result.add(new ArrayList<>());
//                 prevCol = node.col;
//             }

//             result.get(result.size() - 1).add(node.val);
//         }

//         return result;
//     }

//     private void dfs(TreeNode root, int row, int col, List<Node> nodes) {
//         if (root == null)
//             return;

//         nodes.add(new Node(row, col, root.val));

//         dfs(root.left, row + 1, col - 1, nodes);
//         dfs(root.right, row + 1, col + 1, nodes);
//     }
// }