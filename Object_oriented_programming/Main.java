package Object_oriented_programming;


class Calculator{
    public int add(int a, int b){
        return a + b;
    }
}
public class Main {
    public static void main(String[] args) {
        // we wanted to add 2 nums
        int num1 = 2;
        int num2 = 3;
        int result = num1 + num2;
        System.out.println(result);

        // we now use calculator class to add 2 nums
        
        //but we can't simplyn call add() func:
        // add(1,2); // error: cannot find symbol
        // you need an object of Calculator class to call add() func

        
        // we also can't do this:
        // Calculator calc;
        // calc.add(num1, num2); // error: variable calc might not have been initialized
        //this is just a reference variable, it doesn't point to any object yet

        // you need to use "new" keyword to create an object of a class
        // "new" keyword allocates memory for the object and returns the reference to that memory
        


        Calculator calc = new Calculator();
        int sum = calc.add(num1, num2);
        System.out.println(sum);

    }
}
