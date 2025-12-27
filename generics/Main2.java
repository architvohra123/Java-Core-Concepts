package generics;

class Container<T>{ // here T represents type parameter , and it can by anything like E,K,V etc
    T value; 
    public void show(){
        System.out.println(value.getClass().getName());
    }
    public T getValue(){
        return value;
    }

}
public class Main2 {
    public static void main(String[] args) {
        Container obj = new Container();
        obj.value = 10.1234567890123456789d;
        obj.show();
        System.out.println(obj.getValue());
        
    }
}
