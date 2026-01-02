package Static;


class Student {

    int rollNo;
    String name;
    
    // static variable
    static String Training_Center
        = "GFG"; 

    Student(int r, String n){
        
        rollNo = r;
        name = n;
    }

    void display(){
        
        System.out.println(rollNo + " " + name + " "
                           + Training_Center);
    }
}

public class staticVariable {
    
    public static void main(String[] args){
        
        Student s1 = new Student(101, "Ravi");
        Student s2 = new Student(102, "Amit");
      	

        s1.display();
        s2.display();
        // here it will both print GFG as training center
        s1.Training_Center = "Coding Ninjas";
        s1.display();
        s2.display();
        // even though we changed the training center for only s1 object, here both will print Coding Ninjas as training center as static variable is shared among all objects
    }
}