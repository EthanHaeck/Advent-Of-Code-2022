import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day8 {
    public void run() throws FileNotFoundException {
        File file = new File("C:\\Users\\ethan\\Desktop\\Advent-Of-Code-2022\\Inputs\\Day8.txt");
        Scanner scanner = new Scanner(file);
        Scanner scanner2 = new Scanner(file);

        boolean part1 = false; //FALSE for pt 2

        //every tree on the edge is visible
        int treesVisible = 0;
        int largestScenicScore = 0;

        //calculate number on the exterior

        String firstLine = scanner.nextLine();
        //width & height
        int width = firstLine.toCharArray().length;
        int height = 1;
        while(scanner.hasNextLine()){
            height++;
            scanner.nextLine();
        }

        //outside edge of trees
        treesVisible = (width*2) + (height*2) - 4;

        int[][] trees = new int[width][height];

        //fill 2D array
        int temp1 = 0;
        while(scanner2.hasNextLine()){
            String currLine = scanner2.nextLine();
            String[] temp2 = currLine.split("");
            for(int i = 0; i < temp2.length; i++){
                trees[temp1][i] = Integer.parseInt(temp2[i]);
            }
            temp1++;
        }

        //for each inner tree
        //visible if all of the other trees between it and an edge of the grid are shorter than it
        //don't count exterior trees
        if(part1){
            boolean visible = true;
            boolean checkOthers = true;
            for(int i = 1; i < height-1; i++){
                for(int j = 1; j < width-1; j++){
                    checkOthers = true;
                    int currHeight = trees[i][j];
                    //left
                    if(checkOthers){ //search if not visible yet
                        visible = true;
                        for(int k = 0; k < j; k++){
                            if(trees[i][k] >= currHeight){
                                visible = false;
                                break;
                            }
                        }
                        if(visible){
                            treesVisible++;
                            checkOthers = false;
                        }
                    }
                    //right
                    if(checkOthers){
                        visible = true;
                        for(int k = j+1; k < width; k++){
                            if(trees[i][k] >= currHeight){
                                visible = false;
                                break;
                            }
                        }
                        if(visible){
                            treesVisible++;
                            checkOthers = false;
                        }

                    }
                    //up
                    if(checkOthers){
                        visible = true;
                        for(int k = 0; k < i; k++){
                            if(trees[k][j] >= currHeight){
                                visible = false;
                                break;
                            }
                        }
                        if(visible){
                            treesVisible++;
                            checkOthers = false;
                        }
                    }
                    //down
                    if(checkOthers){
                        visible = true;
                        for(int k = i+1; k < height; k++){
                            if(trees[k][j] >= currHeight){
                                visible = false;
                                break;
                            }
                        }
                        if(visible){
                            treesVisible++;
                        }
                    }
                }
            }
            System.out.println(treesVisible);
        }
        else{ //PART 2
            //calculate viewing distance for each direction
            //NOT COUNTING EDGES
            //every tree not on the edge can see at least 1 tree in every direction
            for(int i = 1; i < height-1; i++){
                for(int j = 1; j < width-1; j++){
                    int leftDist = 1;
                    int rightDist = 1;
                    int upDist = 1;
                    int downDist = 1;
                    int currHeight = trees[i][j];
                    int currScenicScore;
                    //left
                    for(int k = j-1; k > 0; k--){
                        if(trees[i][k] < currHeight){
                            leftDist++;
                        }
                        else{
                            break;
                        }
                    }

                    //right
                    for(int k = j+1; k < width-1; k++){
                        if(trees[i][k] < currHeight){
                            rightDist++;
                        }
                        else{
                            break;
                        }
                    }
                    //up
                    for(int k = i-1; k > 0; k--){
                        if(trees[k][j] < currHeight){
                            upDist++;
                        }
                        else{
                            break;
                        }
                    }
                    //down
                    for(int k = i+1; k < height-1; k++){
                        if(trees[k][j] < currHeight){
                            downDist++;
                        }
                        else{
                            break;
                        }
                    }
                    //calculate scenic score
                    currScenicScore = leftDist * rightDist * upDist * downDist;
                    if(currScenicScore > largestScenicScore){
                        largestScenicScore = currScenicScore;
                    }
                }
            }
            System.out.println(largestScenicScore);
        }

    }
}
