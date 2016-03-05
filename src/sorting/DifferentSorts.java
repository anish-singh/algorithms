package sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class DifferentSorts {

	int [] a;
	
	public DifferentSorts(int [] input) {
		this.a = input;
	}
	
	//https://www.youtube.com/watch?v=xhr26ia4k38
	public int [] radixSort()
	{
		
		int radix = 10;
		
		//get the number of digits in the max # in the list to sort.

		int max = 0;
		for(int i=0; i < a.length;i++)
			if(a[i] > max) max = a[i];		
		int maxDigits = Integer.toString(max).length();
		
		for(int e=1; e <= maxDigits; e++)
		{
			ArrayList<ArrayList<Integer>>  list = new ArrayList<ArrayList<Integer>> (radix);
			for(int i=0; i < radix;i++)
				list.add(new ArrayList<Integer>());
			
			for(int i=0; i < a.length;i++)
			{
				int modBy = (int)Math.pow(radix,e);
				int divBy = (int)Math.pow(radix, (e-1));
				int index = (a[i] % modBy) / divBy;
				list.get(index).add(a[i]);	
			}
			
			//now put the elements in the list back into a.
			int index = 0;
			for(ArrayList<Integer> n: list)
			{
				for(Integer num : n)
					a[index++] = num;
			}
		}
		
		return a;

		
	}
	
	//How you sort a deck of cards in your hand
	public int [] insertionSort()
	{
		for(int i=1; i < a.length; i++)
		{
			int currElement = a[i];
			
			int j;
			for(j=(i-1); j>=0;j--)
			{
				if(a[j] > currElement)  a[j+1] = a[j];
				else break;
			}
			a[j+1] = currElement;
		}
		
		return a;
	}
	
	//in each iteration find the min element and put it in right place
	public int [] selectionSort()
	{
		for(int i=0; i < (a.length -1); i++)
		{
			for(int j=i+1;j< a.length;j++)
			{
				if(a[j] < a[i])
				{
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}  
		}
		
		return a;
	}
	
	//in each iteration bubble the max element to the top
	public int [] bubbleSort()
	{
		
		//loop Down to 0 from last but one element
		for(int i=(a.length-2); i >=0; i--)
		{
			for(int j=0; j<=i;j++)
			{
				if(a[j] > a[j+1])
				{
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		return a;
	}
	
	public static void main(String[] args) {
		
		int a[] = new int [] {3,2,1};
		
		System.out.println("Input:" + Arrays.toString(a));
		DifferentSorts m = new DifferentSorts(a);
		System.out.println("Output:" + Arrays.toString(m.insertionSort()));
	}
}
