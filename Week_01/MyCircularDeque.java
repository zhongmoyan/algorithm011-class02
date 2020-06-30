package com.test.leetcode;

public class MyCircularDeque {
    private int capacity;
    private int[] arr;
    private int first;
    private int last;
    /** Initialize your data structure here. Set the size of the deque to be k.
     * 构造函数,双端队列的大小为k。
     * */
    public MyCircularDeque(int k) {
        capacity=k+1;//尾指针 尾部指向下一个插入元素的位置
        arr=new int[capacity];
        first=last=0;
        // 头部指向第 1 个存放元素的位置
        // 插入时，先减，再赋值
        // 删除时，索引 +1
        // 尾部指向下一个插入元素的位置
        // 插入时，先赋值，再加
        // 删除时，索引 -1（注意取模）
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful.
     * 将一个元素添加到双端队列头部。 如果操作成功返回 true
     * */
    public boolean insertFront(int value) {
        if(isFull())
            return false;
        first=(first-1+capacity)%capacity;//负数
        arr[first]=value;
        return true;
    }
    /** Adds an item at the rear of Deque. Return true if the operation is successful.
     * 将一个元素添加到双端队列尾部。如果操作成功返回 true。
     * */
    public boolean insertLast(int value) {
            if(isFull())
                return false;
            arr[last]=value;
            last=(last+1)%capacity;
            return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful.
     * 从双端队列头部删除一个元素。 如果操作成功返回 true。
     * */
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
            }
        first=(first+1)%capacity;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful.
     * 从双端队列尾部删除一个元素。如果操作成功返回 true。
     * */
    public boolean deleteLast() {
        if(isEmpty())
            return false;
        last=(last-1+capacity)%capacity;
        return true;
    }

    /** Get the front item from the deque.
     * 从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
     * */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[first];
    }

    /** Get the last item from the deque.
     * 获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
     * */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(last - 1 + capacity) % capacity];

    }

    /** Checks whether the circular deque is empty or not.
     * 检查双端队列是否为空。
     * 判别队列为空的条件是：first == last;
     * */
    public boolean isEmpty() {
        return first==last;
    }

    /** Checks whether the circular deque is full or not.
     * 检查双端队列是否满了。
     * 判别队列为满的条件是：first == last+1;
     * */
    public boolean isFull() {
        return (last+1)%capacity ==first;
    }
    public static void main(String[] args){
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        boolean param_1 =circularDeque.insertLast(1);			        // 返回 true
        boolean param_2 =circularDeque.insertLast(2);			        // 返回 true
        boolean param_3 =circularDeque.insertFront(3);			        // 返回 true
        boolean param_4 =circularDeque.insertFront(4);			        // 已经满了，返回 false
        int param_5 = circularDeque.getRear();  				// 返回 2
        boolean param_6 = circularDeque.isFull();				        // 返回 true
        boolean param_7=circularDeque.deleteLast();			        // 返回 true
        boolean param_8=circularDeque.insertFront(4);			        // 返回 true
        int param_9=circularDeque.getFront();				// 返回 4

    System.out.println(param_1);
    System.out.println(param_2);
    System.out.println(param_3);
    System.out.println(param_4);
    System.out.println(param_5);
    System.out.println(param_6);
    System.out.println(param_7);
    System.out.println(param_8);
    System.out.println(param_9);
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

