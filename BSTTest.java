/**
* BSTTest.java
* @author Quan Ha
* @author Kenneth Dannlyson
* CIS 22C Lab 5
*/
import java.util.Comparator;
import java.util.NoSuchElementException;

public class BSTTest {
	public static void main(String[] args) {
		BST<Integer> b = new BST<>();
		Comparator<Integer> c = Comparator.naturalOrder();
		System.out.println("True: " + b.isEmpty());
		System.out.println("Print -1 for height: " + b.getHeight());
		try {
			b.findMin();

		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		try {
			b.findMax();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Print 0: " + b.getSize());
		try {
			b.getRoot();

		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

		b.insert(7, c);
		b.insert(9, c);
		b.insert(3, c);

		System.out.println("Print 1 for height: " + b.getHeight());
		System.out.println("Print 3: " + b.getSize());
		System.out.println("Root is 7: " + b.getRoot());
		b.insert(2, c);
		System.out.println("Print 2 for height: " + b.getHeight());
		System.out.println("False: " + b.isEmpty());
		b.inOrderPrint();
		System.out.println(b.search(10, c));
		System.out.println("Should print 7 for search: " + b.search(7, c));
		System.out.println("Should print 9 for search: " + b.search(9, c));
		System.out.println("Should print 2 for findMin: " + b.findMin());
		System.out.println("Should print 9 for findMax: " + b.findMax());
		BST<Integer> bcopy = new BST<>(b, c);
		BST<Integer> d = new BST<>();

		d.inOrderPrint();
		BST<Integer> dcopy = new BST<>(d, c);
		bcopy.inOrderPrint();
		dcopy.inOrderPrint();
		b.insert(15, c);
		b.insert(8, c);
		b.insert(5, c);
		b.insert(4, c);
		b.inOrderPrint();
		System.out.println("Root is 7: " + b.getRoot());
		b.postOrderPrint();
		b.remove(5, c);
		System.out.println("Root after remove is: " + b.getRoot());
		b.postOrderPrint();

	}
}
