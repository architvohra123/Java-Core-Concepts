package generics;

public class Main {
    static class Box<T> { // T is a type parameter
        private T item;

        public void setItem(T item) {
            this.item = item;
        }

        public T getItem() {
            return item;
        }
    }
    // Generics allow us to create classes, interfaces, and methods with a placeholder for the type of data they operate on.
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.setItem(123);
        System.out.println("Integer Value: " + intBox.getItem());

        Box<String> strBox = new Box<>();
        strBox.setItem("Hello Generics");
        System.out.println("String Value: " + strBox.getItem());
    }


    // everything about generics, and what are T, E, K, V etc:
    /*
    Generics in Java is a powerful feature that allows developers to create classes, interfaces, and methods with a placeholder for the type of data they operate on. This enables code reusability, type safety, and cleaner code.
    Here are some key concepts related to generics:
    1. Type Parameters: Generics use type parameters to define the types that a class, interface, or method can operate on. Commonly used type parameter names include:
       - T: Type
       - E: Element (used in collections)
       - K: Key (used in maps)
       - V: Value (used in maps)
    2. Generic Classes: You can define a class with type parameters. For example, a generic Box class that can hold any type of object.
    3. Generic Methods: You can also define methods with type parameters, allowing them to operate on different types without casting.
    4. Type Safety: Generics provide compile-time type checking, which helps catch errors

    example of T:
    Box<Integer> intBox = new Box<>();
    Here, T is replaced with Integer, ensuring that only Integer objects can be stored in intBox.
    
    example of E:
    List<String> stringList = new ArrayList<>();
    Here, E is replaced with String, meaning stringList can only contain String objects.

    example of K and V:
    Map<String, Integer> map = new HashMap<>();
    Here, K is replaced with String (the key type) and V is replaced with Integer (the value type).
    */
}
