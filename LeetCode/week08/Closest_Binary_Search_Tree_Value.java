package Algorithm.LeetCode.week08;

public class Closest_Binary_Search_Tree_Value {

  static int closest = Integer.MAX_VALUE;

  public static void main(String[] args) {
    // Example 1
    TreeNode root1 = new TreeNode(4,
        new TreeNode(2,
            new TreeNode(1),
            new TreeNode(3)
        ),
        new TreeNode(5));
    double target1 = 3.714286;
    System.out.println("Output: " + closestValue(root1, target1)); //4

    // Example 2
    TreeNode root2 = new TreeNode(1);
    double target2 = 4.428571;
    System.out.println("Output: " + closestValue(root2, target2)); //1
  }

  public static int closestValue(TreeNode root, double target) {
    int closest = root.val;

    while (root != null) {
      if (Math.abs(root.val - target) < Math.abs(closest - target)) {
        closest = root.val;
      } else if (Math.abs(root.val - target) == Math.abs(closest - target)) {
        closest = Math.min(closest, root.val);
      }
      root = (target < root.val) ? root.left : root.right;
    }
    return closest;
  }
}
