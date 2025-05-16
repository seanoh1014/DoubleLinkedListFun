import java.util.*;

public class MyDoublyLinkedList {

    // You should only have two instance variables
    Node head = null;
    Node tail = null;

    public void add(String str) {
		if (str == "") {
			return;
		}
		// set i to 0
		int i = 0;

		// convert string to list of char
		char[] charList = str.toCharArray();
		
		// sort list of char
		Arrays.sort(charList);

		// length of charList
		int charLeng = charList.length;

		// if list is empty
		if (head == null) {
			head = new Node(charList[0]);
			head.prev = null;
			head.next = null;
			tail = head;
			i++;
		}

		// if list is not empty, add char list to preexisting list with alphanumerical order

		// traverse through list and insert char between them
		for (i = i; i<charLeng; i++) {

			char curChar = charList[i];

			Node current = head;

			while (current != null) {
				
				// if current char is less than or equal to current node, add char prev to node
				if (Character.compare(curChar, current.data) <= 0) {

					// if current node is head, add char between null and head
					if (current == head) {
						Node newNode = new Node(curChar, null, head);
						head = newNode;
						newNode.next.prev = head;
					}
					else {
						Node newNode = new Node(curChar, current.prev, current);
						current.prev.next = newNode;
						current.prev = newNode;
					}
					break;
				}
				// if current char is greater than current node and current.next is null (if current node is tail)
				else if (current.next == null) {
					Node newNode = new Node(curChar, tail, null);
					tail = newNode;
					newNode.prev.next = tail;
					break;
				}
				// if current char is greater than current node and less than or equal to current.next
				else if (current.next != null && Character.compare(curChar, current.next.data) <= 0) {
					Node newNode = new Node(curChar, current, current.next);
					current.next.prev = newNode;
					current.next = newNode;
					break;
				}

				current = current.next;
			}
		}

		return;

    }

    
    public String removeDuplicates() {
		if (head == null) {
			return "";
		}

		String dupText = "";

		Node current = head;

		while (current != null) {
			char curChar = current.data;

			Node current2 = current.next;

			while (current2 != null) {

				// if char is same, remove that node
				if (curChar == current2.data) {
					// store char to dupText
					dupText += curChar;

					// if tail
					System.out.println(tail == current2);
					if (tail == current2 && current2.prev != null) {

						current2.prev.next = null;
						tail = current2.prev;
					}
					else {
						current2.prev.next = current2.next;
						current2.next.prev = current2.prev;
					}
				}

				current2 = current2.next;
			}

			current = current.next;
		}
		
        return dupText;
    }

    
    public boolean contains(String str) {
		if (head == null || str == "") {
			return false;
		}

		int count = 0;
		
		for (int i=0; i<str.length(); i++) {
			char curChar = str.charAt(i);

			Node current = head;

			while (current != null) {
				if (curChar == current.data) {
					count++;
					break;
				}

				current = current.next;
			}
		}


		if (count == str.length()) {
			return true;
		}

		return false;
    }

    
    public int remove(String str) {
		if (head == null || str == "") {
			return 0;
		}

		int count = 0;

		for (int i=0; i<str.length(); i++) {
			char curChar = str.charAt(i);

			Node current = head;

			while (current != null) {
				if (curChar == current.data) {
					count++;
					// remove Node
					// null - O - null
					if (current.prev == null && current.next == null) {
						head = null;
						tail = null;
						break;
					}
					// O - O - O
					if (current.prev != null && current.next != null) {
						current.prev.next = current.next;
						current.next.prev = current.prev;
					}
					// null - O - O
					else if (current.prev == null && current.next != null) {
						current.next.prev = null;
						head = current.next;
					}
					// O - O - null
					else if (current.prev != null && current.next == null) {
						current.prev.next = null;
						tail = current.prev;
					}

					break;
				}
				current = current.next;
			}
		}
        return count;
    }

    
    public String toString() {
		if (head == null) {
			return "";
		}

		String text = "";

		Node current = head;

		while (current != null) {
			text += current.data;

			current = current.next;
		}

        return text;
    }

    
    public String toStringTail() {
		if (head == null || tail == null) {
			return "";
		} 

		String text = "";

		Node current = tail;
		
		while (current != null) {
			text += current.data;

			current = current.prev;
		}

		return text;
    }
}
    
class Node {

    char data;
    Node next = null;
    Node prev = null;

    public Node (char data) {
        this.data = data;
    }

    public Node (Character data, Node prev, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}
