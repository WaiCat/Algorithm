package Algorithm.LeetCode.week08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Zigzag_Level_Order_Traversal {

  public static void main(String[] args) {
    // 예시 1: [3,9,20,null,null,15,7]
    TreeNode tree1 = new TreeNode(3,
        new TreeNode(9),
        new TreeNode(20,
            new TreeNode(15),
            new TreeNode(7))
    );
    System.out.println("Output 1: " + zigzagLevelOrder(tree1));

    // 예시 2: [1]
    TreeNode tree2 = new TreeNode(1);
    System.out.println("Output 2: " + zigzagLevelOrder(tree2));

    // 예시 3: []
    TreeNode tree3 = null;
    System.out.println("Output 3: " + zigzagLevelOrder(tree3));
  }

  public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    if (root != null) {
      queue.add(root);

    }
    boolean reverse = false;

    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        list.add(node.val);
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      if (reverse) {
        Collections.reverse(list);
        reverse = false;
      } else {
        reverse = true;
      }
      result.add(list);
    }
    return result;
  }
}
