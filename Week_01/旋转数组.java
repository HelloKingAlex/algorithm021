// LeetCode 189
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length <= 1) {
            return;
        }
        int len = nums.length;
        k = k%len;
        int moved = 0;
        for( int i = 0; moved < len; i++) {
            int current = i;
            int prev = nums[i];
            do {
                int next = (current + k) % len;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                moved++;
            } while (i != current);
        }
    }
}