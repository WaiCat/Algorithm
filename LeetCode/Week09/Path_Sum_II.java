package Algorithm.LeetCode.Week09;

import java.util.ArrayList;
import java.util.List;

public class Path_Sum_II {

  public static void main(String[] args) {
    // Example 1
    TreeNode root1 = new TreeNode(5,
        new TreeNode(4,
            new TreeNode(11,
                new TreeNode(7),
                new TreeNode(2)),
            null),
        new TreeNode(8,
            new TreeNode(13),
            new TreeNode(4,
                new TreeNode(5),
                new TreeNode(1))));
    int targetSum1 = 22;
    System.out.println("Example 1 Output: " + pathSum(root1, targetSum1));

    // Example 2
    TreeNode root2 = new TreeNode(1,
        new TreeNode(2),
        new TreeNode(3));
    int targetSum2 = 5;
    System.out.println("Example 2 Output: " + pathSum(root2, targetSum2));

    // Example 3
    TreeNode root3 = new TreeNode(1,
        new TreeNode(2),
        null);
    int targetSum3 = 0;
    System.out.println("Example 3 Output: " + pathSum(root3, targetSum3));
  }

  public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> result = new ArrayList<>();
    dfs(root, targetSum, new ArrayList<>(), result);
    return result;
  }

  private static void dfs(TreeNode node, int remainingSum, List<Integer> path,
      List<List<Integer>> result) {
    if (node == null) {
      return;
    }

    path.add(node.val);

    if (node.left == null && node.right == null && remainingSum == node.val) {
      result.add(new ArrayList<>(path));
    } else {
      dfs(node.left, remainingSum - node.val, path, result);
      dfs(node.right, remainingSum - node.val, path, result);
    }

    path.remove(path.size() - 1);
  }
}
