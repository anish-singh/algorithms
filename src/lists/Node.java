package lists;

public class Node<T> {

	public Node(Node<T> next, T data) {
		super();
		this.next = next;
		this.data = data;
	}

	public Node(T data) {
		super();
		this.data = data;
		this.next = null;
	}

	private Node<T> next;
	private T data;

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
