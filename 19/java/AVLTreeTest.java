import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import java.util.Random;
import org.junit.Test;
public class AVLTreeTest {

	@Test
	public void testMax() {
		AVLTree test_m = new AVLTree();
		int a = 5;
		int b = 10;
		Node r = new Node(1);
		Node r1 = new Node(2);
		Node r2 = new Node(3);
		test_m.insert(r, 5);
		test_m.insert(r1, 10);
		test_m.insert(r2, 2);

		//calclate max

		assertEquals("max is not right for integer entered", b, test_m.max(a, b));
	}

	@Test
	public void testNull() {
		AVLTree t = new AVLTree();
		Node r = new Node(1);
		Node l = new Node(1);
		int k = 1;
		if (l.equals(r))
			assertNull("node is 1", l);
		else
			assertEquals("node is not right", l, t.insert(l, l.key));

		//else
		//assertEquals("node isn't null",r,t.insert(r,r.key));
	}

	@Test
	public void testHeight() {
		AVLTree test_m = new AVLTree();
		int a = 5;
		int b = 10;
		Node r = new Node(1);
		Node r1 = new Node(2);
		Node r2 = new Node(3);
		test_m.insert(test_m.root, 5);
		test_m.insert(r1, 10);
		test_m.insert(r2, 2);

		int height_expected = 2;
		int height_actual = test_m.height(r2);


		assertEquals("getHeightTree isn't correct", height_expected, height_actual);

	}

	@Test
	public void testInsertRoot() {
		AVLTree test_tree = new AVLTree();

		test_tree.root = test_tree.insert(test_tree.root, 5);
		test_tree.root = test_tree.insert(test_tree.root, 10);
		test_tree.root = test_tree.insert(test_tree.root, 2);
		test_tree.root = test_tree.insert(test_tree.root, 15);
		test_tree.root = test_tree.insert(test_tree.root, 17);
		test_tree.root = test_tree.insert(test_tree.root, 28);
		test_tree.root = test_tree.insert(test_tree.root, 13);

		//test_tree.preOrder(test_tree.root);

		//order 15 5 2 10 13 17 28
		int max_balance_expected = 1;
		//int balance_actual = test_tree.getBalance(r3);
		assertEquals("Root is not right", 15, test_tree.root.key);
	}

	@Test
	public void testBalance() {
		AVLTree test_tree = new AVLTree();

		test_tree.root = test_tree.insert(test_tree.root, 5);
		test_tree.root = test_tree.insert(test_tree.root, 10);
		test_tree.root = test_tree.insert(test_tree.root, 2);
		test_tree.root = test_tree.insert(test_tree.root, 15);
		test_tree.root = test_tree.insert(test_tree.root, 17);
		test_tree.root = test_tree.insert(test_tree.root, 28);
		test_tree.root = test_tree.insert(test_tree.root, 13);

		int max_balance_expected = 1;
		int balance_expected = test_tree.getBalance(test_tree.root);
		assertEquals("Balance is not right", max_balance_expected, balance_expected);
	}

	@Test
	public void testLeftRotation() {
		AVLTree test_tree = new AVLTree();

		test_tree.root = test_tree.insert(test_tree.root, 5);
		test_tree.root = test_tree.insert(test_tree.root, 10);
		test_tree.root = test_tree.insert(test_tree.root, 2);

		Node originalRoot = test_tree.root.right;
		Node returnedNode = test_tree.leftRotate(test_tree.root);


		assertEquals("Left Rotation not correct", originalRoot.key, returnedNode.key);

	}
	@Test
	public void testRightRotation() {
		AVLTree test_tree = new AVLTree();

		test_tree.root = test_tree.insert(test_tree.root, 5);
		test_tree.root = test_tree.insert(test_tree.root, 10);
		test_tree.root = test_tree.insert(test_tree.root, 2);

		Node originalRoot = test_tree.root.left;
		Node returnedNode = test_tree.rightRotate(test_tree.root);


		assertEquals("Right Rotation not correct", originalRoot.key, returnedNode.key);

	}
}