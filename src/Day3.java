import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day3 {

    public void run() throws FileNotFoundException {
        File file = new File("C:\\Users\\Ethan\\Desktop\\Advent of Code\\Inputs\\Day3.txt");
        Scanner scanner = new Scanner(file);
        String currLine;
        int totalVal = 0;

        while(scanner.hasNextLine()){
            currLine = scanner.nextLine();
            int mid = (currLine.length() / 2);

            char[] half1 = new char[mid];
            char[] half2 = new char[mid];

            for(int i = 0; i < mid; i++){
                half1[i] = currLine.charAt(i);
            }
            for(int i = mid; i < currLine.length(); i++){
                half2[i-mid] = currLine.charAt(i);
            }

            Arrays.sort(half1);
            Arrays.sort(half2);

            for(int i = 0; i < half1.length; i++){
                for(int j = 0; j < half2.length; j++){
                    if(half1[i] == half2[j]){
//                        System.out.println(half1[i]);
                        if((half1[i] - 'a') < 0){ //UPPER CASE
                            totalVal += half1[i] - 'A' + 27;
//                            System.out.println(totalVal);
                        }
                        else{ //lower case
                            totalVal += half1[i] - 'a' + 1;
//                            System.out.println(totalVal);
                        }
                        i = half1.length; //stop looking
                        j = half2.length;
                    }
                }
            }

        }
        System.out.println(totalVal);
    }

    public void runPt2() throws FileNotFoundException {
        File file = new File("C:\\Users\\Ethan\\Desktop\\Advent of Code\\src\\Day3.txt");
        Scanner scanner = new Scanner(file);
        String currLine;
        int totalVal = 0;
        String line1;
        String line2;
        String line3;

        while(scanner.hasNextLine()){

            line1 = scanner.nextLine();
            line2 = scanner.nextLine();
            line3 = scanner.nextLine();

            char[] l1 = line1.toCharArray();
            char[] l2 = line2.toCharArray();
            char[] l3 = line3.toCharArray();

            HashMap<Integer, Character> map1 = new HashMap<Integer, Character>();
            HashMap<Integer, Character> map2 = new HashMap<Integer, Character>();
            HashMap<Integer, Character> map3 = new HashMap<Integer, Character>();

            //add each line's chars to HashMap
            //key = index
            //value = character
            for(int i = 0; i < l1.length; i++){
                map1.put(i, l1[i]);
            }
            for(int i = 0; i < l2.length; i++){
                map2.put(i, l2[i]);
            }
            for(int i = 0; i < l3.length; i++){
                map3.put(i, l3[i]);
            }

            //look for shared character
            for(int i = 0; i < map1.size(); i++){
                char a = map1.get(i);
                if(map2.containsValue(map1.get(i)) && map3.containsValue(map1.get(i))){
                    //add character value to total
                    if((map1.get(i) - 'a') < 0){ //UPPER CASE
                        totalVal += map1.get(i) - 'A' + 27;
                    }
                    else{ //lower case
                        totalVal += map1.get(i) - 'a' + 1;
                    }
                    //stop looking
                    break;
                }
            }
        }
        System.out.println(totalVal);
    }
}
