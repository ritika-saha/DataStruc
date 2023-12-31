public class LinkedList<T> {
    Node<T> head;
    Node<T> tail;
    public LinkedList() {
        this.head = null;
        this.tail=null;
    }

    //uc9_deleteNodeLL deleting node
    public void deleteNode(T data) {
        if (head == null) {
            return;
        }

        if (head.data.equals(data)) {
            this.deleteFirst();
            return;
        }

        if (tail.data.equals(data)) {
            this.deleteLast();
            return;
        }

        Node<T> temp = head;
        while (temp.next != null && !temp.next.data.equals(data)) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
    }

    //uc8_addNodeafterLL adding node after a particular node 
    public void addAfterNode(T queryNode, T newNode) {
        int index = this.searchNode(queryNode);
        if (index == -1) {
            System.out.println("Source node not found.");
            return;
        }
        this.insertAtPos(index + 1, newNode);
    }

    //uc7_searchNodeLL searching particular node by value
    public int searchNode(T data) {
        if (head == null) {
            return -1;
        }

        Node<T> temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data.equals(data)) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    //uc6_deleteLastLL deleting last element
    public void deleteLast() {
        if (head == null) {
            return;
        }

        Node<T> temp = head;
        
        if (temp.next == null) {
            head = null;
            tail = null;
            return;
        }

        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
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
