package MainPackage.TypePackage;

// at  most one public class
// if one public class is present then
// name should be the file name

// if mulitple classes are non public
// then only class will be excuated with main   
// method on called with java packageName.subClassName

class TypeDType1{
    public static void main1(String arr[]){
        Integer i = Integer.valueOf(10);
        System.out.println(i.compareTo(9));
        System.out.println(i.byteValue());
    }
}

class noClass{
    public static void main1(String arr[]){
        System.out.println("Hello world");
    }

    private void randomMethod(){
        System.out.println("random function");

    }
}