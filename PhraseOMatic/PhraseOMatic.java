package PhraseOMatic;

public class PhraseOMatic {
    public static void main (String[] args) {

        // Create three arrays with random words to choose from
        String[] wordListOne = {"24/7", "Multi-tier", "30,000 foot"};
        String[] wordListTwo = {"empowered", "sticky", "oriented"}; 
        String[] wordListThree = {"process", "tipping", "solution"};

        // Find out how many words are in each list
        int oneLength = wordListOne.length; 
        int twoLength = wordListTwo.length; 
        int threeLength = wordListThree.length; 

        // Generate three random numbers
        int rand1 = (int) (Math.random() * oneLength);
        int rand2 = (int) (Math.random() * twoLength);
        int rand3 = (int) (Math.random() * threeLength);

        // Construct a phrase
        String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];

        // Print out the phrase
        System.out.println("what we need is a " + phrase);
    }
}
