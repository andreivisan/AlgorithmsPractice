package io.programminglife.leetcode.LinkedLists;

import java.util.List;

/**
 * Merge two sorted linked lists and return it as a new sorted list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(-1);

        ListNode temp = l3;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }

            temp = temp.next;
        }

        temp.next = l1 == null ? l2 : l1;

        return l3.next;
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(4, null);
        ListNode node2 = new ListNode(2, node3);
        ListNode l1 = new ListNode(1, node2);

        ListNode node5 = new ListNode(4, null);
        ListNode node4 = new ListNode(3, node5);
        ListNode l2 = new ListNode(1, node4);

        ListNode l3 = mergeTwoLists(l1, l2);

        while(l3.next != null) {
            System.out.print(l3.val + "->");
            l3 = l3.next;
        }

        if(l3 != null) {
            System.out.print(l3.val);
        }
    }

}
