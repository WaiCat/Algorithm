package Algorithm.LeetCode.week08;

import java.util.LinkedList;
import java.util.Queue;

public class Deepest_Leaves_Sum {

  public static void main(String[] args) {

    // Test Case 1: [1,2,3,4,5,null,6,7,null,null,null,null,8]
    TreeNode tree1 = new TreeNode(1,
        new TreeNode(2,
            new TreeNode(4,
                new TreeNode(7), null),
            new TreeNode(5)),
        new TreeNode(3,
            null,
            new TreeNode(6,
                null,
                new TreeNode(8)))
    );
    System.out.println("Output 1: " + deepestLeavesSum(tree1)); // Expected: 15

    // Test Case 2: [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
    TreeNode tree2 = new TreeNode(6,
        new TreeNode(7,
            new TreeNode(2,
                new TreeNode(9), null),
            new TreeNode(7,
                new TreeNode(1), new TreeNode(4))),
        new TreeNode(8,
            new TreeNode(1), new TreeNode(3,
            null, new TreeNode(5)))
    );
    System.out.println("Output 2: " + deepestLeavesSum(tree2)); // Expected: 19
  }

  public static int deepestLeavesSum(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int sum = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();
      sum = 0;
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
    }
    return sum;
  }
}
