import java.io.File;
import java.io.FileNotFoundException;

public class Pizza {

    private String[][] pizzaGrid;
    private int maxr;
    private int maxc;
    private InputParser inputParser;

    public Pizza() throws FileNotFoundException{

        inputParser = new InputParser(new File("small.in"));
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



}
