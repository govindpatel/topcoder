
public class Islands {

    int H, L;

    boolean valid(int i, int j) {
        if (i >= 0 && i < H && j >= 0 && j < L) {
            return true;
        }
        return false;
    }

    public int beachLength(String[] kingdom) {
        int cnt = 0;
        H = kingdom.length;
        L = kingdom[0].length();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < L; j++) {
                if (kingdom[i].charAt(j) == '#') {//land
                    int add = 6;
                    if (!valid(i, j - 1) || kingdom[i].charAt(j - 1) == '#') {
                        cnt--;//left
                    }
                    if (!valid(i, j + 1) || kingdom[i].charAt(j + 1) == '#') {
                        cnt--;//right
                    }
                    if (i % 2 == 0) {//even row...
                        if (!valid(i - 1, j - 1) || kingdom[i - 1].charAt(j - 1) == '#') {
                            cnt--;//top-left
                        }
                        if (!valid(i + 1, j - 1) || kingdom[i + 1].charAt(j - 1) == '#') {
                            cnt--;//bot-left
                        }
                        if (!valid(i - 1, j) || kingdom[i - 1].charAt(j) == '#') {
                            cnt--;//top-right
                        }
                        if (!valid(i + 1, j) || kingdom[i + 1].charAt(j) == '#') {
                            cnt--;//bot-right
                        }
                    } else {//odd row...
                        if (!valid(i - 1, j) || kingdom[i - 1].charAt(j) == '#') {
                            cnt--;//top-left;
                        }
                        if (!valid(i - 1, j + 1) || kingdom[i - 1].charAt(j + 1) == '#') {
                            cnt--;//top-right;
                        }
                        if (!valid(i + 1, j) || kingdom[i + 1].charAt(j) == '#') {
                            cnt--;//bot-left;
                        }
                        if (!valid(i + 1, j + 1) || kingdom[i + 1].charAt(j + 1) == '#') {
                            cnt--;//bot-right;
                        }
                    }
                    cnt += add;
                }
            }
        }
        return cnt;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            IslandsHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                IslandsHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class IslandsHarness {

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
                String[] kingdom = {".#...#.."};
                int expected__ = 4;

                return verifyCase(casenum__, expected__, new Islands().beachLength(kingdom));
            }
            case 1: {
                String[] kingdom = {"..#.##",
                    ".##.#.",
                    "#.#..."};
                int expected__ = 19;

                return verifyCase(casenum__, expected__, new Islands().beachLength(kingdom));
            }
            case 2: {
                String[] kingdom = {"#...#.....",
                    "##..#...#."};
                int expected__ = 15;

                return verifyCase(casenum__, expected__, new Islands().beachLength(kingdom));
            }
            case 3: {
                String[] kingdom = {"....#.",
                    ".#....",
                    "..#..#",
                    "####.."};
                int expected__ = 24;

                return verifyCase(casenum__, expected__, new Islands().beachLength(kingdom));
            }

            // custom cases

            /*      case 4: {
             String[] kingdom          = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new Islands().beachLength(kingdom));
             }*/
            /*      case 5: {
             String[] kingdom          = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new Islands().beachLength(kingdom));
             }*/
            /*      case 6: {
             String[] kingdom          = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new Islands().beachLength(kingdom));
             }*/
            default:
                return -1;
        }
    }
}

// END CUT HERE
