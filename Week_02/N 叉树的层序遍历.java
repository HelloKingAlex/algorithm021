// LeetCode 429
// 尚不熟练，需要加强
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count-- > 0) {
                //将当前元素的非空子节点压入栈
                Node cur = queue.poll();
                list.add(cur.val);
                for (Node node : cur.children) {
                    if (node != null) {
                        queue.add(node);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }
}