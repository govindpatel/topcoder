
public class PalindromeDecoding {

    public String decode(String code, int[] position, int[] length) {
        for (int i = 0; i < position.length; i++) {
            code = add(code, code.substring(position[i], position[i] + length[i]), position[i] + length[i]);
        }
        return code;
    }

    String add(String init, String toAdd, int pos) {
        String ans = init.substring(0, pos);
        ans += reverse(toAdd);
        ans += init.substring(pos);
        return ans;
    }

    public String reverse(String in) {
        String out = "";
        for (int i = in.length() - 1; i >= 0; i--) {
            out += in.charAt(i);
        }
        return out;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            PalindromeDecodingHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                PalindromeDecodingHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class PalindromeDecodingHarness {

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
                String code = "ab";
                int[] position = {0};
                int[] length = {2};
                String expected__ = "abba";

                return verifyCase(casenum__, expected__, new PalindromeDecoding().decode(code, position, length));
            }
            case 1: {
                String code = "Misip";
                int[] position = {2, 3, 1, 7};
                int[] length = {1, 1, 2, 2};
                String expected__ = "Mississippi";

                return verifyCase(casenum__, expected__, new PalindromeDecoding().decode(code, position, length));
            }
            case 2: {
                String code = "XY";
                int[] position = {0, 0, 0, 0};
                int[] length = {2, 4, 8, 16};
                String expected__ = "XYYXXYYXXYYXXYYXXYYXXYYXXYYXXYYX";

                return verifyCase(casenum__, expected__, new PalindromeDecoding().decode(code, position, length));
            }
            case 3: {
                String code = "TC206";
                int[] position = {1, 2, 5};
                int[] length = {1, 1, 1};
                String expected__ = "TCCC2006";

                return verifyCase(casenum__, expected__, new PalindromeDecoding().decode(code, position, length));
            }
            case 4: {
                String code = "nodecoding";
                int[] position = {};
                int[] length = {};
                String expected__ = "nodecoding";

                return verifyCase(casenum__, expected__, new PalindromeDecoding().decode(code, position, length));
            }

            // custom cases

            /*      case 5: {
             String code               = ;
             int[] position            = ;
             int[] length              = ;
             String expected__         = ;

             return verifyCase(casenum__, expected__, new PalindromeDecoding().decode(code, position, length));
             }*/
            /*      case 6: {
             String code               = ;
             int[] position            = ;
             int[] length              = ;
             String expected__         = ;

             return verifyCase(casenum__, expected__, new PalindromeDecoding().decode(code, position, length));
             }*/
            /*      case 7: {
             String code               = ;
             int[] position            = ;
             int[] length              = ;
             String expected__         = ;

             return verifyCase(casenum__, expected__, new PalindromeDecoding().decode(code, position, length));
             }*/
            default:
                return -1;
        }
    }
}

// END CUT HERE
