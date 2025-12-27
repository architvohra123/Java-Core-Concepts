package Object_oriented_programming;
class Parent{
    public void print(){
        System.out.println("Parent class");
    }
}
class Child extends Parent{
    @Override
    public void print(){
        System.out.println("Child class");
    }
}
public class Main2 {
    public static void main(String[] args) {
        // 4 ways to create an object:
        Parent obj = new Parent();
        Parent obj2 = new Child(); 
        Child obj3 = new Child();
        // Child obj4 = new Parent(); // error: incompatible types: Parent cannot be converted to Child

        // which one is the best?
        // answer: it depends on the situation
        // if you want to use polymorphism, then use Parent obj = new Child();
        // if you want to use child class methods, then use Child obj = new Child();

    }
}
