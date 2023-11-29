public class StackMain {
    public static void main(String[] args){
        Stack<Integer> st=new Stack<>();
        st.push(50);
        st.push(30);
        st.push(70);
        System.out.print("Stack :");
        st.display();

        while(st.isEmpty()==false){
            System.out.println("stack top: "+st.peek());
            st.pop();
            System.out.println("After poping");
            st.display();
        }
    }

    
}
