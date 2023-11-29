public class LinkedListMain {
    public static void main(String[] args) throws Exception {
        System.out.println("operations on unordered Lined List");
     LinkedList<Integer> list=new LinkedList<>();
     list.add(56);
     list.add(70);
     list.display();
     list.insertAtPos(1, 30);
     list.display();
     list.deleteFirst();
     list.display();
     list.deleteLast();
     list.display();
     list.add(56);
     list.add(70);
     list.display();
     int searchResult=list.searchNode(70);
     System.out.println(searchResult > -1 ? "Node found at index: " + searchResult : "Node not found");
    list.addAfterNode(56, 40);
    list.display();
    list.deleteNode(56);
    list.display();
     
    }
}
