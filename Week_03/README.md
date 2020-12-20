# 学习笔记
## 基本概念
### 递归的本质
递归的本质就是寻找重复性，从数学角度就是寻找递推公式。  
递归的难点也在这个重复性的寻找上，在递归还不熟练的时候，可以人肉绘制递归树，然后寻找规律。  
当较为熟练之后，其实不建议再用人肉的递归的方式解决递归的问题。  
### 分治
从寻找重复性作为开始，一个大规模的问题可以分解为多个部分来解决，而每个子问题也可以按照同样的方式拆分。
从这个角度去理解爬楼的问题，就可以把爬n阶楼梯的问题分解成为走一步到达和走两步到达的两个子问题n-1以及n-2，
最后再合并两个子问题得到 f(n) = f(n-1) + f(n-2)
### 回溯
回溯我认为是在泛型递归上进行的调整，这个调整在于需要向上清理状态，也就是说，泛型递归或者分治的思路是在明确知道下一步要干什么的情况下，逐渐分解问题，而回溯在于下探的过程中，会遇到错误解，为了避免问题进一步扩散，需要逐步向上清理达成错误解的状态
## 刷题技巧
### 小技巧 & 必背思路
  
#### 泛型递归模板-必背
```
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
  
#### 分治法递归模板-必背
```
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
## 个人总结
本周的进度比较糟糕，一方面要还之前拖欠的二叉树及数组链表部分遗留的不熟练的问题，还需要学习新的内容，另一方面又因为感冒导致做题的进度稍慢了一些(思维无法集中）。下周会在平日里增加训练的提炼，避免算法债进一步扩散，赶上进度

