## backtrack 模板



## inorder traversal non-recursive
public void inorder(TreeNode root) {
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

## subset II
