class node:
    def __init__(self, data=None):
        self.data = data
        self.next = None

class linked_list:
    def __init__(self):
        self.head = None

    def append(self, data):
        new_node = node(data)

        if self.head is None:
            self.head = new_node
            return

        current = self.head
        while current.next != None:
            current = current.next
        current.next = new_node

    def prepend(self, data):
        new_node = node(data)
        new_node.next = self.head
        self.head = new_node

    def insert(self, index, data):
        if index >= self.length():
            print("ERROR: 'Insert' Index is out of range")
        current = self.head
        new_node = node(data)
        current_index = 0
        if index == 0:
            self.prepend(data)
            return
        while current_index < index-1:
            current = current.next
            current_index += 1
        next_node = current.next
        current.next = new_node
        new_node.next = next_node

    def length(self):
        current = self.head
        total = 0
        while current.next != None:
            total += 1
            current = current.next
        return total

    def display(self):
        current_node = self.head
        while current_node != None:
            print(current_node.data)
            current_node = current_node.next

    def get(self, index):
        if index >= self.length():
            print("ERROR: 'Get' Index is out of range")
            return None
        current_index = 0
        current_node = self.head
        while True:
            current_node = current_node.next
            if current_index == index:
                return current_node.data
            current_index += 1

    def delete(self, index):
        if index >= self.length():
            print("ERROR: 'Erase' Index is out of range")
            return None
        current_index = 0
        current_node = self.head
        while True:
            last_node = current_node
            current_node = current_node.next
            if current_index == index:
                last_node.next = current_node.next
                return
            current_index += 1

    def reverse(self):
        if self.head.next is None:
            return
        
        first_node = self.head
        second_node = first_node.next

        while second_node:
            holder_node = second_node.next
            second_node.next = first_node
            first_node = second_node
            second_node = holder_node

        self.head.next = None
        self.head = first_node


my_list = linked_list()

my_list.append(1)
my_list.append(2)
my_list.append(3)
my_list.append(4)
my_list.insert(0, 7)

my_list.display()

my_list.reverse()
print('\n')

my_list.display()