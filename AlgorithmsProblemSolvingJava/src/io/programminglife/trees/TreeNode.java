package io.programminglife.trees;

public class TreeNode {

    public Integer val;

    public TreeNode left;
    public TreeNode right;

    TreeNode(Integer key) {
        this.val = key;
    }

    public String toString() {
        return String.valueOf(val);
    }

}
