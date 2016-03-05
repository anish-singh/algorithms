package lists;

import java.util.ArrayList;

public class CrackingProblems {

	public static void removeDuplicates(List<Integer> l)
	{
		ArrayList<Integer> found = new ArrayList<Integer>();
		
		//need to track 2 nodes at any given time.
		// n1  and n1->next.   if n1.next is contained in found list then delete n1.next
		
		
		//for each item in the list
		//    for each item in found
		//       if there is a match then the current node needs to be removed
		//			advance to n.next.next
		//		 else add to found.
		
		
		
		
		
	}
	public static void main(String[] args) {

		List<Integer> l = new SinglyLinkedList<Integer>();
		l.add(3);
		l.add(1);
		l.add(4);
		l.add(1);
		l.add(3);
		l.add(5);
		
		l.printList();
	}

}
