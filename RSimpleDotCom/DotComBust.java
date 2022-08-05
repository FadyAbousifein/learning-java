package RSimpleDotCom;

import java.util.ArrayList;

public class DotComBust {
    // instance variables
    private GameHelper helper = new GameHelper(); 
    private ArrayList<DotCom> dotComList = new ArrayList<DotCom>(); 
    private int numOfGuesses = 0; 

    private void setUpGame() {
        // first make some dot comes and give them names
        DotCom one = new DotCom(); 
        one.setName("Pets.com");

        DotCom two = new DotCom(); 
        two.setName("eToys.com");

        DotCom three = new DotCom(); 
        three.setName("Go2.com");

        // put the DotComs in the ArrayList
        dotComList.add(one); 
        dotComList.add(two); 
        dotComList.add(three); 
        
        // brief instructions 
        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("Pets.com, eToys.com, and Go2.com");
        System.out.println("Try to sink them all in the fewest number of guesses");

        for(DotCom dotComToSet : dotComList) { 
            ArrayList<String> newLocation = helper.placeDotCom(3); 
            dotComToSet.SetLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        // as long as the list is not empty
        while(!dotComList.isEmpty()) { 
            String userGuess = helper.getUserInput("Enter a guess"); 
            checkUserGuess(userGuess); 
        }
        finishGame(); 
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++; 
        String result = "miss"; 
        
        for(int x = 0; x < dotComList.size(); x++) {
            result = dotComList.get(x).checkYourself(userGuess); 

            if(result.equals("hit")) {
                // if hit no need to test others
                break; 
            }
            if(result.equals("kill")) {
                // if dead take them out of the list 
                dotComList.remove(x); 
                break; 
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("All DotComs are dead! Your stock is now worthless.");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
        } else {
            System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options");
        }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust(); 
        game.setUpGame(); 
        game.startPlaying(); 
    }
}