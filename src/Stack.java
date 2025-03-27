// Stack.java
/* We created the Stack interface for level 5, 
we need this code to run MyStackLevel5.java class without any error.
*
* Citation: https://docs.oracle.com/en/java/javase/17/docs/specs/javadoc/doc-comment-spec.html
**/

/**
 * The Stack interface defines the standard stack operations.
 * This interface is used to ensure a consistent stack implementation.
 * 
 * @param <T> the type of elements stored in the stack
 * @author Arjina and Elizabeth
 */
public interface Stack<T> {

    /**
     * Pushes an item onto the top of the stack.
     * 
     * @param item the item to be added to the stack
     */
    void push(T item);

    /**
     * Removes and returns the top item of the stack.
     * 
     * @return the top item of the stack
     * @throws IllegalStateException if the stack is empty
     */
    T pop();               

    /**
     * Returns the top item of the stack without removing it.
     * 
     * @return the top item of the stack
     * @throws IllegalStateException if the stack is empty
     */
    T peek();

    /**
     * Checks if the stack is empty.
     * 
     * @return {@code true} if the stack is empty, {@code false} otherwise
     */
    // javadoc cite: https://docs.oracle.com/en/java/javase/17/docs/specs/javadoc/doc-comment-spec.html
    boolean isEmpty();

    /**
     * Returns the number of elements currently in the stack.
     * 
     * @return the size of the stack
     */
    int size();            // to get the current size of the stack
}

// to run javadoc: javadoc -d doc Stack.java 