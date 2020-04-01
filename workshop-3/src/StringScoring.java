/*
* Student id: 910913
*
* Student Name: Edward Marozzi
*
* Aim: To parse a string and return a value based on sum of the values of the chars in the string
*
* Basic Structure: Create a scorer object which contains an array of letter objects,
*       each letter object contains its symbol ("A") and value (1). The scorer object parses the
*       string into an array of chars and then each char is converted to ASCII and then an array
*       index by subtracting 65. This is used to look up the letter in the array of letters and
*       call the Letter method getScore(). This scores are summed and returned.
 */

// Imports
import java.util.Scanner;

// Class to parse string and give a score to the string based on the scoring array (scoreArr)
class Scorer
{
    /* Constants */
    // Array holding a score value for each of the letters in alphabetical order.
    private final int[] scoreArr = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
    // Number of letters in our alphabet
    private final int alphabetLen = 26;
    // The ASCII value of the first letter of the alphabet "A"
    private final int asciiOffset = 65;
    // Array of Letter objects which holds the char and score associated.
    private Letter[] alphabetArr = new Letter[alphabetLen];
    // This number is used to generate all chars of the alphabet starting at the first one "A"
    private int asciiValue = asciiOffset;
    // Current score
    private int score = 0;

    // Constructor initialises array of Letter objects with associated scores and symbols
    public Scorer()
    {
        for(int i = 0; i< alphabetLen; i++)
        {
            alphabetArr[i] = new Letter(asciiValue++, scoreArr[i]);
        }
    }

    // Calculates the score of the entire string
    public int outputScore(String string)
    {
        // Converts string to upper case to avoid case problems
        string = string.toUpperCase();
        // Forms a array of chars
        char[] chars = string.toCharArray();

        // Iterates through each char in array.
        for(char character:chars)
        {
            // Converts ASCII to alphabet index (0 -> A, 1 -> B....)
            int characterIndex = (byte)character - asciiOffset;
            // Valid letter checking
            if(characterIndex >= 0 && characterIndex < alphabetLen)
                score = score + alphabetArr[characterIndex].getScore();
            else // If not valid give warning
                System.out.println("Warning: " + character + " is non-alphabetic and has been ignored.");

        }
        return score;
    }


}

// Letter class with score and symbol
class Letter
{
    private int score;
    private char symbol;

    // Constructor to assign variables
    public Letter(int asciiValue, int score)
    {
        this.symbol = (char)asciiValue;
        this.score = score;
    }
    // Get method
    public int getScore()
    {
        return score;
    }

}

// Driver program
public class StringScoring {
    public static void main(String[] args) {
        String testCase = new Scanner(System.in).nextLine();
        // Feel free to do whatever you want from here, just make sure your output is
        // printed to System.out
        // Create scorer object
        Scorer scorer = new Scorer();
        // Print out results
        System.out.println(scorer.outputScore(testCase));
    }
}
