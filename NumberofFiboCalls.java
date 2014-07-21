
public class NumberofFiboCalls {

    int[][] num_array;
    boolean[] found;

    public int[] fiboCallsMade(int n) {
        //int[] ret = new int[2];


        num_array = new int[n + 5][2];
        found = new boolean[n + 5];

        found[0] = true;
        found[1] = true;
        num_array[0][0] = 1;
        num_array[0][1] = 0;
        num_array[1][0] = 0;
        num_array[1][1] = 1;
        fib(n);
        return num_array[n];
    }

    int[] fib(int n) {
        if (n < 0) {
            return new int[]{0, 0};
        }
        if (found[n]) {
            return num_array[n];
        }
        int[] ans = add(fib(n - 1), fib(n - 2));
        found[n] = true;
        num_array[n] = ans;
        return ans;
    }

    int[] add(int[] f1, int[] f2) {
        return new int[]{f1[0] + f2[0], f1[1] + f2[1]};
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            NumberofFiboCallsHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                NumberofFiboCallsHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class NumberofFiboCallsHarness {

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
                int n = 0;
                int[] expected__ = {1, 0};

                return verifyCase(casenum__, expected__, new NumberofFiboCalls().fiboCallsMade(n));
            }
            case 1: {
                int n = 3;
                int[] expected__ = {1, 2};

                return verifyCase(casenum__, expected__, new NumberofFiboCalls().fiboCallsMade(n));
            }
            case 2: {
                int n = 6;
                int[] expected__ = {5, 8};

                return verifyCase(casenum__, expected__, new NumberofFiboCalls().fiboCallsMade(n));
            }
            case 3: {
                int n = 22;
                int[] expected__ = {10946, 17711};

                return verifyCase(casenum__, expected__, new NumberofFiboCalls().fiboCallsMade(n));
            }

            // custom cases

            /*      case 4: {
             int n                     = ;
             int[] expected__          = ;

             return verifyCase(casenum__, expected__, new NumberofFiboCalls().fiboCallsMade(n));
             }*/
            /*      case 5: {
             int n                     = ;
             int[] expected__          = ;

             return verifyCase(casenum__, expected__, new NumberofFiboCalls().fiboCallsMade(n));
             }*/
            /*      case 6: {
             int n                     = ;
             int[] expected__          = ;

             return verifyCase(casenum__, expected__, new NumberofFiboCalls().fiboCallsMade(n));
             }*/
            default:
                return -1;
        }
    }
}

// END CUT HERE
