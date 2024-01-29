package hashtable;

import java.util.ArrayList;
import java.util.Objects;

public class HashTable {
    // The default size of the hash table
    private int size = 7;

    // The array of nodes that stores the key-value pairs
    private Node[] dataMap;

    // The inner Node class that represents a node in the linked list
    // of values stored at a particular index in the hash table
    class Node {
        String key;
        int value;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // The constructor that initializes the dataMap array to
    // an array of Node objects with the default size
    public HashTable() {
        dataMap = new Node[size];
    }

    public void printTable() {
        for(int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            if(dataMap[i] != null) {
                Node temp = dataMap[i];
                while (temp != null) {
                    System.out.println("   {" + temp.key + ", " + temp.value + "}");
                    temp = temp.next;
                }
            }
        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int asciiValue : keyChars) {
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value) {
        // Get the index of the node based on the key
        int index = hash(key);

        // Create a new node with the given key and value
        Node newNode = new Node(key, value);

        // If the data map at the index is null, add the new node
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            // If there is already a node at the index, traverse the linked list
            Node temp = dataMap[index];

            // If the first node's key matches the given key, update its value
            if (temp.key == key) {
                temp.value += value;
                return;
            }

            // Traverse the linked list until the end or a node with a matching key is found
            while (temp.next != null) {
                temp = temp.next;
                if (temp.key == key) {
                    temp.value += value;
                    return;
                }
            }

            // Add the new node to the end of the linked list
            temp.next = newNode;
        }
    }

    public int get(String key) {
        // Compute the hash code for the given key.
        int index = hash(key);
        // Get the head node of the linked list at the computed hash code index.
        Node temp = dataMap[index];
        // Traverse the linked list to find the node with the given key.
        while (temp != null) {
            // If we find a node with the given key, return its value.
            if (Objects.equals(temp.key, key)) return temp.value;
            // Move on to the next node in the linked list.
            temp = temp.next;
        }
        // If the key is not found, return 0.
        return 0;
    }

    public ArrayList<String> keys() {
        // Create a new ArrayList to hold the keys
        ArrayList<String> allKeys = new ArrayList<>();

        // Loop through all the indices in the dataMap array
        for (int i = 0; i < dataMap.length; i++) {
            // Get the head node of the linked list at the current index
            Node temp = dataMap[i];

            // Loop through the linked list at the current index
            while (temp != null) {
                // Add the key of the current node to the allKeys ArrayList
                allKeys.add(temp.key);

                // Move to the next node in the linked list
                temp = temp.next;
            }
        }

        // Return the ArrayList containing all the keys
        return allKeys;
    }

}
