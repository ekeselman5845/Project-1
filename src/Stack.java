/* 
* created the Stack interface for level 5, 
we need this code to run MyStackLevel5.java class without any error**/

// Stack.java
public interface Stack<T> {
    void push(T item);     // Method to add an item to the stack
    T pop();               // Method to remove the top item from the stack
    T peek();              // Method to look at the top item without removing it
    boolean isEmpty();     // Method to check if the stack is empty
    int size();            // Method to get the current size of the stack
}
