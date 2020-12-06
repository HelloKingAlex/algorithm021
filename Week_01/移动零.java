


// LeetCode 283
class Solution {
    public void moveZeroes(int[] nums) {
        int zeroPos = 0;
        for(int i = 0;i<nums.length; i++) {
            if(nums[i]!=0) {
                nums[zeroPos] = nums[i];
                if(zeroPos != i) {
                    nums[i] = 0;
                }
                zeroPos++;
            }
        }
    }
}