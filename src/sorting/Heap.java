package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Heap<T extends Comparable<T>> {

	ArrayList<T> h = new ArrayList<T>();

	// for inserts
	private void siftUp() {
		int k = lastElementIndex();
		int p;

		while (k > 0) {
			p = (k - 1) / 2;
			// compare with parent. If greater than parent then swap.
			if (h.get(k).compareTo(h.get(p)) > 0)
				swap(k, p);
			else
				break;
			
			k=p;
		}

	}

	private void swap(int k, int p) {
		T temp = h.get(k);
		h.set(k, h.get(p));
		h.set(p, temp);
	}

	// for deletes
	private void siftDown() {
		int k=0;
		int l=1;
		int r=2;
		
		while(l <= lastElementIndex())
		{
			
			r=l+1;
			int maxIndex = l;
			
			if(r <= lastElementIndex())
			{
				// there is a right child and we need to do 2 compares
				maxIndex = (h.get(l).compareTo(h.get(r)) > 0) ? l : r;

			}
			if(h.get(k).compareTo(h.get(maxIndex)) < 0)
			{
				swap(k,maxIndex);
				k=maxIndex;
				l=2*k+1;
			}
			else
				break;
			
			
		}
	}

	public void add(T item) {
		// add to the end
		h.add(item);
		siftUp();
	}

	public T fetchMax() {
		if (h.size() == 0)
			return null;
		T max = (T) h.get(0);
		h.set(0, h.get(lastElementIndex()));
		h.remove(lastElementIndex());
		siftDown();
		return max;

	}
	
	public void printHeap()
	{
		System.out.println(h);
	}
	
	private int lastElementIndex()
	{
		return h.size()-1;
	}

	public static void main(String[] args) {
		Integer[] a = new Integer[] { 1, 2,3,4,5 };
		ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(a));
		

		System.out.println("Input:" + input);
		Heap<Integer> heap = new Heap<Integer>();
		for (Iterator<Integer> i = input.iterator(); i.hasNext();) {
			Integer item = (Integer) i.next();
			heap.add(item);
		}
		
		//Heap Sort
		ArrayList<Integer> sorted = new ArrayList<Integer>(a.length);
		for(int i=0;i<input.size();i++)
		{
			sorted.add(heap.fetchMax());
		}
		System.out.println("Sorted:" + sorted);



	}

}
