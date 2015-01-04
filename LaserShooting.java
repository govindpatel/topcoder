
public class LaserShooting {

    public double numberOfHits(int[] x, int[] y1, int[] y2) {
        double res = 0;
        //exp(x+y) = exp(x) + exp(y)
        //exp(x)  = sum(xi * pi);
        for (int i = 0; i < x.length; i++) {
            double pb = 0;
            double ang1 = Math.atan2(y1[i], x[i]);
            double ang2 = Math.atan2(y2[i], x[i]);
            double diff = Math.abs(ang1 - ang2);
            pb = diff / Math.PI;
            res += 1.0 * pb;
        }
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            LaserShootingHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                LaserShootingHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class LaserShootingHarness {

    public static void run_test(int casenum) {
        if (casenum != -1) {
            if (runTestCase(casenum) == -1) {
                System.err.println("Illegal input! Test case " + casenum + " does not exist.");
            }
            return;
        }

        int correct = 0, total = 0;
        for (int i = 0;; ++i) {
            int x = runTestCase(i);
            if (x == -1) {
                if (i >= 100) {
                    break;
                }
                continue;
            }
            correct += x;
            ++total;
        }

        if (total == 0) {
            System.err.println("No test cases run.");
        } else if (correct < total) {
            System.err.println("Some cases FAILED (passed " + correct + " of " + total + ").");
        } else {
            System.err.println("All " + total + " tests passed!");
        }
    }
    static final double MAX_DOUBLE_ERROR = 1E-9;

    static boolean compareOutput(double expected, double result) {
        if (Double.isNaN(expected)) {
            return Double.isNaN(result);
        } else if (Double.isInfinite(expected)) {
            if (expected > 0) {
                return result > 0 && Double.isInfinite(result);
            } else {
                return result < 0 && Double.isInfinite(result);
            }
        } else if (Double.isNaN(result) || Double.isInfinite(result)) {
            return false;
        } else if (Math.abs(result - expected) < MAX_DOUBLE_ERROR) {
            return true;
        } else {
            double min = Math.min(expected * (1.0 - MAX_DOUBLE_ERROR), expected * (1.0 + MAX_DOUBLE_ERROR));
            double max = Math.max(expected * (1.0 - MAX_DOUBLE_ERROR), expected * (1.0 + MAX_DOUBLE_ERROR));
            return result > min && result < max;
        }
    }

    static double relativeError(double expected, double result) {
        if (Double.isNaN(expected) || Double.isInfinite(expected) || Double.isNaN(result) || Double.isInfinite(result) || expected == 0) {
            return 0;
        }
        return Math.abs(result - expected) / Math.abs(expected);
    }

    static String formatResult(double res) {
        return String.format("%.10g", res);
    }

    static int verifyCase(int casenum, double expected, double received) {
        System.err.print("Example " + casenum + "... ");
        if (compareOutput(expected, received)) {
            System.err.print("PASSED");
            double rerr = relativeError(expected, received);
            if (rerr > 0) {
                System.err.printf(" (relative error %g)", rerr);
            }
            System.err.println();
            return 1;
        } else {
            System.err.println("FAILED");
            System.err.println("    Expected: " + formatResult(expected));
            System.err.println("    Received: " + formatResult(received));
            return 0;
        }
    }

    static int runTestCase(int casenum__) {
        switch (casenum__) {
            case 0: {
                int[] x = {1};
                int[] y1 = {-1};
                int[] y2 = {1};
                double expected__ = 0.5;

                return verifyCase(casenum__, expected__, new LaserShooting().numberOfHits(x, y1, y2));
            }
            case 1: {
                int[] x = {1, 2};
                int[] y1 = {-1, -2};
                int[] y2 = {1, 2};
                double expected__ = 1.0;

                return verifyCase(casenum__, expected__, new LaserShooting().numberOfHits(x, y1, y2));
            }
            case 2: {
                int[] x = {3, 4, 7, 1};
                int[] y1 = {1, 2, 3, 4};
                int[] y2 = {4, 3, 2, 1};
                double expected__ = 0.4623163952488826;

                return verifyCase(casenum__, expected__, new LaserShooting().numberOfHits(x, y1, y2));
            }
            case 3: {
                int[] x = {134, 298, 151, 942};
                int[] y1 = {-753, -76, 19, 568};
                int[] y2 = {440, 689, -39, 672};
                double expected__ = 1.444210260641501;

                return verifyCase(casenum__, expected__, new LaserShooting().numberOfHits(x, y1, y2));
            }

            // custom cases

            /*      case 4: {
             int[] x                   = ;
             int[] y1                  = ;
             int[] y2                  = ;
             double expected__         = ;

             return verifyCase(casenum__, expected__, new LaserShooting().numberOfHits(x, y1, y2));
             }*/
            /*      case 5: {
             int[] x                   = ;
             int[] y1                  = ;
             int[] y2                  = ;
             double expected__         = ;

             return verifyCase(casenum__, expected__, new LaserShooting().numberOfHits(x, y1, y2));
             }*/
            /*      case 6: {
             int[] x                   = ;
             int[] y1                  = ;
             int[] y2                  = ;
             double expected__         = ;

             return verifyCase(casenum__, expected__, new LaserShooting().numberOfHits(x, y1, y2));
             }*/
            default:
                return -1;
        }
    }
}

// END CUT HERE
