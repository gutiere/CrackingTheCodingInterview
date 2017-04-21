/* 16.2 - Word Frequencies
 * Author: Edgardo (Elijah) Gutierrez Jr.
 * Date: 4/1/17
 * Description: Design a method to find the frequency of occurrences of any
 * given word in a book. What if we were running this algorithm multiple times?
 */

/* Plan of attack:
 * - Parse book as text.
 * - Go through ever word.
 * - If word is in map, increment frequency counter (value).
 * - Else, create the key for the word.
 */


import java.util.HashMap;
import java.lang.String;

public class WordFrequencies {
    
    public static void main(String[] theArgs) {
        System.out.println(calculateFrequencies("Hello there, there lol"));
    }

    private static HashMap<String, Integer> calculateFrequencies(String book) {
        HashMap<String, Integer> frequencies = new HashMap<String, Integer>();
        for (String word: book.split("\\W+")) {
            String lowerWord = word.toLowerCase();
            if (frequencies.get(lowerWord) == null) frequencies.put(word, 1);
            else frequencies.replace(lowerWord, frequencies.get(lowerWord) + 1);
        }
        return frequencies;
    }
}
