/* 1.9 - StringRotation
 * Author: Edgardo (Elijah) Gutierrez Jr.
 * Date: 4/2/17
 * Description: Assume you have a method isSubstring which checks if
 * one word is a substring of another. Given two strings, s1 and s2, write code
 * to check if s2 is a rotation of s1 using only one call to isSubstring
 * (e.g., "waterbottle" is a rotation of "erbottlewat").
 */

 /* Plan of attack:
  * - Write the isSubstring method.
  * - Check to see if the s1 is a substring of s2 + s2.
  */

public class StringRotation {
    public static void main(String[] theArgs) {
        String s1 = "Hello", s2 = "elloH";
        System.out.println(isSubstring(s2 + s2, s1));
    }

    private static Boolean isSubstring(String word, String substring) {
        int subPointer = 0;
        for (int wordPointer = 0; wordPointer < word.length(); wordPointer++) {
            if (word.charAt(wordPointer) == substring.charAt(subPointer)) {
                subPointer++;
                if (subPointer == substring.length()) return true;
            } else subPointer = 0;
        }
        return false;
    }
}
