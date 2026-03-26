//Program:3-> Implement CRUD operations using Collection API (ArrayList, HashMap, TreeMap) 

import java.util.*;

// Student class (data structure)
class Student {
    int id;
    String name;

    // constructor
    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // display method
    void display() {
        System.out.println(id + " " + name);
    }
}

// Main class
public class Program3 {
    public static void main(String[] args) {

        //CREATE (Initialize collections)
        ArrayList<Student> list = new ArrayList<>();
        HashMap<Integer, Student> map = new HashMap<>();
        TreeMap<Integer, Student> tmap = new TreeMap<>();

        //C ->Create (Add data)
        Student s1 = new Student(1, "Amit");
        Student s2 = new Student(2, "Riya");

        list.add(s1);
        list.add(s2);

        map.put(s1.id, s1);
        map.put(s2.id, s2);

        tmap.put(s1.id, s1);
        tmap.put(s2.id, s2);

        // R -> Read (Display data)
        System.out.println("ArrayList Data:");
        for (Student s : list) {
            s.display();
        }

        System.out.println("\nHashMap Data:");
        for (Student s : map.values()) {
            s.display();
        }

        System.out.println("\nTreeMap Data (Sorted):");
        for (Student s : tmap.values()) {
            s.display();
        }

        // U -> Update (modify student name)
        map.get(1).name = "Rahul"; // update in map

        System.out.println("\nAfter Update:");
        map.get(1).display();

        //D -> Delete (remove student)
        list.remove(0);     // remove from list
        map.remove(2);      // remove from map
        tmap.remove(2);     // remove from treemap

        System.out.println("\nAfter Deletion (ArrayList):");
        for (Student s : list) {
            s.display();
        }
    }
}