package Static;

public class StaticBlock {
    
    // static variable
    static int a = 10;
    static int b;
    
    // static block
    static{
        
        System.out.println("Static block initialized.");
        b = a * 4;
    }

    public static void main(String[] args)
    {
       System.out.println("from main");
       System.out.println("Value of a : "+a);
       System.out.println("Value of b : "+b);
    }
}
// A static block is executed only once when the class is first loaded into memory. It is often used to initialize static variables or perform configuration tasks before the main method executes.
