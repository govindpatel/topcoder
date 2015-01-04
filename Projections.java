
public class Projections {

    public int[] count(String front, String right) {
        int xInRight = 0;
        int xInFront = 0;
        for (int i = 0; i < right.length(); i++) {
            if (right.charAt(i) == 'x') {
                xInRight++;
            }
        }
        for (int i = 0; i < front.length(); i++) {
            if (front.charAt(i) == 'x') {
                xInFront++;
            }
        }
//        for (int i = 0; i < front.length(); i++) {
//            if (front.charAt(i) == 'x') {
//                max += xInRight;
//            }
//            if (front.charAt(i) == 'x' && i < right.length() && right.charAt(i) == 'x') {
//                bothxx++;
//            }
//        }
        System.out.println(xInFront + " " + xInRight);
        return new int[]{Math.max(xInFront, xInRight), xInRight * xInFront};
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            ProjectionsHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                ProjectionsHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class ProjectionsHarness {

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

    static boolean compareOutput(int[] expected, int[] result) {
        if (expected.length != result.length) {
            return false;
        }
        for (int i = 0; i < expected.length; ++i) {
            if (expected[i] != result[i]) {
                return false;
            }
        }
        return true;
    }

    static String formatResult(int[] res) {
        String ret = "";
        ret += "{";
        for (int i = 0; i < res.length; ++i) {
            if (i > 0) {
                ret += ",";
            }
            ret += String.format(" %d", res[i]);
        }
        ret += " }";
        return ret;
    }

    static int verifyCase(int casenum, int[] expected, int[] received) {
        System.err.print("Example " + casenum + "... ");
        if (compareOutput(expected, received)) {
            System.err.println("PASSED");
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
                String front = "x";
                String right = "x";
                int[] expected__ = {1, 1};

                return verifyCase(casenum__, expected__, new Projections().count(front, right));
            }
            case 1: {
                String front = "x.";
                String right = ".x";
                int[] expected__ = {1, 1};

                return verifyCase(casenum__, expected__, new Projections().count(front, right));
            }
            case 2: {
                String front = "xxxx";
                String right = "x..x";
                int[] expected__ = {4, 8};

                return verifyCase(casenum__, expected__, new Projections().count(front, right));
            }
            case 3: {
                String front = "x.x.x.x";
                String right = "x.x.x.x";
                int[] expected__ = {4, 16};

                return verifyCase(casenum__, expected__, new Projections().count(front, right));
            }
            case 4: {
                String front = "x...xx..x.xxx..x.xx.";
                String right = ".xx..xxx.xx.";
                int[] expected__ = {10, 70};

                return verifyCase(casenum__, expected__, new Projections().count(front, right));
            }

            // custom cases

            /*      case 5: {
             String front              = ;
             String right              = ;
             int[] expected__          = ;

             return verifyCase(casenum__, expected__, new Projections().count(front, right));
             }*/
            /*      case 6: {
             String front              = ;
             String right              = ;
             int[] expected__          = ;

             return verifyCase(casenum__, expected__, new Projections().count(front, right));
             }*/
            /*      case 7: {
             String front              = ;
             String right              = ;
             int[] expected__          = ;

             return verifyCase(casenum__, expected__, new Projections().count(front, right));
             }*/
            default:
                return -1;
        }
    }
}

// END CUT HERE
