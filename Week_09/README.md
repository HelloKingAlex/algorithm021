# 学习笔记
## 基本概念
```java
public void recur(int level, int param) { 
  // terminator 终止条件
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  }
  // process current logic 当前层逻辑
  process(level, param); 
  // drill down 下探到下一层
  recur( level: level + 1, newParam); 
  // restore current status 
 
}
```

#### DFS
```java
    // visted.add(node)
    // for next in node.children
    //    next not in visted
    //      dfs(next)
```
#### 泛型递归模板

  
#### 分治法递归模板
```java
private static int divide_conquer(Problem problem, ) {
  
  if (problem == NULL) {
    int res = process_last_result();
    return res;     
  }
  subProblems = split_problem(problem)
  
  res0 = divide_conquer(subProblems[0])
  res1 = divide_conquer(subProblems[1])
  
  result = process_result(res0, res1);
  
  return result;
}
```

#### dp
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
  
#### 分治
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