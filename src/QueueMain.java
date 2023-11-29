public class QueueMain {
    public static void main(String[] args){
        Queue<Integer> q=new Queue<>();
        q.add(50);
        q.add(30);
        q.add(70);
        System.out.print("Queue is :");
        q.display();
        q.dequeue();
        System.out.print("after dequeue  :");
        q.display();
        q.dequeue();
        System.out.print("after dequeue  :");
        q.display();
        
    }
}
