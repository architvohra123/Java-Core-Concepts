package Collections_Framework;

public class abstract_classes {
    public static void main(String[] args) {
        // abstract means: khyali pulao || existing in thoughts but not in reality
        // abstract method: a method that is declared without an implementation

        // abstract class: a class that is declared abstract - it can have abstract and non-abstract methods , this cannot be instantiated but can be subclassed
        // if a class has at least one abstract method, then the class must be declared abstract
        // abstract class ek aisi class hai, jiski sahayta lekar hum dusri classes bana sakte hain, lekin us class ka apna koi object nahi bana sakte


    }
    // example of abstract method:
    abstract class Bike {
        abstract void run();
    }

    // now there should be a doubt of use case between abstract class and interface
    // the difference in use case is:
    // use abstract class when we have some common functionality to share among all the subclasses
    // use interface when we have to achieve complete abstraction and multiple inheritance, here multiple inheritance means that a class can implement multiple interfaces but can extend only one class
}
