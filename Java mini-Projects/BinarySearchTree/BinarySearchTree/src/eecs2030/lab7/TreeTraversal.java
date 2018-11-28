package eecs2030.lab7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * A utility class that provides methods for traversing a binary search tree.
 *
 */
public class TreeTraversal {
	private TreeTraversal() {
	}

	/**
	 * Returns the list of strings formed by traversing the specified tree using an
	 * inorder traversal.
	 * 
	 * @param tree
	 *            a binary search tree
	 * @return the list of strings formed by traversing the specified tree using an
	 *         inorder traversal
	 */
	public static List<String> inorder(BinarySearchTree<String> tree) {
		return TreeTraversal.inorder(tree.root());
	}

	/**
	 * Returns the list of strings formed by traversing the specified tree using a
	 * preorder traversal.
	 * 
	 * @param tree
	 *            a binary search tree
	 * @return the list of strings formed by traversing the specified tree using a
	 *         preorder traversal
	 */
	public static List<String> preorder(BinarySearchTree<String> tree) {
		return TreeTraversal.preorder(tree.root());
	}

	/**
	 * Returns the list of strings formed by traversing the specified tree using a
	 * postorder traversal.
	 * 
	 * @param tree
	 *            a binary search tree
	 * @return the list of strings formed by traversing the specified tree using a
	 *         postorder traversal
	 */
	public static List<String> postorder(BinarySearchTree<String> tree) {
		return TreeTraversal.postorder(tree.root());
	}

	/**
	 * Returns the list of strings formed by traversing the specified tree using a
	 * breadth first traversal. The traversal visits nodes of the tree starting at
	 * the root moving left to right for each level of the tree.
	 * 
	 * @param tree
	 *            a binary search tree
	 * @return the list of strings formed by traversing the specified tree using a
	 *         breadth first traversal
	 */
	public static List<String> breadthFirst(BinarySearchTree<String> tree) {
		List<String> finalResult = new ArrayList<>();
		INode<String> root = tree.root();
		if (root == null) {
			return finalResult;
		}
		
		Queue<INode<String>> que = new LinkedList<>();

		que.add(root);
		while (!(que.isEmpty())) {

			root = que.element();
			que.remove(root);

			finalResult.add(root.data());

			if (root.left() != null) {
				que.add(root.left());
			}

			if (root.right() != null) {
				que.add(root.right());
			}
		}
		return finalResult;
	}

	/**
	 * Returns the list of strings formed by traversing a tree having the specified
	 * root using an inorder traversal.
	 * 
	 * @param root
	 *            the root of the tree
	 * @return the list of strings formed by traversing a tree having the specified
	 *         root using an inorder traversal
	 */
	private static List<String> inorder(INode<String> root) {
		List<String> finalResult = new ArrayList<>();

		if (root == null) {
			return finalResult;
		}

		if (root.left() == null && root.right() == null) {
			finalResult.add(root.data());
			return finalResult;
		}

		finalResult.addAll(TreeTraversal.inorder(root.left()));
		finalResult.add(root.data());
		finalResult.addAll(TreeTraversal.inorder(root.right()));

		return finalResult;
	}

	/**
	 * Returns the list of strings formed by traversing a tree having the specified
	 * root using a preorder traversal.
	 * 
	 * @param root
	 *            the root of the tree
	 * @return the list of strings formed by traversing a tree having the specified
	 *         root using a preorder traversal
	 */
	private static List<String> preorder(INode<String> root) {
		List<String> finalResult = new ArrayList<>();

		if (root == null) {
			return finalResult;
		}

		if (root.left() == null && root.right() == null) {
			finalResult.add(root.data());
			return finalResult;
		}

		finalResult.add(root.data());
		finalResult.addAll(TreeTraversal.preorder(root.left()));
		finalResult.addAll(TreeTraversal.preorder(root.right()));

		return finalResult;
	}

	/**
	 * Returns the list of strings formed by traversing a tree having the specified
	 * root using a postorder traversal.
	 * 
	 * @param root
	 *            the root of the tree
	 * @return the list of strings formed by traversing a tree having the specified
	 *         root using a postorder traversal
	 */
	private static List<String> postorder(INode<String> root) {
		List<String> finalResult = new ArrayList<>();

		if (root == null) {
			return finalResult;
		}

		if (root.left() == null && root.right() == null) {
			finalResult.add(root.data());
			return finalResult;
		}

		finalResult.addAll(TreeTraversal.postorder(root.left()));
		finalResult.addAll(TreeTraversal.postorder(root.right()));
		finalResult.add(root.data());

		return finalResult;
	}

}