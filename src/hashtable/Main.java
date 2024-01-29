package hashtable;

public class Main {
    public static void main(String[] args) {

        System.out.println("//////////////CONSTRUCTOR//////////////");

        HashTable myHashTable = new HashTable();

        myHashTable.printTable();


        /*
            EXPECTED OUTPUT:
            ----------------
            0:
            1:
            2:
            3:
            4:
            5:
            6:
    	*/

        System.out.println("//////////////SET//////////////");

        myHashTable.set("nails", 100);
        myHashTable.set("tile", 50);
        myHashTable.set("lumber", 80);
        myHashTable.set("bolts", 200);
        myHashTable.set("screws", 140);

        myHashTable.printTable();

        /*
            EXPECTED OUTPUT:
            ----------------
            0:
            1:
            2:
            3:
               {screws= 140}
            4:
               {bolts= 200}
            5:
            6:
               {nails= 100}
               {tile= 50}
               {lumber= 80}
        */

        System.out.println("//////////////GET//////////////");

        System.out.println("Lumber:");
        System.out.println( myHashTable.get("lumber") );

        System.out.println("\nScrewdrivers:");
        System.out.println( myHashTable.get("screwdrivers") );

        /*
            EXPECTED OUTPUT:
            ----------------
            Lumber:
            80

            Screwdrivers:
            0
        */

        System.out.println("//////////////KEYS//////////////");

        System.out.println( myHashTable.keys() );

    	/*
        	EXPECTED OUTPUT:
        	----------------
        	[screws, bolts, nails, tile, lumber]
    	*/
    }
}
