package practiceproblemsTrees;

public class ImplementBinarySearchTree {

	class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;

		public TreeNode(int item) {
			key = item;
			left = right = null;
		}
	}

	TreeNode root;

	ImplementBinarySearchTree() {
		root = null;
	}

	TreeNode search(TreeNode root, int key) {
		if (root == null || root.key == key) {
			return root;
		}
		if (root.key < key) {
			return search(root.right, key);
		}
		return search(root.left, key);

	}

	TreeNode inser(int key) {
		return root = insertRec(root, key);
	}

	TreeNode insertRec(TreeNode root, int key) {
		if (root == null) {
			root = new TreeNode(key);
		} else if (key < root.key) {
			root.left = insertRec(root.left, key);
		} else if (key > root.key) {
			root.right = insertRec(root.right, key);
		}
		return root;
	}

	TreeNode deleteRec(TreeNode root, int key) {
		if (root == null) {
			return root;
		}
		if (root.key > key) {
			root.left = deleteRec(root.left, key);
			return root;
		} else if (root.key < key) {
			root.right = deleteRec(root.right, key);
			return root;
		}
		if (root.left == null) {
			TreeNode temp = root.right;
			return temp;
		} else if (root.right == null) {
			TreeNode temp = root.left;
			return temp;
		} else {
			TreeNode succParent = root;
			TreeNode succ = root.right;
			while (succ.left != null) {
				succParent = succ;
				succ = succ.left;
			}
			if (succParent != root) {
				succParent.left = succ.right;
			} else {
				succParent.right = succ.right;
			}
			root.key = succ.key;
			return root;
		}
	}
}
