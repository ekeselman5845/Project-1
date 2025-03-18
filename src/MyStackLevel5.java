/*
 * Level 5 Goals – your stack and packaging 
1. Replace the built-in stack with a stack implemented by your team.  It can be a LinkedList- or 
Array-based stack. Your stack should also implement the Stack interface.  If you have 
implemented the previous code correctly, there should be very few modifications to 
substitute your stack. 
2. Has appropriate JavaDoc documentation for all classes. 
3. Has all necessary source code. 
4. Has an executable Jar. 
5. Has screenshots demonstrating successful operation of Goal 1, 2, 3, and 4. 
6. Has a weekly log of accomplishments, with each group member appropriately attributed. 
 */

// MyStackLevel5.java
public class MyStackLevel5<T> implements Stack<T> {
    private Node<T> top; // The top of the stack
    
    // Inner class for the stack's nodes
    private static class Node<T> {
        T data;
        Node<T> next;
        
        public Node(T data) {
            this.data = data;
        }
    }

    public MyStackLevel5() {
        top = null; // Initialize stack as empty
    }

    @Override
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode; // Place new node at the top of the stack
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T item = top.data;
        top = top.next; // Remove the top item from the stack
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data; // Return the top item without removing it
    }

    @Override
    public boolean isEmpty() {
        return top == null; // Stack is empty if top is null
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = top;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next; // Traverse the stack
        }
        return sb.toString().trim();
    }
}
