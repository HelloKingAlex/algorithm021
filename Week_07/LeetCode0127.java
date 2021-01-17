public class LeetCode0127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // BFS 模板
        // queue
        // queue.offer(first)
        // visted.add(first)
        // while queue not empty
        //   node = queue.poll
        //   visted.add(node)
        //   process(node)
        //   nodes = node.children
        //   queue.offer(nodes)

        Set<String> words = new HashSet<>(wordList);
        if ( !words.contains(endWord)) {
            return 0;
        }

        int len = beginWord.length();
        words.remove(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visted = new HashSet<>();
        visted.add(beginWord);

        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] chars = word.toCharArray();
                for (int j = 0; j < len; j++) {
                    char c = chars[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == c) {
                            continue;
                        }
                        chars[j] = k;
                        String newWord = String.valueOf(chars);
                        if (words.contains(newWord)) {
                            if (newWord.equals(endWord)) {
                                return ++step;
                            }
                            if (!visted.contains(newWord)) {
                                visted.add(newWord);
                                queue.offer(newWord);
                            }
                        }
                    }
                    chars[j] = c;
                }
            }
            step++;
        }
        return 0;
    }
}