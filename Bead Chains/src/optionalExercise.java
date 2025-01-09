import java.util.*;

public class optionalExercise {
    static Scanner reader = new Scanner(System.in);

    public optionalExercise() {
    }

    /*
    Exercise 1 - every third character is replaced by '$'
     */
    public String exercise1(String inputString) {
        String outputString = "";
        for (int i = 0; i < inputString.length(); i++) {
            if ((i + 1) % 3 == 0)
                outputString = outputString + '$';
            else
                outputString = outputString + inputString.charAt(i);
        }
        return outputString;
    }

    /*
    Exercise 2 - after every occurrence of "aba" insert "$$".
    I assume that after "ababa" we insert twice, after every occurrence. Easy to change.
     */
    public String exercise2(String inputString) {
        String outputString = "";
        String lastTriplet = "xyz";
        char lastChar;

        for (int i = 0; i < inputString.length(); i++) {
            lastChar = inputString.charAt(i);
            outputString = outputString + lastChar;
            lastTriplet = lastTriplet.substring(1) + lastChar;
            if (lastTriplet.equals("aba"))
                outputString = outputString + "$$";
        }
        return outputString;
    }

    /*
    Exercise 3 - there must be a nicer way to do that!
     */
    public String exercise3(String inputString) {
        String outputString = "";
        int tail = 0;
        char lastChar;

        for (int i = 0; i < inputString.length(); i++) {
            lastChar = inputString.charAt(i);
            if (tail == 0)
                if (lastChar == 'a')
                    tail = 1;
                else
                    outputString += lastChar;
            else if (tail == 1)
                if (lastChar == 'b')
                    tail = 2;
                else if (lastChar == 'a') {
                    outputString += lastChar;
                    tail = 1;
                } else {
                    outputString += "a" + lastChar;
                    tail = 0;
                }
            else // tail == 2
                if (lastChar == 'a')
                    tail = 0;
                else {
                    outputString += "ab" + lastChar;
                    tail = 0;
                }
        }
        if (tail == 1)
            outputString += "a";
        else if (tail == 2)
            outputString += "ab";

        return outputString;
    }

    /*
    Exercise 4
     */
    public void exercise4(String inputString) {
        int[] firstLetter = new int[26];    // frequency of all letters as first in word
        int BASE = (int) 'a';   // ASCII value of 'a', for mapping all letters into 0-25
        int pointer = 0;    // into the input array, for scanning it
        int letterValue;    // temp variable. Could do without it.
        int nextSpace = 0;  // location of the next space
        while (nextSpace != -1) {
            letterValue = (int) inputString.charAt(pointer) - BASE;
            firstLetter[letterValue]++;
            nextSpace = inputString.substring(pointer).indexOf(' ');
            pointer = pointer + nextSpace + 1;
        }
        // Finding the max value. Could use instead Arrays.stream(firstLetter).max()
        int max = 0;
        for (int i = 0; i < 26; i++)
            if (firstLetter[i] > max)
                max = firstLetter[i];
        System.out.printf("Input sentence is: %s\n", inputString);
        System.out.printf("Letters with highest frequncy as first letter: ");
        // Finding the letters with the max value. Note:can be done in one pass but ugly.
        for (int i = 0; i < 26; i++)
            if (firstLetter[i] == max)
                System.out.printf("%c ", (char) (BASE + i));
    }

    // It boiled down to just String equals()
    public boolean testResponse(String test, String response) {
        //System.out.printf("Prompt:   %s\nResponse: %s\n", test, response);
        boolean answer = test.equals(response);
        //System.out.printf("The answer is: %b",answer);
        return answer;
    }
}