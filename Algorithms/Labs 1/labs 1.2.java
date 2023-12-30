/*
For a given word entered from standard input, print it reversed. 
On input in the first line, the number of words that will be entered is given. 
In the following lines, the words are entered.
*/

import java.util.Scanner;

public class ReverseWord {

    public static void printReversed(String word) {
        StringBuilder reversed = new StringBuilder(word);
        reversed = reversed.reverse();
        System.out.println(reversed);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numWords = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numWords; i++) {
            String word = scanner.nextLine();
            printReversed(word);
        }
    }
}
