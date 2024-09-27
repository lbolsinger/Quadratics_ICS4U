public class Quadratic {

    // FIELDS

    private double a;
    private double b;
    private double c;


    // CONSTRUCTORS

    /**
     * Constructs the default Quadratic (x²).
     */
    public Quadratic(){
        this.a = 1;
        this.b = 0;
        this.c = 0;
    }

    /**
     * Constructs a Quadratic with parameters as the coefficients.
     * @param a - coefficient of x²
     * @param b - coefficient of x
     * @param c - constant
     */
    public Quadratic(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Copies the values of another Quadratic to construct a new Quadratic.
     * @param q - other Quadratic
     */
    public Quadratic(Quadratic q){
        this.a = q.a;
        this.b = q.b;
        this.c = q.c;
    }

    /**
     * Constructs a Quadratic given a point and the vertex of the parabola.
     * @param p - a point that the parabola passes through
     * @param vertex - the vertex (turning point) of the parabola
     */
    public Quadratic(double[] p, double[] vertex){
        this.a = (p[1]-vertex[1])/(Math.pow(p[0]-vertex[0], 2));
        this.b = -2*this.a*vertex[0];
        this.c = this.a*vertex[0]*vertex[0] + vertex[1];
    }

    /**
     * Constructs a Quadratic with a single root and a point that the parabola passes through.
     * @param p - a point that lies on the parabola
     * @param r - the single root (x-intercept) of the parabola
     */
    public Quadratic(double[] p, double r){
        this.a = p[1] / ((p[0]-r)*(p[0]-r));
        this.b = this.a * (-2) * r;
        this.c = this.a * r * r;
    }

    /**
     * Constructs a Quadratic that has 2 real roots, given the roots and a point.
     * @param p - a point that lies on the parabola
     * @param r1 - one x-intercept value
     * @param r2 - the other x-intercept value
     */
    public Quadratic(double[] p, double r1, double r2){
        this.a = p[1] / ((p[0]-r1)*(p[0]-r2));
        this.b = this.a*(-r1-r2);
        this.c = this.a * r1 * r2;
    }


    // ACCESSORS

    /**
     * Accesses the a (the coefficient of x²).
     * @return a
     */
    public double getA(){
        return this.a;
    }

    /**
     * Accesses the b (the coefficient of x).
     * @return b
     */
    public double getB(){
        return this.b;
    }

    /**
     * Accesses the c (the constant).
     * @return c
     */
    public double getC(){
        return this.c;
    }


    // MUTATORS

    /**
     * Changes the value of a.
     * @param a - the coefficient of x²
     */
    public void setA(double a){
        this.a = a;
    }

    /**
     * Changes the value of b.
     * @param b - the coefficient of x
     */
    public void setB(double b){
        this.b = b;
    }

    /**
     * Changes the value of c.
     * @param c - the constant
     */
    public void setC(double c){
        this.c = c;
    }

    /**
     * Changes the value of all fields of the Quadratic.
     * @param a - the coefficient of x²
     * @param b - the coefficient of x
     * @param c - the constant
     */
    public void setAll(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }


    // INSTANCE METHODS

    /**
     * Converts the Quadratic to a String in standard form.
     * @return - Equation of the parabola in standard form
     */
    @Override
    public String toString(){
        String result = "y = ";
        if (a != 0){
            result += a + "x²" ;
        }
        if (b != 0){
            if (b>0){
                result += " + " + b + "x";
            }
            else{
                result += " - " + (-1)*b + "x";
            }
        }
        if (c != 0){
            if (c > 0){
                result += " + " + c;
            }
            else{
                result += " - " + (-1)*c;
            }
        }
        return result;
    }

    /**
     * Completes the square, then converts the Quadratic to a String in vertex form.
     * @return - Equation of the parabola in vertex form
     */
    public String vertexForm(){
        String result = "y = " + a;
        double h = this.turningPoint()[0];
        double k = this.turningPoint()[1];
        if(h > 0){
            result += "(x - " + h + ")² ";
        }
        else if (h < 0){
            result += "(x + " + -h + ")² ";
        }
        else {
            result += "x²";
        }
        if (k > 0){
            result += "+ " + k;
        }
        else if (k < 0){
            result += "- " + -k;
        }
        return result;
    }

    /**
     * Uses the quadratic formula to find the roots, then converts the Quadratic to a String in factored form, where it includes imaginary numbers as necessary.
     * @return - Equation of the parabola in factored form
     */
    public String factoredForm(){
        int nRoots = this.numRoots();
        if (nRoots == 1){
            double r = this.roots()[0][0];
            if (r > 0){
                return "y = " + a + "(x - " + r + ")²";
            }
            else{
                return "y = " + a + "(x + " + r + ")²";
            }
        }
        else if (nRoots == 2){
            double r1 = this.roots()[0][0];
            double r2 = this.roots()[1][0];
            String result = "y = " + a + "(x ";
            if (r1 > 0){
                result += "- " + r1 + ")(x ";
            }
            else {
                result += "+ " + (-r1) + ")(x ";
            }
            if (r2 > 0){
                result += "- " + r2 + ")";
            }
            else {
                result += "+ " + (-r2) + ") ";
            }
            return result;
        }
        else {
            double r1 = (- b + Math.pow(-(b*b - 4*a*c), 0.5)) / (2*a);
            double r2 = (- b - Math.pow(-(b*b - 4*a*c), 0.5)) / (2*a);
            String result = "y = " + a + "(x ";
            if (r1 > 0){
                result += "- " + r1 + " i)(x ";
            }
            else {
                result += "+ " + (-r1) + " i)(x ";
            }
            if (r2 > 0){
                result += "- " + r2 + " i)";
            }
            else {
                result += "+ " + (-r2) + " i) ";
            }
            return result;
        }
    }

    /**
     * Prints a table of values that lie on the Quadratic.
     * @param n - number of ordered pairs printed
     * @param x - starting x value for the parabola
     * @param incr - increment of x values printed
     */
    public void table(int n, double x, double incr){
        System.out.printf("\t%-8s | \t\ty %n", "x");
        System.out.println("--------------------------");
        for (int i = 0; i < n; i++){
            System.out.printf("\t%-8s | \t %.2f %n", x+incr*i, yAtX(x+incr*i));
        }
        System.out.println("");
    }

    /**
     * Calculates the y-value for a corresponding x-value.
     * @param x - x coordinate
     * @return corresponding y coordinate
     */
    public double yAtX(double x){
        return a*x*x + b*x + c;
    }

    /**
     * Calculates the instantaneous rate of change as a given x-value using power rule.
     * @param x - x-value
     * @return the derivative at x
     */
    public double derivativeAtX(double x){
        return 2*a*x + b;
    }

    /**
     * Calculates the area bound between the parabola and the x-axis, and the selected x-value bounds on the side.
     * @param x1 - lower bound
     * @param x2 - upper bound
     * @return the area underneath the curve
     */
    public double integralBetween(double x1, double x2){
        return a*(x2*x2*x2 - x1*x1*x1)/3 + b*(x2*x2-x1*x1)/2 + c*(x2-x1);
    }

    /**
     * Determines the vertex of the Quadratic by completing the square.
     * @return the coordinate of the vertex
     */
    public double[] turningPoint(){
        double[] point = new double[2];
        point[0] = -b/(2*a);
        point[1] = -b*b/(4*a) + c;
        return point;
    }

    /**
     * Determines the x-intercepts of the Quadratic using the quadratic formula.
     * @return an array of all real roots
     */
    public double[][] roots(){
        if (this.numRoots() == 1) {
            double[][] xInts = new double[1][2];
            xInts[0][0] = -b / (2 * a);
            if (b==0){
                xInts[0][0] = 0;
            }
            xInts[0][1] = 0;
            return xInts;
        }
        else if (this.numRoots()==2) {
            double[][] xInts = new double[2][2];
            xInts[0][0] = (- b + Math.pow(b*b - 4*a*c, 0.5)) / (2*a);
            xInts[0][1] = 0;
            xInts[1][0] = (- b - Math.pow(b*b - 4*a*c, 0.5)) / (2*a);
            xInts[1][1] = 0;
            return xInts;
        }
        else{
            double[][] xInts = new double[0][0];
            return xInts;
        }
    }

    /**
     * Determines the number of real roots of the Quadratic by testing the discriminant.
     * @return the number of roots
     */
    public int numRoots(){
        double discr = b*b - 4*a*c;
        if (discr>0){
            return 2;
        }
        else if (discr == 0){
            return 1;
        }
        return 0;
    }

    public double yInt(){
        return c;
    }

    /**
     * Accesses the set of defined x-values of the Quadratic.
     * @return the domain
     */
    public String domain(){
        return "{x∈R}";
    }

    /**
     * Accesses the set of possible y-values of the Quadratic.
     * @return the range
     */
    public String range(){
        if (a<0){
            return "{y∈R | y ≤" + this.turningPoint()[1] + "}";
        }
        else{
            return "{y∈R | y ≥ " + this.turningPoint()[1] + "}";
        }
    }

    /**
     * Determines if two Quadratics have the same coefficients and constants.
     * @param q - the other Quadratic
     * @return true if they are the same
     */
    public boolean equals(Quadratic q){
        return this.a == q.a && this.b == q.b && this.c == q.c;
    }

    /**
     * Determines if a point lies on the curve of the Quadratic.
     * @param p - point
     * @return true if the y-value satisfies the Quadratic with the given x-value
     */
    public boolean pointExists(double[] p){
        return p[1] == this.yAtX(p[0]);
    }

    /**
     * Transforms the Quadratic by stretching it vertically.
     * @param factor - factor of vertical stretch/compression
     */
    public void stretchVertically(double factor) {
        double h = this.turningPoint()[0];
        double k = this.turningPoint()[1];
        this.a *= factor;
        this.b *= factor;
        this.c = a*h*h + k;
    }

    /**
     * Transforms the Quadratic by shifting it vertically.
     * @param shift - number of units shifted
     */
    public void shiftVertically(double shift){
        this.c += shift;
    }

    /**
     * Transforms the Quadratic by stretching it horizontally.
     * @param factor - factor of horizontal stretch/compression
     */
    public void stretchHorizontally(double factor) {
        double h = this.turningPoint()[0];
        double k = this.turningPoint()[1];
        this.a *= 1/(factor*factor);
        this.b *= 1/(factor*factor);
        this.c = this.a*h*h + k;
    }

    /**
     * Transforms the Quadratic by shifting it horizontally, where left is negative and right is positive.
     * @param shift - number of units shifted
     */
    public void shiftHorizontally(double shift){
        double h = this.turningPoint()[0]+shift;
        double k = this.turningPoint()[1];
        this.b = -2*a*h;
        this.c = k + h*h*a;
    }

    /**
     * Reflects the Quadratic over the x-axis (vertical reflection).
     */
    public void flipOverX(){
        double h = this.turningPoint()[0];
        double k = -this.turningPoint()[1];
        this.a *= -1;
        this.b = -2*this.a*h;
        this.c = this.a*h*h + k;
    }

    /**
     * Reflects the Quadratic over the y-axis (horizontal reflection).
     */
    public void flipOverY(){
        double h = -this.turningPoint()[0];
        double k = this.turningPoint()[1];
        this.b = -2*this.a*h;
        this.c = this.a*h*h + k;
    }


    // STATIC METHODS

    /**
     * Determines all real points of intersection between two Quadratics.
     * @param q1 - first Quadratic
     * @param q2 - second Quadratic
     * @return array of all real points of intersection
     */
    public static double[][] pointsOfIntersection(Quadratic q1, Quadratic q2){
        double a = q1.getA() - q2.getA();
        double b = q1.getB() - q2.getB();
        double c = q1.getC() - q2.getC();
        Quadratic q3 = new Quadratic(a, b, c);
        if (q3.numRoots() == 2){
            double[][] temp = q3.roots();
            temp[0][1] = q1.yAtX(temp[0][0]);
            System.out.println(q3);
            temp[1][1] = q1.yAtX(temp[1][0]);
            return temp;
        }
        else if (q3.numRoots() == 1){
            double[][] temp = q3.roots();
            temp[0][1] = q1.yAtX(temp[0][0]);
            return temp;
        }
        return q3.roots();
    }

    /**
     * Creates a new Quadratic that is the sum of two Quadratics.
     * @param q1 - first Quadratic
     * @param q2 - second Quadratic
     * @return a new Quadratic
     */
    public static Quadratic add(Quadratic q1, Quadratic q2){
        return new Quadratic(q1.getA()+ q2.getA(), q1.getB()+ q2.getB(), q1.getC()+ q2.getC());
    }

    /**
     * Creates a new Quadratic that is the difference of two Quadratics.
     * @param q1 - first Quadratic
     * @param q2 - second Quadratic
     * @return a new Quadratic
     */
    public static Quadratic subtract(Quadratic q1, Quadratic q2){
        return new Quadratic(q1.getA()- q2.getA(), q1.getB()- q2.getB(), q1.getC()- q2.getC());
    }
}
