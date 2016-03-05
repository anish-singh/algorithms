package lists;

import java.util.NoSuchElementException;

public class LinkedListAsStack<T> implements Stack<T> {

	Node<T> head;
	Node<T> tail;
	int size;

	public T pop() {
		if (size == 0)
			throw new NoSuchElementException();

		Node<T> tmp = head;

		if (size == 1) {
			head = tail = null;
			size--;
			return tmp.getData();

		}
		while (tmp.getNext() != tail)
			tmp.getNext();
		T data = tail.getData();
		tmp.setNext(null);
		tail = tmp;
		size--;
		return data;
	}

	public void push(T item) {

		if (item == null)
			throw new NullPointerException();

		Node<T> n = new Node<T>(item);

		if (head == null)
			head = tail = n;
		else {
			tail.setNext(n);
			tail = n;
		}
		size++;

	}

	public T peek() {
		if (size == 0)
			throw new NoSuchElementException();

		// otherwise get data at tail;
		return tail.getData();
	}

	public int getSize()
	{
		return size;
	}
	
}
