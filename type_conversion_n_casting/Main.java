package type_conversion_n_casting;

public class Main {
    public static void main(String[] args) {
        // normal conversion example
        int a = 10;
        float b = a;
        System.out.println(b);
        
        // when you are explicitly converting a larger type to a smaller type, it is called casting
        int c = 10;
        byte d = (byte) c;
        System.out.println(d);
        
        // when you are explicitly converting a smaller type to a larger type, it is called widening
        byte e = 10;
        int f = e;
        System.out.println(f);
        
        // then what is lossy conversion?
        // when you are converting a larger type to a smaller type, and the value is too large to be stored in the smaller type, then it is called lossy conversion
        int g = 1000;
        byte h = (byte) g;
        System.out.println(h);
        // the output is -24
        // because 1000 is too large to be stored in a byte, so it is converted to -24
        // but why only -24?
        // 1000 in binary (base 10) = 00000000 00000000 00000011 11101000
        // so it keeps the last 8 bits and discards the rest
        // or you could get it by 1000 % 256 = 
        int i = 1000 % 256;
        System.out.println(i);

    }
}
