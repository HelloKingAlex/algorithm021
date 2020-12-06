// LeetCode 66
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i]%10;
            // 不产生进位
            // 比如 8+1=9
            // 9%10 = 9
            if(digits[i] != 0){
                return digits;
            }
            // else
            // 产生了进位
            // 比如 1，9，9+1后余数为0,需要进入下一轮再判断
        }
        // 如果没有在循环中退出，说明原数组都是由9,组成的
        // 所以数组需要扩张1位，首位为1,其余的为0
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
}