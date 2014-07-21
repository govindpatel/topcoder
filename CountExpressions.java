
public class CountExpressions {

    int xx, yy, value;
    int cnt;

    public int calcExpressions(int x, int y, int val) {
        /*int cnt = 0;
         char[] op = new char[]{'+', '-', '*'};
         for (int p1 = 0; p1 < 4; p1++) {//x
         for (int p2 = 0; p2 < 4; p2++) {//x
         if (p1 == p2) {
         continue;
         }
         for (int p3 = 0; p3 < 4; p3++) {//y
         if (p3 == p1 || p3 == p2) {
         continue;
         }
         for (int p4 = 0; p4 < 4; p4++) {//y
         if (p1 == p4 || p2 == p4 || p3 == p4) {
         continue;
         }

         int[] arrangement = new int[4];
         arrangement[p1] = x;
         arrangement[p2] = x;
         arrangement[p3] = y;
         arrangement[p4] = y;

         for (int op1 = 0; op1 < 3; op1++) {
         for (int op2 = 0; op2 < 3; op2++) {
         for (int op3 = 0; op3 < 3; op3++) {
         int exp_val = 0;
         if (op1 == 0) {
         exp_val = arrangement[0] + arrangement[1];
         } else if (op1 == 1) {
         exp_val = arrangement[0] - arrangement[1];
         } else if (op1 == 2) {
         exp_val = arrangement[0] * arrangement[1];
         }

         if (op2 == 0) {
         exp_val += arrangement[2];
         } else if (op2 == 1) {
         exp_val -= arrangement[2];
         } else if (op2 == 2) {
         exp_val *= arrangement[2];
         }


         if (op3 == 0) {
         exp_val += arrangement[3];
         } else if (op3 == 1) {
         exp_val -= arrangement[3];
         } else if (op3 == 2) {
         exp_val *= arrangement[3];
         }

         if (exp_val == val) {
         cnt++;
         }
         }
         }
         }
         }
         }
         }
         }
         return cnt / 4;
         * */
        cnt = 0;
        value = val;
        xx = x;
        yy = y;

        dfs(0, 1, y);
        dfs(1, 0, x);

        return cnt;
    }

    void dfs(int i, int j, int past) {
        if (i + j == 4) {
            if (past == value) {
                cnt++;
            }
            return;
        }
        if (i < 2) {
            dfs(i + 1, j, past + xx);
            dfs(i + 1, j, past - xx);
            dfs(i + 1, j, past * xx);
        }
        if (j < 2) {
            dfs(i, j + 1, past + yy);
            dfs(i, j + 1, past - yy);
            dfs(i, j + 1, past * yy);
        }
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            CountExpressionsHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                CountExpressionsHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class CountExpressionsHarness {

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

    static boolean compareOutput(int expected, int result) {
        return expected == result;
    }

    static String formatResult(int res) {
        return String.format("%d", res);
    }

    static int verifyCase(int casenum, int expected, int received) {
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
                int x = 7;
                int y = 8;
                int val = 16;
                int expected__ = 9;

                return verifyCase(casenum__, expected__, new CountExpressions().calcExpressions(x, y, val));
            }
            case 1: {
                int x = 3;
                int y = 5;
                int val = 7;
                int expected__ = 5;

                return verifyCase(casenum__, expected__, new CountExpressions().calcExpressions(x, y, val));
            }
            case 2: {
                int x = 99;
                int y = 100;
                int val = 98010000;
                int expected__ = 6;

                return verifyCase(casenum__, expected__, new CountExpressions().calcExpressions(x, y, val));
            }
            case 3: {
                int x = -99;
                int y = 42;
                int val = -1764;
                int expected__ = 2;

                return verifyCase(casenum__, expected__, new CountExpressions().calcExpressions(x, y, val));
            }
            case 4: {
                int x = 100;
                int y = -100;
                int val = -100000000;
                int expected__ = 0;

                return verifyCase(casenum__, expected__, new CountExpressions().calcExpressions(x, y, val));
            }
            case 5: {
                int x = 1;
                int y = 2;
                int val = 5;
                int expected__ = 17;

                return verifyCase(casenum__, expected__, new CountExpressions().calcExpressions(x, y, val));
            }

            // custom cases

            /*      case 6: {
             int x                     = ;
             int y                     = ;
             int val                   = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new CountExpressions().calcExpressions(x, y, val));
             }*/
            /*      case 7: {
             int x                     = ;
             int y                     = ;
             int val                   = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new CountExpressions().calcExpressions(x, y, val));
             }*/
            /*      case 8: {
             int x                     = ;
             int y                     = ;
             int val                   = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new CountExpressions().calcExpressions(x, y, val));
             }*/
            default:
                return -1;
        }
    }
}

// END CUT HERE
