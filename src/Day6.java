import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day6 {
    public void run() throws FileNotFoundException {
        File file = new File("C:\\Users\\Ethan\\Desktop\\Advent of Code\\Advent-Of-Code-2022\\Inputs\\Day6.txt");
        Scanner scanner = new Scanner(file);

        String input = scanner.nextLine();
        boolean hasDup = true;
        int check = 0;

        char[] chars = input.toCharArray();

        char[] recent = new char[4];
        for(int i = 0; i < chars.length; i++){
            recent[0] = chars[i];
            recent[1] = chars[i+1];
            recent[2] = chars[i+2];
            recent[3] = chars[i+3];

           Set<Character> unique = new HashSet<Character>();
           for(int j = 0; j < 4; j++){
               if(unique.add(recent[j])){
                    check++;
               }
           }
           if(check == 4){
               System.out.println(i+3);
               System.exit(0);
           }
           check = 0;
        }

    }
}
