import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class InputParser {
    private Scanner scanner;
    private File input;
    private String[] inputArray;
    private String[] parameters;


    public InputParser(File input) throws FileNotFoundException {
        this.input = input;
        scanner = new Scanner(input);
        storeInput();
    }

    private void storeInput(){
        //first line specifies rows, columns, min num of each ingredient per slice, max cells per slice
        //other lines show the actual pizza
        String line = scanner.nextLine();
        String[] commands = line.split(" ");
        parameters = commands;


        ArrayList<String> resultArrayList = new ArrayList<>();

        while(scanner.hasNext()){
            line = scanner.nextLine();
            char[] chars = line.toCharArray();
            String[] strings = new String[chars.length];

            for (int i = 0; i < chars.length; i++)
            {
               strings[i] = String.valueOf(chars[i]);

            }
            Collections.addAll(resultArrayList, strings);
        }

        String[] resultArray = new String[resultArrayList.size()];
        resultArray = resultArrayList.toArray(resultArray);
        inputArray = resultArray;

    }

    public int getRows(){
        return Integer.parseInt(parameters[0]) ;
    }

    public int getColumns() {
        return Integer.parseInt(parameters[1]);
    }

    public int getMinIngredients(){
        return Integer.parseInt(parameters[2]);
    }

    public int getMaxIngredients(){
        return Integer.parseInt(parameters[3]);
    }

    public String[] getInput(){
        return inputArray;
    }

}
