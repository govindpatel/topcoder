
public class UnderscoreJustification {

    public String justifyLine(String[] words, int width) {
        int length = 0;
        for (int i = 0; i < words.length; i++) {
            length += words[i].length();
        }
        int spaces = width - length;
        int gap = spaces / (words.length - 1);
        int extra = spaces % (words.length - 1);
        String gapper = "";
        String[] gaps = new String[words.length - 1];
        for (int i = 0; i < gap; i++) {
            gapper += "_";
        }
        for (int i = 0; i < words.length - 1; i++) {
            gaps[i] = gapper;
            if (extra > 0) {
                gaps[i] = gaps[i] + "_";
                --extra;
            }
        }
        int[] permute = new int[words.length - 1];
        for (int i = 0; i < words.length - 1; i++) {
            permute[i] = i;
        }
        String res = "";
        do {
            String now = "";
            for (int i = 0; i < words.length; i++) {
                now = now + words[i];
                if (i < words.length - 1) {
                    now += gaps[permute[i]];
                }
            }
            if (res.length() == 0 || res.compareTo(now) > 0) {
                res = now;
            }
        } while (permutation(permute));
        return res;
    }

    boolean permutation(int[] arr) {
        int a = arr.length - 2;
        for (a = arr.length - 2; a >= 0; a--) {
            if (arr[a] < arr[a + 1]) {
                break;
            }
        }
        if (a == -1) {
            return false;
        }
        int b = arr.length - 1;
        for (; b >= 0; b--) {
            if (arr[b] > arr[a]) {
                break;
            }
        }
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
        a++;
        b = arr.length - 1;
        while (a < b) {
            t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
            b--;
            a++;
        }
        return true;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            UnderscoreJustificationHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                UnderscoreJustificationHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class UnderscoreJustificationHarness {

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
                String[] words = {"A", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
                int width = 50;
                String expected__ = "A___quick__brown__fox__jumps__over__the__lazy__dog";

                return verifyCase(casenum__, expected__, new UnderscoreJustification().justifyLine(words, width));
            }
            case 1: {
                String[] words = {"Alpha", "Beta", "Gamma", "Delta", "Epsilon"};
                int width = 32;
                String expected__ = "Alpha_Beta_Gamma__Delta__Epsilon";

                return verifyCase(casenum__, expected__, new UnderscoreJustification().justifyLine(words, width));
            }
            case 2: {
                String[] words = {"Hello", "world", "John", "said"};
                int width = 29;
                String expected__ = "Hello____world___John____said";

                return verifyCase(casenum__, expected__, new UnderscoreJustification().justifyLine(words, width));
            }

            // custom cases

            /*      case 3: {
             String[] words            = ;
             int width                 = ;
             String expected__         = ;

             return verifyCase(casenum__, expected__, new UnderscoreJustification().justifyLine(words, width));
             }*/
            /*      case 4: {
             String[] words            = ;
             int width                 = ;
             String expected__         = ;

             return verifyCase(casenum__, expected__, new UnderscoreJustification().justifyLine(words, width));
             }*/
            /*      case 5: {
             String[] words            = ;
             int width                 = ;
             String expected__         = ;

             return verifyCase(casenum__, expected__, new UnderscoreJustification().justifyLine(words, width));
             }*/
            default:
                return -1;
        }
    }
}

// END CUT HERE
