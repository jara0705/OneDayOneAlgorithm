package com.jara.alg.stackqueue;

import java.util.Stack;

/**
 * 两个栈实现队列
 * Created by Jiaqi on 2017/12/3.
 */
public class TowStack002 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public static void main(String[] args) {
        TowStack002 towStack = new TowStack002();
        towStack.push(2);
        towStack.push(4);
        towStack.push(5);
        towStack.push(1);

        System.out.println(towStack.poll());
    }

    public TowStack002() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    private void push(int data) {
        stack1.push(data);
    }

    /**
     * 队列出队操作
     * 首先判断两个栈是否为空，基本操作；
     * 其次，判断负责出队是否为空，空的话就push入队的栈元素
     * 最后出队栈负责出队
     */
    private int poll() {
        popAndPush();
        return stack2.pop();
    }

    private int peak() {
        popAndPush();
        return stack2.peek();
    }

    private void popAndPush() {
        if (stack1.empty() && stack2.empty()) {
            throw new RuntimeException("Two stacks are empty");
        } else if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}
