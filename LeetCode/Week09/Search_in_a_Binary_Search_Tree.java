package Algorithm.LeetCode.Week09;

public class Search_in_a_Binary_Search_Tree {

  public static void main(String[] args) {
    // Example 1
    TreeNode root1 = new TreeNode(4);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(7);
    root1.left.left = new TreeNode(1);
    root1.left.right = new TreeNode(3);

    System.out.println("Example 1 Output: " + searchBST(root1, 2));
    // Expected: [2,1,3]

    // Example 2
    System.out.println("Example 2 Output: " + searchBST(root1, 5));
    // Expected: []
  }


  public static TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return null;
    }
    if (root.val == val) {
      return root;
    }
    if (val < root.val) {
      return searchBST(root.left, val);
    } else {
      return searchBST(root.right, val);
    }
  }

}
