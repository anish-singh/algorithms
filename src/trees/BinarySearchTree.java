package trees;

import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {

	BinarySearchTreeNode<T> root = null;

	public boolean lookup(T key) {
		if (root == null)
			return false;
		if (key == null)
			throw new NullPointerException();

		return lookup(root, key);

	}

	private boolean lookup(BinarySearchTreeNode<T> n, T key) {
		if (n == null)
			return false;
		int comp = key.compareTo(n.getKey());
		if (comp == 0)
			return true;
		else if (comp < 0)
			return lookup(n.getLeft(), key);
		else
			return lookup(n.getRight(), key);
	}

	public void insert(T key) {
		if (key == null)
			throw new NullPointerException();

//		root = insert2(root, key);
		if (root == null)
			root = new BinarySearchTreeNode<T>(key);
		else
			insert(root, key);
	}

	private BinarySearchTreeNode<T> insert2(BinarySearchTreeNode<T> n, T key) {
		
		if(n == null)  return new BinarySearchTreeNode<T>(key);
		
		int comp = key.compareTo(n.getKey());
		if (comp == 0)
			throw new DuplicateException();
		else if (comp < 0) {
			n.setLeft(insert2(n.getLeft(), key));
		}
		else
			n.setRight(insert2(n.getRight(), key));
		
		return n;
		
	}
	
	private void insert(BinarySearchTreeNode<T> n, T key) {

		int comp = key.compareTo(n.getKey());
		if (comp == 0)
			throw new DuplicateException();
		else if (comp < 0) {
			if (n.getLeft() == null)
				n.setLeft(new BinarySearchTreeNode<T>(key));
			else
				insert(n.getLeft(), key);
		} else {
			if (n.getRight() == null)
				n.setRight(new BinarySearchTreeNode<T>(key));
			else
				insert(n.getRight(), key);
		}

	}

	public void delete(T key) {
		if (key == null)
			throw new NullPointerException();

		root = delete(root, key);
	}

	private BinarySearchTreeNode<T> delete(BinarySearchTreeNode<T> n, T key) {
		if (n == null)
			return null;

		int comp = key.compareTo(n.getKey());
		if (comp == 0) {
			// this node is to be deleted
			// case 1 no children
			if (n.getLeft() == null && n.getRight() == null)
				return null;

			// case 2 1 child
			if (n.getLeft() == null)
				return n.getRight();
			if (n.getRight() == null)
				return n.getLeft();

			// case 3 2 children
			BinarySearchTreeNode<T> s = smallest(n.getRight());
			n.setKey(s.getKey());
			n.setRight(delete(n.getRight(), s.getKey()));
			return n;
		} else if (comp < 0) {
			// node in left subtree needs to be deleted
			n.setLeft(delete(n.getLeft(), key));
			return n;
		} else {
			// node in right subtree needs to be deleted
			n.setRight(delete(n.getRight(), key));
			return n;
		}

	}

	private BinarySearchTreeNode<T> smallest(BinarySearchTreeNode<T> n) {
		while (n.getLeft() != null)
			n = n.getLeft();
		return n;
	}

	public void sort(List<T> output) {
		inOrderTraversal(root, output);
	}

	public void inOrderTraversal(BinarySearchTreeNode<T> n, List<T> output) {
		if (n == null)
			return;

		inOrderTraversal(n.getLeft(), output);
		output.add(n.getKey());
		inOrderTraversal(n.getRight(), output);
	}

	public void bfsTraversal() {
		LinkedList<BinarySearchTreeNode<T>> l = new LinkedList<BinarySearchTreeNode<T>>();

		l.add(root);

		while (l.size() > 0) {
			BinarySearchTreeNode<T> n = l.remove();
			System.out.println(n.getKey());

			if (n.getLeft() != null)
				l.add(n.getLeft());
			if (n.getRight() != null)
				l.add(n.getRight());
		}
	}

}
