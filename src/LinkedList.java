public class LinkedList<T> {
    Node<T> head;
    public LinkedList() {
        this.head = null;
    }

    // uc-2 adding node to front of Linked list
    public void addFront(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = node;
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
