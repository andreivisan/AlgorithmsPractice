class BST:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


class TreeInfo:
    def __init__(self, rootIdx):
        self.rootIdx = rootIdx


def reconstructBst(preOrderTraversalValues):
    tree_info = TreeInfo(0)
    return reconstructBstRec(float("-inf"), float("inf"), preOrderTraversalValues, tree_info)


def reconstructBstRec(lowerBound, upperBound, preOrderTraversalValues, tree_info):
    if (len(preOrderTraversalValues) == tree_info.rootIdx):
        return None

    root_value = preOrderTraversalValues[tree_info.rootIdx]
    if (root_value < lowerBound or root_value >= upperBound):
        return None

    tree_info.rootIdx += 1
    left_tree = reconstructBstRec(
        lowerBound, root_value, preOrderTraversalValues, tree_info)
    right_tree = reconstructBstRec(
        root_value, upperBound, preOrderTraversalValues, tree_info)

    root = BST(root_value, left_tree, right_tree)

    return root
