package lists;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListTests {

	@Test
	public void testAdd() {
		List<Integer> l = new SinglyLinkedList<Integer>();

		for (int i = 0; i < 2; i++) {
			l.add(i);
		}

		for (int i = 0; i < 2; i++) {
			int item = l.get(i);
			assertEquals(i, item);
		}

	}

	@Test
	public void testAddAtPos() {
		List<Integer> l = new SinglyLinkedList<Integer>();

		for (int i = 0; i < 2; i++) {
			l.add(i, i);
		}

		for (int i = 0; i < 2; i++) {
			int item = l.get(i);
			assertEquals(i, item);
		}

	}

	@Test
	public void testRemove() {
		List<Integer> l = new SinglyLinkedList<Integer>();

		for (int i = 0; i < 5; i++) {
			l.add(i);
		}
		assertEquals(5, l.size());

		for (int i = 0; i < 2; i++) {
			l.remove(0);
		}

		assertEquals(3, l.size());
		assertEquals(2, (int) l.get(0));

	}

	@Test
	public void testArrayAsListIterator() {
		List<Integer> l = new ArrayAsList<Integer>();

		assertFalse(l.iterator().hasNext());

		for (int i = 0; i < 4; i++)
			l.add(i);

		int i = 0;
		while (l.iterator().hasNext()) {
			assertEquals(i,(int)l.iterator().next());
			i++;
		}

	}
	
	@Test
	public void testLinkedListAsListIterator() {
		List<Integer> l = new SinglyLinkedList<Integer>();

		assertFalse(l.iterator().hasNext());

		for (int i = 0; i < 4; i++)
			l.add(i);

		int i = 0;
		while (l.iterator().hasNext()) {
			assertEquals(i,(int)l.iterator().next());
			i++;
		}

	}

}
