package MainPackage;

public class MyException extends Exception{
    public MyException(String message){
        super(message);
        Integer newInt = 12;// autoboxing
        Integer integer = Integer.valueOf(12);//  
        int a = integer; // unboxing
        message = message + String.valueOf(a);
    }

    public <T> void setMsg(T data){
        T msg = data;
    }
}