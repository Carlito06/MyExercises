import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;


public class StateCapitals {

    public static void main(String[] args) throws Exception {
        String delimiter = "::";

        HashMap <String,String> states = new HashMap<String,String>();

        
        Scanner sc = new Scanner(new BufferedReader(new FileReader("stateCapitals.txt")));

        while (sc.hasNextLine())
        {
            String [] statecapital = sc.nextLine().split(delimiter);

            states.put(statecapital[0],statecapital[1]);


        }
        sc.close();

        sc = new Scanner(System.in);

        

        int randomState = (int) (Math.random()*50);
        System.out.println("What is the capital of "+ states.keySet().toArray()[randomState]);
        
        String capital = sc.nextLine();

        if (states.containsValue(capital) && states.get(states.keySet().toArray()[randomState]).equals(capital))
        {
            System.out.println("You are correct!");
        }

        else
        {
            System.out.println("You are wrong!");
        }
        
        sc.close();
        
        
    }
}
