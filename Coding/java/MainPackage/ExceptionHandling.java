package MainPackage;

/*
    
    runtime error(developer fault)
        - NullPoint Exception
        - Out of bond Exception
        - Airthmetic Exception
    All above classes inherit Exception class

    IOException (compile time error)
        - FileNotFoundException
 */

 /*
Exception  --> Runtime --> Index out of
                       --> Airthematic 
                       --> Null Point
           --> IOException --> FileNotFound
*/


public class ExceptionHandling{

    public static void main(String[] args){
        try{
            int arr[] = {1,2,3};
            System.out.println(arr[4]);

            // statement below the exceptional statement 
            // will not be executed
            int result = 4/0;
        }
        // catch(ArrayIndexOutOfBoundsException | RuntimeException exception){
        //     System.out.println("Error while accessing element 1");
        // }
        // catch(IOException exception){
        //     System.out.println("Error while accessing element 2");
        // }
        catch(Exception exception){
            System.out.println("Error while accessing element 3");
        }
        finally{
            System.out.println("Always Executed");
        }

        // System.exit(0);

        // try{
            // int arr[] = {1,2,3};
            // System.out.println(arr[4]);
            // System.exit(0);
        // }
        // finally{
            // System.out.println("Always Executed");
        // }

        // System.exit(1);

        System.out.println("Always Executed");

        try {
            method1(6);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Always Executed");
        }

        Generic<String,Integer> generic = new Generic<>("data", 4);
        System.out.println(generic.getData());
        generic.setElement(12);

        Integer a = 12;// autoboxing
        int b = a; // unboxing
        System.out.println(a+b);
    }

    private final static void method1(int a) throws Exception{
        System.out.println(a);
        if(a>1){
            throw new RuntimeException("This is runtime Error");
        }
        else{
            throw new MyException("this is my exception");
        }
    }

}
