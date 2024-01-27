package doubleyLinkedList;

public class DoublyLinkedList {

    // Declare head of the doubly linked list.
    private Node head;
    // Declare tail of the doubly linked list.
    private Node tail;
    // Declare length of the doubly linked list.
    private int length;

    // Nested class for the nodes of the doubly linked list.
    class Node {
        // Declare integer value of the node.
        int value;
        // Declare reference to the next node.
        Node next;
        // Declare reference to the previous node.
        Node prev;

        // Constructor to create a new node with a given value.
        Node(int value) {
            this.value = value;
        }
    }

    // Constructor to create a new doubly linked list with a single node.
    public DoublyLinkedList(int value) {
        // Create a new node with the given value.
        Node newNode = new Node(value);
        // Set the head and tail of the list to the new node.
        head = newNode;
        tail = newNode;
        // Set the length of the list to 1.
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    // Go through all the list and print each Node value
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }


    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value) {
        // Create a new node with the given value.
        Node newNode = new Node(value);
        if (length == 0) {
            // If the list is empty, set both the head and tail to the new node.
            head = newNode;
            tail = newNode;
        } else {
            // Otherwise, add the new node to the end of the list by updating the `next` and `prev` fields of the relevant nodes.
            // Set the `next` field of the current tail node to the new node.
            tail.next = newNode;
            // Set the `prev` field of the new node to the current tail node.
            newNode.prev = tail;
            // Set the `tail` member variable to the new node.
            tail = newNode;
        }
        // Increment the `length` member variable by 1 to indicate that the list has one more node.
        length++;
    }

    public Node removeLast() {
        // If the list is empty, return null.
        if (length == 0) return null;
        // Create a new node `temp` to hold the value of the last node.
        Node temp = tail;
        // If the list contains only one node, set both `head` and `tail` to null.
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            // Otherwise, update the `tail` and `prev` fields of the second-to-last node
            // and the `next` and `prev` fields of the last node.
            // Set the `tail` to the previous node of the current tail.
            tail = tail.prev;
            // Set the `next` field of the new tail to `null`.
            tail.next = null;
            // Set the `prev` field of `temp` to `null`.
            temp.prev = null;
        }
        // Decrement the `length` by 1 to indicate that the list has one less node.
        length--;
        // Return the `temp` node, which holds the value of the removed last node.
        return temp;
    }

    public void prepend(int value) {
        // Create a new node with the given value.
        Node newNode = new Node(value);

        // If the list is empty, set both head and tail to the new node.
        if (length == 0) {
            head = newNode;
            tail = newNode;
        }
        // If the list is not empty, insert the new node at the head of the list.
        else {
            // Set the next field of the new node to point to the current head.
            newNode.next = head;
            // Set the prev field of the current head to point to the new node.
            head.prev = newNode;
            // Set the head of the list to be the new node.
            head = newNode;
        }
        // Increment the length of the list.
        length++;
    }

    public Node removeFirst() {
        // If the list is empty, return null
        if (length == 0) return null;

        // Get the first node
        Node temp = head;

        if (length == 1) { // If there is only one node in the list
            head = null;
            tail = null;
        } else { // If there are more than one node in the list
            // Set the head to the next node
            head = head.next;
            // Set the previous pointer of the new head to null
            head.prev = null;
            // Set the next pointer of the removed node to null
            temp.next = null;
        }

        // Decrease the length of the list
        length--;

        // Return the removed node
        return temp;
    }

    public Node get(int index) {
        // check if the index is out of bounds, return null if true
        if (index < 0 || index >= length) return null;
        // initialize a temporary node with the value of the head
        Node temp = head;
        // if the index is in the first half of the list
        if (index < length/2) {
            // iterate through the list from the head to the index
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            // if the index is in the second half of the list
            // initialize the temporary node with the value of the tail
            temp = tail;
            // iterate through the list from the tail to the index
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        // return the node at the given index
        return temp;
    }

    public boolean set(int index, int value) {
        // Get the node at the specified index
        Node temp = get(index);
        // If the node exists, set its value to the given value and return true
        if(temp != null) {
            temp.value = value;
            return true;
        }
        // If the node does not exist, return false
        return false;
    }

    public boolean insert(int index, int value) {

        // Return false if the index is out of range
        if(index < 0 || index > length) return false;

        // If index is 0, prepend the new value to the list
        if(index == 0) {
            prepend(value);
            return true;
        }

        // If index is equal to length, append the new value to the list
        if(index == length) {
            append(value);
            return true;
        }

        // Otherwise, create a new node with the given value
        Node newNode = new Node(value);

        // Get the node before the specified index
        Node before = get(index - 1);

        // Get the node after the specified index
        Node after = before.next;

        // Set the new node's previous and next pointers to the before and after nodes
        newNode.prev = before;
        newNode.next = after;

        // Update the next pointer of the before node and the previous pointer of the after node to point to the new node
        before.next = newNode;
        after.prev = newNode;

        // Increment the length of the linked list
        length++;

        // Return true to indicate that the value was successfully inserted
        return true;
    }

    public Node remove(int index) {
        // Check if index is out of range.
        if(index < 0 || index >= length) return null;

        // If index is the first element, remove it.
        if(index == 0) return removeFirst();

        // If index is the last element, remove it.
        if(index == length - 1) return removeLast();

        // Get the node to remove.
        Node temp = get(index);

        // Update the prev and next pointers to remove the node from the linked list.
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;

        // Set the next and prev pointers of the removed node to null.
        temp.next = null;
        temp.prev = null;

        // Decrement the length of the linked list.
        length--;

        // Return the removed node.
        return temp;
    }
}
