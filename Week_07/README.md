# 学习笔记
## 基本概念
### Trie树模板
```java
class Trie {    
    private boolean isEnd;    
    private Trie[] next;    
    /** Initialize your data structure here. */    
    public Trie() {        
        isEnd = false;        
        next = new Trie[26];    
    }        
    /** Inserts a word into the trie. */    
    public void insert(String word) {        
        if (word == null || word.length() == 0) return;        
        Trie curr = this;        
        char[] words = word.toCharArray();        
        for (int i = 0;i < words.length;i++) {            
            int n = words[i] - 'a';            
            if (curr.next[n] == null) curr.next[n] = new Trie();            
                curr = curr.next[n];        
        }        
        curr.isEnd = true;    
    }        
    /** Returns if the word is in the trie. */    
    public boolean search(String word) {        
        Trie node = searchPrefix(word);        
        return node != null && node.isEnd;    
    }        
    /** Returns if there is any word in the trie that starts with the given prefix. */    
    public boolean startsWith(String prefix) {        
        Trie node = searchPrefix(prefix);        
        return node != null;    
    }    
    private Trie searchPrefix(String word) {        
        Trie node = this;        
        char[] words = word.toCharArray();        
        for (int i = 0;i < words.length;i++) {            
            node = node.next[words[i] - 'a'];            
            if (node == null) return null;        
        }        
        return node;   
        }
    }
```
### 并查集
```java
class UnionFind { 	
    private int count = 0; 
    private int[] parent; 
    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    } 
    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p; 
    }
    public void union(int p, int q) { 
        int rootP = find(p); 
        int rootQ = find(q); 
        if (rootP == rootQ) 
            return; 
        parent[rootP] = rootQ; 
        count--;
        }
    }
```
## 个人总结
工作中遇到了一个例子，也许可以用Trie树+倒排索引来实现  
场景是这样的，我有一份清单A，这份清单的每一行都是一些特定字符的组合的词组，每一个词组都可以按照顺序进行分割，每一个分割的单元都代表者一种分数。现在需要在清单B中，按照同样的分词方式去A里进行匹配，匹配之后的清单B的每一行数据都是从A里获得的分数的加权和。  
按照传统的做法，我们会从A扩展出一张A.detail表，detail表的每一行数据都存的是清单A的分词结果以及对应的分数，然后通过B.detail表来进行比配和运算。  
实际上，观察清单A，可以发现有大量的分词是重复的，构建Trie树锁需要的空间并不是很大，所以我在考虑是否可以按照这种思路，在内存甚至存储中直接构建这样一个Trie树的结构，然后直接通过清单B来匹配这颗Trie树，长度限制为Trie.next!=null && depth <= B.length,假设清单A中的一个词组可以分成5层，清单B的其中一个词的长度是6，那么最终命中的分数就是 5/6.当然了，其中还有一些细节以及倒排索引的部分还需要考虑。