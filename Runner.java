import java.util.*;

public class Runner {

    public static void main(String[] args) {

        // You should test your methods here

        MyDoublyLinkedList list = new MyDoublyLinkedList();
        
        list.add("apple");
        list.add("banana");
        
        System.out.println("\nFrom Head");
        System.out.println("Expected: aaaabelnnpp");
        System.out.println("Actual:   " + list.toString());

        System.out.println("\nFrom Tail");
        System.out.println("Expected: ppnnlebaaaa");
        System.out.println("Actual:   " + list.toStringTail());

        System.out.println("\nDuplicates removed");
        System.out.println("Expected: aaanp");
        System.out.println("Actual:   " + list.removeDuplicates());

        System.out.println("\nFrom head after duplicates removed");
        System.out.println("Expected: abelnp");
        System.out.println("Actual:   " + list.toString());
        
        System.out.println();

		System.out.println("======================================");

		MyDoublyLinkedList list2 = new MyDoublyLinkedList();

		list2.add("abccccccccccccccccccc");
		System.out.println("List2: " + list2.toString());
		System.out.println("Expected: " + "1");
		System.out.println("Actual: " + list2.removeDuplicates());
		System.out.println("List2: " + list2.toString());
		System.out.println("List2 Inverse: " + list2.toStringTail());
    }
}
