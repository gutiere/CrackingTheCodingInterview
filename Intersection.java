/* 16.3 - Intersection
 * Author: Edgardo (Elijah) Gutierrez Jr.
 * Date: 4/1/17
 * Description: Given two straight line segments (represented as a start point
 * and an end point)' compute the point of intersection, if any.
 */

 // NOTE: Does not account for asymptotes.

/* Plan of attack:
 * - Calculate slope for lines A & B.
 * - Calculate Y intercepts for A and B.
 * - Derive equation of both lines using the line formula and set them equal to
 *   eachother to find X.
 * - Confirm the X value is within the X bounds of both lines.
 */

import java.text.DecimalFormat;

public class Intersection {
    public static void main(String[] theArgs) {
        calcIntersection(true);
    }

    // Calculate intersection of 2 lines.
    private static void calcIntersection(Boolean test) {
        // // Line A
        // double x1A = 1.0, y1A = 1.0, x2A = 3.0, y2A = 3.0;
        // // Line B
        // double x1B = 1.0, y1B = 5.0, x2B = 3.0, y2B = 1.0;



        double x1A = 0.0, y1A = 0.0, x2A = 0.0, y2A = 10.0;
        double x1B = -1.0, y1B = 5.0, x2B = 3.0, y2B = 1.0;




        // Calculate slope for lines A & B.
        double slopeA = calcSlope(x1A, y1A, x2A, y2A);
        double slopeB = calcSlope(x1B, y1B, x2B, y2B);

        // TEST: Slopes.
        if (test) {
            System.out.println("Testing slopes A & B:");
            System.out.format("SlopeA: %.2f\n", slopeA);
            System.out.format("SlopeB: %.2f\n\n", slopeB);
        }

        // Calculate Y intercepts for A and B.
        double yInterA = calcYIntercept(slopeA, x1A, y1A);
        double yInterB = calcYIntercept(slopeB, x1B, y1B);

        // TEST: Y intercepts.
        if (test) {
            System.out.println("Testing Y intercepts of A & B:");
            System.out.format("Y intercept of line A: %.2f\n", yInterA);
            System.out.format("Y intercept of line B: %.2f\n\n", yInterB);
        }

        // Derive equation of both lines using the line formula and set them equal
        // to eachother to find X.
        double interX = calcIntersectionX(slopeA, slopeB, yInterA, yInterB);

        // TEST: X value of calculated intersection.
        if (test) {
            System.out.println("Testing X value of intersection.");
            System.out.format("X intersectin of lines A & B: %.2f\n\n", interX);
        }

        // Confirm the X value is within the X bounds of both lines.
        if (xInRange(x1A, x2A, interX) && xInRange(x1B, x2B, interX)) {
            double interY = calcIntersectionY(slopeA, interX, yInterA);
            System.out.format("Lines intersect at (%.2f,%.2f)", interX, interY);
        } else {
            System.out.println("Lines do not intersect.");
        }
    }

    // Calculate the slope of a line using y2-y1/x2-x1.
    private static double calcSlope(double x1,
                                    double y1,
                                    double x2,
                                    double y2) {
        return (y2-y1)/(x2-x1);
    }

    // Calculate the intersection's X value.
    private static double calcIntersectionX(double slopeA,
                                            double slopeB,
                                            double yInterA,
                                            double yInterB) {
        double coefficient = slopeA - slopeB;
        double constant = yInterB - yInterA;
        return constant / coefficient;
    }

    // Determine if the intersection is within the line segment.
    private static Boolean xInRange(double xStart,
                                    double xFinish,
                                    double xInter) {
        Boolean maybe = false;
        if (xStart < xFinish) maybe = xStart < xInter && xInter < xFinish;
        else if (xStart == xFinish) maybe = xStart == xInter;
        else if (xStart > xFinish) maybe = xStart > xInter && xInter > xFinish;
        return maybe;
    }

    // Calculate Y in Y = mX+b.
    private static double calcIntersectionY(double m,
                                            double x,
                                            double b) {
        return m * x + b;
    }

    // Find the Y intercept based on a slope and point.
    private static double calcYIntercept(double slope, double x, double y) {
        // NOTE: this process is under the assumption that x and y are whole #s.
        double pointX = x;
        double pointY = y;
        if (x < 0) {
            while (pointX != 0) {
                pointX++;
                pointY += slope;
            }
        } else if (x > 0) {
            while (pointX != 0) {
                pointX--;
                pointY -= slope;
            }
        }
        return pointY;
    }
}
