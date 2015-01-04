
public class InverseHaar1D {

    public int[] transform(int[] transformedData, int L) {
        //size = 4->2->1
        int N = transformedData.length;
        int len = N >> L;
        //System.out.println(len);
        for (int i = 0; i < L; i++) {
            int[] copy = new int[N];
            for (int j = 0; j < N; j++) {
                copy[j] = transformedData[j];
            }
            for (int j = 0; j < len; j++) {
                copy[2*j] = (transformedData[j] + transformedData[len + j]) / 2;
                copy[2*j+1] = (transformedData[j] - transformedData[len + j]) / 2;
            }
            transformedData = copy;
            len = len << 1;
        }
        return transformedData;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            InverseHaar1DHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                InverseHaar1DHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class InverseHaar1DHarness {

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
                int[] transformedData = {101, -53};
                int L = 1;
                int[] expected__ = {24, 77};

                return verifyCase(casenum__, expected__, new InverseHaar1D().transform(transformedData, L));
            }
            case 1: {
                int[] transformedData = {3, 8, -1, -2};
                int L = 1;
                int[] expected__ = {1, 2, 3, 5};

                return verifyCase(casenum__, expected__, new InverseHaar1D().transform(transformedData, L));
            }
            case 2: {
                int[] transformedData = {11, -5, -1, -2};
                int L = 2;
                int[] expected__ = {1, 2, 3, 5};

                return verifyCase(casenum__, expected__, new InverseHaar1D().transform(transformedData, L));
            }
            case 3: {
                int[] transformedData = {369, 477, 451, 262, 47, 135, -125, -2, 18, -23, 30, 101, -5, -18, 54, -20, 11, 45, -5, 70, -24, 2, -50, 15, 55, -62, -23, -17, 44, -8, -44, -52};
                int L = 3;
                int[] expected__ = {62, 51, 70, 25, 32, 37, 81, 11, 72, 96, 70, 68, 43, 93, 25, 10, 67, 12, 11, 73, 56, 79, 68, 85, 68, 24, 15, 23, 6, 50, 12, 64};

                return verifyCase(casenum__, expected__, new InverseHaar1D().transform(transformedData, L));
            }

            // custom cases

            /*      case 4: {
             int[] transformedData     = ;
             int L                     = ;
             int[] expected__          = ;

             return verifyCase(casenum__, expected__, new InverseHaar1D().transform(transformedData, L));
             }*/
            /*      case 5: {
             int[] transformedData     = ;
             int L                     = ;
             int[] expected__          = ;

             return verifyCase(casenum__, expected__, new InverseHaar1D().transform(transformedData, L));
             }*/
            /*      case 6: {
             int[] transformedData     = ;
             int L                     = ;
             int[] expected__          = ;

             return verifyCase(casenum__, expected__, new InverseHaar1D().transform(transformedData, L));
             }*/
            default:
                return -1;
        }
    }
}
// END CUT HERE

