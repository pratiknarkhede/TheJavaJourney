package com.pratik.thejavajourney.dsa.linkedlist;

public class MergePointOfLinkedList {

    /*    Calculate the difference in node count between the two linked lists.
    Move the temporary head of the longer linked list by the difference count.
    Compare each node of both linked lists by traversing further to find the merge point.*/

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);

        ListNode list2 = new ListNode(6);
        list2.next = new ListNode(7);
        list2.next.next = new ListNode(8);
        list2.next.next.next = list1.next.next.next; // Merge point

        ListNode mergePoint = getIntersectionNode(list1, list2);
        if (mergePoint != null) {
            System.out.println("Merge point value: " + mergePoint.val);
        }else{
            System.out.println("provide valid input");
        }
    }


    public static ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) return null;
        ListNode p1 = head1;
        ListNode p2 = head2;
        int lengthOfList1 = 0;
        int lengthOfList2 = 0;
        int diff = 0;
        ListNode mergePointValue;
        while (p1 != null) {
            lengthOfList1++;
            p1 = p1.next;
        }

        while (p2 != null) {
            lengthOfList2++;
            p2 = p2.next;
        }
        //reset p1 and p2 to head to utilize those again for traversing
        p1 = head1;
        p2 = head2;

        if (lengthOfList1 > lengthOfList2) {
            diff = lengthOfList1 - lengthOfList2;
            //since lenght of list1 is more , we will move the p1 with value 'diff'  so that now if we count ,length of both will be same
            for (int i = 0; i < diff; i++) {
                p1 = p1.next;
            }
        } else {
            diff = lengthOfList2 - lengthOfList1;
            for (int i = 0; i < diff; i++) {
                p2 = p2.next;
            }
        }
        //now that length of both is equal , we will compare value of each node to find common value
        while (p1 != null || p2 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        //since we didnt find intersection hence returning null
        return null;
    }
}
