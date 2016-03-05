package trees;

public class BinarySearchTreeNode<T extends Comparable<T>> {

	public BinarySearchTreeNode(BinarySearchTreeNode<T> left,
			BinarySearchTreeNode<T> right, T key) {
		super();
		this.left = left;
		this.right = right;
		this.key = key;
	}

	public BinarySearchTreeNode(T key) {
		super();
		this.key = key;
		left = null;
		right = null;
	}

	private BinarySearchTreeNode<T> left;
	private BinarySearchTreeNode<T> right;
	private T key;

	public BinarySearchTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinarySearchTreeNode<T> left) {
		this.left = left;
	}

	public BinarySearchTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinarySearchTreeNode<T> right) {
		this.right = right;
	}

	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}

}
