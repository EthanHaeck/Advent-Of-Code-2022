import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day2 {
    public void run() throws FileNotFoundException {
        File file = new File("C:\\Users\\Ethan\\Desktop\\Advent of Code\\Inputs\\Day2Input.txt");
        Scanner scanner = new Scanner(file);
        String line;
        int score = 0;

        // A/X = Rock  1pt
        // B/Y = Paper  2pt
        // C/Z = Scissors  3pt
        //WIN = 6pt
        //DRAW = 3pt

        //X = LOSE
        //Y = TIE
        //Z = WIN

        char oppMove;
        char myMove;

        while(scanner.hasNextLine()){
            line = scanner.nextLine();
            oppMove = line.charAt(0);
            myMove = line.charAt(2);

            if(oppMove == 'A'){
                if(myMove == 'X'){
                    score += 3;
                }
                if(myMove == 'Y'){
                    score += 1;
                    score += 3;
                }
                if(myMove == 'Z'){
                    score += 2;
                    score += 6;
                }
            }
            if(oppMove == 'B'){
                if(myMove == 'X'){
                    score += 1;
                }
                if(myMove == 'Y'){
                    score += 2;
                    score += 3;
                }
                if(myMove == 'Z'){
                    score += 3;
                    score += 6;
                }
            }
            if(oppMove == 'C'){
                if(myMove == 'X'){
                    score += 2;
                }
                if(myMove == 'Y'){
                    score += 3;
                    score += 3;
                }
                if(myMove == 'Z'){
                    score += 1;
                    score += 6;
                }
            }

        }
        System.out.println(score);

    }
}
