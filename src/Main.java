// file is for testing purposes
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Quadratic q1 = new Quadratic();
        System.out.println("new Quadratic()");
        System.out.println("q1 standard form: " + q1 + "\n");

        Quadratic q2 = new Quadratic(3, -24, 30);
        System.out.println("new Quadratic(3, -24, 30)");
        System.out.println("q2 standard form: " + q2);
        System.out.println("q2 vertex form: " + q2.vertexForm());
        System.out.println("q2 factored form: " + q2.factoredForm() + "\n");

        double[] p1 = {-5, 225};
        double[] v1 = {4, -18};
        Quadratic q3 = new Quadratic(p1, v1);
        System.out.println("point on the parabola (p1): " + Arrays.toString(p1));
        System.out.println("vertex (v1): " + Arrays.toString(v1));
        System.out.println("new Quadratic(p1, v1)");
        System.out.println("q3 standard form: " + q3 + "\n");

        System.out.println("q1 and q2 are equal: " + q1.equals(q2));
        System.out.println("q2 and q3 are equal: " + q3.equals(q2) + "\n");

        q3.stretchHorizontally(2);
        q3.shiftVertically(28);


        System.out.println("q3 was stretched horizontally by a factor of 2, and then shifted up 28 units.\n");

        System.out.println("updated q3 standard form: " + q3);
        System.out.println("q3 vertex form: " + q3.vertexForm());
        System.out.println("q3 factored form: " + q3.factoredForm() + "\n");
        System.out.println("Table of values for q3: ");
        q3.table(12, -1, 0.5);
        System.out.println("Vertex of q3: " + Arrays.toString(q3.turningPoint()));
        System.out.println("y-intercept of q3: " + q3.yInt());
        System.out.println("roots of q3: " + Arrays.deepToString(q3.roots()));
        System.out.println("dy/dx for q3 at x = 5: " + q3.derivativeAtX(5));
        System.out.println("integral of q3 between x = 9 and x = 15: " + q3.integralBetween(9, 15) + "\n");

        double[][] POIs = Quadratic.pointsOfIntersection(q1, q3);
        System.out.println("Points of intersection between q1 and q3: " + Arrays.deepToString(POIs) + "\n");

        System.out.println(Arrays.toString(POIs[0]) + "is a point on q2: " + q2.pointExists(POIs[0]));
        double x1 = POIs[0][0];
        double y1 = q2.yAtX(POIs[0][0]);
        System.out.println("On q2 at x = " + x1 + ", y = " + y1 +"\n");

        Quadratic q4 = Quadratic.add(q2, q3);
        System.out.println("q4 is the sum of q2 and q3: " + q4);
        q4.flipOverY();
        q4.flipOverX();
        q4.stretchHorizontally(0.5);
        q4.shiftVertically(5);
        System.out.println("q4 was reflected over the y-axis, reflected over the x-axis, compressed horizontally by a factor of 1/2, then shifted vertically 5 units up.");
        System.out.println(q4.vertexForm() + "\n");

        double[] p2 = {0, 1};
        double r1 = 5;
        Quadratic q6 = new Quadratic(p2, r1);
        System.out.println("q6 passes through p2 = [0, 1] and has a single x-intercept r1 at x = 5");
        System.out.println("new Quadratic(p2, r1)");
        System.out.println("q6 in standard form: " + q6 + "\n");

        double r2 = 12;
        Quadratic q7 = new Quadratic(p2, r1, r2);
        System.out.println("q7 passes through p2 = [0, 1] and has an x-intercept r1 at x = 5 and r2 at x=12");
        System.out.println("new Quadratic(p2, r1, r2)");
        System.out.println("q6 in standard form: " + q7 + "\n");
    }
}
