import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day1 {

    public void run() throws FileNotFoundException {
        File file = new File("C:\\Users\\Ethan\\Desktop\\Advent of Code\\Inputs\\Day1Input.txt");
        Scanner scanner = new Scanner(file);
        int calorieCount = 0;
        String line;
        int lineVal;
        ArrayList<Integer> values = new ArrayList<Integer>();

        while(scanner.hasNextLine()){
            line = scanner.nextLine();
            if(line.isEmpty()){
                values.add(calorieCount);
                calorieCount = 0;
            }
            else{
                lineVal = Integer.parseInt(line);
                calorieCount += lineVal;
            }

        }

        Collections.sort(values);

        System.out.println(values);

    }
}
