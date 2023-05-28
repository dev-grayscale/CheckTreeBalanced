import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

  @Test
  public void test() {
    Assertions.assertFalse(Main.isBalanced(null));

    Node a = new Node(10);
    Assertions.assertTrue(Main.isBalanced(a));

    Node b = new Node(1);
    a.left = b;

    /**
     *    a
     *  b
     */
    Assertions.assertTrue(Main.isBalanced(a));

    Node c = new Node(2);
    b.left = c;

    /**
     *     a
     *   b
     * c
     */
    Assertions.assertFalse(Main.isBalanced(a));

    Node d = new Node(3);
    a.right = d;

    /**
     *     a
     *   b   d
     * c
     */
    Assertions.assertTrue(Main.isBalanced(a));

    Node e = new Node(4);
    b.right = e;

    /**
     *      a
     *   b     d
     * c   e
     */
    Assertions.assertTrue(Main.isBalanced(a));

    Node f = new Node(5);
    e.left = f;

    /**
     *        a
     *    b      d
     * c     e
     *     f
     */
    Assertions.assertFalse(Main.isBalanced(a));

    Node g = new Node(6);
    d.right = g;

    /**
     *      a
     *   b     d
     * c   e      g
     *    f
     */
    Assertions.assertTrue(Main.isBalanced(a));

    Node h = new Node(7);
    g.right = h;

    /**
     *      a
     *   b     d
     * c   e      g
     *    f         h
     */
    Assertions.assertFalse(Main.isBalanced(a));

    Node i = new Node(7);
    h.right = i;

    /**
     *      a
     *   b     d
     * c   e      g
     *    f          h
     *                  i
     */
    Assertions.assertFalse(Main.isBalanced(a));

    Node j = new Node(8);
    h.left = j;

    /**
     *       a
     *   b      d
     * c   e       g
     *    f           h
     *             j     i
     */
    Assertions.assertFalse(Main.isBalanced(a));

    Node k = new Node(9);
    g.left = k;

    /**
     *       a
     *   b       d
     * c   e        g
     *    f      k     h
     *               j   i
     */
    Assertions.assertFalse(Main.isBalanced(a));

    Node l = new Node(11);
    d.left = l;

    /**
     *         a
     *   b          d
     * c   e    l       g
     *    f          k     h
     *                   j   i
     */
    Assertions.assertFalse(Main.isBalanced(a));

    Node m = new Node(12);
    l.right = m;

    /**
     *          a
     *   b            d
     * c   e     l         g
     *    f        m    k     h
     *                      j   i
     */
    Assertions.assertTrue(Main.isBalanced(a));
  }
}
