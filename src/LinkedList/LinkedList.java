package LinkedList;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        // point the head to the new Node (also the only one)
        head = newNode;
        // point the tail to the new Node (also the only one)
        tail = newNode;
        // make the length of the List 1, because we added one element
        length = 1;
    }

    // Inner class Node representing the Node object inside the list which have value and pointer to the next Node
    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
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
        // Create a new node with the given value
        Node newNode = new Node(value);
        // If the list is empty, have both head and tail
        // point at the new node.
        // The LL could be come empty if the original node was removed.
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            // If the list is not empty, set the next node of the
            // current tail to the new node
            // and update the tail to be the new node
            tail.next = newNode;
            tail = newNode;
        }
        // Increment the length of the list
        length++;
    }

    public Node removeLast() {
        // if the length of the linked list is 0, return null
        if (length == 0) return null;

        // start at the head node
        Node temp = head;
        Node pre = head;
        // iterate through the linked list until the last node is reached
        while(temp.next != null) {
            pre = temp;  // keep track of the second-to-last node
            temp = temp.next;
        }
        // set the new tail node to be the second-to-last node
        tail = pre;
        // remove the reference to the former tail node
        tail.next = null;
        // decrement the length of the linked list
        length--;
        // if the linked list is now empty, set head and tail to null
        if (length == 0) {
            head = null;
            tail = null;
        }
        // return the removed node
        return temp;
    }

    public void prepend(int value) {
        // create a new node with the specified value
        Node newNode = new Node(value);
        // if the linked list is currently empty
        if (length == 0) {
            // set the new node as both the head and tail of the linked list
            head = newNode;
            tail = newNode;
        } else {
            // set the new node's next reference to the current head node
            newNode.next = head;
            // set the new node as the new head node of the linked list
            head = newNode;
        }
        // increment the length of the linked list
        length++;
    }
    public Node removeFirst() {
        // if the length of the linked list is 0, return null
        if (length == 0) return null;
        // save a reference to the current head node
        Node temp = head;
        // set the new head node to be the next node in the linked list
        head = head.next;
        // remove the reference to the former head node
        temp.next = null;
        // decrement the length of the linked list
        length--;
        // if the linked list is now empty, set tail to null
        if (length == 0) {
            tail = null;
        }
        // return the removed node
        return temp;
    }

    public Node get(int index) {
        // if the index is less than 0 or greater than or equal to the length of the linked list, return null
        if (index < 0 || index >= length) return null;
        // start at the head of the linked list
        Node temp = head;
        // traverse the linked list until the desired node is reached
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        // return the pointer to the node at the desired index
        return temp;
    }

    public boolean set(int index, int value) {
        // retrieve the node at the specified index
        Node temp = get(index);

        // if the index is out of bounds, return false
        if (temp != null) {
            // if the node is found, set the value of the node
            temp.value = value;
            // return true to indicate that the value was set successfully
            return true;
        }
        // return false if the index is out of bounds
        return false;
    }


    public boolean insert(int index, int value)  {
        // Check if the index is valid
        if (index < 0 || index > length) return false;

        // If the index is 0, insert at the beginning of the list
        if (index == 0) {
            prepend(value);
            return true;
        }

        // If the index is at the end, insert at the end of the list
        if (index == length) {
            append(value);
            return true;
        }

        // If the index is in the middle, insert the node
        // Create the new node
        Node newNode = new Node(value);

        // Get a pointer to the node at the previous index
        Node temp = get(index - 1);

        // Insert the new node by updating the next pointers
        newNode.next = temp.next;
        temp.next = newNode;

        // Update the length of the list
        length++;

        // Return true to indicate successful insertion
        return true;
    }

    // Remove the node at the specified index in the list
    public Node remove(int index) {
        // Check if the index is out of bounds
        if (index < 0 || index >= length) return null;
        // If the index is 0, remove the first node in the list
        if (index == 0) return removeFirst();
        // If the index is the last one in the list, remove the last node
        if (index == length - 1) return removeLast();

        // Get the previous node of the one to be removed
        Node prev = get(index - 1);
        // Get the node to be removed
        Node temp = prev.next;

        // Update the previous node's pointer to skip over the removed node
        prev.next = temp.next;
        // Detach the removed node from the list
        temp.next = null;
        // Decrease the length of the list
        length--;
        // Return the removed node
        return temp;
    }

    public void reverse() {
        // Set temp to the current head of the linked list
        Node temp = head;
        // Set the new head to be the current tail
        head = tail;
        // Set the new tail to be the previous head (stored in temp)
        tail = temp;

        // Set after to be the next node after the current head
        Node after = temp.next;
        // Initialize before to null, as the first node in the reversed list will not have a previous node
        Node before = null;

        // Loop through the linked list, reversing the order of the nodes
        for (int i = 0; i < length; i++) {
            // Set after to be the next node after the current node
            after = temp.next;
            // Set the current node's next pointer to the previous node
            temp.next = before;
            // Set before to be the current node, as it will be the previous node in the next iteration of the loop
            before = temp;
            // Set temp to be the next node in the linked list
            temp = after;
        }
    }
}
