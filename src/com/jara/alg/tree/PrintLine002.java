package com.jara.alg.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 二叉树行遍历
 * Created by Jiaqi on 2017/12/10.
 */
public class PrintLine002 {


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);
        printLine(tree);
        printAsLine(tree);
    }

    /**
     * 引入队列数据结构，Queue是接口，使用LinkedList可实现，其他实现可见Queue源码类注释
     * 因为入队是先进先出特性，每次出队的元素，入队它的左右节点（如果有的话）
     * 以1234567这个完全二叉树为例，首先根节点1入队，紧接着1出队，并入队23
     * 出队2，可入队45，然后出队3，入队67
     * 按行遍历
     * @param root
     */
    private static void printLine(BinaryTree root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTree node = queue.poll();
            System.out.print(node.value + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.println();
    }

    /**
     * 按行打印
     * 主要思想参见{@link #printLine}
     * last和nLast是指本行和下一行最右节点
     *            1   --->last                       1
     *          /   \                              /   \
     *        2       3  --->nLast   -----》     2       3   --->last==nLast 此时一行已经打印完全可以换行打印了
     *      /   \   /   \                      /   \   /   \                \
     *     4     5 6     7                    4     5 6     7  ------------->nLast
     *
     * @param root
     */
    private static void printAsLine(BinaryTree root) {
        if (root == null) {
            return;
        }
        int i = 2;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        BinaryTree last = root;
        BinaryTree nLast = root;
        System.out.print("第1行：");
        while (!queue.isEmpty()) {
            BinaryTree node = queue.poll();
            System.out.print(node.value + " ");
            if (node.left != null) {
                queue.add(node.left);
                nLast = node.left;
            }
            if (node.right != null) {
                queue.add(node.right);
                nLast = node.right;
            }
            if (node == last && !queue.isEmpty()) {
                System.out.println();
                System.out.print("第"+i+"行：");
                i++;
                last = nLast;
            }
        }
    }
}
