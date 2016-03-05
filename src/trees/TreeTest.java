package trees;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TreeTest {
	
	
	@Test
	public void testAVLTree()
	{
		AVLTree t = new AVLTree();
		t.insert(1);
		t.insert(2);
		
		assertTrue(t.lookup(1));
		assertTrue(t.lookup(2));
		assertFalse(t.lookup(5));
	}
	
	@Test
	public void testTree()
	{
		BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();
		t.insert(1);
		t.insert(6);
		t.insert(5);
		t.insert(3);
		t.insert(2);
		t.insert(4);

		
		assertTrue(t.lookup(1));
		assertTrue(t.lookup(2));
		
		t.delete(1);
		assertFalse(t.lookup(1));
		assertTrue(t.lookup(2));
		t.delete(2);
		assertFalse(t.lookup(2));
				
	}
	
	@Test
	public void testSortWithBST()
	{
		int [] unsorted = new int [] {1,3,2};
		BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();
		for(int i=0;i < unsorted.length;i++)
			t.insert(unsorted[i]);
		
		List<Integer> sorted = new ArrayList<Integer>();
		t.sort(sorted);
		
		Arrays.sort(unsorted);
		System.out.println(Arrays.toString(unsorted));
		for(int i=0;i<unsorted.length;i++)
			assertEquals((int)sorted.get(i), unsorted[i]);
		
		t.bfsTraversal();
				
	}
	
	@Test
	public void testTrie()
	{
	        Trie tree = new Trie();
	        
	        String[] words = {"an", "ant", "all", "allot", "alloy", "aloe", "are", "ate", "be"};
//	        String [] words = {"a","an"};
	        for (int i = 0; i < words.length; i++)
	            tree.addWord(words[i]);
	        
//	        tree.print();
	        
	        assertTrue(tree.find("an"));
	        assertFalse(tree.find("hello"));
//	        
	    }

}
