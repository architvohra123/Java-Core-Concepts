package Static;

public class StaticClass {
    public static void main(String[] args)
    {
        Outer.Inner obj = new Outer.Inner();
        obj.show();
    }
}
class Outer {

    static class Inner{

        void show(){
            
            System.out.println(
                "Static Nested Class Method");
        }
    }

    
}
// A static nested class is a class declared as static inside another class. It can be accessed without creating an object of the outer class.
