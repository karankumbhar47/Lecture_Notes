package MainPackage.MyCollections;

import java.util.ArrayList;

public class MyArrayList {
    /*
     * some initial capacity set
     * full capacity reached resize the array
     * new size = (oldSize*3)/2 + 1
     * after resizing coping element
     */
    public static void main(String[] args) {
        ArrayList<Integer> newList = new ArrayList<>();

        for(int i=0; i<25; i++){
            newList.add(i);
        }

        /*
         * inital arraylist size is 10
         * then increase as per formula 
         * and then copy the old values to new
         */
    }

}
