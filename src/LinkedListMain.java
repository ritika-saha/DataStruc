public class LinkedListMain {
    public static void main(String[] args) throws Exception {
        // uc-1 branch uc1_simpleLL - creating simple linked list
        Node<Integer> node1 = new Node<>(56);
        Node<Integer> node2 = new Node<>(30);
        Node<Integer> node3 = new Node<>(70);
        node1.next = node2;
        node2.next = node3;

        Node<Integer> currNode = node1;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }
}
