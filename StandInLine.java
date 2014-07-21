
import java.util.ArrayList;

public class StandInLine {

    public int[] reconstruct(int[] left) {
        int N = left.length;
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            int remain = left[i];
            for (int j = 0; j < N; j++) {
                if (remain <= 0 && res[j] == 0) {
                    res[j] = i + 1;
                    break;
                }
                if (res[j] == 0 || res[j] > i) {
                    remain--;
                }
                
            }
        }
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            StandInLineHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                StandInLineHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class StandInLineHarness {

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
                int[] left = {2, 1, 1, 0};
                int[] expected__ = {4, 2, 1, 3};

                return verifyCase(casenum__, expected__, new StandInLine().reconstruct(left));
            }
            case 1: {
                int[] left = {0, 0, 0, 0, 0};
                int[] expected__ = {1, 2, 3, 4, 5};

                return verifyCase(casenum__, expected__, new StandInLine().reconstruct(left));
            }
            case 2: {
                int[] left = {5, 4, 3, 2, 1, 0};
                int[] expected__ = {6, 5, 4, 3, 2, 1};

                return verifyCase(casenum__, expected__, new StandInLine().reconstruct(left));
            }
            case 3: {
                int[] left = {6, 1, 1, 1, 2, 0, 0};
                int[] expected__ = {6, 2, 3, 4, 7, 5, 1};

                return verifyCase(casenum__, expected__, new StandInLine().reconstruct(left));
            }

            // custom cases

            /*      case 4: {
             int[] left                = ;
             int[] expected__          = ;

             return verifyCase(casenum__, expected__, new StandInLine().reconstruct(left));
             }*/
            /*      case 5: {
             int[] left                = ;
             int[] expected__          = ;

             return verifyCase(casenum__, expected__, new StandInLine().reconstruct(left));
             }*/
            /*      case 6: {
             int[] left                = ;
             int[] expected__          = ;

             return verifyCase(casenum__, expected__, new StandInLine().reconstruct(left));
             }*/
            default:
                return -1;
        }
    }
}
// END CUT HERE

