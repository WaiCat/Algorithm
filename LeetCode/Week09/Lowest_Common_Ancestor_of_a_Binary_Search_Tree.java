package Algorithm.LeetCode.Week09;

public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

  public static void main(String[] args) {

    // 예제 1
    TreeNode root1 = new TreeNode(6);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(8);
    root1.left.left = new TreeNode(0);
    root1.left.right = new TreeNode(4);
    root1.right.left = new TreeNode(7);
    root1.right.right = new TreeNode(9);
    root1.left.right.left = new TreeNode(3);
    root1.left.right.right = new TreeNode(5);

    TreeNode p1 = findNode(root1, 2);
    TreeNode q1 = findNode(root1, 8);
    TreeNode lca1 = lowestCommonAncestor(root1, p1, q1);
    System.out.println(lca1.val);  // 6

    // 예제 2
    TreeNode p2 = findNode(root1, 2);
    TreeNode q2 = findNode(root1, 4);
    TreeNode lca2 = lowestCommonAncestor(root1, p2, q2);
    System.out.println(lca2.val);  // 2

    // 예제 3
    TreeNode root3 = new TreeNode(2);
    root3.left = new TreeNode(1);
    TreeNode p3 = findNode(root3, 2);
    TreeNode q3 = findNode(root3, 1);
    TreeNode lca3 = lowestCommonAncestor(root3, p3, q3);
    System.out.println(lca3.val);  // 2
  }

  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }

    if (p.val < root.val && q.val < root.val) {
      return lowestCommonAncestor(root.left, p, q);
    }
    if (p.val > root.val && q.val > root.val) {
      return lowestCommonAncestor(root.right, p, q);
    }
    return root;
  }

  private static TreeNode findNode(TreeNode root, int val) {
    if (root == null) {
      return null;
    }
    if (root.val == val) {
      return root;
    }
    if (val < root.val) {
      return findNode(root.left, val);
    } else {
      return findNode(root.right, val);
    }
  }
}
