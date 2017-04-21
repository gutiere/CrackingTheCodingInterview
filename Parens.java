/*
 * Parens
 * Author: (Elijah) Edgardo Gutierrez Jr.
 * Date: 4/21/17
 */

 import java.util.ArrayList;
 import java.util.HashSet;

 /*
  * This class finds every organization of N sets of parens.
  */
 public class Parens {

    /*
     * This method is the main driver of the program, printing the results of
     * the findParents recursive method.
     */
    public static void main(String[] theArgs) {
        for (HashSet<String> set : findParens(new ArrayList<HashSet<String>>(), 3)) {
            for (String element : set) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    /*
     * This method recursively builds memory to answer smaller cases.
     * @param memo is the memory of the recursion, making this dynamic programming.
     * @param N is the quantity of paren sets.
     * @return the new memory after computation.
     */
    private static ArrayList<HashSet<String>> findParens(ArrayList<HashSet<String>> memo, int N) {
        // Edge case, invalid quantity of parens.
        if (N < 0) return null;
        ArrayList<HashSet<String>> newMemo;
        // Base case, 0 is an empty string.
        if (N == 0) {
            newMemo = new ArrayList<HashSet<String>>();
            newMemo.add(new HashSet());
            newMemo.get(0).add("");
        // Ever implementation that can be broken down.
        } else {
            newMemo = findParens(memo, N - 1);
            newMemo.add(new HashSet());
            for (String element : newMemo.get(N - 1)) {
                newMemo.get(N).add("(" + element + ")");
                newMemo.get(N).add("()" + element);
                newMemo.get(N).add(element + "()");

            }
        }
        return newMemo;
    }
 }
