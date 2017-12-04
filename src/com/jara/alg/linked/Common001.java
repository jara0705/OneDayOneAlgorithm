package com.jara.alg.linked;

/**
 * 两个有序链表公共部分
 * Created by Jiaqi on 2017/12/4.
 */
public class Common001 {

    public static void main(String[] args) {
        Node node11 = new Node(1);
        node11.next = new Node(2);
        node11.next.next = new Node(3);
        Node node21 = new Node(2);
        node21.next = new Node(3);
        printCommonPart(node11, node21);
    }

    private static void printCommonPart(Node head1, Node head2) {
        System.out.print("Common part: ");
        // 默认为升序的链表
        while(head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value){
                head2 = head2.next;
            } else {
                System.out.println(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }

}
