package Methods_Overloading;
class Calculator{
    // Method to add two integers
    public int add(int a, int b){
        return a + b;
    }
    
    // Overloaded method to add two doubles
    public double add(double a, double b){
        return a + b;
    }
    
    // Overloaded method to add three integers
    public int add(int a, int b, int c){
        return a + b + c;
    }

    // say we have this overloaded method too
    public String print1(int a, String b){
        return "num is " + a + " and str is " + b;
    }

    // we can also have this overloaded method
    public String print1(String b, int a){
        return "str is " + b + " and num is " + a;
    }
}
public class Main {
    public static void main(String[] args) {
        // Method Overloading example
        Calculator calc = new Calculator();
        
        int sum1 = calc.add(2, 3); // calls add(int, int)
        System.out.println("Sum of 2 and 3: " + sum1);
        
        double sum2 = calc.add(2.5, 3.5); // calls add(double, double)
        System.out.println("Sum of 2.5 and 3.5: " + sum2);
        
        int sum3 = calc.add(1, 2, 3); // calls add(int, int, int)
        System.out.println("Sum of 1, 2 and 3: " + sum3);
    }
}
