package lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements List<T> {

	Node<T> head = null;

	int size;
	ListIterator<T> itr=null;

	public void add(T item) {

		Node<T> n = new Node<T>(item);
		if (head == null)
			head = n;
		else {
			Node<T> t = head;
			while (t.getNext() != null)
				t = t.getNext();

			t.setNext(n);

		}

		size++;

	}

	private Node<T> getItemAtPosition(int pos) {
		// traverse the list until pos.
		if (pos < 0 || pos >= size)
			throw new NoSuchElementException();

		Node<T> temp = head;
		if (pos == 0)
			return head;

		// loop until pos -1. getNext of pos - 1 node
		for (int i = 0; i < pos; i++) {
			temp = temp.getNext();
		}

		return temp;
	}

	/**
	 * pos can be 0 to size -1
	 */
	public T get(int pos) {

		Node<T> n = getItemAtPosition(pos);
		return n.getData();

	}

	/**
	 * One more than the last index.
	 */
	public int size() {
		return size;
	}

	/**
	 * Pos is 0 to size -1
	 */
	public void remove(int pos) {
		if (pos < 0 || pos >= size)
			throw new NoSuchElementException();

		if (pos == 0) {
			head = head.getNext();
		} else {

			Node<T> n = getItemAtPosition(pos - 1);
			n.setNext(n.getNext().getNext());
		}
		size--;

	}

	// Add At Pos
	public void add(T item, int pos) {
		if (pos < 0 || pos > size)
			throw new NoSuchElementException();

		Node<T> n = new Node<T>(item);
		if (pos == 0) {
			n.setNext(head);
			head = n;
		} else if (pos == size) {
			Node<T> t = getItemAtPosition(pos - 1);
			t.setNext(n);
		} else {
			Node<T> t = getItemAtPosition(pos - 1);
			n.setNext(t.getNext());
			t.setNext(n);
		}
		size++;
	}
	
	public Iterator<T> iterator() {

		return ((itr == null)? itr = new ListIterator<T>(this) : itr);
	}

	public void printList() {
		if(head != null)
		{
			Node n = head;
			while(n.getNext() != null)
			{
				System.out.println(n.getData() + ",");
				n = n.getNext();
			}
			System.out.println(n.getData());
		}
	}

}
