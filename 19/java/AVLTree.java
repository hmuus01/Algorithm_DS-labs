import java.util.*;
//AVL TREE CLASS
public class AVLTree { 
	//Initialize the Head Node also known as root
	Node root;

	//AVL TREE Constructor
	// public AVLTree(Node root) {
	// 	this.root = root;
	// }

	// getHeightTree method to retrieve the getHeightTree of a node
	public int getHeightTree(Node N) {
		if (N == null) 
			return 0; 

		return N.nodeHeight;
	} 

	/* getMax method takes two integers as a parameter a and b,
	   checks if a > b, if it is a is the max else b is the maximum value.
	   Purpose of this method is when deciding to do a left rotation
	   and a right rotation you need to check
	*/
	public int getMax(int a, int b) {
		int maxValue;
		if(a>b)
			maxValue = a;
		else
			maxValue = b;
		return maxValue;
	} 

	/*
	 
	 */
	public Node rightRotate(Node y) { 
		Node x = y.left; 
		Node T2 = x.right; 

		// Perform rotation 
		x.right = y; 
		y.left = T2; 

		// Update heights 
		y.nodeHeight = getMax(getHeightTree(y.left), getHeightTree(y.right)) + 1;
		x.nodeHeight = getMax(getHeightTree(x.left), getHeightTree(x.right)) + 1;

		// Return new root 
		return x; 
	} 

	// A utility function to left rotate subtree rooted with x 
	// See the diagram given above. 
	public Node leftRotate(Node x) { //5
		Node y = x.right; //10
		Node T2 = y.left; //2

		// Perform rotation 
		y.left = x; //5
		x.right = T2; //2

		// Update heights 
		x.nodeHeight = getMax(getHeightTree(x.left), getHeightTree(x.right)) + 1;
		y.nodeHeight = getMax(getHeightTree(y.left), getHeightTree(y.right)) + 1;

		// Return new root 
		return y; 
	} 

	// Get Balance factor of node N 
	public int getBalance(Node N) { 
		if (N == null)
			return 0;

		return getHeightTree(N.left) - getHeightTree(N.right);
	}

	public Node insert(Node node, int key) { 

		/* 1. Perform the normal BST insertion */
		if (node == null) 
			return (new Node(key)); 

		if (key < node.keyValue)
			node.left = insert(node.left, key); 
		else if (key > node.keyValue)
			node.right = insert(node.right, key); 
		else // Duplicate keys not allowed 
			return node; 

		/* 2. Update getHeightTree of this ancestor node */
		node.nodeHeight = 1 + getMax(getHeightTree(node.left),
							getHeightTree(node.right));

		/* 3. Get the balance factor of this ancestor 
			node to check whether this node became 
			unbalanced */
		int balance = getBalance(node); 

		// If this node becomes unbalanced, then there 
		// are 4 cases Left Left Case 
		if (balance > 1 && key < node.left.keyValue)
			return rightRotate(node); 

		// Right Right Case 
		if (balance < -1 && key > node.right.keyValue)
			return leftRotate(node); 

		// Left Right Case 
		if (balance > 1 && key > node.left.keyValue) {
			node.left = leftRotate(node.left); 
			return rightRotate(node); 
		} 

		// Right Left Case 
		if (balance < -1 && key < node.right.keyValue) {
			node.right = rightRotate(node.right); 
			return leftRotate(node); 
		} 

		/* return the (unchanged) node pointer */
		return node; 
	} 

	// A utility function to print preorder traversal 
	// of the tree. 
	// The function also prints getHeightTree of every node
	void preOrder(Node node, List<Integer> in) {
		if (node != null) { 
			//System.out.print(node.key + " ");
			in.add(node.keyValue);
			preOrder(node.left,in); 
			preOrder(node.right,in); 
		} 
	}
	public List<Integer> getTraversalList(Node node){
		List<Integer> list = new ArrayList<Integer>();
		preOrder(node, list);
		return list;
	}

	public static void main(String[] args) { 
		// AVLTree tree = new AVLTree(); 

		// /* Constructing tree given in the above figure */
		// tree.root = tree.insert(tree.root, 10); 
		// tree.root = tree.insert(tree.root, 20); 
		// tree.root = tree.insert(tree.root, 30); 
		// tree.root = tree.insert(tree.root, 40); 
		// tree.root = tree.insert(tree.root, 50); 
		// tree.root = tree.insert(tree.root, 25); 

		// /* The constructed AVL Tree would be 
		// 	30 
		// 	/ \ 
		//    20 40 
		//   / \  \ 
	 //     10 25 	50 
		// */
		// System.out.println("Preorder traversal" + 
		// 				" of constructed tree is : "); 
		// tree.preOrder(tree.root); 
		AVLTree test_tree = new AVLTree();

		// test_tree.root = test_tree.insert(test_tree.root,5);
		// test_tree.root = test_tree.insert(test_tree.root,10);
		// test_tree.root = test_tree.insert(test_tree.root,2);
		// test_tree.root = test_tree.insert(test_tree.root,15);
		// test_tree.root = test_tree.insert(test_tree.root,17);
		// test_tree.root = test_tree.insert(test_tree.root,28);
		// test_tree.root = test_tree.insert(test_tree.root,13);

		test_tree.root = test_tree.insert(test_tree.root,5);
		test_tree.root = test_tree.insert(test_tree.root,10);
		test_tree.root = test_tree.insert(test_tree.root,2);
		// test_tree.root = test_tree.insert(test_tree.root,13);
		// test_tree.root = test_tree.insert(test_tree.root,20);
		List<Integer> list1 = test_tree.getTraversalList(test_tree.root);
		System.out.println();
		for (int nodeKey: list1)
		{
			System.out.println(nodeKey);
		}
		
		Node missing = test_tree.leftRotate(test_tree.root);
		//System.out.println(test_tree.root.key);

		List<Integer> list = test_tree.getTraversalList(test_tree.root);
		System.out.println();
		for (int nodeKey: list)
		{
			System.out.println(nodeKey);
		}
		System.out.println(missing.keyValue);

	} 
} 
// This code has been contributed by Mayank Jaiswal 
