
public class BestTriangulation {

    public double maxArea(String[] vertices) {
        double max = -1;
        for (int i = 0; i < vertices.length; i++) {
            for (int j = i + 1; j < vertices.length; j++) {
                for (int k = j + 1; k < vertices.length; k++) {
                    double now = Math.abs(crossProduct(vertices[i], vertices[j], vertices[k]));
                    max = Math.max(max, now);
                }
            }
        }
        //System.out.println(max);
        return max / 2.0;
    }

    double crossProduct(String p1, String p2, String p3) {
        int[] diffp1 = diff(p1, p3);
        int[] diffp2 = diff(p2, p3);
        return diffp1[0] * diffp2[1] - diffp1[1] * diffp2[0];
    }

    int[] diff(String P, String X) {
        int[] ret = new int[2];
        String[] pxy = P.split(" ");
        String[] xxy = X.split(" ");
        ret[0] = Integer.parseInt(pxy[0]) - Integer.parseInt(xxy[0]);
        ret[1] = Integer.parseInt(pxy[1]) - Integer.parseInt(xxy[1]);;
        return ret;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            BestTriangulationHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                BestTriangulationHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class BestTriangulationHarness {

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
                String[] vertices = {"1 1", "2 3", "3 2"};
                double expected__ = 1.5;

                return verifyCase(casenum__, expected__, new BestTriangulation().maxArea(vertices));
            }
            case 1: {
                String[] vertices = {"1 1", "1 2", "3 3", "2 1"};
                double expected__ = 1.5;

                return verifyCase(casenum__, expected__, new BestTriangulation().maxArea(vertices));
            }
            case 2: {
                String[] vertices = {"1 2", "1 3", "2 4", "3 4", "4 3", "4 2", "3 1", "2 1"};
                double expected__ = 3.0;

                return verifyCase(casenum__, expected__, new BestTriangulation().maxArea(vertices));
            }
            case 3: {
                String[] vertices = {"6 2", "2 1", "1 2", "1 4", "2 6", "5 6", "6 5"};
                double expected__ = 10.0;

                return verifyCase(casenum__, expected__, new BestTriangulation().maxArea(vertices));
            }
            case 4: {
                String[] vertices = {"10000 3469", "9963 712", "9957 634", "9834 271", "9700 165",
                    "9516 46", "8836 4", "1332 57", "229 628", "171 749",
                    "52 1269", "30 1412", "7 4937", "35 8676", "121 9917",
                    "2247 9960", "3581 9986", "6759 9995", "9486 9998", "9888 9890",
                    "9914 9318", "9957 8206", "9998 6402"};
                double expected__ = 4.8292483E7;

                return verifyCase(casenum__, expected__, new BestTriangulation().maxArea(vertices));
            }

            // custom cases

            /*      case 5: {
             String[] vertices         = ;
             double expected__         = ;

             return verifyCase(casenum__, expected__, new BestTriangulation().maxArea(vertices));
             }*/
            /*      case 6: {
             String[] vertices         = ;
             double expected__         = ;

             return verifyCase(casenum__, expected__, new BestTriangulation().maxArea(vertices));
             }*/
            /*      case 7: {
             String[] vertices         = ;
             double expected__         = ;

             return verifyCase(casenum__, expected__, new BestTriangulation().maxArea(vertices));
             }*/
            default:
                return -1;
        }
    }
}

// END CUT HERE
