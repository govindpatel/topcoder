
import java.util.*;

public class SmoothNumbers {

    public int countSmoothNumbers(int N, int k) {
        int cnt = 0;

        boolean[] primes = new boolean[100006];
        Arrays.fill(primes, true);
        int[] res = new int[1000];
        int size = 0;
        for (int i = 2; i * i < 100006; i++) {
            if (primes[i]) {
                res[size] = i;
                size++;
                for (int j = i * i; j < 100006; j += i) {
                    primes[j] = false;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (largePrime(i, res, size) <= k) {
                cnt++;
            }
        }
        return cnt;
    }

    int largePrime(int number, int[] primes, int size) {
        if (number == 1) {
            return 1;
        }
        int large = 0;
        for (int i = 0; i < size; i++) {
            while (number % primes[i] == 0) {
                number /= primes[i];
                large = primes[i];
            }
        }
        return number != 1 ? number : large;
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            SmoothNumbersHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                SmoothNumbersHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class SmoothNumbersHarness {

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
                int N = 10;
                int k = 3;
                int expected__ = 7;

                return verifyCase(casenum__, expected__, new SmoothNumbers().countSmoothNumbers(N, k));
            }
            case 1: {
                int N = 10;
                int k = 4;
                int expected__ = 7;

                return verifyCase(casenum__, expected__, new SmoothNumbers().countSmoothNumbers(N, k));
            }
            case 2: {
                int N = 15;
                int k = 3;
                int expected__ = 8;

                return verifyCase(casenum__, expected__, new SmoothNumbers().countSmoothNumbers(N, k));
            }
            case 3: {
                int N = 5;
                int k = 20;
                int expected__ = 5;

                return verifyCase(casenum__, expected__, new SmoothNumbers().countSmoothNumbers(N, k));
            }
            case 4: {
                int N = 100000;
                int k = 100;
                int expected__ = 17442;

                return verifyCase(casenum__, expected__, new SmoothNumbers().countSmoothNumbers(N, k));
            }

            // custom cases

            /*      case 5: {
             int N                     = ;
             int k                     = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new SmoothNumbers().countSmoothNumbers(N, k));
             }*/
            /*      case 6: {
             int N                     = ;
             int k                     = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new SmoothNumbers().countSmoothNumbers(N, k));
             }*/
            /*      case 7: {
             int N                     = ;
             int k                     = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new SmoothNumbers().countSmoothNumbers(N, k));
             }*/
            default:
                return -1;
        }
    }
}

// END CUT HERE
