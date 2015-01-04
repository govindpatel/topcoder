
public class PalindromeMaker {

    public String make(String baseString) {
        int[] ch = new int[27];
        String front = "";
        String rear = "";
        String mid = "";
        int odd = 0;
        for (int i = 0; i < baseString.length(); i++) {
            ch[baseString.charAt(i) - 'A']++;
        }
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] % 2 != 0) {
                odd++;
                mid += (char) ('A' + i);
                --ch[i];
            }
            int div = ch[i] / 2;
            for (int j = 0; j < div; j++) {
                front += (char) ('A' + i);
            }
            for (int j = 0; j < div; j++) {
                rear = (char) ('A' + i) + rear;
            }
        }
        if (odd > 1) {
            return "";
        }
        return front + mid + rear;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            PalindromeMakerHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                PalindromeMakerHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class PalindromeMakerHarness {

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
                String baseString = "AABB";
                String expected__ = "ABBA";

                return verifyCase(casenum__, expected__, new PalindromeMaker().make(baseString));
            }
            case 1: {
                String baseString = "AAABB";
                String expected__ = "ABABA";

                return verifyCase(casenum__, expected__, new PalindromeMaker().make(baseString));
            }
            case 2: {
                String baseString = "ABACABA";
                String expected__ = "AABCBAA";

                return verifyCase(casenum__, expected__, new PalindromeMaker().make(baseString));
            }
            case 3: {
                String baseString = "ABCD";
                String expected__ = "";

                return verifyCase(casenum__, expected__, new PalindromeMaker().make(baseString));
            }

            // custom cases

            /*      case 4: {
             String baseString         = ;
             String expected__         = ;

             return verifyCase(casenum__, expected__, new PalindromeMaker().make(baseString));
             }*/
            /*      case 5: {
             String baseString         = ;
             String expected__         = ;

             return verifyCase(casenum__, expected__, new PalindromeMaker().make(baseString));
             }*/
            /*      case 6: {
             String baseString         = ;
             String expected__         = ;

             return verifyCase(casenum__, expected__, new PalindromeMaker().make(baseString));
             }*/
            default:
                return -1;
        }
    }
}

// END CUT HERE
