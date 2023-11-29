public class LinkedList<T> {
    Node<T> head;
    Node<T> tail;
    public LinkedList() {
        this.head = null;
        this.tail=null;
    }

    //uc5_deleteFirstLL deleting element front front of linked list
    public void deleteFirst() {
        if (head == null) {
            return;
        }

        Node<T> tempNode = head.next;
        head.next = null;
        head = tempNode;
    }

    //uc4_addBetweenLL adding node between
    public int size() {
        Node<T> node = head;
        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }
        return size;
    }

    public void insertAtPos(int index, T data) {
        if (index < 0 || index > this.size()) {
            System.out.println("Index provided is invalid");
            return;
        }

        Node<T> node = new Node<>(data);
        if (index == 0) {
            this.addFront(data);
        } else {
            Node<T> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }
    }

    //uc-3 uc3_addLL adding/appending node to the linked list 
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
