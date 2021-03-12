package io.programminglife.algoexpert.easy;

public class LinkedListRemoveDuplicates {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList current = linkedList;

        if (linkedList == null) {
            return linkedList;
        }

        while (current.next != null) {
            LinkedList next = current.next;
            if (current.value == next.value) {
                current.next = next.next;
            } else {
                current = current.next;
            }
        }

        return linkedList;
    }

}
