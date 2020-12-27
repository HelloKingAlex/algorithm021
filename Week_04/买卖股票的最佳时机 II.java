// LeetCode 122
class Solution {
    public int maxProfit(int[] prices) {
        int binfit = 0;
        if(prices == null || prices.length <2){
            return 0;
        }
        for (int i = 1; i < prices.length; i++) {
            binfit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return binfit;
    }
}