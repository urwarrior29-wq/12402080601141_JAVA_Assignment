//Program6-> Demonstrate Inner Classes (member, local, anonymous) 

class Outer {

    int x = 10;

    //1 Member Inner Class
    class MemberInner {
        void show() {
            System.out.println("Member Inner Class: x = " + x);
        }
    }

    // Method to demonstrate Local and Anonymous class
    void display() {

        int y = 20;

        //2 Local Inner Class
        class LocalInner {
            void show() {
                System.out.println("Local Inner Class: y = " + y);
            }
        }

        LocalInner local = new LocalInner();
        local.show();

        //3 Anonymous Inner Class
        DemoInterface obj = new DemoInterface() {
            public void show() {
                System.out.println("Anonymous Inner Class");
            }
        };

        obj.show();
    }
}

// Interface for Anonymous class
interface DemoInterface {
    void show();
}

// Main class
public class Program7 {
    public static void main(String[] args) {

        Outer outer = new Outer();

        // Access Member Inner Class
        Outer.MemberInner member = outer.new MemberInner();
        member.show();

        // Access Local + Anonymous through method
        outer.display();
    }
}