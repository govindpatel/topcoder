
public class BusSeating {

    public double getArrangement(String leftRow, String rightRow) {
        String complete = leftRow + rightRow;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < complete.length(); i++) {
            if (complete.charAt(i) == '-') {
                for (int j = i + 1; j < complete.length(); j++) {
                    if (i != j && complete.charAt(j) == '-') {
                        for (int k = j + 1; k < complete.length(); k++) {
                            if (i != k && j != k && complete.charAt(k) == '-') {
                                int[] pos1 = new int[]{2 * (i / 10), i % 10};
                                int[] pos2 = new int[]{2 * (j / 10), j % 10};
                                int[] pos3 = new int[]{2 * (k / 10), k % 10};
                                //System.out.println(pos1[0] + " " + pos1[1]);
                                //System.out.println(pos2[0] + " " + pos2[1]);
                                //System.out.println(pos3[0] + " " + pos3[1]);

                                double dist = dist(pos1, pos2) + dist(pos2, pos3) + dist(pos3, pos1);
                                //System.out.println(dist + "\n");
                                min = Math.min(dist, min);
                            }
                        }
                    }
                }
            }
        }
        return min;
    }

    double dist(int[] p1, int[] p2) {
        int x = Math.abs(p1[0] - p2[0]);
        int y = Math.abs(p1[1] - p2[1]);
        return Math.sqrt(x * x + y * y);
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            BusSeatingHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                BusSeatingHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class BusSeatingHarness {

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
                String leftRow = "----------";
                String rightRow = "----------";
                double expected__ = 4.0;

                return verifyCase(casenum__, expected__, new BusSeating().getArrangement(leftRow, rightRow));
            }
            case 1: {
                String leftRow = "XXX-X-XX-X";
                String rightRow = "-XXXX---XX";
                double expected__ = 4.0;

                return verifyCase(casenum__, expected__, new BusSeating().getArrangement(leftRow, rightRow));
            }
            case 2: {
                String leftRow = "XXXXXXXXXX";
                String rightRow = "-XX-XX-X--";
                double expected__ = 6.0;

                return verifyCase(casenum__, expected__, new BusSeating().getArrangement(leftRow, rightRow));
            }
            case 3: {
                String leftRow = "XXX-X-XX-X";
                String rightRow = "XXX-X-XX-X";
                double expected__ = 6.82842712474619;

                return verifyCase(casenum__, expected__, new BusSeating().getArrangement(leftRow, rightRow));
            }

            // custom cases

            /*      case 4: {
             String leftRow            = ;
             String rightRow           = ;
             double expected__         = ;

             return verifyCase(casenum__, expected__, new BusSeating().getArrangement(leftRow, rightRow));
             }*/
            /*      case 5: {
             String leftRow            = ;
             String rightRow           = ;
             double expected__         = ;

             return verifyCase(casenum__, expected__, new BusSeating().getArrangement(leftRow, rightRow));
             }*/
            /*      case 6: {
             String leftRow            = ;
             String rightRow           = ;
             double expected__         = ;

             return verifyCase(casenum__, expected__, new BusSeating().getArrangement(leftRow, rightRow));
             }*/
            default:
                return -1;
        }
    }
}

// END CUT HERE
