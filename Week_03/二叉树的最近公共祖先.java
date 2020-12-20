// LeetCode 236
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 退出条件
        if( root == null || root == q || root == p) {
            return root;
        }

        // 处理当前层
        // 下探到下一层
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        // 返回贵上一层
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;

        // 还原现场
    }
}
