public class Queue<T> extends LinkedList<T> {
    public Queue() {
        super();
    }

    // uc3_enqueue adding to queue
    public void enqueue(T data) {
        super.add(data); 
    }
}