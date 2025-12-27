package Strings;

public class Main {
    public static void main(String[] args) {
        // way to create a string
        // String name = "abc";
        // but this is immutable, so we cannot change it
        String name = new String("abc");
        // this is mutable, so we can change it
        // Reason:
        // When we create a string using double quotes, it is stored in the string pool
        // and string pool is a special memory area in the heap memory
        // and strings in string pool are immutable
        // but when we create a string using new keyword, it is stored in the heap memory
        
    }
}
