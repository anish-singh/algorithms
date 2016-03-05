package trees;

public class Trie {

	Node root = new Node('\0');

	private class Node {
		char data;
		Node[] children = new Node[26];
		boolean isWord;

		Node(char data) {
			this.data = data;
		}

	}

	public void addWord(String word) {
		addWord(root, word.toLowerCase());
	}

	private void addWord(Node n, String word) {
		int offset = 97;
		int len = word.length();

		Node currNode = n;

		for (int i = 0; i < len; i++) {
			char currChar = word.charAt(i);
			if (currNode.children[currChar - offset] == null) {
				Node newNode = new Node(currChar);
				currNode.children[currChar - offset] = newNode;
			}
			currNode = currNode.children[currChar - offset];
		}
		currNode.isWord = true;
	}

	public boolean find(String word) {
		int offset = 97;
		String tofind = word.toLowerCase();

		Node n = root;
		int len = tofind.length();

		for (int i = 0; i < len; i++) {
			char currChar = tofind.charAt(i);

			if (n == null)
				return false;
			// System.out.println("n.char:" + n.data);

			n = n.children[currChar - offset];
		}
		if (n != null && n.isWord)
			return true;

		return false;

	}

	private void printTree(Node n, int level, char[] branch) {

		if (n == null)
			return;

		for (int i = 0; i < n.children.length; i++) {
			branch[level] = n.data;
			printTree(n.children[i], level + 1, branch);
		}

		if (n.isWord) {
			for (int j = 1; j <= level; j++)
				System.out.print(branch[j]);
			System.out.println();
		}
	}

	public void print() {

		printTree(root, 0, new char[50]);
	}
}
