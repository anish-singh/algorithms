package sorting;

public class BinarySearch {

	public boolean binSearch(int A[], int val) {

		int lo, hi, mid;
		lo = 1;
		hi = A.length;

		while (lo <= hi) {
			mid = lo + (hi - lo) / 2;
			if (A[mid] == val)
				return true;
			else if (A[mid] < val)
				lo = mid + 1;
			else
				hi = mid - 1;
		}
		return false;
	}
}
