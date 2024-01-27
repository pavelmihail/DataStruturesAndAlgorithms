package stack;

public class Main {
    public static void main(String[] args) {

        System.out.println("/////////////////////CONSTRUCTOR/////////////////////");

        Stack myStack = new Stack(4);

        myStack.printAll();

        /*
            EXPECTED OUTPUT:
            ----------------
            Top: 4
            Height: 1

            Stack:
            4

        */

        System.out.println("/////////////////////PUSH/////////////////////");

        myStack.makeEmpty();
        myStack.push(2);

        System.out.println("Before push():");
        System.out.println("--------------");
        myStack.printAll();

        myStack.push(1);

        System.out.println("\n\nAfter push():");
        System.out.println("-------------");
        myStack.printAll();

        /*
            EXPECTED OUTPUT:

			Before push():
			--------------
			Top: 2
			Height: 1

			Stack:
			2


			After push():
			-------------
			Top: 1
			Height: 2

			Stack:
			1
			2

        */

        System.out.println("/////////////////////POP/////////////////////");

        myStack.makeEmpty();
        myStack.push(2);
        myStack.push(1);

        // (2) Items - Returns 1 Node
        System.out.println(myStack.pop().value);
        // (1) Item - Returns 2 Node
        System.out.println(myStack.pop().value);
        // (0) Items - Returns null
        System.out.println(myStack.pop());


        /*
            EXPECTED OUTPUT:
            ----------------
            1
            2
            null

        */

    }
}
