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

        //pt 1 - 4 chars
        //pt 2 - 14 chars
        int part2 = 14;

        char[] recent = new char[part2];
        for(int i = 0; i < chars.length; i++){

            //fill recent
            for(int a = 0; a < part2; a++){
                recent[a] = chars[a+i];
            }

           Set<Character> unique = new HashSet<Character>();
           for(int j = 0; j < part2; j++){
               if(unique.add(recent[j])){
                    check++;
               }
           }
           if(check == part2){
               System.out.println(i+part2);
               System.exit(0);
           }
           check = 0;
        }
    }
}
