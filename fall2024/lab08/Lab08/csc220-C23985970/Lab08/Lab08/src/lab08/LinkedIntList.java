package lab08;

/**
 * The {@code LinkedIntList} class represents a singly linked list of integers.
 * It supports basic operations like adding elements, finding the size of the list,
 * and printing the list in a comma-separated, bracketed format. 
 * This modified version of the linked list class also includes placeholders for additional
 * functionality such as shifting and stuttering elements in the list, and removing specific elements.
 * 
 * <h3>Usage Example:</h3>
 * <pre>
 * LinkedIntList list = new LinkedIntList();
 * list.add(5);        // Adds 5 to the list
 * list.add(2, 10);    // Adds 10 at index 2
 * System.out.println(list.size());  // Prints the size of the list
 * System.out.println(list);         // Prints the list
 * </pre>
 * 
 * @see ListNode
 * @author Your Name
 */
public class LinkedIntList {
    /**
     * A reference to the first node in the list.
     */
    public ListNode front; //whenever we have to do something we have to do it from front

    /**
     * Constructs an empty linked list.
     * The {@code front} reference is set to {@code null}.
     */
    public LinkedIntList() {
        front = null;
    }

    /**
     * Constructs a linked list from an array of integers.
     * The elements of the array are added to the list in the order they appear.
     * 
     * @param arr the array of integers to be added to the list
     */
    public LinkedIntList(int[] arr) { //creates linkedlist from an array
        this();
        for (int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }
    }

    /**
     * Returns the number of elements in the list.
     * 
     * @return the number of elements in the list
     */
    public int size() { //prob do something similar
        int count = 0;
        ListNode current = front;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    /**
     * Returns a string representation of the list in a comma-separated, bracketed format.
     * For example, a list containing the elements [1, 2, 3] will be returned as "[1, 2, 3]".
     * 
     * @return the string representation of the list
     */
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            ListNode current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    /**
     * Adds a new value to the end of the list.
     * 
     * @param value the integer value to be added to the list
     */
    public void add(int value) { //if front is null create new node and have current be that new node
        if (front == null) {
            front = new ListNode(value);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }

    /**
     * Returns the node at the specified index.
     * 
     * @param index the index of the node to return
     * @return the {@code ListNode} at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 or index >= size())
     */
    private ListNode nodeAt(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
    //to insert create new node. new node.next = previous.node.next then previous.next = new node

    /**
     * Inserts a new value at the specified index in the list.
     * 
     * @param index the position at which to insert the value
     * @param value the integer value to insert
     */
    public void add(int index, int value) {
        if (index == 0) {
            front = new ListNode(value, front);
        } else if (index == size()) {
            add(value);
        } else if (index > size()) {
            return;
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = new ListNode(value, current.next);
        }
    }

    // *************************************************

    /**
     * Finds the index of the last occurrence of the given value in the list.
     * 
     * @param value the integer value to search for
     * @return the index of the last occurrence of the value, or -1 if the value is not found
     */
    public int lastIndexOf(int value) {//update a variable till you get to the end. if its never in there, return -1
        // TODO: Lab part 2.1
    	
    	ListNode current = front;
    	int currentIndex = 0;
    	int lastIndex = -1;
    	
    		while(current !=null) {//makes sure the list isnt empty
    			if(current.data == value) {
    			
    				lastIndex = currentIndex;
    			}
    			currentIndex++;
        		current = current.next;
    		}
    		return lastIndex;
    	
    }

    /**
     * Removes all occurrences of the given value from the list.
     * 
     * @param value the integer value to remove from the list
     */
    public void removeAll(int value) { //given a value, u need to remove all instances of that value. notice remove is the oppositte of add. 
    	//keep track of current and previous. 
    	// at each step first have previous equal current then have current equal current.next
    	//to remove, prveious.next needs to point to current.next
        // TODO: Lab part 2.2
    	
    
    	
    	while(front!=null && front.data == value) {
    		front = front.next;
    	}
    	
    	
    	ListNode current = front;
    	ListNode previous = null;
    	
    		while(current !=null) {//makes sure list isnt empty
    			if(current.data == value) {
    				previous.next = current.next;
    			}else {
    			
        		previous=current;
    			}
    		
    		current = current.next;

    }}


    /**
     * Doubles the size of the list by replacing each integer in the list with two of that integer.
     * If the list is empty, this method does nothing.
     */
    public void stutter() {
        // TODO: Assignment part 2.1
    	 ListNode current = front;
    	 
         while (current!= null) {
        	 ListNode dupe = new ListNode(current.data);
        	 dupe.next = current.next;
        	 current.next=dupe;
        	 current=dupe.next;
        	 
        
    }
         return;
         }

    /**
     * Rearranges the list by moving all values at odd-numbered positions to the end of the list.
     * The original order of the elements is otherwise preserved.
     * 
     * <p>This method must not create any new nodes or use any auxiliary data structures.
     * The links of the list must be rearranged to achieve the desired result.</p>
     */
    public void shift() {
        // TODO: Assignment part 2.2
    	
    	if (front == null || front.next == null || front.next.next == null) { //if the list has 0, 1, or 2 nodes, nothing will change
            return; 
        }
    	ListNode evenHead = front; // Head of the even nodes
        ListNode oddHead = front.next; // Head of the odd nodes
        ListNode evenCurrent = evenHead; // Current pointer for even nodes
        ListNode oddCurrent = oddHead; // Current pointer for odd nodes

        
        while (evenCurrent != null && oddCurrent != null) { //while the first and second elements are not null
            evenCurrent.next = oddCurrent.next; // Connect current even to next even
            evenCurrent = evenCurrent.next; // Move to next even node

            if (evenCurrent != null) { // If there is an even node after this
                oddCurrent.next = evenCurrent.next; // Connect current odd to next odd
                oddCurrent = oddCurrent.next; // Move to next odd node
            }
        }

        // Connect the end of even list to the start of odd list
        if (evenCurrent != null) {
            evenCurrent.next = oddHead;
        } else {
            // If there are no even nodes left, just set the end of the list
            oddCurrent.next = null;
        }
    }
    }

    
