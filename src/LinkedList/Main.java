package LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(4);

        //////////////////////////////////////////////////
        // test printAll
        myLinkedList.makeEmpty();
        myLinkedList.append(1);
        myLinkedList.append(2);

        myLinkedList.printAll();

        //////////////////////////////////////////////////
        //test append
        myLinkedList.makeEmpty();
        myLinkedList.append(1);
        myLinkedList.append(2);

        myLinkedList.printAll();
        /*
       		EXPECTED OUTPUT:
        	----------------
        	Head: 1
        	Tail: 2
        	Length: 2

        	Linked List:
        	1
        	2
     	*/

        //////////////////////////////////////////////////
        // test removeLast
        myLinkedList.makeEmpty();
        myLinkedList.append(1);
        myLinkedList.append(2);

        // (2) Items - Returns 2 Node
        System.out.println(myLinkedList.removeLast().value);
        // (1) Item - Returns 1 Node
        System.out.println(myLinkedList.removeLast().value);
        // (0) Items - Returns null
        System.out.println(myLinkedList.removeLast());
    	/*
        	EXPECTED OUTPUT:
        	----------------
        	2
        	1
        	null
     	*/

        //////////////////////////////////////////////////
        // test prepend
        myLinkedList.makeEmpty();
        myLinkedList.append(3);

        System.out.println("Before prepend():");
        System.out.println("-----------------");
        myLinkedList.printAll();

        myLinkedList.prepend(1);

        System.out.println("\n\nAfter prepend():");
        System.out.println("----------------");
        myLinkedList.printAll();
        /*
            EXPECTED OUTPUT:

            Before prepend():
            -----------------
            Head: 2
            Tail: 3
            Length: 2

            Linked List:
            2
            3

            After prepend():
            ----------------
            Head: 1
            Tail: 3
            Length: 3

            Linked List:
            1
            2
            3
        */

        //////////////////////////////////////////////////
        // test remove first
        myLinkedList.makeEmpty();
        myLinkedList.append(2);
        myLinkedList.append(1);

        // (2) Items - Returns 2 Node
        System.out.println(myLinkedList.removeFirst().value);
        // (1) Item - Returns 1 Node
        System.out.println(myLinkedList.removeFirst().value);
        // (0) Items - Returns null
        System.out.println(myLinkedList.removeFirst());
        /*
            EXPECTED OUTPUT:
            ----------------
            2
            1
            null

        */
    }
}
