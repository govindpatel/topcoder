
import java.util.*;

public class FibonacciKnapsack {

    class Item implements Comparable<Item> {

        long wg;
        long cst;

        public Item(String in) {
            String[] item = in.split(" ");
            wg = Long.parseLong(item[0]);
            cst = Long.parseLong(item[1]);
        }

        @Override
        public int compareTo(Item sec) {
            if (wg == sec.wg) {
                return (int) Math.signum(sec.cst - cst);
            }
            return (int) Math.signum(sec.wg - wg);
        }

        @Override
        public String toString() {
            return wg + " " + cst;
        }
    }
    int N;
    long[] wSum;
    long[] cSum;
    Item[] item;

    public long maximalCost(String[] items, String C) {
        N = items.length;
        wSum = new long[N + 1];
        cSum = new long[N + 1];
        item = new Item[N];
        for (int i = 0; i < N; i++) {
            item[i] = new Item(items[i]);
        }
        Arrays.sort(item);
        //for (int i = 0; i < N; i++) {
        //     System.out.println(item[i]);
        // }
        //System.out.println(" ");
        for (int i = N - 1; i >= 0; i--) {
            wSum[i] = item[i].wg + wSum[i + 1];
            cSum[i] = item[i].cst + cSum[i + 1];
            //System.out.println(i + " " + wSum[i] + " " + cSum[i]);
        }


        return go(0, Long.parseLong(C));
        //return 0;
    }
    HashMap<String, Long> memo = new HashMap<String, Long>();

    long go(int pos, long W) {
        if (W <= 0) {
            return 0;
        }
        if (wSum[pos] <= W) {
            return cSum[pos];
        }
        String key = pos + " " + W;
        if (memo.containsKey(key)) {
            // System.out.println("Helpful");
            return memo.get(key);
        }
        long ret = go(pos + 1, W);
        if (W >= item[pos].wg) {
            ret = Math.max(ret, item[pos].cst + go(pos + 1, W - item[pos].wg));
        }
        memo.put(key, ret);
        return ret;
    }
// BEGIN CUT HERE

    public static void main(String[] args) {
        if (args.length == 0) {
            FibonacciKnapsackHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                FibonacciKnapsackHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class FibonacciKnapsackHarness {

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

    static boolean compareOutput(long expected, long result) {
        return expected == result;
    }

    static String formatResult(long res) {
        return String.format("%d", res);
    }

    static int verifyCase(int casenum, long expected, long received) {
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
                String[] items = {"5 555", "8 195", "13 651"};
                String C = "15";
                long expected__ = 750;

                return verifyCase(casenum__, expected__, new FibonacciKnapsack().maximalCost(items, C));
            }
            case 1: {
                String[] items = {"5 555", "8 195", "13 751"};
                String C = "15";
                long expected__ = 751;

                return verifyCase(casenum__, expected__, new FibonacciKnapsack().maximalCost(items, C));
            }
            case 2: {
                String[] items = {"55 1562", "5 814", "55 1962", "8 996", "2 716", "34 1792"};
                String C = "94";
                long expected__ = 4568;

                return verifyCase(casenum__, expected__, new FibonacciKnapsack().maximalCost(items, C));
            }
            case 3: {
                String[] items = {"13 89"};
                String C = "1";
                long expected__ = 0;

                return verifyCase(casenum__, expected__, new FibonacciKnapsack().maximalCost(items, C));
            }
            case 4: {
                String[] items = {"27777890035288 9419696870097445",
                    "53316291173 6312623457097563",
                    "165580141 8848283653257131"};
                String C = "27777900000000";
                long expected__ = 15160907110354694L;

                return verifyCase(casenum__, expected__, new FibonacciKnapsack().maximalCost(items, C));
            }

            // custom cases

            /*      case 5: {
             String[] items            = ;
             String C                  = ;
             long expected__           = ;

             return verifyCase(casenum__, expected__, new FibonacciKnapsack().maximalCost(items, C));
             }*/
            /*      case 6: {
             String[] items            = ;
             String C                  = ;
             long expected__           = ;

             return verifyCase(casenum__, expected__, new FibonacciKnapsack().maximalCost(items, C));
             }*/
            /*      case 7: {
             String[] items            = ;
             String C                  = ;
             long expected__           = ;

             return verifyCase(casenum__, expected__, new FibonacciKnapsack().maximalCost(items, C));
             }*/
            default:
                return -1;
        }
    }
}

// END CUT HERE
