package lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayAsList<T> implements List<T> {

	// List items are indexed 0 to size -1 but length is size +1
	final static int INIT_SIZE = 10;

	Object[] items = new Object[INIT_SIZE];
	ListIterator<T> itr = null;
	
	int size = 0;

	public void add(T item) {
		if (item == null)
			throw new IllegalArgumentException();

		if (size == (items.length))
			resize();
		items[size++] = item;
	}

	private void resize() {

		Object[] newSpace = new Object[items.length * 2];
		for (int i = 0; i < items.length; i++)
			newSpace[i] = items[i];
		items = newSpace;
	}

	@SuppressWarnings("unchecked")
	public T get(int pos) {
		if (pos < 0 || pos > size)
			throw new NoSuchElementException();

		return (T) items[pos];
	}

	public int size() {
		return size;
	}

	public void remove(int pos) {

		for (int i = pos; i < size; i++)
			items[i] = items[i + 1];

		size--;

	}

	public void add(T item, int pos) {

		if (pos < 0 || pos > size)
			throw new NoSuchElementException();

		if (item == null)
			throw new IllegalArgumentException();

		if (size == items.length)
			resize();
		
		//what about inserting at the end or beginning?

		for (int i = pos; i < size; i++)
			items[i + 1] = items[i];

		items[pos] = item;
		size++;

	}

	
	public Iterator<T> iterator() {

		return ((itr == null)? itr = new ListIterator<T>(this) : itr);
	}

	public void printList() {
		// TODO Auto-generated method stub
		
	}

}
