package Algorithm.LeetCode.Week09;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Average_of_Levels_in_Binary_Tree {

  public static void main(String[] args) {
    // Example 1
    TreeNode root1 = new TreeNode(3,
        new TreeNode(9),
        new TreeNode(20, new TreeNode(15), new TreeNode(7))
    );
    System.out.println("Example 1 Output: " + averageOfLevels(root1));
    // Expected: [3.00000, 14.50000, 11.00000]

    // Example 2
    TreeNode root2 = new TreeNode(3,
        new TreeNode(9, new TreeNode(15), new TreeNode(7)),
        null
    );
    System.out.println("Example 2 Output: " + averageOfLevels(root2));
    // Expected: [3.00000, 9.00000, 11.00000]
  }

  public static List<Double> averageOfLevels(TreeNode root) {
    List<Double> res = new LinkedList<>();
    if (root == null) {
      return res;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      double sum = 0;
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        sum += node.val;
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      res.add(sum / size);
    }
    return res;
  }
}
