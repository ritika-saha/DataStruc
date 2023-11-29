public class Stack<T> extends LinkedList<T> {
    public Stack() {
        super();
    }

    // uc1_stackPush pushing elements in stack
    public void push(T data) {
        super.add(data); // adding to end
    }
}
