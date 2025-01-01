package com.coreJava.RunnerClasses.List;

import com.coreJava.FactoryPattern.CodeRunnerInterface;

import javax.sound.sampled.LineListener;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class StackPractice implements CodeRunnerInterface {
    @Override
    public void runCode() {
        StackPractice.main(null);
    }

    public static void main(String[] args) {
        // stack extends vector
        // so stack is also synchronized
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
        Integer topElement = stack.pop();
        System.out.println("top element "+topElement);
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack);
        Integer distanceFromTop = stack.search(2);
        System.out.println(distanceFromTop);
        System.out.println(stack);

        // we can use vectors methods also
        stack.addFirst(2);
        stack.addFirst(3);
        stack.addFirst(4);
        stack.add(1,1);
        System.out.println(stack);


        // we can use a linked list as stack also as stack has synchronized methods
        // it will have performance overhead to in a single thread environment we can
        // use a linked list as stack (as a linked list is a doubly linked list, we have
        // a tail pointer, so we can achieve it by linked list)
        LinkedList<Integer> st = new LinkedList<>();
        st.addLast(1); // push
        st.addLast(2);
        st.addLast(3);
        st.addLast(4);
        st.getLast(); // peek
        st.removeLast(); // pop
        st.size(); //size
        st.isEmpty(); // empty

        // Arraylist as stack
        ArrayList<Integer> st1 = new ArrayList<>();
        st1.addLast(1); //push
        st1.addLast(1);
        st1.addLast(1);
        st1.getLast(); // peek
        st1.removeLast(); //pop
        st1.size(); // size of a collection
        st1.isEmpty(); //empty

        // but the recommended way to get stack is using ArrayDeque
        // better memory management
    }
}
