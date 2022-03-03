package AlgorithmTemplates.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public void solution(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            TreeNode right = cur.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }



    }

}
