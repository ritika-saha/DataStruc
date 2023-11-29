//uc10_orderedLL creating a sorted Linked List
public class OrderedLinkedList<T extends Comparable<T>> extends LinkedList<T> {
    public OrderedLinkedList() {
        super();
    }

    public void displayList(){
        this.display();
    }

    public void add(T data) {
        if (this.head == null) {
            super.add(data);
            return;
        }

        // if data is smaller than head
        if (this.head.data.compareTo(data) > 0) {
            super.addFront(data);
            return;
        }

        // if data is greater than tail
        if (this.tail.data.compareTo(data) < 0) {
            super.add(data);
            return;
        }

        //if we have to insert in between according to comparison

        Node<T> temp = head;
        int index = 0;
        while (temp.next.data.compareTo(data) < 0) {
            temp = temp.next;
            index++;
        }
        super.insertAtPos(index + 1, data);
    }
}
