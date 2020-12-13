// LeetCode 94
class Solution {
    // 思路1，递归
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if ( root == null) {
            return new ArrayList<Integer>();
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);

        return res;
    }
    // 思路2，迭代
    public List<Integer> inorderTraversal(TreeNode root) {
        if ( root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        // 左路压栈，出栈输出
        while ( root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}