
// LeetCode 26
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int q = 0;
        for(int p = 1;p < nums.length; p++) {
            if(nums[p] != nums[q]){
                nums[++q] = nums[p];
            }
        }
        return q+1;
    }
}