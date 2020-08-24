package io.programminglife.leetcode.LinkedLists;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }

    void print() {
        ListNode current = this;
        while(current.next != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }

        if(current != null) {
            System.out.print(current.val);
        }
    }

}
