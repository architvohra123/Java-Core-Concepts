package Stack_and_Heap_in_java;

class Calculator{
    int num = 100;
    public int add(int a, int b){
        System.out.println(num);
        return a + b;
    }
}
public class Main {
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        int sum = calc.add(2, 3);
        System.out.println(sum);

    }
}

// As I said stack is of 2 parts key and value
// and each method will have its own stack memory
// Here main method inside Main class will have its own stack memory
// so inside that stack memory we will have key value pairs as:
// args -> reference to String array
// calc -> reference to Calculator object , lets say it is at address 0x001
// sum -> value of sum (5 in this case)

// now for method add, there will be another stack memory created when we call calc.add(2,3)
// so inside that stack memory we will have key value pairs as:
// a -> 2
// b -> 3
// and when the method add finishes execution that stack memory will be destroyed

// ok but where does num get stored?
// this is where heap memory comes into picture

// when we create an object of a class using "new" keyword, memory for that object is allocated in heap memory
// so when we do Calculator calc = new Calculator();, a new object of Calculator class is created in heap memory

// in heap we will have:
// Calculator object at address 0x001:
// num -> 100
// add() -> reference to add method

// so starting from the stack memory of main method, we get to the heap memory using the reference calc
// and then inside the heap memory we can access num variable of Calculator object


