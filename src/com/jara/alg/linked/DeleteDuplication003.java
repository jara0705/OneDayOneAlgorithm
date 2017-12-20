package com.jara.alg.linked;

import java.util.HashSet;

/**
 * 删除单链表中数值重复出现的节点
 * Created by Jiaqi on 2017/12/20.
 */
public class DeleteDuplication003 {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(1);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        deleteDuplication(node);
    }

    private static void deleteDuplication(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node next = head.next;
        HashSet<Integer> set = new HashSet<>();
        set.add(cur.value);
        while (next != null) {
            if (set.contains(next.value)) {
                cur = next;
            } else {
                set.add(next.value);
                cur = next;
            }
            next = next.next;
        }
        for (Integer i : set) {
            System.out.print(i + " ");
        }
    }

}
