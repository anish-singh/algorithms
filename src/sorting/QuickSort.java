package sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	int a[];

	//http://algs4.cs.princeton.edu/23quicksort/Quick.java.html
	public QuickSort() {

	}

	public int[] quickSort(int[] input) {
		if (input == null || input.length == 0)
			return null;

		this.a = input;
		shuffle();

		sort(0, a.length - 1);
		return a;
	}

	private void shuffle() {
		Random r = new Random();
		System.out.println("Before:" + Arrays.toString(a));

		for (int i = a.length - 1; i > 0; i--) {
			int shuffleIndex = r.nextInt(i);
			swap(a, i, shuffleIndex);
		}

		System.out.println("Shuffled:" + Arrays.toString(a));

	}

	private void swap(int[] a2, int i, int j) {

		int tmp = a2[i];
		a2[i] = a[j];
		a[j] = tmp;
	}

	private void sort(int start, int end) {

		if (end <= start)
			return;

		int partitionIndex = partition(start, end);

		sort(start, partitionIndex);
		sort(partitionIndex + 1, end);
	}

	private int partition(int start, int end) {
		// pick partition element
		int pivot = start;
		int left = start;

		int right = end+1;

		while (true) {
			
			while(a[++left] < a[pivot])
			{
				if(left == end) break;
			}
			
			while(a[--right] > a[pivot])
			{
				if(right == start) break;
			}
			
			if(left >= right) break;
			swap(a, left, right);
		}

		swap(a, pivot, right);
		return right;
	}

	public static void main(String[] args) throws Exception {
		int[] input = new int[] { -3,-9,-10,3,2,1};
		QuickSort q = new QuickSort();
		System.out.println(Arrays.toString(q.quickSort(input)));
	}

}
