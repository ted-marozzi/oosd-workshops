/*
 * Student id: 910913
 *
 * Student Name: Edward Marozzi
 *
 * Aim: To reduce strings down to acronyms.
 *
 * Basic Structure: Creates an acronym machine, which contains a method that splits the word
 *      by its spaces and takes the first char of each word, then capitalises it and uses a
 *      string builder object to build the output acronym string.
 */
// Imports
import java.util.Scanner;
// Acronym machine, used to manipulate acronyms.
class AcroMachine
{
    // Most basic method of reducing string to acro
    public String outputAcro(String input)
    {
        char firstLetter;
        // Splits word by spaces
        String[] words = input.split(" ");
        // Creates a string builder object
        StringBuilder output = new StringBuilder();
        // Iterate through each word in word array
        for(String word:words)
        {
            // Gets the first letter of each word and capitalises it.
            firstLetter = Character.toUpperCase(word.charAt(0));
            // Appends the letter onto the existing acronym
            output.append(firstLetter);
        }
        // returns result
        return output.toString();
    }

}
// Driver program
public class Acronyms {
    public static void main(String[] args) {
        String testCase = new Scanner(System.in).nextLine();
        // Feel free to do whatever you want from here, just make sure your output is
        // printed to System.out

        // Creates the acronym machine
        AcroMachine acroMachine = new AcroMachine();
        // Uses it to process the test case and print resultant Acronym.
        System.out.println(acroMachine.outputAcro(testCase));
    }
}
