
public class DrawingMarbles {

    public double sameColor(int[] colors, int n) {
        double ans = 0;
        int sum = 0;
        for (int s : colors) {
            sum += s;
        }
        for (int i = 0; i < colors.length; i++) {
            double pb = 1.0;
            for (int j = 0; j < n; j++) {
                pb *= (colors[i] - j)*1.0 / (sum - j);
            }
            ans += pb;
        }

        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            DrawingMarblesHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                DrawingMarblesHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class DrawingMarblesHarness {

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
                int[] colors = {13};
                int n = 8;
                double expected__ = 1.0;

                return verifyCase(casenum__, expected__, new DrawingMarbles().sameColor(colors, n));
            }
            case 1: {
                int[] colors = {5, 7};
                int n = 1;
                double expected__ = 1.0;

                return verifyCase(casenum__, expected__, new DrawingMarbles().sameColor(colors, n));
            }
            case 2: {
                int[] colors = {5, 6, 7};
                int n = 2;
                double expected__ = 0.3006535947712418;

                return verifyCase(casenum__, expected__, new DrawingMarbles().sameColor(colors, n));
            }
            case 3: {
                int[] colors = {12, 2, 34, 13, 17};
                int n = 4;
                double expected__ = 0.035028830818304504;

                return verifyCase(casenum__, expected__, new DrawingMarbles().sameColor(colors, n));
            }

            // custom cases

            /*      case 4: {
             int[] colors              = ;
             int n                     = ;
             double expected__         = ;

             return verifyCase(casenum__, expected__, new DrawingMarbles().sameColor(colors, n));
             }*/
            /*      case 5: {
             int[] colors              = ;
             int n                     = ;
             double expected__         = ;

             return verifyCase(casenum__, expected__, new DrawingMarbles().sameColor(colors, n));
             }*/
            /*      case 6: {
             int[] colors              = ;
             int n                     = ;
             double expected__         = ;

             return verifyCase(casenum__, expected__, new DrawingMarbles().sameColor(colors, n));
             }*/
            default:
                return -1;
        }
    }
}

// END CUT HERE
