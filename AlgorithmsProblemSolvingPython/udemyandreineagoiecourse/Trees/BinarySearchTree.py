class Node:
    def __init__(self, data=None):
        self.data = data
        self.left = None
        self.right = None

class BinarySearchTree:
    def __init__(self):
        self.root = None

    def insert(self, data):
        if self.root is None:
            self.root = Node(data)
        else:
            self._insert(data, self.root)

    def _insert(self, data, current_node):
        if data < current_node.data:
            if current_node.left is None:
                current_node.left = Node(data)
            else:
                self._insert(data, current_node.left)
        elif data > current_node.data:
            if current_node.right is None:
                current_node.right = Node(data)
            else:
                self._insert(data, current_node.right)
        else:
            print("Value is already present in the tree")

    def find(self, data):
        if self.root:
            is_found = self._find(data, self.root)
            if is_found:
                return True
            return False
        else:
            return None

    def _find(self, data, current_node):
        if data > current_node.data and current_node.right:
            return self._find(data, current_node.right)
        elif data < current_node.data and current_node.left:
            return self._find(data, current_node.left)
        if data == current_node.data:
            return True

    def inOrderTraverseTree(self, root):
        values = []
        stack = []

        if root == None:
            return values

        current = self.root
        while not current is None or stack:
            while not current is None:
                stack.append(current)
                current = current.left
            
            current = stack.pop()
            values.append(current.data)
            current = current.right

        return values

    def inOrderTraverseTreeRec(self, focus_node, values):
        if focus_node: 
            self.inOrderTraverseTreeRec(focus_node.left, values)
            values.append(focus_node.data)
            self.inOrderTraverseTreeRec(focus_node.right, values)

        return values

    def postOrderTraverseTree(self, root):
        values = []
        stack = []

        if root == None:
            return values

        stack.append(root)
        while stack:
            current = stack.pop()
            values.insert(0, current.data)

            if current.left is not None:
                stack.append(current.left)

            if current.right is not None:
                stack.append(current.right)

        return values

    def postOrderTraverseTreeRec(self, root, values):
        if root:
            self.postOrderTraverseTreeRec(root.left, values)
            self.postOrderTraverseTreeRec(root.right, values)
            values.append(root.data)

        return values

    def preOrderTraverseTree(self, root):
        values = []
        stack = []

        if root is None:
            return values

        stack.append(root)

        while stack:
            current = stack.pop()
            values.append(current.data)

            if current.right is not None:
                stack.append(current.right)

            if current.left is not None:
                stack.append(current.left)
             
        return values

    def preOrderTraverseTreeRec(self, root, values):
        if root:
            values.append(root.data)
            self.preOrderTraverseTreeRec(root.left, values)
            self.preOrderTraverseTreeRec(root.right, values)

        return values

    def breadthFirstSearch(self):
        current = self.root
        queue = []
        result = []

        queue.append(current)

        while len(queue) > 0:
            current = queue.pop(0)
            result.append(current.data)
            if current.left:
                queue.append(current.left)
            if current.right:
                queue.append(current.right)

        return result

bst = BinarySearchTree()
bst.insert(9)
bst.insert(4)
bst.insert(6)
bst.insert(20)
bst.insert(1)
bst.insert(15)
bst.insert(170)

print(bst.breadthFirstSearch())



