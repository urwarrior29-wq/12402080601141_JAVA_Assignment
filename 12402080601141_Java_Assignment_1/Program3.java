// Program:3-> Wrapper class and string vs stringbuffer

public class Program3 {

    public static void main(String args[]) {

        // wrapper class example
        
        int a = 10;
        Integer obj = a;   // converting int to Integer

        System.out.println("value: " + obj);

        Integer b = 20;
        int num = b;   // converting Integer to int

        System.out.println("value: " + num);

        int x = 50;
        String str = Integer.toString(x);   // int to string

        System.out.println("int to string: " + str);

        String s = "100";
        int y = Integer.parseInt(s);   // string to int

        System.out.println("string to int: " + y);


        // string example
        
        String s1 = "Hello";
        s1.concat(" World");   // not changing original string

        System.out.println("string: " + s1);


        // stringbuffer example
        
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World");   // changing original value

        System.out.println("stringbuffer: " + sb);
    }
}