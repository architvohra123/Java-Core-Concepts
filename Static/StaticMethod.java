package Static;

public class StaticMethod {
        
    // static variable
    static int a = m1();

    // static block
    static{
        
        System.out.println("Inside static block");
    }

    // static method
    static int m1(){
        
        System.out.println("From m1");
        return 20;
    }
    // another static method
    static int m2(){
        
        System.out.println("From m2");
        return 999;
    }

    public static void main(String[] args){
        
        System.out.println("Value of a: " + a);
        System.out.println("From main");
        System.out.println(m2());
    }
}

// A static method belongs to the class rather than to any object. It can be called directly using the class name.

// Can access only static data directly.
// Cannot access instance variables or methods directly.
// Cannot use this or super keywords.