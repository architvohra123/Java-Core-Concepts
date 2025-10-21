package Methods;
class Computer{
    public void powerOn(){
        System.out.println("Powering On");
    }

    public String getTotalCost(int units){
        if(units <= 0){
            return "Invalid units";
        }else return "Total cost is: " + (units * 5) + " USD";
    }
}

// Here explain the concept of methods in Java in detail
// A method is a block of code that performs a specific task
public class Main {
    public static void main(String[] args) {
        Computer obj = new Computer();
        obj.powerOn();
        String cost = obj.getTotalCost(10);
        System.out.println(cost);
    }
}
