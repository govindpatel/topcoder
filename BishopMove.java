
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BishopMove {

    int[][] board;

    public int howManyMoves(int r1, int c1, int r2, int c2) {
        board = new int[8][8];
        for (int i = 0; i < 8; i++) {
            Arrays.fill(board[i], Integer.MAX_VALUE);
        }
        board[r1][c1] = 0;
        boolean[][] visited = new boolean[8][8];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(r1);
        q.add(c1);
        while (!q.isEmpty()) {
            int r = q.poll();
            int c = q.poll();
            if (visited[r][c]) {
                continue;
            }
            int val = board[r][c];
            visited[r][c] = true;
            for (int k = 0; k < 8; k++) {
                if (valid(r + k, c + k)) {
                    board[r + k][ c + k] = Math.min(board[r + k][c + k], val + 1);
                    q.add(r + k);
                    q.add(c + k);
                }
            }
            for (int k = 0; k < 8; k++) {
                if (valid(r + k, c - k)) {
                    board[r + k][ c - k] = Math.min(board[r + k][c - k], val + 1);
                    q.add(r + k);
                    q.add(c - k);
                }
            }
            for (int k = 0; k < 8; k++) {
                if (valid(r - k, c + k)) {
                    board[r - k][ c + k] = Math.min(board[r - k][c + k], val + 1);
                    q.add(r - k);
                    q.add(c + k);
                }
            }
            for (int k = 0; k < 8; k++) {
                if (valid(r - k, c - k)) {
                    board[r - k][ c - k] = Math.min(board[r - k][c - k], val + 1);
                    q.add(r - k);
                    q.add(c - k);
                }
            }
        }
        return board[r2][c2] == Integer.MAX_VALUE ? -1 : board[r2][c2];
    }

    void bfs(int r, int c, int val) {
        if (!valid(r, c)) {
            return;
        }

        board[r][c] = Math.min(val, board[r][c]);
        for (int k = 0; k < 8; k++) {
            if (valid(r + k, c + k)) {
                bfs(r + k, c + k, val + 1);
            }
        }
        for (int k = 0; k < 8; k++) {
            if (valid(r + k, c - k)) {
                bfs(r + k, c + k, val + 1);
            }
        }
        for (int k = 0; k < 8; k++) {
            if (valid(r - k, c + k)) {
                bfs(r + k, c + k, val + 1);
            }
        }
        for (int k = 0; k < 8; k++) {
            if (valid(r - k, c - k)) {
                bfs(r + k, c + k, val + 1);
            }
        }
    }

    boolean valid(int r, int c) {
        return r >= 0 && c >= 0 && r < 8 && c < 8;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            BishopMoveHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                BishopMoveHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class BishopMoveHarness {

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
                int r1 = 4;
                int c1 = 6;
                int r2 = 7;
                int c2 = 3;
                int expected__ = 1;

                return verifyCase(casenum__, expected__, new BishopMove().howManyMoves(r1, c1, r2, c2));
            }
            case 1: {
                int r1 = 2;
                int c1 = 5;
                int r2 = 2;
                int c2 = 5;
                int expected__ = 0;

                return verifyCase(casenum__, expected__, new BishopMove().howManyMoves(r1, c1, r2, c2));
            }
            case 2: {
                int r1 = 1;
                int c1 = 3;
                int r2 = 5;
                int c2 = 5;
                int expected__ = 2;

                return verifyCase(casenum__, expected__, new BishopMove().howManyMoves(r1, c1, r2, c2));
            }
            case 3: {
                int r1 = 4;
                int c1 = 6;
                int r2 = 7;
                int c2 = 4;
                int expected__ = -1;

                return verifyCase(casenum__, expected__, new BishopMove().howManyMoves(r1, c1, r2, c2));
            }

            // custom cases

            /*      case 4: {
             int r1                    = ;
             int c1                    = ;
             int r2                    = ;
             int c2                    = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new BishopMove().howManyMoves(r1, c1, r2, c2));
             }*/
            /*      case 5: {
             int r1                    = ;
             int c1                    = ;
             int r2                    = ;
             int c2                    = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new BishopMove().howManyMoves(r1, c1, r2, c2));
             }*/
            /*      case 6: {
             int r1                    = ;
             int c1                    = ;
             int r2                    = ;
             int c2                    = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new BishopMove().howManyMoves(r1, c1, r2, c2));
             }*/
            default:
                return -1;
        }
    }
}

// END CUT HERE
