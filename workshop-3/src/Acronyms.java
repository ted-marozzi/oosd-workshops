/*
 * Student id: 910913
 *
 * Student Name: Edward Marozzi
 *
 * Aim:
 *
 * Basic Structure:
 */

import java.util.Scanner;

class AcroMachine
{
    //private final String input;

    public String outputAcro(String input)
    {
        String[] words = input.split(" ");
        char firstLetter;
        StringBuilder output = new StringBuilder();
        for(String word:words)
        {
            firstLetter = Character.toUpperCase(word.charAt(0));
            output.append(firstLetter);
        }
        return output.toString();
    }

}

public class Acronyms {
    public static void main(String[] args) {
        String testCase = new Scanner(System.in).nextLine();
        // Feel free to do whatever you want from here, just make sure your output is
        // printed to System.out
        AcroMachine acroMachine = new AcroMachine();
        System.out.println(acroMachine.outputAcro(testCase));
    }
}
