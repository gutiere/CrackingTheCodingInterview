/*
 * Towers of Hanoi
 * Author: (Elijah) Edgardo Gutierrez Jr.
 * Date: 4/20/17
 */

import java.util.Stack;
import java.util.ArrayList;

/*
 * This class solved the Towers of Hanoi problem.
 */
public class TowersOfHanoi {

    /*
     * First argument should be an integer.
     */
    public static void main(String[] theArgs) {
        int N; // Number of elements.
        // Number of elements not specified.
        if (theArgs.length == 0) N = 3; // Default number of elements.
        else N = Integer.parseInt(theArgs[0]); // Number of elements given.
        Towers towers = new Towers(N); // Object of all 3 towers.
        System.out.println(towers); // Print towers before any movement.
        towers = moveTower(towers, N, 0, 2); // Move tower from 0 -> 2

        /* Uncomment the below print if you comment the step by stop print
           located in the move method of the Towers class. */
        // System.out.println(towers); // Print towers after movement.
    }

    /*
     * This method recursively moves towers.
     * @param towers is the towers object which will be acted upon.
     * @param N is the size of the tower that needs to be moved.
     * @param source is the number of the stack the tower exists in.
     * @param destination is the number of the stack the tower should go to.
     * @return the modified object of towers.
     */
    private static Towers moveTower(Towers towers, int N, int source, int destination) {
        Towers newTowers = towers;
        if (N == 1) {
            newTowers.move(source, destination);
        } else {
            int alternate = otherTower(source, destination);
            newTowers = moveTower(newTowers, N - 1, source, alternate); // Moving smaller tower
            newTowers.move(source, destination); // Moving largest value.
            newTowers = moveTower(newTowers, N - 1, alternate, destination); // Moving smaller tower
        }
        return newTowers;
    }

    /*
     * This method find the number of the tower that is not currently used.
     * @return the number of the tower that is not the source or destination tower.
     */
    private static int otherTower(int towerA, int towerB) {
        return 3 - (towerA + towerB);
    }

    /*
     * This class represents an object of 3 towers.
     */
    private static class Towers {
        // List of stacks that represent towers.
        private ArrayList<Stack<Integer>> towers;

        // Total of elements
        private int size;

        /*
         * Builds the object of towers, instantiating the towers and filling the first tower.
         */
        Towers(int towerSize) {
            size = towerSize;
            towers = new ArrayList<Stack<Integer>>();
            addTowers();
            fillTower(towerSize);
        }

        /*
         * This method instantiated 3 stacks that represent the 3 Towers of Hanoi.
         */
        private void addTowers() {
            for (int i = 0; i < 3; i++) towers.add(new Stack<Integer>());
        }

        /*
         * This method fills the tower 1 with N elements.
         */
        private void fillTower(int N) {
            for (int i = N; i >= 1; i--) {
                towers.get(0).push(i);
            }
        }

        /*
         * This method moves the top element from one tower to another.
         */
        protected void move(int source, int destination) {
            towers.get(destination).push(towers.get(source).pop());
            System.out.println(toString()); // Shows the steps
        }

        /*
         * This method overrides the stadard toString method.
         * @return the string representation of the towers.
         */
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Stack<Integer> tempTower = new Stack<Integer>();
            Integer tempInt = -1;
            for (int i = 0; i < 3; i++) {
                sb.append(String.format("Tower %d: ", i + 1));
                while (!towers.get(i).isEmpty()) {
                    tempInt = towers.get(i).pop();
                    sb.append(tempInt);
                    tempTower.push(tempInt);
                }
                while (!tempTower.isEmpty()) {
                    towers.get(i).push(tempTower.pop());
                }
                sb.append('\n');
            }
            return sb.toString();
        }
    }

}
