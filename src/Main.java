import java.io.FileNotFoundException;

public class Main {


    public static void main (String[] args)  throws FileNotFoundException{
        Pizza pizza = new Pizza();
        pizza.populate();
        pizza.printGrid();
        System.out.println("T: " + pizza.getNumOfT());
        System.out.println("M: " + pizza.getNumOfM());
        pizza.slice();


    }

}
