/**
 * How to determine if a binary tree is height-balanced?
 *
 * (Challenge definition seen in Cracking the coding interview book.)
 *
 * A height-balanced tree is a binary tree in which the height of the left subtree and right subtree of any node does not
 * differ by more than 1 and both the left and right subtree are also height balanced.
 *
 * For this challenge, we'll assume the following Tree Node structure:
 *
 * public class Node {
 *   public int value;
 *   public Node left;
 *   public Node right;
 *
 *   public Node(int value) {
 *     this.value = value;
 *   }
 * }
 *
 * Following the definition of a balanced tree given above, we need to check if any parent node has a difference > 1 for any
 * children (subtree) height/depth. If at least 1 such occurrence is found (regardless of the position) the tree is not balanced.
 *
 * One way to solve this problem is to find a traversal algorithm that visits the parent node first (<link>to BinaryTreeTraversal#pre-order</link>)
 * and then get the heights of the left and right subtrees. If their difference is bigger than 1 -> not balanced tree, otherwise recursively call the same method
 * for each subtree. This approach would result to taking almost the same path many times (excluding parent nodes as we go).
 *
 * We could come up with a recursive solution that initially reaches the bottom and then starts calculating the height for each subtree and if at any point
 * the validity check fails (children difference height > 1), we halt any further actions and propagate the result to the top.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(log n) - allocated frames due to recursion
 */
public class Main {
  public static boolean isBalanced(Node node) {
    // Assume that if node == null -> not balanced
    return getHeight(node) > 0;
  }

  private static int getHeight(Node node) {
    if (node == null) {
      return 0;
    }

    int left;
    int right;

    if ((left = getHeight(node.left)) == -1 || (right = getHeight(node.right)) == -1) {
      return -1;
    }

    if (Math.abs(left - right) > 1) {
      return -1;
    }

    return Math.max(left, right) + 1;
  }
}
