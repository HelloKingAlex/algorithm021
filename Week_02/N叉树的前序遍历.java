// LeetCode 589
class Solution {
    // 思路1，递归
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        if( root == null) {
            return new ArrayList<Integer>();
        }
        res.add(root.val);
        for(Node node : root.children) {
            preorder(node);
        }
        return res;
    }

    // 思路2，迭代
    // 迭代法通过模拟递归栈来实现
    public List<Integer> preorder(Node root) {
        if( root == null) {
            return new ArrayList<Integer>();
        }
        Deque<Node> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<Integer>();

        stack.add(root);
        // 原始数据
        // 0
        // 1,    2
        // 3,4,5,6,7,8
        // 出入栈的顺序应该是[0]
        // [2,1] 0出栈
        // [2,5,4,3] 1出栈
        // children如果不翻转那么
        // 0出栈的那一轮，就编程了[1,2]
        // 下一轮是2出栈，不符合前序（根，左->右)
        // 简而言之，出栈要保证左->右，那么入栈就要 右->左
        while (!stack.isEmpty()) {
            Node n = stack.pollLast();
            res.add(n.val);
            Collections.reverse(n.children);
            for( Node nn : n.children) {
                stack.add(nn);
            }
        }

        return res;
    }
}