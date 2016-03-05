package sorting;

import java.util.Arrays;

//TODO Make this Generic.
public class MergeSort {
	
	int [] a;
	

	public MergeSort(int [] input)
	{
		//TODO add NULL Check here.
		this.a = input;
		
		
	}
	
	public int [] mergeSort()
	{
		sort(0, a.length-1);
		return a;
		
	}
	
	private void sort(int start, int end)
	{
		//split into two halves
		if(end <= start)
			return;
		
		int mid = (start+end)/2;
		
		sort(start, mid);
		sort(mid+1, end);
		
		//merge the results
		merge(start, mid, end);
		
	}
	
	
	private void merge(int start, int mid, int end) {
		//create a temp array to store the results

		int [] temp = new int[end+1];
		
		int left = start;
		int curr = start;
		int right = mid+1;
		
		while(left <= mid && right <= end)
		{
			if(a[left] < a[right])
				temp[curr++] = a[left++];
			else
				temp[curr++] = a[right++];
		}
		
		while(left<=mid)
			temp[curr++] = a[left++];
		while(right <=end)
			temp[curr++] = a[right++];
		
		for(int i=start;i<=end;i++)
			a[i]=temp[i];

	}

	public static void main(String[] args) {

		int a[] = new int [] {3,1,5,2,4};
		
		System.out.println("Input:" + Arrays.toString(a));
		MergeSort m = new MergeSort(a);
		System.out.println("Output:" + Arrays.toString(m.mergeSort()));
	}

}
