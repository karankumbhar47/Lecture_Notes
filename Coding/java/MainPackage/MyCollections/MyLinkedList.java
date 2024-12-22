package MainPackage.MyCollections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;


public class MyLinkedList {
    // class can implements mulitple interfaces but only extend one class
    // to avoid diamond abmiguity java only limit to extend class limit to 1
    // not store in continuous manner
    // LL (implements) --> DLL (also implements List, Queue) 
    // list implemented by (vector(--> Stack), arraylist, linkedlist)

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(12);
        linkedList.add(12);

        for(int i=0; i<linkedList.size(); i++){
            System.out.println(linkedList.get(i));
        }

        Iterator<Integer> iterator = linkedList.iterator(); 
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for(Integer node : linkedList){
            System.out.println(node);
        }
    }
}
