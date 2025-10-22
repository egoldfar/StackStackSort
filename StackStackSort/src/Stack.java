
import java.util.*;

public class Stack<T extends Comparable<T>> {

    private final ArrayList<T> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    public Stack(T first) {
        stack = new ArrayList<>();
        stack.add(first);
    }

    public Stack(Stack<T> stack) {
        this.stack = new ArrayList<>();
        this.stack.addAll(stack.stack);

    }

    public void push(T add) {
        stack.add(add);
    }

    public T peek() {
        return stack.get(stack.size() - 1);
    }

    public void pop() {
        stack.remove(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    @Override
    public String toString() {
        return stack.toString();
    }

    public Stack<T> stackSort() {
        Stack<T> orderedStack = new Stack<T>();
        Stack<T> reverseOrder = new Stack<T>();

        while (!this.isEmpty()) {
            if (orderedStack.isEmpty()) {
                orderedStack.push(this.peek());
                this.pop();
            } else {
                T temp = this.peek();
                this.pop();
                if (temp.compareTo(orderedStack.peek()) >= 0) {
                    orderedStack.push(temp);
                } else {
                    while (temp.compareTo(orderedStack.peek()) < 0) {
                        reverseOrder.push(orderedStack.peek());
                        orderedStack.pop();
                        if (orderedStack.isEmpty() || temp.compareTo(orderedStack.peek()) >= 0) {
                            orderedStack.push(temp);
                        }
                    }
                    while (!reverseOrder.isEmpty()) {
                        orderedStack.push(reverseOrder.peek());
                        reverseOrder.pop();
                    }
                }

            }
        }
        return orderedStack;
    }

    public Stack<T> twoStackSort() {
        Stack<T> orderedStack = new Stack<T>();
        int i = 0; //Used to know how many were moved back to the stack
        while (!this.isEmpty()) {
            if (orderedStack.isEmpty()) {
                orderedStack.push(this.peek());
                this.pop();
            } else {
                T temp = this.peek();
                i = 0;
                this.pop();
                if (temp.compareTo(orderedStack.peek()) >= 0) {
                    orderedStack.push(temp);
                } else {
                    while (temp.compareTo(orderedStack.peek()) < 0) {
                        this.push(orderedStack.peek());
                        orderedStack.pop();
                        i++;
                        if (orderedStack.isEmpty() || temp.compareTo(orderedStack.peek()) >= 0) {
                            orderedStack.push(temp);
                        }
                    }
                    while (i > 0) {
                        orderedStack.push(this.peek());
                        this.pop();
                        i--;
                    }
                }

            }
        }
        return orderedStack;
    }


    public void originalStackSort() {
        Stack<T> storageStack = new Stack<T>();
        Stack<T> reverseOrder = new Stack<T>();

        while(this.size() > 1) {
            storageStack.push(this.peek());
            this.pop();
        }

        while (!storageStack.isEmpty()) {

            T temp = storageStack.peek();
            storageStack.pop();

            if (temp.compareTo(this.peek()) >= 0) {
                this.push(temp);
            } else {
                while (temp.compareTo(this.peek()) < 0) {
                    reverseOrder.push(this.peek());
                    this.pop();
                    if (this.isEmpty() || temp.compareTo(this.peek()) >= 0) {
                        this.push(temp);
                    }
                }
                while (!reverseOrder.isEmpty()) {
                    this.push(reverseOrder.peek());
                    reverseOrder.pop();
                }
            }

        }
    }

}
