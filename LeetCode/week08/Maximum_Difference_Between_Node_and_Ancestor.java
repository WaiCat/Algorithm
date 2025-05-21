package Algorithm.LeetCode.week08;

public class Maximum_Difference_Between_Node_and_Ancestor {

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(8);
    root1.left = new TreeNode(3);
    root1.right = new TreeNode(10);
    root1.left.left = new TreeNode(1);
    root1.left.right = new TreeNode(6);
    root1.left.right.left = new TreeNode(4);
    root1.left.right.right = new TreeNode(7);
    root1.right.right = new TreeNode(14);
    root1.right.right.left = new TreeNode(13);

    System.out.println("Output: " + maxAncestorDiff(root1));  //7

    TreeNode root2 = new TreeNode(1);
    root2.right = new TreeNode(2);
    root2.right.right = new TreeNode(0);
    root2.right.right.left = new TreeNode(3);

    System.out.println("Output: " + maxAncestorDiff(root2));  //3
  }

  public static int maxAncestorDiff(TreeNode root) {
    return dfs(root, root.val, root.val);
  }

  private static int dfs(TreeNode node, int curMin, int curMax) {
    if (node == null) {
      return curMax - curMin;
    }

    // 현재 노드 값 기준으로 min/max 갱신
    curMin = Math.min(curMin, node.val);
    curMax = Math.max(curMax, node.val);

    // 좌우 서브트리에서 최대 차이 탐색
    int left = dfs(node.left, curMin, curMax);
    int right = dfs(node.right, curMin, curMax);

    return Math.max(left, right);
  }

}
