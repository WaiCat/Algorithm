package Algorithm.LeetCode.Week09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Invert_Binary_Tree {

  public static void main(String[] args) {
    // Example 1: root = [4,2,7,1,3,6,9]
    TreeNode root1 = new TreeNode(4,
        new TreeNode(2,
            new TreeNode(1),
            new TreeNode(3)),
        new TreeNode(7,
            new TreeNode(6),
            new TreeNode(9)));
    TreeNode inverted1 = invertTree(root1);
    System.out.println("Output: " + invertTree(inverted1));

    // Example 2: root = [2,1,3]
    TreeNode root2 = new TreeNode(2,
        new TreeNode(1),
        new TreeNode(3));
    TreeNode inverted2 = invertTree(root2);
    System.out.println("Output: " + invertTree(inverted2));

    // Example 3: root = []
    TreeNode root3 = null;
    TreeNode inverted3 = invertTree(root3);
    System.out.println("Output: " + invertTree(inverted3));
  }

  public static TreeNode invertTree(TreeNode root) {
    List<Integer> list = bfs(root);
    if (list == null || list.isEmpty() || list.get(0) == null) {
      return null;
    }

    TreeNode reroot = new TreeNode(list.get(0));
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(reroot);

    int i = 1;
    while (i < list.size()) {
      TreeNode current = queue.poll();

      Integer leftVal = list.get(i++);
      if (leftVal != null) {
        TreeNode leftNode = new TreeNode(leftVal);
        current.left = leftNode;
        queue.offer(leftNode);
      }

      if (i < list.size()) {
        Integer rightVal = list.get(i++);
        if (rightVal != null) {
          TreeNode rightNode = new TreeNode(rightVal);
          current.right = rightNode;
          queue.offer(rightNode);
        }
      }
    }

    return reroot;
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

      queue.offer(node.right);
      queue.offer(node.left);
    }
    return list;
  }
}
