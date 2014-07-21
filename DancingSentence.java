
public class DancingSentence {

    public String makeDancing(String sentence) {
        String res = "";
        boolean cap = true;
        for (int i = 0; i < sentence.length(); i++) {
            char now = sentence.charAt(i);
            if (now == ' ') {
                res += " ";
            } else {
                if (cap) {
                    res += Character.toUpperCase(now);
                } else {
                    res += Character.toLowerCase(now);
                }
                cap = !cap;
            }
        }
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            DancingSentenceHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                DancingSentenceHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class DancingSentenceHarness {

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
                String sentence = "This is a dancing sentence";
                String expected__ = "ThIs Is A dAnCiNg SeNtEnCe";

                return verifyCase(casenum__, expected__, new DancingSentence().makeDancing(sentence));
            }
            case 1: {
                String sentence = " This   is         a  dancing   sentence  ";
                String expected__ = " ThIs   Is         A  dAnCiNg   SeNtEnCe  ";

                return verifyCase(casenum__, expected__, new DancingSentence().makeDancing(sentence));
            }
            case 2: {
                String sentence = "aaaaaaaaaaa";
                String expected__ = "AaAaAaAaAaA";

                return verifyCase(casenum__, expected__, new DancingSentence().makeDancing(sentence));
            }
            case 3: {
                String sentence = "z";
                String expected__ = "Z";

                return verifyCase(casenum__, expected__, new DancingSentence().makeDancing(sentence));
            }

            // custom cases

            /*      case 4: {
             String sentence           = ;
             String expected__         = ;

             return verifyCase(casenum__, expected__, new DancingSentence().makeDancing(sentence));
             }*/
            /*      case 5: {
             String sentence           = ;
             String expected__         = ;

             return verifyCase(casenum__, expected__, new DancingSentence().makeDancing(sentence));
             }*/
            /*      case 6: {
             String sentence           = ;
             String expected__         = ;

             return verifyCase(casenum__, expected__, new DancingSentence().makeDancing(sentence));
             }*/
            default:
                return -1;
        }
    }
}

// END CUT HERE
