class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None

class DoublyLinkedList:
    def __init__(self):
        self.head = None

    def append(self, data):
        new_node = Node(data)
        if self.head is None:
            new_node.prev = None
            self.head = new_node
        else:
            current_node = self.head
            while current_node.next != None:
                current_node = current_node.next
            current_node.next = new_node
            new_node.prev = current_node
            new_node.next = None

    def prepend(self, data):
        new_node = Node(data)
        if self.head is None:
            new_node.prev = None
            self.head = new_node
        else:
            current_node = self.head
            current_node.prev = new_node
            new_node.next = current_node
            new_node.prev = None
            self.head = new_node

    def reverse(self):
        temp_node = None
        current_node = self.head
        while current_node:
            temp_node = current_node.prev
            current_node.prev = current_node.next
            current_node.next = temp_node
            current_node = current_node.prev
        if temp_node is not None:
            self.head = temp_node.prev
            
    def print_list(self):
        current_node = self.head
        while current_node != None:
            print(current_node.data)
            current_node = current_node.next

dllist = DoublyLinkedList()
dllist.append(1)
dllist.append(2)
dllist.append(3)
dllist.append(4)
dllist.prepend(0)

dllist.reverse()

dllist.print_list()