package com.pratik.thejavajourney.interviewprep.microsoft.easy;

import com.pratik.thejavajourney.dsa.linkedlist.ListNode;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next = new ListNode(6);
        MiddleOfLinkedList middleOfLinkedList = new MiddleOfLinkedList();
        ListNode middleNode = middleOfLinkedList.middleNode(list);
        System.out.println(middleNode.val);
    }


    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
}
