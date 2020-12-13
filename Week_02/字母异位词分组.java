// LeetCode 49
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }

        HashMap<String, List> res = new HashMap<String, List>();
        for (String s : strs) {
            char[] sorted = s.toCharArray();
            Arrays.sort(sorted);
            String key = String.valueOf(sorted);
            if( !res.containsKey(key)) {
                res.put(key,new ArrayList());
            }
            res.get(key).add(s);
        }
        return new ArrayList(res.values());
    }
}