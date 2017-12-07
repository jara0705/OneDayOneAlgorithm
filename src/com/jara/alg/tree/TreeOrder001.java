package com.jara.alg.tree;

import java.util.Stack;

/**
 * 二叉树遍历 非递归的方式
 *            1
 *          /   \
 *        2       3
 *      /   \   /   \
 *     4     5 6     7
 *  整体思想是利用栈结构
 * Created by Jiaqi on 2017/12/7.
 */
public class TreeOrder001 {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);
        preOrder(tree);
        inOrder(tree);
        posOrder(tree);
    }

    /**
     * 应输出1234567
     * 这个结构比较简单，先入栈根节点 然后直接出栈，
     * 左右子树先入栈右子树 再入栈左子树（先入后出）
     * @param root
     */
    private static void preOrder(BinaryTree root) {
        if (root != null) {
            Stack<BinaryTree> stack = new Stack<>();
            stack.add(root);
            while (!stack.empty()) {
                root = stack.pop();
                System.out.print(root.value + " ");
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
        }
        System.out.println();
    }

    /**
     * 4251637
     *
     * @param root
     */
    private static void inOrder(BinaryTree root) {
        if (root != null) {
            Stack<BinaryTree> stack = new Stack<>();
            while (!stack.empty() || root !=null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    System.out.print(root.value + " ");
                    root = root.right;
                }
            }
        }
        System.out.println();
    }

    /**
     * 4526731
     * 利用两个栈 stack1入栈并出栈到stack2中
     * stack1基本就是先入左子树 再入右子树
     * @param root
     */
    private static void posOrder(BinaryTree root) {
        if (root != null) {
            Stack<BinaryTree> stack1 = new Stack<>();
            Stack<BinaryTree> stack2 = new Stack<>();
            stack1.push(root);
            while (!stack1.empty()) {
                root = stack1.pop();
                stack2.push(root);
                if (root.left != null) {
                    stack1.push(root.left);
                }
                if (root.right != null) {
                    stack1.push(root.right);
                }
            }
            while (!stack2.empty()) {
                System.out.print(stack2.pop().value + " ");
            }
        }
        System.out.println();
    }
}
