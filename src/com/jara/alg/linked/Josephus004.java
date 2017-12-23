package com.jara.alg.linked;

/**
 * 约瑟夫环问题
 * Created by Jiaqi on 2017/12/23.
 */
public class Josephus004 {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = node;
        josephus(node, 1);
    }

    private static void josephus(Node node, int m) {
        if (node == null || m < 1) {
            return;
        }
        Node tail = node;
        while (tail.next != node) {
            tail = tail.next;
        }
        int i = 0;
        while (node != tail) {
            if (++i == m) {
                tail.next = node.next;
                i = 0;
            } else {
                tail = tail.next;
            }
            node = tail.next;
        }
        System.out.println(node.value + " ");

    }

}
