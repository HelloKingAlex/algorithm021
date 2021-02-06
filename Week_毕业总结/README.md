# 总结

## 数组

数组是一维的线性数据结构。数组在内存中占用一段连续的空间，访问一个具体位置的元素时，通过数组的首地址加上偏移量可以在O(1)的时间里找到这个元素。同样由于数组要求空间上的连续，所以数组在删除或者添加一个元素时，或多或少都需要移动一些元素。比如一个长度为n的数组：

1. 在第i个位置添加一个元素，需要将i+1到n-1位置的元素向后移动一个位置。
2. 删除第i个元素时，需要将i+1到n-1位置的元素，向前移动一个位置
  
这两项操作的平均复杂度都是O(N)
  
## 链表

链表与数组一样，都是一维的线性数据结构，每个节点都维护了一个指向后驱的指针next。在工程领域，比如java中的链表，实际上是一个双向的指针，也就是除了一个后驱的next，还有一个前驱的prev。  
链表的添加和删除元素的时间复杂度是O(1)
  
```java
// 在target后添加一个节点
ListNode node = new ListNode(value)
node.next = target.next
target.next = node

// 删除target元素
if(prev.next == target) {
    prev.next = target.next;
    target == null;
}
```
  
链表在内存中存储不连续，所以没有办法通过地址偏移的方式快速找到目标元素，链表访问的时间复杂度是O(N)

## 栈与队列

栈和队列是对线性一维数据结构加以不同约束的数据结构，二者都可以通过双向链表或者数组来实现。其中

1. 栈: 后进先出
2. 队列: 先进先出

### 树

树状结构时对一维数据的扩展，树结构中最常用的是二叉树，从结构上来看，树中的任意一个节点都可以看做是根节点，左子树和右子树的组合。从这个特性可以看出，二叉树的访问非常适合用递归的方式来实现

```java
// 前序遍历
root
preOrder(root.left)
preOrder
// 中序遍历
inOrder(root.left)
root
inOrder(root.right)
// 后续遍历
postOrder(root.left)
postOrder(root.right)
root
```

## 递归的本质

递归的本质就是寻找重复性

## 分治

从寻找重复性作为开始，一个大规模的问题可以分解为多个部分来解决，而每个子问题也可以按照同样的方式拆分。

## 泛型递归模板

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
  
## 分治法递归模板

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

## 动态规划
递归 分治+最优子结构

找到重复的子问题，在过程中淘汰掉次优解。

dp过程  

1. 找到子问题
2. 定义状态转移数组
3. 定义dp方程

## dp

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

## 快速排序

1.选定一个位置
2.这个位置的左边都要比这个位置的数字小，这个位置的右边都要大于这个位置
3.以同样的方式处理左半部分
4.以同样的方式处理右半部分

```java
public static void quickSort(int[] array, int begin, int end) {
    if (end <= begin) return;
    int pivot = partition(array, begin, end);
    quickSort(array, begin, pivot - 1);
    quickSort(array, pivot + 1, end);
}
static int partition(int[] a, int begin, int end) {
    // pivot: 标杆位置，counter: 小于pivot的元素的个数
    int pivot = end, counter = begin;
    for (int i = begin; i < end; i++) {
        if (a[i] < a[pivot]) {
            int temp = a[counter]; a[counter] = a[i];
            a[i] = temp;
            counter++;
        }
    }
    int temp = a[pivot];
    a[pivot] = a[counter];
    a[counter] = temp;
    return counter;
}
```

## 归并排序

1.将目标分为二
2.左边及右边各自有序后，合并左右
3.每个部分都重复1，2的步骤

```java
public static void mergeSort(int[] array, int left, int right) {
    if (right <= left) return;
    int mid = (left + right) >> 1;
    // (left + right) / 2
    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
    merge(array, left, mid, right);
}
public static void merge(int[] arr, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    // 中间数组
    int i = left, j = mid + 1, k = 0;
    while (i <= mid && j <= right) {
        temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
    } 
    while (i <= mid)
        temp[k++] = arr[i++];
    while (j <= right) 
        temp[k++] = arr[j++];
    for (int p = 0; p < temp.length; p++) {
        arr[left + p] = temp[p];
    }
    // 也可以用 System.arraycopy(a, start1, b, start2, length)
}
```

## 堆排序

1. 建立堆
2. 将堆顶元素移到这一轮的最后
3. 重复1，2

```java
static void heapify(int[] array, int length, int i) {
    int left = 2 * i + 1, right = 2 * i + 2;
    int largest = i;
    if (left < length && array[left] > array[largest]) {
        largest = left;
    }
    if (right < length && array[right] > array[largest]) {
        largest = right;
    }
    if (largest != i) {
        int temp = array[i];
        array[i] = array[largest];
        array[largest] = temp;
        heapify(array, length, largest);
    }
}

public static void heapSort(int[] array) {
    if (array.length == 0)
        return;
    int length = array.length;
    for (int i = length / 2-1; i >= 0; i-)
        heapify(array, length, i);
    for (int i = length - 1; i >= 0; i--) {
        int temp = array[0];
        array[0] = array[i];
        array[i] = temp;
        heapify(array, i, 0);
    }
}
```

## 脑图总结

[链接](https://www.edrawsoft.cn/viewer/public/s/d2b31606383774)