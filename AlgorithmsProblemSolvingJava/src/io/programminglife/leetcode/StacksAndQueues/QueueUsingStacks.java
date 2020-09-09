package io.programminglife.leetcode.StacksAndQueues;

import java.util.Stack;

public class QueueUsingStacks {

    Stack<Integer> stackOne;
    Stack<Integer> stackTwo;
    int front;

    /** Initialize your data structure here. */
    public QueueUsingStacks() {
        stackOne = new Stack<>();
        stackTwo = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(stackOne.empty()) {
            front = x;
        }
        stackOne.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stackTwo.isEmpty()) {
            while (!stackOne.isEmpty()) {
                stackTwo.push(stackOne.pop());
            }
        }

        return stackTwo.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(!stackTwo.isEmpty()) {
            return stackTwo.peek();
        }

        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackOne.isEmpty() && stackTwo.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks myQueue = new QueueUsingStacks();

        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);

        System.out.println(myQueue.peek());
    }

}
