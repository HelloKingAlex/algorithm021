# 学习笔记
## 基本概念
### 贪心
贪心试图从局部最优得出全局最优的结论，与回溯的区别在于，贪心没有后悔药。
贪心的整体思路与人的思维思路类似，所以算法本身较为好理解，但是贪心有局限性，有时局部最优解未必是全局最优解
所以，贪心适合那种  
> 1.求多个解中的某一个解，不强调最优
  
> 2.能够证明局部最优就是全局最优的
## 刷题技巧
### 小技巧 & 必背思路
  
#### DFS-必背
```
    // DFS 模板
    // visted.add(node)
    // for next in node.children
    //    next not in visted
    //      dfs(next)
```
  
#### 分治法递归模板-必背
```
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
}
```
## 个人总结
说是走完了一半，其实才刚刚开始，上周的感冒延续到了这一周，由于要补上一周拉下的进度，这周过的痛苦无比
并没有新的心得体会，多练多背多思考。
