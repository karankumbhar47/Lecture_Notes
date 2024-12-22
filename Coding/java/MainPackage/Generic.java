package MainPackage;

/*
Wrapper class --> Collection only allows object 
              --> no premitive allows
              --> classes in java.util only allows object
              --> autoboxing(int->Integer) and unboxing(Integer->int) used
              --> best in synchronized function in mulitthreading
 * bounded generic type (only allows some Type) 
 * like E extends Number
 * 
 * Generic class
 * Generic Method
 */
public class Generic <T,E extends Number>{
    private T data;
    private E element;

    Generic(T data, E name){
        System.out.println("generic constructor");
        this.data = data;
        this.element= name;
    }

    public T getData(){
        return data;
    }

    public  void setElement(E element){
        this.element = element;
    }

    public E getElement(){
        return element;
    }

    // generic method
    public static <K> void printData(K data){
        System.out.println(data);
    }

    public static void main(String[] args) {
        printData("this");
        Generic.<Integer>printData(12);
    }

}
