package io.programminglife.leetcode.LinkedLists;

import java.util.List;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 */
public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }

        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode reversedSecondHalfStart = reverse(firstHalfEnd.next);

        ListNode p1 = head;
        ListNode p2 = reversedSecondHalfStart;
        boolean result = true;
        while(result && p2 != null) {
            if(p1.val != p2.val) {
                result = false;
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        firstHalfEnd.next = reverse(reversedSecondHalfStart);

        return result;
    }

    public static ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;

        while(head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode node4 = new ListNode(1, null);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode l1 = new ListNode(1, node2);

        l1.print();

        System.out.println();

        System.out.println(isPalindrome(l1));
    }

}
