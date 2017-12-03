package com.jara.alg.stackqueue;

import java.util.Stack;

/**
 * 最小栈实现
 * Created by Jiaqi on 2017/12/2.
 */
public final class getMin001 {
    static MinStack minStack = new MinStack();
    public static void main(String[] args) {
        minStack.push(3);
        minStack.push(4);
        minStack.push(2);
        minStack.push(6);
        minStack.push(1);
        System.out.println(minStack.pop());
        System.out.println(minStack.getMin());
    }

    static class MinStack {
        /**
         * 两个栈去实现getMin，norStack正常的入栈和出栈，minStack只入栈最小值
         */
        private Stack<Integer> norStack;
        private Stack<Integer> minStack;

        public MinStack() {
            this.norStack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(int data) {
            norStack.push(data);
            if (minStack.isEmpty()) {
                minStack.push(data);
            } else if (data <= getMin()) {
                minStack.push(data);
            }
        }

        public int pop() {
            if (minStack.isEmpty()) {
                throw new RuntimeException("the min stackqueue is empty!");
            }
            int now = norStack.pop();
            if (now == getMin()) {
                minStack.pop();
            }
            return now;
        }

        public int getMin() {
            if (minStack.isEmpty()) {
                throw new RuntimeException("the min stackqueue is empty!");
            } else {
                return minStack.peek();
            }
        }
    }

}
