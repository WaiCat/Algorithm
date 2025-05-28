package Algorithm.LeetCode.Week09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Same_Tree {

  public static void main(String[] args) {
    // Example 1: p = [1,2,3], q = [1,2,3]
    TreeNode p1 = new TreeNode(1,
        new TreeNode(2),
        new TreeNode(3));
    TreeNode q1 = new TreeNode(1,
        new TreeNode(2),
        new TreeNode(3));
    System.out.println("Example 1 Output: " + isSameTree(p1, q1));  // true

    // Example 2: p = [1,2], q = [1,null,2]
    TreeNode p2 = new TreeNode(1,
        new TreeNode(2),
        null);
    TreeNode q2 = new TreeNode(1,
        null,
        new TreeNode(2));
    System.out.println("Example 2 Output: " + isSameTree(p2, q2));  // false

    // Example 3: p = [1,2,1], q = [1,1,2]
    TreeNode p3 = new TreeNode(1,
        new TreeNode(2),
        new TreeNode(1));
    TreeNode q3 = new TreeNode(1,
        new TreeNode(1),
        new TreeNode(2));
    System.out.println("Example 3 Output: " + isSameTree(p3, q3));  // false
  }

  public static boolean isSameTree(TreeNode p, TreeNode q) {
    List<Integer> list1 = bfs(p);
    List<Integer> list2 = bfs(q);

    return list1.equals(list2);
  }


  public static List<Integer> bfs(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    if (root != null) {
      queue.add(root);
    }

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node == null) {
        list.add(null);
        continue;
      }
      list.add(node.val);

      queue.offer(node.left);
      queue.offer(node.right);
    }
    return list;
  }
}
