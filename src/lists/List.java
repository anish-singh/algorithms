package lists;

import java.util.Iterator;

public interface List<T> {

	public void add(T item);
	
	public void add(T item, int pos);

	public T get(int pos);

	public int size();

	public void remove(int pos);
	
	public Iterator<T> iterator();
	
	public void printList();

}
