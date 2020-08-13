package io.programminglife.trees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
    Node root;

    public void addNode(int key) {
        Node newNode = new Node(key);
        if(root == null) {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;

            while(true) {
                parent = focusNode;
                if(key < focusNode.key) {
                    focusNode = focusNode.leftChild;
                    if(focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightChild;
                    if(focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node findNode(int key) {
        Node focusNode = root;

        while(focusNode.key != key) {
            if(key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            if(focusNode == null) {
                return null;
            }
        }

        return focusNode;
    }

    public void inOrderTraverseTree(Node focusNode) {
        if(focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void preOrderTraverseTree(Node focusNode) {
        if(focusNode != null) {
            System.out.println(focusNode);
            preOrderTraverseTree(focusNode.leftChild);
            preOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void postOrderTraverseTree(Node focusNode) {
        if(focusNode != null) {
            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }

    public List<Integer> inOrderTraverseTreeNonRecursive(Node root ) {
        List<Integer> values = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        if(root == null) {
            return values;
        }

        Node current = root;
        while(current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.push(current);
                current = current.leftChild;
            }

            current = stack.pop();
            values.add(current.key);
            current = current.rightChild;
        }

        return values;
    }

    public List<Integer> postOrderTraverseTreeNonRecursive(Node root) {
        List<Integer> values = new ArrayList<>();

        if(root == null) {
            return values;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node current = stack.pop();
            values.add(0, current.key);
            if(current.leftChild != null) {
                stack.push(current.leftChild);
            }
            if(current.rightChild != null) {
                stack.push(current.rightChild);
            }
        }
        
        return values;
    }

    public List<Integer> preOrderTraverseTreeNonRecursive(Node root) {
        List<Integer> values = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println("====> " + current.key);
            //values.add(current.key);

            if(current.rightChild != null) {
                stack.push(current.rightChild);
            }

            if(current.leftChild != null) {
                stack.push(current.leftChild);
            }
        }

        return values;
    }

    public List<Integer> breadthFirstSearch() {
        Node current = root;
        List<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(current);

        while(queue.size() > 0) {
            current = queue.remove();
            result.add(current.key);
            if(current.leftChild != null) {
                queue.add(current.leftChild);
            }
            if(current.rightChild != null) {
                queue.add(current.rightChild);
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

class Node {
    int key;

    Node leftChild;
    Node rightChild;

    Node(int key) {
        this.key = key;
    }

    public String toString() {
        return String.valueOf(key);
    }
}
