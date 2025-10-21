package datatypes;
public class Main {
    public static void main(String[] args) {

        // we can not set float value without f, as it is by default double
        float n = 2.4f;
        // all other data types with assignment
        int a = 10;
        char b = 'a';
        short c = 100;
        byte d = 10;
        long e = 1000000000000000000L;
        double f = 10.5;
        boolean g = true;
        // size of boolean is 1 bit
        // size of char is 2 bytes
        // size of short is 2 bytes
        // size of int is 4 bytes
        // size of long is 8 bytes
        // size of float is 4 bytes
        // size of double is 8 bytes 
        // in memory, say boolean, is stored as 00000000 or 00000001

        // what is a literal?
        // a literal is a constant value that is assigned to a variable
        // give examaples like how to assign binary, hexadecimal, octal values , using underscores and epsilon, assign them to variables
        // binary value
        int binaryValue = 0b1010;
        // hexadecimal value
        int hexadecimalValue = 0x1A;
        // octal value
        int octalValue = 012;
        // epsilon value
        double epsilonValue = 1e-6;
        // using underscores
        int underscoresValue = 1_000_000;
        
        // why for binary hexadecimal and octal values, there is 0 in front of the value? would not it be easier to write without 0, like for binary it could have been :
        // int a = b1010;
        // for hexadecimal it could have been :
        // int b = x1A;
        // for octal it could have been :
        // int c = 012;
        // why is it like this?
        // because the compiler needs to know that the value is a binary, hexadecimal or octal value

        // what is the actual value of epsilonValue?
        System.out.println(epsilonValue);
        // it gets printed as 1.0E-6
        // but what is the actual value of epsilonValue?
        // it is 0.000001
    }
}
