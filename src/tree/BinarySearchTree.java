package tree;

public class BinarySearchTree {

    // The root node of the binary search tree
    private Node root;

    // The Node class represents a node in the binary search tree
    class Node {
        // The value stored in the node
        public int value;
        // The left subtree of the node
        public Node left;
        // The right subtree of the node
        public Node right;

        // Constructor that takes an int value and sets the value of the node
        Node(int value) {
            this.value = value;
        }
    }

    // Get the root node of the binary search tree
    public Node getRoot() {
        return root;
    }

    public boolean insert(int value) {
        // Create a new node with the given value
        Node newNode = new Node(value);

        // If the tree is empty...
        if (root == null) {
            // Set the root to be the new node
            root = newNode;
            // Return true to indicate that the insertion was successful
            return true;
        }

        // Set temp to be the root node
        Node temp = root;

        // Loop until the new node is successfully inserted or determined to be a duplicate
        while (true) {
            // If the new node's value is equal to the current node's value, return false to indicate that the insertion failed
            if (newNode.value == temp.value)
                return false;

            // If the new node's value is less than the current node's value...
            if (newNode.value < temp.value) {
                // If the current node does not have a left child...
                if (temp.left == null) {
                    // Set the left child of the current node to be the new node
                    temp.left = newNode;
                    // Return true to indicate that the insertion was successful
                    return true;
                }
                // Otherwise, set temp to be the left child of the current node and continue looping
                temp = temp.left;
            } else {
                // If the current node does not have a right child...
                if (temp.right == null) {
                    // Set the right child of the current node to be the new node
                    temp.right = newNode;
                    // Return true to indicate that the insertion was successful
                    return true;
                }
                // Otherwise, set temp to be the right child of the current node and continue looping
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        // If the tree is empty, return false
        if (root == null) {
            return false;
        }

        // Start at the root node
        Node temp = root;

        // Loop until we find a node with the given value or exhaust the search space
        while (temp != null) {
            if (value < temp.value) {
                // If the given value is less than the current node's value, search the left subtree
                temp = temp.left;
            } else if (value > temp.value) {
                // If the given value is greater than the current node's value, search the right subtree
                temp = temp.right;
            } else {
                // If the given value is equal to the current node's value, we've found the node, so return true
                return true;
            }
        }

        // If we've exhausted the search space without finding the value, return false
        return false;
    }


}