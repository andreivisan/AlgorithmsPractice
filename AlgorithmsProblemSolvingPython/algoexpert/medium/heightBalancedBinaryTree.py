class BinaryTree:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


class TreeInfo:
    def __init__(self, height, is_balanced):
        self.height = height
        self.is_balanced = is_balanced


def heightBalancedBinaryTree(tree):
    tree_info = get_binary_tree_info(tree)
    return tree_info.is_balanced


def get_binary_tree_info(tree):
    if not tree:
        return TreeInfo(-1, True)

    left_subtree = get_binary_tree_info(tree.left)
    right_subtree = get_binary_tree_info(tree.right)

    is_balanced = (left_subtree.is_balanced and right_subtree.is_balanced) and abs(
        left_subtree.height - right_subtree.height) <= 1
    height = max(left_subtree.height, right_subtree.height) + 1

    return TreeInfo(height, is_balanced)
