
public class ParallelepipedUnion {

    public int getVolume(String[] parallelepipeds) {

        int[] first = get(parallelepipeds[0]);
        int[] second = get(parallelepipeds[1]);
        int cnt = 0;
        for (int x = 0; x < 105; x++) {
            for (int y = 0; y < 105; y++) {
                for (int z = 0; z < 105; z++) {
                    if ((first[0] <= x && x < first[3] && first[1] <= y && y < first[4] && first[2] <= z && z < first[5])
                            || second[0] <= x && x < second[3] && second[1] <= y && y < second[4] && second[2] <= z && z < second[5]) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    int[] get(String in) {
        String[] sp = in.split(" ");
        return new int[]{Integer.parseInt(sp[0]), Integer.parseInt(sp[1]), Integer.parseInt(sp[2]), Integer.parseInt(sp[3]), Integer.parseInt(sp[4]), Integer.parseInt(sp[5])};
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            ParallelepipedUnionHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                ParallelepipedUnionHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class ParallelepipedUnionHarness {

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
                String[] parallelepipeds = {"1 1 1 4 4 2", "3 2 1 5 3 3"};
                int expected__ = 12;

                return verifyCase(casenum__, expected__, new ParallelepipedUnion().getVolume(parallelepipeds));
            }
            case 1: {
                String[] parallelepipeds = {"1 1 1 2 2 2", "3 3 3 4 4 4"};
                int expected__ = 2;

                return verifyCase(casenum__, expected__, new ParallelepipedUnion().getVolume(parallelepipeds));
            }
            case 2: {
                String[] parallelepipeds = {"1 10 20 5 15 23", "2 12 22 3 14 23"};
                int expected__ = 60;

                return verifyCase(casenum__, expected__, new ParallelepipedUnion().getVolume(parallelepipeds));
            }
            case 3: {
                String[] parallelepipeds = {"28 31 21 67 60 81", "60 1 21 67 50 81"};
                int expected__ = 80460;

                return verifyCase(casenum__, expected__, new ParallelepipedUnion().getVolume(parallelepipeds));
            }
            case 4: {
                String[] parallelepipeds = {"34 3 50 37 6 53", "36 1 51 38 4 55"};
                int expected__ = 49;

                return verifyCase(casenum__, expected__, new ParallelepipedUnion().getVolume(parallelepipeds));
            }

            // custom cases

            /*      case 5: {
             String[] parallelepipeds  = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new ParallelepipedUnion().getVolume(parallelepipeds));
             }*/
            /*      case 6: {
             String[] parallelepipeds  = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new ParallelepipedUnion().getVolume(parallelepipeds));
             }*/
            /*      case 7: {
             String[] parallelepipeds  = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new ParallelepipedUnion().getVolume(parallelepipeds));
             }*/
            default:
                return -1;
        }
    }
}

// END CUT HERE
