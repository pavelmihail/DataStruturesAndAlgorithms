package heap;

public class Main {
    public static void main(String[] args) {

        System.out.println("///////////////////INSERT///////////////////");

        Heap myHeap = new Heap();
        myHeap.insert(99);
        myHeap.insert(72);
        myHeap.insert(61);
        myHeap.insert(58);

        System.out.println(myHeap.getHeap());


        myHeap.insert(100);

        System.out.println(myHeap.getHeap());


        myHeap.insert(75);

        System.out.println(myHeap.getHeap());

        /*
            EXPECTED OUTPUT:
            ----------------
            [99, 72, 61, 58]
            [100, 99, 61, 58, 72]
            [100, 99, 75, 58, 72, 61]

        */

        System.out.println("///////////////////REMOVE///////////////////");

        System.out.println(myHeap.getHeap());


        myHeap.remove();

        System.out.println(myHeap.getHeap());


        myHeap.remove();

        System.out.println(myHeap.getHeap());



    }
}
