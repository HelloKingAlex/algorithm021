# 学习笔记
## 基本概念
### 动态规划
递归 分治+最优子结构

找到重复的子问题，在过程中淘汰掉次优解。

dp过程  
1. 找到子问题
2. 定义状态转移数组
3. 定义dp方程
## 刷题技巧
### 小技巧 & 必背思路
  
#### dp-必背
```java
public void recur(int level, int param) {   
    // terminator
    if (level > MAX_LEVEL) {
        // process result 
        return;
    }  
    // process current logic
    process(level, param);
    // drill down
    recur( level: level + 1, newParam);
    // restore current status
}
```
  
#### 分治-必背
```java
private static int divide_conquer(Problem problem, ) {
    if (problem == NULL) {
        int res = process_last_result();
        return res;
    }  
    subProblems = split_problem(problem);
    res0 = divide_conquer(subProblems[0]);
    res1 = divide_conquer(subProblems[1]);
    // res...
    result = process_result(res0, res1, ...);
    return result;
}
```
## 个人总结
。。。坚持