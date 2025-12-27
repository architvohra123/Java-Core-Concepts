package Arrays;
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
public class Main {
    public static void main(String[] args) {
        // declare and initialize an array
        int[] numbers = {10, 20, 30, 40, 50};

        // print the array elements
        for(int i = 0; i < numbers.length; i++){
            System.out.println("Element at index " + i + ": " + numbers[i]);
        }

        // lets create array of objects
        Person[] people = new Person[3];
        people[0] = new Person("Alice", 25);
        people[1] = new Person("Bob", 30);
        people[2] = new Person("Charlie", 35);

    }
}
