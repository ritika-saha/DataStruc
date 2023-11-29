public class LinkedList<T> {
    Node<T> head;
    Node<T> tail;
    public LinkedList() {
        this.head = null;
        this.tail=null;
    }

    //uc-3 adding/appending node to the linked list 
    public void add(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    // uc-2 adding node to front of Linked list
    public void addFront(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void display(){
        Node<T> node=head;
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("NULL");
    }
}
