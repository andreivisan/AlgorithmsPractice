package io.programminglife.algoexpert.medium;

public class BSTConstruction {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            if (value < this.value) {
                if (this.left == null) {
                    this.left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (this.right == null) {
                    this.right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
            return this;
        }

        public boolean contains(int value) {
            if (this.left == null && this.right == null) {
                return this.value == value;
            }

            if (this.value == value) {
                return true;
            }

            if (value < this.value) {
                if (left != null) {
                    return left.contains(value);
                }
            } else {
                if (right != null) {
                    return right.contains(value);
                }
            }

            return false;
        }

        public BST remove(int value) {
            remove(value, null);
            return this;
        }

        private void remove(int value, BST parentNode) {
            BST currentNode = this;

            while(currentNode != null) {
                if (value < currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.left;
                } else if (value > currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.right;
                } else {
                    if (currentNode.left != null && currentNode.right != null) {
                        currentNode.value = currentNode.right.getMinValue();
                        currentNode.right.remove(currentNode.value, currentNode);
                    } else if (parentNode == null) {
                        if (currentNode.left != null) {
                            currentNode.value = currentNode.left.value;
                            currentNode.right = currentNode.left.right;
                            currentNode.left = currentNode.left.left;
                        } else if (currentNode.right != null) {
                            currentNode.value = currentNode.right.value;
                            currentNode.left = currentNode.right.left;
                            currentNode.right = currentNode.right.right;
                        } else {
                            //One node tree -> Do nothing
                        }
                    } else if (parentNode.left == currentNode) {
                        parentNode.left = currentNode.left != null ? currentNode.left : currentNode.right;
                    } else if (parentNode.right == currentNode) {
                        parentNode.right = currentNode.left != null ? currentNode.left : currentNode.right;
                    }
                    break;
                }
            }
        }

        public void print(BST root) {
            if (root == null) {
                return;
            }

            System.out.print(root.value + " ");
            print(root.left);
            print(root.right);
        }

        private int getMinValue() {
            BST currentNode = this;
            while (currentNode.left != null) {
                currentNode = currentNode.left;
            }

            return currentNode.value;
        }
    }

    public static void main(String[] args) {
        BST tree = new BST(10);
        tree = tree.insert(5);
        tree = tree.insert(15);
        tree = tree.insert(2);
        tree = tree.insert(5);
        tree = tree.insert(13);
        tree = tree.insert(22);
        tree = tree.insert(1);
        tree = tree.insert(14);
        tree = tree.insert(12);

        tree.print(tree);

        System.out.println(tree.contains(25));
    }

}
