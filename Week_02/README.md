# 学习笔记
## 基本概念
### Hash table,Set Map
底层存储为一个数组，元素通过散列算法，对数组长度求余得到具体元素应该存储的下标位置。从这个意义上来看，Hash table的插入复杂度是O(1)。同理，查询和删除的复杂度也是O(1).  
当遇到多个元素的散列值相同时，就产生了Hash冲突。解决Hash冲突的办法可以通过扩展Hash数组，使得每一个数组的元素指向一个线性数据结构，这个结构可以是链表，也可以是AVL树，红黑树，甚至是跳表。查询的复杂度将退化为O(N)或者是O(logN)  
Map 和 Set的区别在于Set中的元素是不重复的  
工程领域常使用Hash table的各种实现作为缓存(Redis)，非结构化数据存储(Mongo)。

### 树
树状结构时对一维数据的扩展，树结构中最常用的是二叉树，从结构上来看，树中的任意一个节点都可以看做是根节点，左子树和右子树的组合。从这个特性可以看出，二叉树的访问非常适合用递归的方式来实现
```
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
  
#### 二叉搜索树
二叉搜索树的特征是，对于任何一个节点，其左边的所有节点的值均小于这个节点，其右边所有节点的值均大于这个节点
这个特性下，二叉树可能退化为一个链表，所以说，链表也是二叉树的一种特殊情况。二叉搜索树的中序遍历就是这个二叉搜索树元素从小到大的排列(升序遍历)。
  
### 堆
堆是一种可以在一堆数中，快速找到最大的元素(大顶堆)或者最小元素(小顶堆)的数据结构  
实现堆的算法有很多，常用的是二叉堆。  
二叉堆首先是一颗完全树(所有的叶子节点都集中在最深一层)，任意一个节点的值总是>=这个节点的子节点的值
由于这个约束存在，堆在增删元素的时候必须对整个结构进行调整。由于完全树的结构特点，二叉堆通常都是利用数组来实现，假设第一个元素的索引是0的话，那么对于第i个元素：  
> 左节点的索引位置是 (2*i + 1)  
> 右节点的索引位置是 (2*i + 2)  
> 父节点的索引位置是 (i-1)/2 向下取整  
  
对于二叉堆的插入元素来说:  
> 新元素先插入到堆的尾部(对于容量够的堆来说，插入的元素的位置位于 size)  
> 依次向上调整 (冒泡)，直到满足二叉堆的第二个性质为止  
  
找到最大或者最小元素的时间复杂度是O(1),删除元素O(logN),插入元素O(logN).  
  
对于二叉堆删除堆顶元素来说:
> 将堆尾部元素替换到堆顶(heap[0] = heap[size-1];size--)  
> 依次向下调整，交换较大子节点与当前节点的值，直到满足二叉堆的第二个性质为止  

```
import java.util.Arrays;
import java.util.NoSuchElementException;


public class BinaryHeap {


    private static final int d = 2;
    private int[] heap;
    private int heapSize;


    /**
     * This will initialize our heap with default size.
     */
    public BinaryHeap(int capacity) {
        heapSize = 0;
        heap = new int[capacity + 1];
        Arrays.fill(heap, -1);
    }


    public boolean isEmpty() {
        return heapSize == 0;
    }


    public boolean isFull() {
        return heapSize == heap.length;
    }




    private int parent(int i) {
        return (i - 1) / d;
    }


    private int kthChild(int i, int k) {
        return d * i + k;
    }


    /**
     * Inserts new element in to heap
     * Complexity: O(log N)
     * As worst case scenario, we need to traverse till the root
     */
    public void insert(int x) {
        if (isFull()) {
            throw new NoSuchElementException("Heap is full, No space to insert new element");
        }
        heap[heapSize] = x;
        heapSize ++;
        heapifyUp(heapSize - 1);
    }


    /**
     * Deletes element at index x
     * Complexity: O(log N)
     */
    public int delete(int x) {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty, No element to delete");
        }
        int maxElement = heap[x];
        heap[x] = heap[heapSize - 1];
        heapSize--;
        heapifyDown(x);
        return maxElement;
    }


    /**
     * Maintains the heap property while inserting an element.
     */
    private void heapifyUp(int i) {
        int insertValue = heap[i];
        while (i > 0 && insertValue > heap[parent(i)]) {
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = insertValue;
    }


    /**
     * Maintains the heap property while deleting an element.
     */
    private void heapifyDown(int i) {
        int child;
        int temp = heap[i];
        while (kthChild(i, 1) < heapSize) {
            child = maxChild(i);
            if (temp >= heap[child]) {
                break;
            }
            heap[i] = heap[child];
            i = child;
        }
        heap[i] = temp;
    }


    private int maxChild(int i) {
        int leftChild = kthChild(i, 1);
        int rightChild = kthChild(i, 2);
        return heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
    }


    /**
     * Prints all elements of the heap
     */
    public void printHeap() {
        System.out.print("nHeap = ");
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }


    /**
     * This method returns the max element of the heap.
     * complexity: O(1)
     */
    public int findMax() {
        if (isEmpty())
            throw new NoSuchElementException("Heap is empty.");
        return heap[0];
    }

}
```
## 刷题技巧
### 小技巧 & 必背思路
#### 提升访问性能-升维
#### 二叉树的三种遍历-必背
#### 通过引入栈，来模拟操作系统的递归调用栈(需要搞清楚出入栈的次序)
## 个人总结
本周除了新知识的学习之外，也复习和上周的内容。在遇到那些做过的题目时，也并非一番风顺。对于链表的两两交换，翻转链表着重做了复习。某些题目为了加强记忆已经做了不止5遍，也算是逐渐找到了做题的感觉吧。

