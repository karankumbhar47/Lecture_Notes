package MainPackage.MyCollections;

import java.util.Stack;

public class MyStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(12);
        System.out.println(st);
        st.push(11);
        System.out.println(st);
        st.add(13);
        System.out.println(st);

        System.out.println(st.get(0));
        System.out.println(st.get(1));
        System.out.println(st.get(2));

        System.out.println(st.peek());
        st.pop();
        System.out.println(st);
        System.out.println(st.peek());
        st.pop();
        System.out.println(st);
        System.out.println(st.peek());
        st.pop();
        System.out.println(st);

        System.out.println(st.empty());
    }
}
