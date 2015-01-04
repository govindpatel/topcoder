
import java.util.*;

public class SolitaireSimulation {

    public int periodLength(int[] heaps) {
        //int[] n = runner(heaps);
        //int[] t = runner(heaps);
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        //print(t);
        map.put(key(heaps), 0);
        //System.out.println("Initial : " + key(heaps));

        for (int i = 1;; i++) {
            int[] nNew = runner(heaps);
            long key = key(nNew);

            //print(nNew);
            //System.out.println(key);

            if (map.containsKey(key)) {
                int ind = map.get(key);
                //System.out.println("Res : " + (ind - i) + " " + ind);
                //print(nNew);
                return i - ind;
            }
            map.put(key, i);
            heaps = nNew;
        }
    }

    long key(int[] a) {
        Arrays.sort(a);
        long ret = 0;
        for (int i = 0; i < a.length; i++) {
            ret = ret * 7L + a[i];
        }
        return ret;
    }

    void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\n");
    }

    int[] runner(int[] p) {
        int[] ret = new int[p.length + 1];
        int cnt = 0;
        for (int i = 0; i < p.length; i++) {
            ret[i] = p[i] - 1;
            if (ret[i] == 0) {
                cnt++;
            }
        }
        ret[p.length] = p.length;
        int[] nret = new int[p.length + 1 - cnt];
        int j = 0;
        for (int i = 0; i < ret.length; i++) {
            if (ret[i] != 0) {
                nret[j] = ret[i];
                j++;
            }
        }
        return nret;
    }

    boolean equals(int[] h1, int[] h2) {
        int[] res = new int[100];
        for (int i = 0; i < h1.length; i++) {
            if (h1[i] != 0) {
                res[h1[i]]++;
            }
        }
        for (int i = 0; i < h2.length; i++) {
            if (h2[i] != 0) {
                res[h2[i]]--;
            }
        }
        for (int i = 1; i < 100; i++) {
            if (res[i] != 0) {
                return false;
            }
        }
        return true;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            SolitaireSimulationHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                SolitaireSimulationHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class SolitaireSimulationHarness {

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
                int[] heaps = {3, 1, 3};
                int expected__ = 4;

                return verifyCase(casenum__, expected__, new SolitaireSimulation().periodLength(heaps));
            }
            case 1: {
                int[] heaps = {1, 4};
                int expected__ = 3;

                return verifyCase(casenum__, expected__, new SolitaireSimulation().periodLength(heaps));
            }
            case 2: {
                int[] heaps = {1};
                int expected__ = 1;

                return verifyCase(casenum__, expected__, new SolitaireSimulation().periodLength(heaps));
            }
            case 3: {
                int[] heaps = {4, 3, 2, 1};
                int expected__ = 1;

                return verifyCase(casenum__, expected__, new SolitaireSimulation().periodLength(heaps));
            }
            case 4: {
                int[] heaps = {3, 3, 3, 3};
                int expected__ = 5;

                return verifyCase(casenum__, expected__, new SolitaireSimulation().periodLength(heaps));
            }

            // custom cases

            /*      case 5: {
             int[] heaps               = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new SolitaireSimulation().periodLength(heaps));
             }*/
            /*      case 6: {
             int[] heaps               = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new SolitaireSimulation().periodLength(heaps));
             }*/
            /*      case 7: {
             int[] heaps               = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new SolitaireSimulation().periodLength(heaps));
             }*/
            default:
                return -1;
        }
    }
}
// END CUT HERE

