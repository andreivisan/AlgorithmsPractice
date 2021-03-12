class LinkedList:
    def __init__(self, value):
        self.value = value
        self.next = None


def removeDuplicatesFromLinkedList(linkedList):
    current = linkedList

    if not current:
        return linkedList

    while current.next:
        next = current.next
        if current.value == next.value:
            current.next = next.next
        else:
            current = current.next

    return linkedList
