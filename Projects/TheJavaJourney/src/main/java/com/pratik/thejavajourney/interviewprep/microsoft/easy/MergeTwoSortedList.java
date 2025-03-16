package com.pratik.thejavajourney.interviewprep.microsoft.easy;

import com.pratik.thejavajourney.dsa.linkedlist.ListNode;

public class MergeTwoSortedList {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        MergeTwoSortedList mergeTwoSortedList=new MergeTwoSortedList();
        ListNode mergeList = mergeTwoSortedList.mergeTwoLists(list1, list2);
        printList(mergeList);


    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // creating new node and attaching desired nodes next to it ,
        ListNode list3 = new ListNode(0);
        ListNode p3 = list3;

        while (list1 != null && list2 != null) {
            if(list1.val <= list2.val){
                p3.next=list1;
                list1=list1.next;
            }else{
                p3.next=list2;
                list2=list2.next;
            }
            p3=p3.next;
        }

        // if either of the list is remaninign append it at the last
        if(list1!=null){
            p3.next=list1;
        } else if (list2 !=null) {
            p3.next=list2;
        }
        return list3.next;

    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
