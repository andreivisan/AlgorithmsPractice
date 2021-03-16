class BST:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


class TreeInfo:
    def __init__(self, kthMax, index):
        self.kthMax = kthMax
        self.index = index


def findKthLargestValueInBst(tree, k):
    ti = TreeInfo(-1, 0)
    reverseInOrder(tree, k, ti)
    return ti.kthMax


def reverseInOrder(tree, k, tree_info):
    if not tree or tree_info.index >= k:
        return

    reverseInOrder(tree.right, k, tree_info)

    if (tree_info.index < k):
        tree_info.index += 1
        tree_info.kthMax = tree.value
        reverseInOrder(tree.left, k, tree_info)
