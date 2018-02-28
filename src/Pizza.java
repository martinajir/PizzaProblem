import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Pizza {

    private String[][] pizzaGrid;
    private int maxr;
    private int maxc;
    private InputParser inputParser;

    public Pizza() throws FileNotFoundException{

        inputParser = new InputParser(new File("medium.in"));
        maxr = inputParser.getRows();
        maxc = inputParser.getColumns();
        pizzaGrid = new String[maxr][maxc];
    }

    public void populate(){
        int i = 0;
        String[] inputArray = inputParser.getInput();

        while(i < inputArray.length){
            for(int r = 0; r < maxr; r++) {
                for (int c = 0; c < maxc; c++) {
                    pizzaGrid[r][c] = inputArray[i];
                    i++;
                }
            }
        }
    }

    public void printGrid(){
        for(int i = 0; i < maxr; i++)
        {
            for(int j = 0; j < maxc; j++)
            {
                System.out.printf("%5s ", pizzaGrid[i][j]);
            }
            System.out.println();
        }

    }


    public int getNumOfM() {
        int numOfM = 0;
        for(String s: inputParser.getInput()){
            if(s.contains("M")){
                numOfM++;
            }
        }
        return numOfM;
    }

    public int getNumOfT(){
        int numOfT = 0;
        for(String s: inputParser.getInput()){
            if(s.contains("T")){
                numOfT++;
            }
        }
        return numOfT;

    }

    public void slice() {

       // String start = pizzaGrid[0][0];
        ArrayList<String> slice = new ArrayList<>();
        int slicecount = 0;


        for (int c = 0; c < maxc; c++) {
        //go through every row in 0th column
            String start = pizzaGrid[0][c];
           // System.out.println("Column " + j +  ": element: " + pizzaGrid[0][j]);
            for (int r = 1; r < maxr - 1; r++) {
                boolean cont = false;

                if (start.equals("T")) {
                    if (pizzaGrid[r][c].equals("M")) {
                        cont = true;
                    }
                }

                else if (start.equals("M")) {
                    if (pizzaGrid[r][c].equals("T")) {
                        cont = true;
                    }
                }

                if (cont) {
                    slice.add(start);
                    slice.add(pizzaGrid[r][c]);
                    System.out.println("Slice ending at: " + "column: " + c + " row: " +  r +  " " + start + " " + pizzaGrid[r][c]);
                    slicecount++;
                    start = pizzaGrid[r + 1][c];
                    slice = new ArrayList<>();
                }
                else {
                    start = pizzaGrid[r][c];
                }

            }


        }

        System.out.println("\nNumber of slices: " + slicecount);
        System.out.println("Total number of cells: " + maxr*maxc);
        System.out.println("Pizza cells utilized: " + slicecount*2);
    }



}
