package trees;

class Node {
	int val;
	Node left;
	Node right;

	public Node(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}

}

public class BinarySearchTree {

	Node root;

	public Node insertRec(Node currentNode, int val) {

		if (currentNode == null) {
			root = new Node(val);
			return root;
		}
		if (val < currentNode.val) {
			currentNode.left = insertRec(currentNode.left, val);
		} else if (val > currentNode.val) {
			currentNode.right = insertRec(currentNode.right, val);
		}
		return currentNode;
	}

	private void insert(int val) {
		root = insertRec(root, val);
	}

	private void traverse(Node currentNode) {
		if (currentNode == null) {
			return;
		}
		traverse(currentNode.left);
		System.out.println(currentNode.val);
		traverse(currentNode.right);
	}

	private Node delete(Node currentNode, int val) {
		if (currentNode == null) {
			return currentNode;
		}
		if (val < currentNode.val) {
			currentNode.left = delete(currentNode.left, val);
		} else if (val > currentNode.val) {
			currentNode.right = delete(currentNode.right, val);
		} else {
			if (currentNode.right == null) {
				return currentNode.left;
			} else if (currentNode.left == null) {
				return currentNode.right;
			} else {
				currentNode.val = min(currentNode.right);
				currentNode.right = delete(currentNode.right, currentNode.val);
			}
		}
		return currentNode;
	}

	private int min(Node node) {
		if (node.left == null) {
			return node.val;
		}
		return min(node.left);
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(90);
		tree.insert(80);
		tree.insert(100);
		tree.insert(79);
		tree.traverse(tree.root);
		tree.delete(tree.root, 90);
		System.out.println("After: ");
		tree.traverse(tree.root);
	}
}
