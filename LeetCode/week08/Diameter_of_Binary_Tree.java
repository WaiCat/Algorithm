package Algorithm.LeetCode.week08;

public class Diameter_of_Binary_Tree {

  static int max;

  public static void main(String[] args) {
    // Test case 1: [1,2,3,4,5]
    TreeNode root1 = new TreeNode(1);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(3);
    root1.left.left = new TreeNode(4);
    root1.left.right = new TreeNode(5);
    System.out.println("Output 1: " + diameterOfBinaryTree(root1));  // Expected: 3

    // Test case 2: [1,2]
    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(2);
    System.out.println("Output 2: " + diameterOfBinaryTree(root2));  // Expected: 1
  }

  public static int diameterOfBinaryTree(TreeNode root) {
    max = 0;
    depth(root);

    return max;
  }

  public static int depth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = depth(root.left);
    int right = depth(root.right);
    max = Math.max(max, left + right);

    return Math.max(left, right) + 1;
  }
}
