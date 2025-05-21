package Algorithm.LeetCode.week08;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Insert_into_a_Binary_Search_Tree {

  public static void main(String[] args) {

    // 예제 1: [4,2,7,1,3], val = 5
    TreeNode tree1 = new TreeNode(4,
        new TreeNode(2, new TreeNode(1), new TreeNode(3)),
        new TreeNode(7)
    );
    TreeNode result1 = insertIntoBST(tree1, 5);
    System.out.println("Output 1: " + levelOrder(result1));

    // 예제 2: [40,20,60,10,30,50,70], val = 25
    TreeNode tree2 = new TreeNode(40,
        new TreeNode(20, new TreeNode(10), new TreeNode(30)),
        new TreeNode(60, new TreeNode(50), new TreeNode(70))
    );
    TreeNode result2 = insertIntoBST(tree2, 25);
    System.out.println("Output 2: " + levelOrder(result2));

    // 예제 3: [4,2,7,1,3,null,null,null,null,null,null], val = 5
    TreeNode tree3 = new TreeNode(4,
        new TreeNode(2,
            new TreeNode(1), new TreeNode(3)),
        new TreeNode(7)
    );
    TreeNode result3 = insertIntoBST(tree3, 5);
    System.out.println("Output 3: " + levelOrder(result3));
  }

  public static TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }

    if (val < root.val) {
      root.left = insertIntoBST(root.left, val);
    } else {
      root.right = insertIntoBST(root.right, val);
    }

    return root;
  }

  public static List<Integer> levelOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node == null) {
        result.add(null);
      } else {
        result.add(node.val);
        queue.offer(node.left);
        queue.offer(node.right);
      }
    }

    int i = result.size() - 1;
    while (i >= 0 && result.get(i) == null) {
      result.remove(i);
      i--;
    }

    return result;
  }
}
