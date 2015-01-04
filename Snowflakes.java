
import java.util.Arrays;

public class Snowflakes {

    public String[] flareOut(String[] snowflake) {
        return first(snowflake);
    }

    String[] first(String[] snowflake) {
        int ii = snowflake.length;
        char[][] res = new char[ii][ii];
        for (int i = 0; i < ii; i++) {
            Arrays.fill(res[i], ' ');
        }
        for (int i = 0; i < ii; i++) {
            for (int j = 0; j < snowflake[i].length(); j++) {
                res[i][j] = snowflake[i].charAt(j);
            }
        }
        for (int i = 0; i < ii; i++) {
            for (int j = i + 1; j < ii; j++) {
                res[i][j] = res[j][i];
            }
        }
        for (int i = 0; i < snowflake.length; i++) {
            snowflake[i] = "";
            for (int j = 0; j < ii; j++) {
                snowflake[i] += res[i][j];
            }
        }
        return second(snowflake);
    }

    String[] second(String[] in) {
        for (int i = 0; i < in.length; i++) {
            in[i] = reverse(in[i]) + in[i];
        }
        return third(in);
    }

    String[] third(String[] in) {
        String[] out = new String[in.length * 2];
        int j = 0;
        for (int i = in.length - 1; i >= 0; i--, j++) {
            out[j] = in[i];
        }
        for (int i = 0; i < in.length; i++, j++) {
            out[j] = in[i];
        }
        return out;
    }

    String reverse(String in) {
        String out = "";
        for (int i = in.length() - 1; i >= 0; i--) {
            out += in.charAt(i);
        }
        return out;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            SnowflakesHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                SnowflakesHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class SnowflakesHarness {

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
                String[] snowflake = {".",
                    "..",
                    "*.*"};
                String[] expected__ = {"*.**.*", "......", "*....*", "*....*", "......", "*.**.*"};

                return verifyCase(casenum__, expected__, new Snowflakes().flareOut(snowflake));
            }
            case 1: {
                String[] snowflake = {"*",
                    "..",
                    ".*.",
                    ".**.",
                    ".*.**"};
                String[] expected__ = {"**.*..*.**", "*.**..**.*", ".*.*..*.*.", "***....***", "....**....", "....**....", "***....***", ".*.*..*.*.", "*.**..**.*", "**.*..*.**"};

                return verifyCase(casenum__, expected__, new Snowflakes().flareOut(snowflake));
            }
            case 2: {
                String[] snowflake = {".",
                    "..",
                    "***"};
                String[] expected__ = {"******", "*....*", "*....*", "*....*", "*....*", "******"};

                return verifyCase(casenum__, expected__, new Snowflakes().flareOut(snowflake));
            }
            case 3: {
                String[] snowflake = {"*",
                    ".*",
                    "***"};
                String[] expected__ = {"******", "**..**", "*.**.*", "*.**.*", "**..**", "******"};

                return verifyCase(casenum__, expected__, new Snowflakes().flareOut(snowflake));
            }
            case 4: {
                String[] snowflake = {".",
                    "..",
                    "***",
                    "...."};
                String[] expected__ = {"........", ".******.", ".*....*.", ".*....*.", ".*....*.", ".*....*.", ".******.", "........"};

                return verifyCase(casenum__, expected__, new Snowflakes().flareOut(snowflake));
            }

            // custom cases

            /*      case 5: {
             String[] snowflake        = ;
             String[] expected__       = ;

             return verifyCase(casenum__, expected__, new Snowflakes().flareOut(snowflake));
             }*/
            /*      case 6: {
             String[] snowflake        = ;
             String[] expected__       = ;

             return verifyCase(casenum__, expected__, new Snowflakes().flareOut(snowflake));
             }*/
            /*      case 7: {
             String[] snowflake        = ;
             String[] expected__       = ;

             return verifyCase(casenum__, expected__, new Snowflakes().flareOut(snowflake));
             }*/
            default:
                return -1;
        }
    }
}

// END CUT HERE
