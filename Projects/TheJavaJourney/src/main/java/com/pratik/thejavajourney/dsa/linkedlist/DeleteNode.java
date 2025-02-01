package com.pratik.thejavajourney.dsa.linkedlist;

public class DeleteNode {
    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode nodeTobeDeleted = new ListNode(3);
        head.next.next = nodeTobeDeleted;
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        printList(head);
        deleteNode(nodeTobeDeleted);
    }

    private static void deleteNode(ListNode nodeTobeDeleted) {

    }


    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

}
