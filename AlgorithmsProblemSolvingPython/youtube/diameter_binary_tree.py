class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def diameterOfBinaryTree(self, root: TreeNode) -> int:
    def maxDepth(root):
        if root is None:
            return 0
        left_height = maxDepth(root.left)
        right_height = maxDepth(root.right)
        ans[0] = max(ans[0], left_height + right_height)
        return max(left_height, right_height) + 1
    ans = [0]
    maxDepth(root)
    return ans[0]
