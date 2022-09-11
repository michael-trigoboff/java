// demonstrates the use of java.util.Set

import java.util.*;
import pcc.stdin;

public class SetDemo
{
    public static void main(String[] args)
    {
        String[]        line;
        Set<String>     set = new HashSet<>();
        
        System.out.println("SetDemo 2.2");
        
    input:
        while (true) {
            System.out.print("enter a word: ");
            line = stdin.getLineWords();
            if (line == null)
                continue;
            for (String word : line) {
                if (word.equalsIgnoreCase("exit"))
                    break input;
                else if (set.add(word))
                    System.out.print("added");
                else
                    System.out.print("already saw");
                System.out.printf(" \"%s\"%n", word);
                }
            }
        System.out.println(set.size() + " words seen:");
        // this output can be alphabetical if the Set is a TreeSet
        for (String word : set)
            System.out.println("  " + word);
        System.out.println("bye...");
    }
}
