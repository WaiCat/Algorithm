package Algorithm.LeetCode.Week09;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal {

  public static void main(String[] args) {
    // Example 1
    TreeNode root1 = new TreeNode(3,
        new TreeNode(9),
        new TreeNode(20,
            new TreeNode(15),
            new TreeNode(7)));
    System.out.println("Example 1 Output: " + levelOrder(root1));
    // Expected: [[3], [9, 20], [15, 7]]

    // Example 2
    TreeNode root2 = new TreeNode(1);
    System.out.println("Example 2 Output: " + levelOrder(root2));
    // Expected: [[1]]

    // Example 3
    TreeNode root3 = null;
    System.out.println("Example 3 Output: " + levelOrder(root3));
    // Expected: []
  }

  public static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new LinkedList<>();
    if (root == null) {
      return res;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> list = new LinkedList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        list.add(node.val);
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      res.add(list);
    }
    return res;
  }


}
