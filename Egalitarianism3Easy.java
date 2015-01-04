
import java.util.*;

public class Egalitarianism3Easy {

    public int maxCities(int n, int[] a, int[] b, int[] len) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 1 << 20);
        }
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }
        for (int i = 0; i < len.length; i++) {
            dist[a[i] - 1][b[i] - 1] = len[i];
            dist[b[i] - 1][a[i] - 1] = len[i];
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dist[i][j] + " ");
//            }
//            System.out.println();
//        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int ans = 1;
        for (int mask = 1; mask < (1 << n); mask++) {
            HashSet<Integer> hs = new HashSet<Integer>();
            for (int i = 0; i < n; i++) {
                if ((1 << i & mask) != 0) {
                    for (int j = 0; j < n; j++) {
                        if (i != j && (1 << j & mask) != 0) {
                            hs.add(dist[i][j]);
                        }
                    }
                }
            }
            if (hs.size() == 1) {
                ans = Math.max(ans, Integer.bitCount(mask));
            }
        }
        return ans;

    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            Egalitarianism3EasyHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                Egalitarianism3EasyHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class Egalitarianism3EasyHarness {

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
                int n = 4;
                int[] a = {1, 1, 1};
                int[] b = {2, 3, 4};
                int[] len = {1, 1, 1};
                int expected__ = 3;

                return verifyCase(casenum__, expected__, new Egalitarianism3Easy().maxCities(n, a, b, len));
            }
            case 1: {
                int n = 6;
                int[] a = {1, 2, 3, 2, 3};
                int[] b = {2, 3, 4, 5, 6};
                int[] len = {2, 1, 3, 2, 3};
                int expected__ = 3;

                return verifyCase(casenum__, expected__, new Egalitarianism3Easy().maxCities(n, a, b, len));
            }
            case 2: {
                int n = 10;
                int[] a = {1, 1, 1, 1, 1, 1, 1, 1, 1};
                int[] b = {2, 3, 4, 5, 6, 7, 8, 9, 10};
                int[] len = {1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000};
                int expected__ = 9;

                return verifyCase(casenum__, expected__, new Egalitarianism3Easy().maxCities(n, a, b, len));
            }
            case 3: {
                int n = 2;
                int[] a = {1};
                int[] b = {2};
                int[] len = {3};
                int expected__ = 2;

                return verifyCase(casenum__, expected__, new Egalitarianism3Easy().maxCities(n, a, b, len));
            }
            case 4: {
                int n = 1;
                int[] a = {};
                int[] b = {};
                int[] len = {};
                int expected__ = 1;

                return verifyCase(casenum__, expected__, new Egalitarianism3Easy().maxCities(n, a, b, len));
            }

            // custom cases

            /*      case 5: {
             int n                     = ;
             int[] a                   = ;
             int[] b                   = ;
             int[] len                 = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new Egalitarianism3Easy().maxCities(n, a, b, len));
             }*/
            /*      case 6: {
             int n                     = ;
             int[] a                   = ;
             int[] b                   = ;
             int[] len                 = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new Egalitarianism3Easy().maxCities(n, a, b, len));
             }*/
            /*      case 7: {
             int n                     = ;
             int[] a                   = ;
             int[] b                   = ;
             int[] len                 = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new Egalitarianism3Easy().maxCities(n, a, b, len));
             }*/
            default:
                return -1;
        }
    }
}
// END CUT HERE

