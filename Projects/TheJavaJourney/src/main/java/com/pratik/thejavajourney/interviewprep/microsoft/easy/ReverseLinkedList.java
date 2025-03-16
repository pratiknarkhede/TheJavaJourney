package com.pratik.thejavajourney.interviewprep.microsoft.easy;

import com.pratik.thejavajourney.dsa.linkedlist.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        printList(head);
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode reverseList = reverseLinkedList.reverseList(head);
        printList(reverseList);

    }

    /*
    * public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    * */


    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next_node;

        /*
         * one thing to cement in mind is we are not swapping two nodes
         *
         * instead we are reversing each node in each iteration
         *
         * so we will maintain previous pointer to keep track of previous node
         * with respect to current one which we are reversing
         *
         * then current node: current node which we are reversing
         *
         * next_node: this will be node to wich next pointer of current is poining
         * since this will be lost as we will be assigning current.next to previous while reversing
         * we need to store it , otherwise access to remaining list will be lost
         *
         *
         * */

        while (current != null) {
            next_node = current.next;
            current.next = previous;
            previous=current;
            current = next_node;
        }

        return previous;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
