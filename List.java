/**
* List.java 
* @author Quan Ha
* @author Kenneth Dannlyson
* CIS 22C, Lab 5
*/

import java.util.NoSuchElementException;

public class List<T> {
	private class Node {
		private T data;
		private Node next;
		private Node prev;

		public Node(T data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	private int length;
	private Node first;
	private Node last;
	private Node iterator;
	   
	    /****CONSTRUCTOR****/
	   
	    /**
	     * Instantiates a new List with default values
	     * @postcondition a new linked list has been created
	     */
		public List() {
			length = 0;
			first = null;
			last = null;
			iterator = null;
		}
	    /*COPY CONSTRUCTOR
	     * Create a complete new List that is different from the original list
	     * @Param: the List
	     * @postcondition a new doubly linked list is created and the same with the original list
	     * 
	     * */
	    
		public List(List<T> obj) {
			if (obj == null) {
				return;
			} else if (obj.length == 0) {
				length = 0;
				first = null;
				last = null;
				iterator = null;
			} else {
				Node temp = obj.first;
				while (temp != null) {
					addLast(temp.data);
					temp = temp.next;
				}
				iterator = null;
			}

		}
  
	    /****ACCESSORS****/
	   
	    /**
	     * Returns the value stored in the first node
	     * @precondition length!=0
	     * @return the value stored at node first
	     * @throws NoSuchElementException when precondition is violated
	     */
		public T getFirst() throws NoSuchElementException {
			if (length == 0) {
				throw new NoSuchElementException("getFirst: "
			+ " Cannot get the First node from an empty list");
			}
			return first.data;
		}
	   
	    /**
	     * Returns the value stored in the last node
	     * @precondition length!=0 
	     * @return the value stored in the node last
	     * @throws NoSuchElementException when precondition is violated
	     */
		public T getLast() throws NoSuchElementException {
			if (length == 0) {
				throw new NoSuchElementException("getLast: " 
			+ " Cannot get the Last node from an empty list");
			}
			return last.data;
		}
	   
	    /**
	     * Returns the current length of the list
	     * @return the length of the list from 0 to n
	     */
	    public int getLength() {
	        return length;
	    }
	   
	    /**
	     * Returns whether the list is currently empty
	     * @return whether the list is empty 
	     */
		public boolean isEmpty() {
			return length == 0;
		}
	    
	   /*
	    * return the data of the iterator
	    * @precondition: iterator != null
	    * @return the data of the iterator 
	    * @throws NoSuchElementException when precondition is violated
	    * */
		public T getIterator() throws NullPointerException {
			if (iterator == null) {
				throw new NullPointerException("getIterator: " + 
			" Cannot get the iterator because it is null");
			}
			return iterator.data;
		}
	    /*
	     * returns whether the iterator is off the end of the list, i.e. is NULL
	     * */
		public boolean offEnd() {
			return iterator == null;
		}

	    /*
	     * overrides the equals method for object to compares 
	     * this list to another list to see if they contain the same data in the same order.
	     * 
	     * */
		public boolean equals(Object copy) {
			if (copy == this) {
				return true;
			} else if (!(copy instanceof List)) {
				return false;
			} else {
				List<T> c = (List<T>) copy;
				if (c.getLength() != this.getLength()) {
					return false;
				} else {
					Node temp = this.first;
					Node temp1 = c.first;
					while (temp != null) {
						if (temp.data == temp1.data) {
							temp = temp.next;
							temp1 = temp1.next;
						} else {
							return false;
						}
					}
					return true;
				}
			}
		}
	    
	    /****MUTATORS****/
	   
	    /**
	     * Creates a new first element
	     * @param data the data to insert at the
	     * front of the list
	     * @postcondition the First node is the same as the input
	     */
		public void addFirst(T data) {
			Node newNode = new Node(data);
			if (first == null) {
				first = last = newNode;
			} else {
				newNode.next = first;
				first.prev = newNode;
				first = newNode;
			}
			length++;

		}
	     /**
	     * Creates a new last element
	     * @param data the data to insert at the
	     * end of the list
	     * @postcondition the Last node is the same as the input
	     */
			public void addLast(T data) {
				if (first == null) {
					first = last = new Node(data);
				} else {
					Node newLast = new Node(data);
					last.next = newLast;
					newLast.prev = last;
					last = newLast;
				}
				length++;

			}
	   
	    /**
	    * removes the element at the front of the list
	    * @precondition length!=0
	    * @postcondition the First node is removed
	    * @throws NoSuchElementException when precondition is violated
	    */
		public void removeFirst() throws NoSuchElementException {
			if (length == 0) {
				throw new NoSuchElementException("removeFirst:"
			+ " Cannot remove from an empty list");
			} else if (length == 1) {
				first = last = null;
			} else if (iterator == first) {
				iterator = null;
			} else {
				first = first.next;
				first.prev = null;

			}
			length--;

		}
	   
	    /**
	     * removes the element at the end of the list
	     * @precondition length!=0
	     * @postcondition the Last node is removed
	     * @throws NoSuchElementException when precondition is violated
	     */
		public void removeLast() throws NoSuchElementException {
			if (length == 0) {
				throw new NoSuchElementException("removeLast:"
			+ " Cannot remove from an empty list");
			} else if (length == 1) {
				first = last = null;
			} else if (iterator == last) {
				iterator = null;
			} else {
				last = last.prev;
				last.next = null;
			}
			length--;
		}
	    
	   /*
	    * moves the iterator to the start of the list
	    * 
	    * */
		public void placeIterator() {
			iterator = first;
		}
	    
	    /*
	     * moves the iterator up by one node
	     * @precondition: iterator != null
	     * @postcondition: Iterator is now pointing to the next node
	     * @throws NoSuchElementException when precondition is violated
	     * */
	    public void advanceIterator() throws NoSuchElementException {
	    	if(iterator == null) {
	    		throw new NoSuchElementException("advanceIterator:"
	    				+" Cannot advance the iterator because the iterator is null");
	    		}	    	
	    	iterator = iterator.next;
	    }
	    
	    /*
	     * moves the iterator down by one node
	     * @precondition: iterator != null
	     * @postcondition: Iterator is now pointing at the previous node
	     * @throws NoSuchElementException when precondition is violated
	     */
		public void reverseIterator() throws NoSuchElementException {
			if (iterator == null) {
				throw new NoSuchElementException(
						"reverseIterator:" + 
				" Cannot reverse the iterator because the iterator is null");
			}
			iterator = iterator.prev;
		}
	    
	    /**
	    * removes the element currently referenced by the iterator
	    * @precondition iterator != null
	    * @throws NullPointerException when iterator is off end
	    * @postcondition iterator will be null
	    */
		public void removeIterator() throws NullPointerException {
			if (iterator == null) {
				throw new NullPointerException("removeIterator: " +
			" Cannot get the iterator because it is null.");
			} else if (iterator == first) {
				removeFirst();
				iterator = null;
			} else if (iterator == last) {
				removeLast();
				iterator = null;
			} else {
				iterator.next.prev = iterator.prev;
				iterator.prev.next = iterator.next;
				iterator = null;
				length--;
			}

		}
	    
	    /*
	     * inserts an element after the node currently pointed to by the iterator
	     * @precondition: iterator != null
	     * @postcondition: a new element has been inserted after the iterator
	     * @throws NullPointerException when the iterator is null
	     * */
		public void addIterator(T data) throws NullPointerException {
			if (iterator == null) {
				throw new NullPointerException("addIterator:" + 
			" Cannot get the iterator because iterator is null");
			} else if (iterator == last) {
				addLast(data);
			} else {
				Node newIterator = new Node(data);
				newIterator.next = iterator.next;
				iterator.next = newIterator;
				newIterator.prev = iterator;
				iterator.next.prev = newIterator;
				length++;
			}
		}
	    
	    
	    /****ADDITIONAL OPERATIONS****/
	   
	    /**
	     * List with each value on its own line
	     * At the end of the List a new line
	     * @return the List as a String for display
	     */
		@Override public String toString() {

			String result = ""; // empty String
			Node iter = first;
			while (iter != null) {
				result += iter.data + "";
				iter = iter.next;
			}

			return result + "\n";
		}

		/*
		 * prints the contents of the linked list to the screen 
		 * in the format #: <element> followed by a newline
		 * */
		public void printNumberList() {
			Node temp = first;
			int count = 0;
			while (temp != null) {
				System.out.println( (++count) + ". " + temp.data);
				temp = temp.next;
			}
		}

	
	
	/*
	 * Print out the list in reverse order*/
	public String printReverse() {
		String result = "";
		Node iter = last;
		while (iter != null) {
			result += iter.data + " ";
			iter = iter.prev;
		}
		result += first.data + " ";
		return result + "\n";

	}
	
	//Lab 5 Methods
	/**
	* Points the iterator at first
	* and then advances it to the
	* specified index
	* @param index the index where
	* the iterator should be placed
	* @precondition 0 < index <= length
	* @throws IndexOutOfBoundsException
	* when precondition is violated
	*/
	public void iteratorToIndex(int index) throws IndexOutOfBoundsException {
		if (0 > index || index > length) {
			throw new IndexOutOfBoundsException("iteratorToIndex: "
		+ "index is out of bounds");
		} else {
			placeIterator();
			for (int i = 1; i < index; i++) {
				advanceIterator();
			}
		}
	}

	/**
	* Searches the List for the specified
	* value using the linear  search algorithm
	* @param value the value to search for
	* @return the location of value in the
	* List or -1 to indicate not found
	* Note that if the List is empty we will
	* consider the element to be not found
	* post: position of the iterator remains
	* unchanged
	*/
	public int linearSearch(T value) {
		if (isEmpty()) {
			return -1;
		} else {
			Node iter = first;
			for (int i = 0; i < length; i++) {
				if (iter.data == value) {
					return i;
				}
				iter = iter.next;
			}
		}
		return -1;
	}
}