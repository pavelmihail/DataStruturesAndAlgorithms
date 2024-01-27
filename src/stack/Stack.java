package stack;

public class Stack {
    // Initialize the top node of the stack and its height
    private Node top;
    private int height;

    // Create a Node class to represent individual nodes in the stack
    class Node {
        int value; // stores the value of the node
        Node next; // stores the reference to the next node in the stack

        // Constructor to create a new node with the given value
        Node(int value) {
            this.value = value;
        }
    }

    // Constructor to create a new stack with the given value as the top element
    public Stack(int value) {
        Node newNode = new Node(value); // create a new node with the given value
        top = newNode; // set the new node as the top of the stack
        height = 1; // set the initial height of the stack to 1
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (height == 0) {
            System.out.println("Top: null");
        } else {
            System.out.println("Top: " + top.value);
        }
        System.out.println("Height:" + height);
        System.out.println("\nStack:");
        if (height == 0) {
            System.out.println("empty");
        } else {
            printStack();
        }
    }

    public void makeEmpty() {
        top = null;
        height = 0;
    }

    public void push(int value) {
        // Create a new node with the given value
        Node newNode = new Node(value);
        // If the stack is empty, set the new node as the top
        if(height == 0) {
            top = newNode;
        } else {
            // Otherwise, set the next node of the new node as the current top node,
            // and then set the new node as the new top node
            newNode.next = top;
            top = newNode;
        }
        // Increase the height of the stack by 1
        height++;
    }

    public Node pop() {
        // if the stack is empty, return null
        if(height == 0) return null;

        // create temporary variable that points to top node
        Node temp = top;
        // set the new top to point to the next node in the stack
        top = top.next;
        // set the next pointer of the temporary node to null
        temp.next = null;

        // decrease the height of the stack
        height--;
        // return the popped node
        return temp;
    }
}
