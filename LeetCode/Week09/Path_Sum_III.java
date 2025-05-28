package Algorithm.LeetCode.Week09;

import java.util.HashMap;
import java.util.Map;

public class Path_Sum_III {

  public static void main(String[] args) {
    // Example 1
    TreeNode root1 = new TreeNode(10,
        new TreeNode(5,
            new TreeNode(3,
                new TreeNode(3),
                new TreeNode(-2)),
            new TreeNode(2,
                null,
                new TreeNode(1))),
        new TreeNode(-3,
            null,
            new TreeNode(11)));
    int targetSum1 = 8;
    System.out.println("Example 1 Output: " + pathSum(root1, targetSum1)); // Expected: 3

    // Example 2
    TreeNode root2 = new TreeNode(5,
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
    int targetSum2 = 22;
    System.out.println("Example 2 Output: " + pathSum(root2, targetSum2)); // Expected: 3
  }

  public static int pathSum(TreeNode root, int targetSum) {
    Map<Long, Integer> prefixSumCount = new HashMap<>();
    prefixSumCount.put(0L, 1);
    return dfs(root, 0, targetSum, prefixSumCount);
  }

  private static int dfs(TreeNode node, long currSum, int target,
      Map<Long, Integer> prefixSumCount) {
    if (node == null) {
      return 0;
    }

    currSum += node.val;
    int count = prefixSumCount.getOrDefault(currSum - target, 0);

    prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);

    count += dfs(node.left, currSum, target, prefixSumCount);
    count += dfs(node.right, currSum, target, prefixSumCount);

    prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);

    return count;
  }
}
