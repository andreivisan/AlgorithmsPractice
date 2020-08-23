package io.programminglife.leetcode.LinkedLists;

/**
 * Given head which is a reference node to a singly-linked list.
 * The value of each node in the linked list is either 0 or 1.
 * The linked list holds the binary representation of a number.
 * Return the decimal value of the number in the linked list.
 *
 * Example 1:
 *
 *
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 */
public class DecimalValue {

    public static int getDecimalValue(ListNode head) {
        int decimalValue = 0;
        ListNode current = reverseLinkedList(head);
        int base = 1;

        while(current != null) {
            if(current.val == 1) {
                decimalValue = decimalValue + base;
            }
            base = base * 2;
            current = current.next;
        }

        return decimalValue;
    }

    public static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;

        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode node4 = new ListNode(0, null);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(0, node3);
        ListNode head = new ListNode(1, node2);

        System.out.println(getDecimalValue(head));
    }

}
