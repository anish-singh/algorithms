package trees;

import java.util.LinkedList;

// http://www.cs.usask.ca/classes/280/t2/Code/AVLTree.java
// Based on Code from
// http://www.sanfoundry.com/java-program-implement-avl-tree/

public class AVLTree {

	private AVLNode root = null;

	private class AVLNode {
		AVLNode left;
		AVLNode right;
		int data;
		int height;

		AVLNode(int data) {
			left = right = null;
			height = 0;
			this.data = data;
		}
	}

	private int height(AVLNode n) {
		if (n == null)
			return -1;
		return n.height;
	}

	public void insert(int data) {
		root = insert(root, data);

	}
	
	public boolean lookup(int num)
	{
		return search(root, num);
		
	}
	
	private boolean search(AVLNode n, int num)
	{
		if(n==null) return false;
		if(n.data == num)  return true;
		if(n.data < num) return search(n.right, num);
		else return search(n.left, num);
		
	}

	private AVLNode insert(AVLNode n, int data) {
		if (n == null)
			return new AVLNode(data);

		if (data < n.data) {
			// insert to left.
			n.left = insert(n.left, data);

			if ((height(n.left) - height(n.right)) == 2) {
				if (height(n.left) - height(n.left.left) == 1)
					n = lRotate(n);
				else
					n = lrRotate(n);
			}
		} else {
			// insert to right
			n.right = insert(n.right, data);
			if ((height(n.right) - height(n.left)) == 2) {
				if (height(n.right) - height(n.right.right) == 1)
					n = rRotate(n);
				else
					n = rlRotate(n);
			}
		}
		n.height = max(height(n.left), height(n.right)) + 1;
		return n;

	}

	private AVLNode rlRotate(AVLNode n) {
		// lRotate the right child first
		n.left = lRotate(n.right);
		// now right rotate the node
		n = rRotate(n);
		return n;
	}

	private AVLNode lrRotate(AVLNode n) {
		// rRotate the left child first
		n.left = rRotate(n.left);
		// now left rotate the node
		n = lRotate(n);
		return n;

	}

	private AVLNode lRotate(AVLNode n) {
		AVLNode l = n.left;

		n.left = null; // TODO verify this.
		// should be
		// n.left = l.right
		l.right = n;

		n.height = max(height(n.left), height(n.right)) + 1;
		l.height = max(height(l.left), height(l.right)) + 1;

		return l;
	}

	private AVLNode rRotate(AVLNode n) {
		AVLNode r = n.right;

		n.right = null; // TODO verify this.
		// should be
		// n.right = r.left
		r.left = n;

		n.height = max(height(n.left), height(n.right)) + 1;
		r.height = max(height(r.left), height(r.right)) + 1;

		return r;
	}

	private int max(int a, int b) {
		return a > b ? a : b;
	}
	
	
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(AVLNode r)
    {
        if (r != null)
        {
            inorder(r.left);
            System.out.print(r.data +" ");
            inorder(r.right);
        }
    }
    
	public void bfsTraversal() {
		LinkedList<AVLNode> l = new LinkedList<AVLNode>();

		l.add(root);

		while (l.size() > 0) {
			AVLNode n = l.remove();
			System.out.println(n.data);

			if (n.left != null)
				l.add(n.left);
			if (n.right != null)
				l.add(n.right);
		}
	}
    
    public static void main(String[] args) {
		AVLTree t = new AVLTree();
		t.insert(-5);
		t.insert(3);
		t.insert(8);
		t.insert(-1);
		t.insert(6);
		
		t.inorder();
		
		System.out.println("BFS:");
		t.bfsTraversal();

		
	}

}
