package com.jara.alg.linked;

/**
 * 打印单链表倒数第K个节点
 * Created by Jiaqi on 2017/12/13.
 */
public class LastKNode002 {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        printLastK(node, 3);
    }

    private static void printLastK(Node node, int last) {
        if (node == null || last < 1) {
            return;
        }
        Node pre = node;
        Node pos = node;
        for (int i = 0; i < last - 1; i++) {
            if (pre.next != null) {
                pre = pre.next;
            } else {
                return;
            }
        }
        while(pre.next != null) {
            pre = pre.next;
            pos = pos.next;
        }
        System.out.println(pos.value);;
    }

}
