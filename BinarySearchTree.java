package BinaryAndHash;

class MyBinaryNode {
    int key;
    MyBinaryNode left;
    MyBinaryNode right;

    public MyBinaryNode(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

class MyBinarySearchTree {
    private MyBinaryNode root;

    public void add(int key) {
        this.root = addNode(root, key);
    }

    private MyBinaryNode addNode(MyBinaryNode currentNode, int key) {
        if (currentNode == null) {
            return new MyBinaryNode(key);
        }

        if (key < currentNode.key) {
            currentNode.left = addNode(currentNode.left, key);
        } else if (key > currentNode.key) {
            currentNode.right = addNode(currentNode.right, key);
        }

        return currentNode;
    }

    public int size() {
        return getSize(root);
    }

    private int getSize(MyBinaryNode currentNode) {
        if (currentNode == null) {
            return 0;
        }

        return 1 + getSize(currentNode.left) + getSize(currentNode.right);
    }

    public boolean search(int key) {
        return searchNode(root, key);
    }

    private boolean searchNode(MyBinaryNode currentNode, int key) {
        if (currentNode == null) {
            return false;
        }

        if (key == currentNode.key) {
            return true;
        } else if (key < currentNode.key) {
            return searchNode(currentNode.left, key);
        } else {
            return searchNode(currentNode.right, key);
        }
    }
}

public class BinarySearchTree {
    public static void main(String[] args) {
        // Ability to create a BST by adding 56, 30, and 70
        MyBinarySearchTree bst = new MyBinarySearchTree();
        bst.add(56);
        bst.add(30);
        bst.add(70);

        System.out.println("Size of BST: " + bst.size());

        // Ability to create a binary tree - 56, 30, 70, 22, 40, 11, 3, 16, 60, 95, 65, 63, 67
        MyBinarySearchTree binaryTree = new MyBinarySearchTree();
        binaryTree.add(56);
        binaryTree.add(30);
        binaryTree.add(70);
        binaryTree.add(22);
        binaryTree.add(40);
        binaryTree.add(11);
        binaryTree.add(3);
        binaryTree.add(16);
        binaryTree.add(60);
        binaryTree.add(95);
        binaryTree.add(65);
        binaryTree.add(63);
        binaryTree.add(67);

        System.out.println("Size of binary tree: " + binaryTree.size());

        // Ability to search 63 in the Binary Tree
        boolean found = binaryTree.search(63);
        System.out.println("63 found in the Binary Tree: " + found);
    }
}
