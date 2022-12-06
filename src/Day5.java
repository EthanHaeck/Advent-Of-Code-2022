import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Day5 {
    public void run() throws FileNotFoundException {
        File file = new File("C:\\Users\\Ethan\\Desktop\\Advent of Code\\Advent-Of-Code-2022\\Inputs\\Day5.txt");
        Scanner scanner = new Scanner(file);
        String currLine;

        //Hard coding stacks because I'm lazy
        Stack<Character> stack1 = new Stack<Character>();
        Stack<Character> stack2 = new Stack<Character>();
        Stack<Character> stack3 = new Stack<Character>();
        Stack<Character> stack4 = new Stack<Character>();
        Stack<Character> stack5 = new Stack<Character>();
        Stack<Character> stack6 = new Stack<Character>();
        Stack<Character> stack7 = new Stack<Character>();
        Stack<Character> stack8 = new Stack<Character>();
        Stack<Character> stack9 = new Stack<Character>();

        //1
        stack1.push('H');
        stack1.push('T');
        stack1.push('Z');
        stack1.push('D');
        //2
        stack2.push('Q');
        stack2.push('R');
        stack2.push('W');
        stack2.push('T');
        stack2.push('G');
        stack2.push('C');
        stack2.push('S');
        //3
        stack3.push('P');
        stack3.push('B');
        stack3.push('F');
        stack3.push('Q');
        stack3.push('N');
        stack3.push('R');
        stack3.push('C');
        stack3.push('H');
        //4
        stack4.push('L');
        stack4.push('C');
        stack4.push('N');
        stack4.push('F');
        stack4.push('H');
        stack4.push('Z');
        //5
        stack5.push('G');
        stack5.push('L');
        stack5.push('F');
        stack5.push('Q');
        stack5.push('S');
        //6
        stack6.push('V');
        stack6.push('P');
        stack6.push('W');
        stack6.push('Z');
        stack6.push('B');
        stack6.push('R');
        stack6.push('C');
        stack6.push('S');
        //7
        stack7.push('Z');
        stack7.push('F');
        stack7.push('J');
        //8
        stack8.push('D');
        stack8.push('L');
        stack8.push('V');
        stack8.push('Z');
        stack8.push('R');
        stack8.push('H');
        stack8.push('Q');
        //9
        stack9.push('B');
        stack9.push('H');
        stack9.push('G');
        stack9.push('N');
        stack9.push('F');
        stack9.push('Z');
        stack9.push('L');
        stack9.push('D');

        ArrayList<Stack<Character>> stackList = new ArrayList<Stack<Character>>();
        stackList.add(stack1);
        stackList.add(stack2);
        stackList.add(stack3);
        stackList.add(stack4);
        stackList.add(stack5);
        stackList.add(stack6);
        stackList.add(stack7);
        stackList.add(stack8);
        stackList.add(stack9);

        //get to instructions
        while(!scanner.nextLine().isEmpty()){}

        int amountToMove;
        int moveFrom;
        int moveTo;
        while(scanner.hasNextLine()){
            //read instruction
            currLine = scanner.nextLine();
            String[] split = currLine.split(" ");
            amountToMove = Integer.parseInt(split[1]);
            //indexing starts at 0
            moveFrom = Integer.parseInt(split[3]) - 1;
            moveTo = Integer.parseInt(split[5]) - 1;

            //PT 1
            //perform the move
//            for(int i = 0; i < amountToMove; i++){
//                stackList.get(moveTo).push(stackList.get(moveFrom).pop());
//            }

            //PT 2
            char[] boxes = new char[amountToMove];
            //pop
            for(int i = 0; i < amountToMove; i++){
                boxes[i] = stackList.get(moveFrom).pop();
            }
            //push
            for(int i = amountToMove-1; i >= 0; i--){
                stackList.get(moveTo).push(boxes[i]);
            }

        }
        System.out.println(stack1);
        System.out.println(stack2);
        System.out.println(stack3);
        System.out.println(stack4);
        System.out.println(stack5);
        System.out.println(stack6);
        System.out.println(stack7);
        System.out.println(stack8);
        System.out.println(stack9);
    }
}
