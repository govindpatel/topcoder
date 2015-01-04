
public class DoubleLetter {

    public String ableToSolve(String S) {
        while (true) {
            boolean found = false;
            for (int i = 1; i < S.length(); i++) {
                if (S.charAt(i - 1) == S.charAt(i)) {
                    String f = S.substring(0, i - 1);
                    String s = S.substring(i + 1);
                    S = f + s;
                    found = true;
                    break;
                }
            }
            if (!found || S.length() == 0) {
                break;
            }
        }
        return S.length() == 0 ? "Possible" : "Impossible";
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            DoubleLetterHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                DoubleLetterHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class DoubleLetterHarness {

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

    static boolean compareOutput(String expected, String result) {
        return expected.equals(result);
    }

    static String formatResult(String res) {
        return String.format("\"%s\"", res);
    }

    static int verifyCase(int casenum, String expected, String received) {
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
                String S = "aabccb";
                String expected__ = "Possible";

                return verifyCase(casenum__, expected__, new DoubleLetter().ableToSolve(S));
            }
            case 1: {
                String S = "aabccbb";
                String expected__ = "Impossible";

                return verifyCase(casenum__, expected__, new DoubleLetter().ableToSolve(S));
            }
            case 2: {
                String S = "abcddcba";
                String expected__ = "Possible";

                return verifyCase(casenum__, expected__, new DoubleLetter().ableToSolve(S));
            }
            case 3: {
                String S = "abab";
                String expected__ = "Impossible";

                return verifyCase(casenum__, expected__, new DoubleLetter().ableToSolve(S));
            }
            case 4: {
                String S = "aaaaaaaaaa";
                String expected__ = "Possible";

                return verifyCase(casenum__, expected__, new DoubleLetter().ableToSolve(S));
            }
            case 5: {
                String S = "aababbabbaba";
                String expected__ = "Impossible";

                return verifyCase(casenum__, expected__, new DoubleLetter().ableToSolve(S));
            }
            case 6: {
                String S = "zzxzxxzxxzzx";
                String expected__ = "Possible";

                return verifyCase(casenum__, expected__, new DoubleLetter().ableToSolve(S));
            }

            // custom cases

            /*      case 7: {
             String S                  = ;
             String expected__         = ;

             return verifyCase(casenum__, expected__, new DoubleLetter().ableToSolve(S));
             }*/
            /*      case 8: {
             String S                  = ;
             String expected__         = ;

             return verifyCase(casenum__, expected__, new DoubleLetter().ableToSolve(S));
             }*/
            /*      case 9: {
             String S                  = ;
             String expected__         = ;

             return verifyCase(casenum__, expected__, new DoubleLetter().ableToSolve(S));
             }*/
            default:
                return -1;
        }
    }
}

// END CUT HERE
