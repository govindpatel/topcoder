
public class FibonacciPositioning {

    public double getFPosition(int n) {
        long[] fib = new long[50];
        fib[1] = 1;
        fib[2] = 1;
        for (int i = 3; i < 45; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        //print(fib);
        if(n==1)return 2.0;
        int ind = -1;
        for(int i=3;i<45;i++){
            if(fib[i]>n)break;
            if(fib[i]==n)return i*1.0;
            ind=i;
        }
        
        return ind + (n-fib[ind])*1.0/(fib[ind+1]-fib[ind])*1.0;
    }

// BEGIN CUT HERE
    void print(long[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            FibonacciPositioningHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                FibonacciPositioningHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class FibonacciPositioningHarness {

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
    static final double MAX_DOUBLE_ERROR = 1E-9;

    static boolean compareOutput(double expected, double result) {
        if (Double.isNaN(expected)) {
            return Double.isNaN(result);
        } else if (Double.isInfinite(expected)) {
            if (expected > 0) {
                return result > 0 && Double.isInfinite(result);
            } else {
                return result < 0 && Double.isInfinite(result);
            }
        } else if (Double.isNaN(result) || Double.isInfinite(result)) {
            return false;
        } else if (Math.abs(result - expected) < MAX_DOUBLE_ERROR) {
            return true;
        } else {
            double min = Math.min(expected * (1.0 - MAX_DOUBLE_ERROR), expected * (1.0 + MAX_DOUBLE_ERROR));
            double max = Math.max(expected * (1.0 - MAX_DOUBLE_ERROR), expected * (1.0 + MAX_DOUBLE_ERROR));
            return result > min && result < max;
        }
    }

    static double relativeError(double expected, double result) {
        if (Double.isNaN(expected) || Double.isInfinite(expected) || Double.isNaN(result) || Double.isInfinite(result) || expected == 0) {
            return 0;
        }
        return Math.abs(result - expected) / Math.abs(expected);
    }

    static String formatResult(double res) {
        return String.format("%.10g", res);
    }

    static int verifyCase(int casenum, double expected, double received) {
        System.err.print("Example " + casenum + "... ");
        if (compareOutput(expected, received)) {
            System.err.print("PASSED");
            double rerr = relativeError(expected, received);
            if (rerr > 0) {
                System.err.printf(" (relative error %g)", rerr);
            }
            System.err.println();
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
                int n = 1;
                double expected__ = 2.0;

                return verifyCase(casenum__, expected__, new FibonacciPositioning().getFPosition(n));
            }
            case 1: {
                int n = 5;
                double expected__ = 5.0;

                return verifyCase(casenum__, expected__, new FibonacciPositioning().getFPosition(n));
            }
            case 2: {
                int n = 4;
                double expected__ = 4.5;

                return verifyCase(casenum__, expected__, new FibonacciPositioning().getFPosition(n));
            }
            case 3: {
                int n = 100;
                double expected__ = 11.2;

                return verifyCase(casenum__, expected__, new FibonacciPositioning().getFPosition(n));
            }

            // custom cases

            /*      case 4: {
             int n                     = ;
             double expected__         = ;

             return verifyCase(casenum__, expected__, new FibonacciPositioning().getFPosition(n));
             }*/
            /*      case 5: {
             int n                     = ;
             double expected__         = ;

             return verifyCase(casenum__, expected__, new FibonacciPositioning().getFPosition(n));
             }*/
            /*      case 6: {
             int n                     = ;
             double expected__         = ;

             return verifyCase(casenum__, expected__, new FibonacciPositioning().getFPosition(n));
             }*/
            default:
                return -1;
        }
    }
}

// END CUT HERE
