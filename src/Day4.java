import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4 {
    public void run() throws FileNotFoundException {
        File file = new File("C:\\Users\\Ethan\\Desktop\\Advent of Code\\Inputs\\Day4.txt");
        Scanner scanner = new Scanner(file);
        int total = 0;
        String currLine;

        while(scanner.hasNextLine()){
            currLine = scanner.nextLine();

            //parse
            String[] pairs = currLine.split(",");
            String[] set1 = pairs[0].split("-");
            String[] set2 = pairs[1].split("-");
            int set1Start = Integer.parseInt(set1[0]);
            int set1End = Integer.parseInt(set1[1]);
            int set2Start = Integer.parseInt(set2[0]);
            int set2End = Integer.parseInt(set2[1]);

            //PT 1 -- Test for a set containing the other

//            if(set1Start <= set2Start && set1End >= set2End){ //pair 1 contains pair 2
//                total++;
//            }
//            else if(set2Start <= set1Start && set2End >= set1End){ //pair 2 contains pair 1
//                total++;
//            }

            // PT 2 -- Test for any overlap
            if(set1Start <= set2End && set2Start <= set1End){
                total++;
            }

        }
        System.out.println(total);

    }
}
