
public class PatternOptimizer {

    public String optimize(String pattern) {
        String ret = "";
        String pat = "";
        for (int i = 0; i < pattern.length(); i++) {
            char now = pattern.charAt(i);
            if (now == '*' || now == '?') {
                pat += now;
            } else {
                ret += format(pat);
                pat = "";
                ret += now;
            }
        }
        ret += format(pat);
        return ret;
    }

    String format(String in) {
        String ret = "";
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == '?') {
                ret += "?";
            }
        }
        if (in.indexOf("*") >= 0) {
            ret = "*" + ret;
        }
        return ret;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            PatternOptimizerHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                PatternOptimizerHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class PatternOptimizerHarness {

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
                String pattern = "*??*a";
                String expected__ = "*??a";

                return verifyCase(casenum__, expected__, new PatternOptimizer().optimize(pattern));
            }
            case 1: {
                String pattern = "*b**a*";
                String expected__ = "*b*a*";

                return verifyCase(casenum__, expected__, new PatternOptimizer().optimize(pattern));
            }
            case 2: {
                String pattern = "cla??";
                String expected__ = "cla??";

                return verifyCase(casenum__, expected__, new PatternOptimizer().optimize(pattern));
            }
            case 3: {
                String pattern = "*?*?*?*";
                String expected__ = "*???";

                return verifyCase(casenum__, expected__, new PatternOptimizer().optimize(pattern));
            }
            case 4: {
                String pattern = "T***nd?*";
                String expected__ = "T*nd*?";

                return verifyCase(casenum__, expected__, new PatternOptimizer().optimize(pattern));
            }

            // custom cases

            /*      case 5: {
             String pattern            = ;
             String expected__         = ;

             return verifyCase(casenum__, expected__, new PatternOptimizer().optimize(pattern));
             }*/
            /*      case 6: {
             String pattern            = ;
             String expected__         = ;

             return verifyCase(casenum__, expected__, new PatternOptimizer().optimize(pattern));
             }*/
            /*      case 7: {
             String pattern            = ;
             String expected__         = ;

             return verifyCase(casenum__, expected__, new PatternOptimizer().optimize(pattern));
             }*/
            default:
                return -1;
        }
    }
}

// END CUT HERE
