// LeetCode 641
class MyCircularDeque {

    private int head;
    private int tail;
    private int capacity;
    private int[] arr;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        head = 0;
        tail = 0;
        // 为了区别空和满两种状态
        // 定义一个dummy空间，初始的时候，首尾在同一个位置，可以利用这个作为判空的条件
        capacity = k+1;
        arr = new int[capacity];
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if( isFull()) {
            return false;
        }
        head = (head-1+capacity) % capacity;
        arr[head] = value;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()) {
            return false;
        }
        arr[tail] = value;
        tail = (tail+1) % capacity;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if( isEmpty()) {
            return false;
        }
        head = (head+1) % capacity;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if( isEmpty()) {
            return false;
        }
        tail = (tail-1+capacity) % capacity;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if( isEmpty()){
            return -1;
        }
        return arr[head];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if( isEmpty()) {
            return -1;
        }
        return arr[(tail-1+capacity)%capacity];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return head == tail;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (tail+1)% capacity == head;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */