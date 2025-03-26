/*
 * Level 5 Goals – your stack and packaging 
1. Replace the built-in stack with a stack implemented by your team.  It can be a LinkedList- or 
Array-based stack. Your stack should also implement the Stack interface.  If you have 
implemented the previous code correctly, there should be very few modifications to 
substitute your stack. 
**/
// MyStackLevel5.java

/**
 * MyStackLevel5 is a custom stack implementation that uses a LinkedList-based structure.
 * It implements the Stack interface, providing basic stack operations such as push, pop, peek,
 * isEmpty, size, and a custom toString method.
 * 
 * @param <T> The type of elements stored in the stack.
 * @author Arjina and Elizabeth
 * @version 1.0
 * @since 03-25-2025
 */
public class MyStackLevel5<T> implements Stack<T> {

    private Node<T> top; // The top of the stack
    
    /**
     * Inner class for the stack's nodes, which stores data and a reference to the next node.
     * 
     * @param <T> The type of data stored in the node.
     */
    private static class Node<T> {
        T data; // data stored in the node
        Node<T> next; // reference to the next node
        
        /**
         * Constructs a new node with the specified data.
         * 
         * @param data The data to store in the node.
         */
        public Node(T data) {
            this.data = data;
        }
    }

    /**
     * Constructs an empty stack.
     */
    public MyStackLevel5() {
        top = null; // to initialized stack as empty
    }

    /**
     * Pushes an element onto the stack.
     * 
     * @param item The element to push onto the stack.
     */
    @Override
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode; // to place new node at the top of the stack
    }

    /**
     * Pops an element off the stack. Removes and returns the top element.
     * 
     * @return The element that was removed from the top of the stack.
     * @throws IllegalStateException If the stack is empty.
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T item = top.data;
        top = top.next; // to remove the top item from the stack
        return item;
    }

    /**
     * This method peeks at the top element of the stack without removing it.
     * 
     * @return The top element of the stack.
     * @throws IllegalStateException If the stack is empty.
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data; // to return the top item without removing it
    }

    /**
     * This method checks if the stack is empty.
     * 
     * @return true if the stack is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return top == null; // Stack is empty if top is null
    }

    /**
     * Returns the size of the stack.
     * 
     * @return The number of elements in the stack.
     */
    @Override
    public int size() {
        int size = 0;
        Node<T> current = top;
        while (current != null) {
            size++;
            current = current.next; // Traverse the stack
        }
        return size;
    }

    /**
     * Returns a string representation of the stack.
     * 
     * @return A string representing the elements in the stack from top to bottom.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = top;
        while (current != null) {
            sb.append(current.data).append(" "); // Append each element to the string builder
            current = current.next; // Traverse the stack
        }
        return sb.toString().trim();
    }
}
