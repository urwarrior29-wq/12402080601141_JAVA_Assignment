//Program:6->Display all  files of a given directory using File class

import java.io.*;

public class Program6 {
    public static void main(String[] args) {

        // Give directory path here
        File folder = new File("C:\\Users\\URVIT\\Desktop\\Java-Programming-Assignment\\Assignment-2");

        // check if folder exists
        if (!folder.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        // check if it is actually a directory
        if (!folder.isDirectory()) {
            System.out.println("This is not a directory!");
            return;
        }

        // get all files and folders
        File[] files = folder.listFiles();

        System.out.println("Files in directory:");

        // loop through files
        for (File f : files) {

            // check if it is a file (not folder)
            if (f.isFile()) {
                System.out.println(f.getName());
            }
        }
    }
}