
public class KnightsTour {

    public int visitedPositions(String[] _board) {
        int posI = -1, posJ = -1;
        boolean[][] board = new boolean[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (_board[i].charAt(j) == 'K') {
                    posI = i;
                    posJ = j;
                }
                if (_board[i].charAt(j) == '*') {
                    board[i][j] = false;
                } else {
                    board[i][j] = true;
                }
            }
        }
        int cnt = 0;
        while (true) {
            cnt++;
            int nI = -100;
            int nJ = -100;
            int adj = 100;
            board[posI][posJ] = false;
            for (int i = -2; i <= 2; i++) {
                for (int j = -2; j <= 2; j++) {
                    if (Math.abs(i) + Math.abs(j) == 3) {
                        int ni = i + posI;
                        int nj = j + posJ;
                        int nadj = check(ni, nj, board);
                        if (nadj < adj) {
                            nI = ni;
                            nJ = nj;
                            adj = nadj;
                        } else if (nadj == adj && ni < nI) {
                            nI = ni;
                            nJ = nj;
                        } else if (nadj == adj && ni == nI && nj < nJ) {
                            nJ = nj;
                        }
                    }
                }
            }
            if (adj == 100) {
                return cnt;
            }
            posI = nI;
            posJ = nJ;
        }
        //return cnt;
    }

    int check(int ii, int jj, boolean[][] b) {
        int cnt = 0;
        if (ii < 0 || jj < 0 || ii >= 8 || jj >= 8) {
            return Integer.MAX_VALUE;
        }
        if (!b[ii][jj]) {
            return Integer.MAX_VALUE;
        }
        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                if (Math.abs(i) + Math.abs(j) == 3) {
                    int ni = i + ii;
                    int nj = j + jj;
                    if (ni >= 0 && ni < 8 && nj >= 0 && nj < 8 && b[ni][nj]) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            KnightsTourHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                KnightsTourHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class KnightsTourHarness {

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
                String[] board = {"........", ".*.*....", ".*......", "..K...*.", "*...*...", "...*....", "...*.*..", "........"};
                int expected__ = 39;

                return verifyCase(casenum__, expected__, new KnightsTour().visitedPositions(board));
            }
            case 1: {
                String[] board = {"K.......", "........", "........", "........", "........", "........", "........", "........"};
                int expected__ = 64;

                return verifyCase(casenum__, expected__, new KnightsTour().visitedPositions(board));
            }
            case 2: {
                String[] board = {"********", "*******.", "********", "**.***.*", "********", "***.*.**", "********", "****K***"};
                int expected__ = 3;

                return verifyCase(casenum__, expected__, new KnightsTour().visitedPositions(board));
            }
            case 3: {
                String[] board = {"*.*....*", ".......*", "**...*..", "..***...", ".**.*...", "..*.*..K", "..***.*.", "**...*.."};
                int expected__ = 17;

                return verifyCase(casenum__, expected__, new KnightsTour().visitedPositions(board));
            }
            case 4: {
                String[] board = {"..*...*.", "**.....*", "*..*....", "*..*....", ".....*..", "....*..K", "**.*...*", "..**...."};
                int expected__ = 27;

                return verifyCase(casenum__, expected__, new KnightsTour().visitedPositions(board));
            }

            // custom cases

            /*      case 5: {
             String[] board            = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new KnightsTour().visitedPositions(board));
             }*/
            /*      case 6: {
             String[] board            = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new KnightsTour().visitedPositions(board));
             }*/
            /*      case 7: {
             String[] board            = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new KnightsTour().visitedPositions(board));
             }*/
            default:
                return -1;
        }
    }
}

// END CUT HERE
