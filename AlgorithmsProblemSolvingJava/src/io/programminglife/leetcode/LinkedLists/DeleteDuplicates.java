package io.programminglife.leetcode.LinkedLists;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class DeleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while(current != null) {
            ListNode next = current.next;
            if(next != null && current.val == next.val) {
                current.next = next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(3, null);
        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(1, null);
        ListNode node2 = new ListNode(1, node3);
        ListNode l1 = new ListNode(1, node2);

        l1.print();

        System.out.println();

        deleteDuplicates(l1).print();
    }

}
