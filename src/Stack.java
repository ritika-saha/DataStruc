public class Stack<T> extends LinkedList<T> {
    public Stack() {
        super();
    }

    // uc1_stackPush pushing elements in stack
    public void push(T data) {
        super.add(data); // adding to end
    }

    //uc2 peek and pop
    public void pop(){
        if (this.size() == 0) {
            System.out.println("Cant pop! stack is empty");
            return;
        }
        super.deleteLast();
    }

    public T peek(){
        if (this.size() == 0) {
             System.out.println("Cant peek! stack is empty");
            return null;
        }
        return this.tail.data;
    }
    public boolean isEmpty(){
        if(this.size()==0)
        return true;
        return false;
    }
}
