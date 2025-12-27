package Object_oriented_programming;

class Parent {
    public void print() {
        System.out.println("Parent class");
    }
}

class Child extends Parent {
    @Override
    public void print() {
        System.out.println("Child class");
    }
    
    public void childOnly() {
        System.out.println("Child-only method");
    }
}

public class Main3 {
    public static void main(String[] args) {
        // Scenario 1: Simple parent
        Parent obj1 = new Parent();
        obj1.print();  // Parent class
        
        // Scenario 2: Polymorphism! ⭐
        Parent obj2 = new Child(); // this is upcasting
        obj2.print();  // Child class (Child's override wins!)
        // obj2.childOnly();  // ✗ ERROR - Parent ref doesn't see this
        
        // Scenario 3: Simple child
        Child obj3 = new Child();
        obj3.print();      // Child class
        obj3.childOnly();  // ✓ Works - Child ref sees everything
        
        // Scenario 4: Illegal
        // Child obj4 = new Parent();  // ✗ COMPILE ERROR
        
        // Downcasting example:
        Parent obj = new Child();  // Actually Child
        Child child = (Child) obj;  // ✓ Safe downcast
        child.childOnly();  // Now we can call child methods


/* 
        Note:
        when we write something like:
        A obj = new B();
        where B extends A, it's called upcasting. Here, obj is of type A but refers to an object of type B.
        Here we can only access methods defined in A (unless overridden in B).
        But we cannot access methods that are only in B.
    

*/
    }
}
