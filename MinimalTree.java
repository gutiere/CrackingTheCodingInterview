/* 4.2 - Minimal Tree
 * Author: Edgardo (Elijah) Gutierrez Jr.
 * Date: 4/2/17
 * Description: Given a sorted (increasing order) array with unique integer
 * elements, write an algorithm to create a binary search tree with minimal
 * height.
 */

 /* Plan of attack:
  * - Create node class.
  * - Write a method to generate a binary tree given a different nodes.
  * - Use a binary search type strategy to add elements to the tree.
  *     - Add the middle of the array, then add the middles of each half, etc.
  */
import java.util.*;

public class MinimalTree {
    private static Node myHead;
    private static int[] myList = {1, 2, 6, 8, 12, 15, 17, 20};
    public static void main(String[] theArgs) {
        myHead = null;
        addMiddles(myList);
        printTree(myHead);

    }
    private static void addMiddles(int[] theNums) {
        int length = theNums.length;
        if (length == 0) return;
        System.out.print("Array: ");
        printArray(theNums);
        System.out.println();
        if (length == 1) myHead = addNode(myHead, theNums[0]);
        else {
            int middle = theNums.length/2;
            myHead = addNode(myHead, theNums[middle]);
            addMiddles(Arrays.copyOfRange(theNums, 0, middle));
            addMiddles(Arrays.copyOfRange(theNums, middle + 1, length));
        }
    }

    private static void printArray(int[] theNums) {
        for (int i = 0; i < theNums.length; i++) {
            System.out.print(theNums[i] + " ");
        }
    }


    private static Node addNode(Node theNode, int theValue) {
        if (theNode == null) return new Node(theValue);
        Node current = theNode;
        if (theValue > current.value) {
            current.right = addNode(current.right, theValue);
        } else if (theValue < current.value) {
            current.left = addNode(current.left, theValue);
        }
        return current;
    }

    private static void printTree(Node theNode) {
        ArrayList<Node> q = new ArrayList<Node>();
        Node current = null;
        q.add(theNode);
        while (!q.isEmpty()) {
            current = q.get(0);
            q.remove(0);
            if (current != null) {
                System.out.println(current.value);
                q.add(current.left);
                q.add(current.right);
            }
        }
    }

    private static class Node {
        int value;
        Node left = null;
        Node right = null;
        Node(int theValue) {
            this.value = theValue;
        }
    }
}
