// Program6-> cipher system using abstract class

// abstract class
abstract class Cipher {
    
    String text;

    // constructor
    Cipher(String text) {
        this.text = text;
    }

    // abstract method (must override in child)
    abstract String encrypt();
    abstract String decrypt();
}

// child class (example: simple shift cipher)
class CaesarCipher extends Cipher {

    int key;

    // constructor
    CaesarCipher(String text, int key) {
        super(text);
        this.key = key;
    }

    // encrypt method
    String encrypt() {
        String result = "";

        for(int i=0;i<text.length();i++) {
            char ch = text.charAt(i);

            // shifting character
            ch = (char)(ch + key);

            result = result + ch;
        }

        return result;
    }

    // decrypt method
    String decrypt() {
        String result = "";

        for(int i=0;i<text.length();i++) {
            char ch = text.charAt(i);

            // reversing shift
            ch = (char)(ch - key);

            result = result + ch;
        }

        return result;
    }
}

// main class
public class Program6{
    public static void main(String args[]) {

        // creating object
        CaesarCipher obj = new CaesarCipher("HELLO", 3);

        String enc = obj.encrypt();
        System.out.println("Encrypted: " + enc);

        // decrypt using encrypted text
        CaesarCipher obj2 = new CaesarCipher(enc, 3);
        String dec = obj2.decrypt();

        System.out.println("Decrypted: " + dec);
    }
}