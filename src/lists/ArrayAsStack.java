package lists;

public class ArrayAsStack<T> implements Stack<T> {

	private final int INIT_SIZE = 10;

	@SuppressWarnings("unchecked")
	T[] items = (T[]) new Object[INIT_SIZE];
	int size = 0;

	public T pop() {

		if (getSize() < getMinSize())
			throw new IndexOutOfBoundsException();

		return items[--size];

	}

	public void push(T item) {

		if(item == null) throw new NullPointerException();

		if(getSize() == getMaxSize())
			resize();
			
			
		items[size++] = item;
	}

	public T peek() {
		if (getSize() == 0)
			throw new IndexOutOfBoundsException();

		return items[size-1];
	}

	public int getSize() {
		return size;
	}
	
	private int getMinSize()
	{
		return 0;
	}
	
	private int getMaxSize()
	{
		return items.length;
	}
	
	private void resize()
	{
		int newSize = getSize() *2;
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[newSize];
		
		for(int i=0;i<getSize();i++)
			temp[i] = items[i];
		
		items = temp;
	}

}
