import java.util.Scanner;

class Scorer
{
    private final int alphabetLen = 26;
    private Letter[] alphabetArr = new Letter[alphabetLen];
    private final int[] scoreArr = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
    private final int asciiOffset = 65;
    private int asciiValue = asciiOffset;
    private int score = 0;

    public Scorer()
    {
        for(int i = 0; i< alphabetLen; i++)
        {
            alphabetArr[i] = new Letter(asciiValue++, scoreArr[i]);
        }
    }

    public int outputScore(String string)
    {

        string = string.toUpperCase();
        char[] chars = string.toCharArray();

        for(char character:chars)
        {
            int characterIndex = (byte)character - asciiOffset;
            if(characterIndex >= 0 && characterIndex < alphabetLen)
                score = score + alphabetArr[characterIndex].getScore();
            else
            {
                System.out.println("Warning: One of the characters enter was non-alphabetic.");
            }
        }
        return score;
    }


}

class Letter
{
    private int score;
    private char symbol;


    public Letter(int asciiValue, int score)
    {
        this.symbol = (char)asciiValue;
        this.score = score;
    }

    public int getScore()
    {
        return score;
    }

}

public class StringScoring {
    public static void main(String[] args) {
        String testCase = new Scanner(System.in).nextLine();
        // Feel free to do whatever you want from here, just make sure your output is
        // printed to System.out

        Scorer scorer = new Scorer();


        System.out.println(scorer.outputScore(testCase));
    }
}
