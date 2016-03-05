package lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator<E> implements Iterator<E> {
	
	int currPos;
	List<E> list;
	
	public ListIterator(List<E> l)
	{
		this.list = l;
		currPos = 0;
	}
	

	public boolean hasNext() {
		return (currPos < list.size());
	}

	public E next() {
		if(!hasNext()) throw new NoSuchElementException();
		
		E item = list.get(currPos++);
		return item;
	}


	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
