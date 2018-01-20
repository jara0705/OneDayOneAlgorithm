package com.jara.alg.tree;

/**
 * 判断二叉树是不是平衡二叉树
 * Created by Jiaqi on 2018/1/20.
 */
public class BalanceTree {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);
        System.out.println("" + isBanlance(tree));
    }

    private static boolean isBanlance(BinaryTree tree) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(tree, 1, res);
        return res[0];
    }

    private static int getHeight(BinaryTree tree, int level, boolean[] res) {
        if (tree == null) {
            return level;
        }
        int lH = getHeight(tree.left, level + 1, res);
        if (!res[0]) {
            return level;
        }
        int rH = getHeight(tree.right, level + 1, res);
        if (!res[0]) {
            return level;
        }
        if (Math.abs(lH - rH) > 1) {
            res[0] = false;
        }
        return Math.max(lH, rH);
    }

}
