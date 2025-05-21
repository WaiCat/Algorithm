package Algorithm.LeetCode.week08;

public class Minimum_Depth_of_Binary_Tree {

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(3);
    root1.left = new TreeNode(9);
    root1.right = new TreeNode(20);
    root1.right.left = new TreeNode(15);
    root1.right.right = new TreeNode(7);

    System.out.println("Output 1: " + minDepth(root1));  // 2

    TreeNode root2 = new TreeNode(2);
    root2.right = new TreeNode(3);
    root2.right.right = new TreeNode(4);
    root2.right.right.right = new TreeNode(5);
    root2.right.right.right.right = new TreeNode(6);

    System.out.println("Output 2: " + minDepth(root2));  // 5
  }

  public static int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    if (root.left == null) {
      return minDepth(root.right) + 1;
    }

    if (root.right == null) {
      return minDepth(root.left) + 1;
    }

    return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
  }
}
