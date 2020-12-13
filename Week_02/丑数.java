// 剑指Offer 49
class Solution {
    public int[] ugluNumber = {2,3,5};
    public int nthUglyNumber(int n) {
        // 1690 溢出了，不能用Integer
        Queue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        int count = 0;
        while ( !queue.isEmpty()) {
            long cur = queue.poll();
            if(++count >= n) {
                return (int)cur;
            }
            for( int num:ugluNumber) {
                if( !queue.contains(num * cur)) {
                    queue.add(num * cur);
                }
            }
        }
        return -1;
    }
}