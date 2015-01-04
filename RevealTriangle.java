
public class RevealTriangle {

    public String[] calcTriangle(String[] questionMarkTriangle) {
        int N = questionMarkTriangle.length;
        String[] res = new String[N];
        for (int i = N - 1; i >= 0; i--) {
            String curr = "";
            boolean found = false;
            for (char ch = '0'; ch <= '9' && !found; ch++) {
                int indX = questionMarkTriangle[i].indexOf(ch + "");
                curr = ch + "";
                if (indX >= 0) {
                    found = true;
                    for (int j = indX - 1; j >= 0; j--) {
                        if (questionMarkTriangle[i].charAt(j) == '?') {
                            int x = curr.charAt(0) - '0';
                            int below = questionMarkTriangle[i + 1].charAt(j) - '0';
                            int val = 0;
                            while ((x + val) % 10 != below) {
                                val++;
                            }
                            curr = val + curr;
                        } else {
                            curr = questionMarkTriangle[i].charAt(j) + curr;
                        }
                    }
                    for (int j = indX + 1; j < questionMarkTriangle[i].length(); j++) {
                        if (questionMarkTriangle[i].charAt(j) == '?') {
                            int x = curr.charAt(curr.length() - 1) - '0';
                            int below = questionMarkTriangle[i + 1].charAt(j - 1) - '0';
                            int val = 0;
                            while ((x + val) % 10 != below) {
                                val++;
                            }
                            curr = curr + val;
                        } else {
                            curr = curr + questionMarkTriangle[i].charAt(j);
                        }
                    }
                }

            }
            res[i] = curr;
            questionMarkTriangle[i] = curr;
        }
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            RevealTriangleHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                RevealTriangleHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class RevealTriangleHarness {

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
                String[] questionMarkTriangle = {"4??",
                    "?2",
                    "1"};
                String[] expected__ = {"457", "92", "1"};

                return verifyCase(casenum__, expected__, new RevealTriangle().calcTriangle(questionMarkTriangle));
            }
            case 1: {
                String[] questionMarkTriangle = {"1"};
                String[] expected__ = {"1"};

                return verifyCase(casenum__, expected__, new RevealTriangle().calcTriangle(questionMarkTriangle));
            }
            case 2: {
                String[] questionMarkTriangle = {"???2", "??2", "?2", "2"};
                String[] expected__ = {"0002", "002", "02", "2"};

                return verifyCase(casenum__, expected__, new RevealTriangle().calcTriangle(questionMarkTriangle));
            }
            case 3: {
                String[] questionMarkTriangle = {"??5?", "??9", "?4", "6"};
                String[] expected__ = {"7054", "759", "24", "6"};

                return verifyCase(casenum__, expected__, new RevealTriangle().calcTriangle(questionMarkTriangle));
            }

            // custom cases

            /*      case 4: {
             String[] questionMarkTriangle = ;
             String[] expected__       = ;

             return verifyCase(casenum__, expected__, new RevealTriangle().calcTriangle(questionMarkTriangle));
             }*/
            /*      case 5: {
             String[] questionMarkTriangle = ;
             String[] expected__       = ;

             return verifyCase(casenum__, expected__, new RevealTriangle().calcTriangle(questionMarkTriangle));
             }*/
            /*      case 6: {
             String[] questionMarkTriangle = ;
             String[] expected__       = ;

             return verifyCase(casenum__, expected__, new RevealTriangle().calcTriangle(questionMarkTriangle));
             }*/
            default:
                return -1;
        }
    }
}
// END CUT HERE

