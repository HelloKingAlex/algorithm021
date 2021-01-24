public class LeetCode0242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length() ) {
            return false;
        }

        // 考虑字母，并且只有小写的情况，26个存储单位应该是够的
        int[] counter = new int[26];
        char base = 'a';
        for (int i = 0; i<s.length(); i++) {
            counter[s.charAt(i)-base]++;
            counter[t.charAt(i)-base]--;
        }

        for( int count : counter) {
            if(count !=0) {
                return false;
            }
        }
        return true;
    }
}
