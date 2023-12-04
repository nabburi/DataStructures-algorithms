package practiceproblemsTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		ImplementBinarySearchTree tree = new ImplementBinarySearchTree();
		int[] treenodes = {4,2,1,3,5 };
		practiceproblemsTrees.ImplementBinarySearchTree.TreeNode root = null;
		for (int i : treenodes) {
			root = tree.inser(i);
		}
		int dbt = 0;

        helper(root, dbt);
	}
	
	private static int helper(practiceproblemsTrees.ImplementBinarySearchTree.TreeNode root, int dbt){
        if(root.left == null && root.right == null){
            return 0;
        }
        int myHeight = 0;
        int leftHeight = 0;
        int rightHeight = 0;
        if(root.left != null){
            leftHeight = helper(root.left, dbt);
            myHeight += leftHeight +1;
        }
        if(root.right != null){
            rightHeight = helper(root.right, dbt);
            myHeight += rightHeight +1;
        }
        dbt = Math.max(dbt, myHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }

	
}
