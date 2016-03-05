package lists;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackTest {

	@Test
	public void testArrayAsStack() {
		ArrayAsStack<Integer> s = new ArrayAsStack<Integer>();

		assertEquals(0, s.getSize());

		s.push(1);
		s.push(2);

		assertEquals(2, s.getSize());

		assertEquals(2, (int) s.peek());
		assertEquals(2, (int) s.pop());

		assertEquals(1, s.getSize());
		assertEquals(1, (int) s.pop());
		assertEquals(0, s.getSize());

	}
	
	@Test
	public void testLinkedListAsStack() {
		LinkedListAsStack<Integer> s = new LinkedListAsStack<Integer>();

		assertEquals(0, s.getSize());

		s.push(1);
		s.push(2);

		assertEquals(2, s.getSize());

		assertEquals(2, (int) s.peek());
		assertEquals(2, (int) s.pop());

		assertEquals(1, s.getSize());
		assertEquals(1, (int) s.pop());
		assertEquals(0, s.getSize());

	}
}
