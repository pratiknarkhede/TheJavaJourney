package com.pratik.thejavajourney.dsa.linkedlist;

public class ReverseTheLinkedList {
    public static void main(String[] args) {

        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        printList(head);
        head = reverseList(head);
        printList(head);


    }


//while solving this problem focus on recursion breaking condition
//suppose this is list p -> q -> r -> s -> t -> u -> null
//our recursion will end when head goes to u
//then it will return and go to t
//now head = t
// t -> u
// expected u -> t
//
// u.next=t
// t.next=null (break link between t to u)
// t=head and u=head.next
//
// head.next.next=head
// head.next=null


    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

       // We're using newHead  to keep track of the new head of the reversed list.
       //newHead is updated at each recursive call to point to the new head of the reversed list.
        // When the recursion ends, newHead points to the original last node (u), which is now the new head of the reversed list.
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

}





