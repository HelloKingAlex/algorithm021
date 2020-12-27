// LeetCode 455
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int matched = 0;
        for (int i=0,j=0;i<g.length&&j<s.length;) {
            if(g[i] <= s[j]) {
                matched++;
                i++;
                j++;
            } else {
                j++;
            }
        } 

        return matched;
    }
}