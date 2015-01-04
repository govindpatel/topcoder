
public class Abacus {

    public String[] add(String[] original, int val) {
        int number = 0;
        for (int i = 0; i < original.length; i++) {
            int cnt = 0;
            for (int j = original[i].length() - 1; j >= 0; j--) {
                if (original[i].charAt(j) == '-') {
                    break;
                } else {
                    cnt++;
                }
            }
            number = number * 10 + cnt;
        }
        //System.out.println(number);
        number = number + val;
        for (int i = 5; i >= 0; i--) {
            int rem = number % 10;
            number = number / 10;
            original[i] = abacus(rem);
        }
        return original;
    }

    String abacus(int last) {
        String ret = "";
        for (int i = 0; i < last; i++) {
            ret += 'o';
        }
        ret = "---" + ret;
        while (ret.length() < 12) {
            ret = "o" + ret;
        }
        return ret;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            AbacusHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                AbacusHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class AbacusHarness {

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

    static boolean compareOutput(String[] expected, String[] result) {
        if (expected.length != result.length) {
            return false;
        }
        for (int i = 0; i < expected.length; ++i) {
            if (!expected[i].equals(result[i])) {
                return false;
            }
        }
        return true;
    }

    static String formatResult(String[] res) {
        String ret = "";
        ret += "{";
        for (int i = 0; i < res.length; ++i) {
            if (i > 0) {
                ret += ",";
            }
            ret += String.format(" \"%s\"", res[i]);
        }
        ret += " }";
        return ret;
    }

    static int verifyCase(int casenum, String[] expected, String[] received) {
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
                String[] original = {"ooo---oooooo",
                    "---ooooooooo",
                    "---ooooooooo",
                    "---ooooooooo",
                    "oo---ooooooo",
                    "---ooooooooo"};
                int val = 5;
                String[] expected__ = {"ooo---oooooo", "---ooooooooo", "---ooooooooo", "---ooooooooo", "o---oooooooo", "ooooo---oooo"};

                return verifyCase(casenum__, expected__, new Abacus().add(original, val));
            }
            case 1: {
                String[] original = {"ooo---oooooo",
                    "---ooooooooo",
                    "---ooooooooo",
                    "---ooooooooo",
                    "oo---ooooooo",
                    "---ooooooooo"};
                int val = 21;
                String[] expected__ = {"oo---ooooooo", "ooooooooo---", "ooooooooo---", "ooooooooo---", "ooooooooo---", "ooooooooo---"};

                return verifyCase(casenum__, expected__, new Abacus().add(original, val));
            }
            case 2: {
                String[] original = {"ooooooooo---",
                    "---ooooooooo",
                    "ooooooooo---",
                    "---ooooooooo",
                    "oo---ooooooo",
                    "---ooooooooo"};
                int val = 100000;
                String[] expected__ = {"oooooooo---o", "---ooooooooo", "ooooooooo---", "---ooooooooo", "oo---ooooooo", "---ooooooooo"};

                return verifyCase(casenum__, expected__, new Abacus().add(original, val));
            }
            case 3: {
                String[] original = {"o---oooooooo",
                    "---ooooooooo",
                    "---ooooooooo",
                    "---ooooooooo",
                    "---ooooooooo",
                    "---ooooooooo"
                };
                int val = 1;
                String[] expected__ = {"---ooooooooo", "ooooooooo---", "ooooooooo---", "ooooooooo---", "ooooooooo---", "ooooooooo---"};

                return verifyCase(casenum__, expected__, new Abacus().add(original, val));
            }

            // custom cases

            /*      case 4: {
             String[] original         = ;
             int val                   = ;
             String[] expected__       = ;

             return verifyCase(casenum__, expected__, new Abacus().add(original, val));
             }*/
            /*      case 5: {
             String[] original         = ;
             int val                   = ;
             String[] expected__       = ;

             return verifyCase(casenum__, expected__, new Abacus().add(original, val));
             }*/
            /*      case 6: {
             String[] original         = ;
             int val                   = ;
             String[] expected__       = ;

             return verifyCase(casenum__, expected__, new Abacus().add(original, val));
             }*/
            default:
                return -1;
        }
    }
}

// END CUT HERE
