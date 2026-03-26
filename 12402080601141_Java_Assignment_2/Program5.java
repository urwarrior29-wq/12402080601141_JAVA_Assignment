//Program:5->Count word occurrences from a  ile using File Handling APIs 

import java.io.*;
import java.util.*;

public class Program5 {
    public static void main(String[] args) {

        // HashMap to store word and count
        HashMap<String, Integer> map = new HashMap<>();

        try {
            // open file
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));

            String line;

            // read file line by line
            while ((line = br.readLine()) != null) {

                // convert to lowercase (for uniform counting)
                line = line.toLowerCase();

                // split line into words
                String[] words = line.split("\\s+");

                for (String word : words) {

                    // remove punctuation (optional but useful)
                    word = word.replaceAll("[^a-z]", "");

                    if (word.length() == 0) continue;

                    // count occurrences
                    if (map.containsKey(word)) {
                        map.put(word, map.get(word) + 1);
                    } else {
                        map.put(word, 1);
                    }
                }
            }

            // close file
            br.close();

            // display result
            System.out.println("Word Count:");
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}