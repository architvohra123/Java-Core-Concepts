package Collections_Framework;

interface Bicycle {
    int a=45;
    void applyBrake(int decrement);
    void speedUp(int increment);
}

class avonCycle implements Bicycle {
    // if we try to change the value of a, it will throw an error because interface variables are final by default
    // but we can redeclare it in the class like below commented line
    // int a = 10;
    
    void blowHorn() {
        System.out.println("Pee Pee Poo Poo");
    }
    @Override
    public void applyBrake(int decrement) {
        System.out.println("Applying Brake");
    }
    @Override
    public void speedUp(int increment) {
        System.out.println("Speeding Up");
    }
}
public class interfaces {
    public static void main(String[] args) {
        avonCycle cycle = new avonCycle();
        System.out.println("Value of a is: "+ cycle.a);
    }
}
