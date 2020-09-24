package io.programminglife.trees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
    public TreeNode root;

    public void addNode(Integer key) {
        if (key != null) {
            TreeNode newNode = new TreeNode(key);
            if(root == null) {
                root = newNode;
            } else {
                TreeNode focusNode = root;
                TreeNode parent;

                while(true) {
                    parent = focusNode;
                    if(key < focusNode.val) {
                        focusNode = focusNode.left;
                        if(focusNode == null) {
                            parent.left = newNode;
                            return;
                        }
                    } else {
                        focusNode = focusNode.right;
                        if(focusNode == null) {
                            parent.right = newNode;
                            return;
                        }
                    }
                }
            }
        }
    }

    public TreeNode findNode(int key) {
        TreeNode focusNode = root;

        while(focusNode.val != key) {
            if(key < focusNode.val) {
                focusNode = focusNode.left;
            } else {
                focusNode = focusNode.right;
            }
            if(focusNode == null) {
                return null;
            }
        }

        return focusNode;
    }

    public void inOrderTraverseTree(TreeNode focusNode) {
        if(focusNode != null) {
            inOrderTraverseTree(focusNode.left);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.right);
        }
    }

    public void preOrderTraverseTree(TreeNode focusNode) {
        if(focusNode != null) {
            System.out.println(focusNode);
            preOrderTraverseTree(focusNode.left);
            preOrderTraverseTree(focusNode.right);
        }
    }

    public void postOrderTraverseTree(TreeNode focusNode) {
        if(focusNode != null) {
            postOrderTraverseTree(focusNode.left);
            postOrderTraverseTree(focusNode.right);
            System.out.println(focusNode);
        }
    }

    public List<Integer> inOrderTraverseTreeNonRecursive(TreeNode root ) {
        List<Integer> values = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root == null) {
            return values;
        }

        TreeNode current = root;
        while(current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            values.add(current.val);
            current = current.right;
        }

        return values;
    }

    public List<Integer> postOrderTraverseTreeNonRecursive(TreeNode root) {
        List<Integer> values = new ArrayList<>();

        if(root == null) {
            return values;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            values.add(0, current.val);
            if(current.left != null) {
                stack.push(current.left);
            }
            if(current.right != null) {
                stack.push(current.right);
            }
        }
        
        return values;
    }

    public List<Integer> preOrderTraverseTreeNonRecursive(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.println("====> " + current.val);
            //values.add(current.key);

            if(current.right != null) {
                stack.push(current.right);
            }

            if(current.left != null) {
                stack.push(current.left);
            }
        }

        return values;
    }

    public List<Integer> breadthFirstSearch() {
        TreeNode current = root;
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(current);

        while(queue.size() > 0) {
            current = queue.remove();
            result.add(current.val);
            if(current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null) {
                queue.add(current.right);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.addNode(9);
        bst.addNode(4);
        bst.addNode(6);
        bst.addNode(20);
        bst.addNode(1);
        bst.addNode(15);
        bst.addNode(170);

         List<Integer> nodes = bst.breadthFirstSearch();
         for(Integer value : nodes) {
             System.out.println(value);
         }
//        System.out.println("\n");
//        bst.preOrderTraverseTree(bst.root);

    }
}
