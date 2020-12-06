// LeetCode 88
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int endPoint = m+n-1;
        int endM = m-1;
        int endN = n-1;
        while( endM >=0 && endN >=0) {
            if( nums1[endM] < nums2[endN] ) {
                nums1[endPoint--] = nums2[endN--];
            } else {
                nums1[endPoint--] = nums1[endM--];
            }
        }
        for(int i = 0;i<=endN;i++) {
            nums1[i] = nums2[i];
        }
    }
}