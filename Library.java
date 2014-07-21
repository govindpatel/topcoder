import java.util.*;
public class Library {

    public int documentAccess(String[] records, String[] userGroups, String[] roomRights) {
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < records.length; i++) {
            String[] details = records[i].split(" ");
            if (find(userGroups, details[2]) && find(roomRights, details[1])) {
                set.add(details[0]);
            }
        }
        return set.size();
    }

    boolean find(String[] array, String search) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(search)) {
                return true;
            }
        }
        return false;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            LibraryHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                LibraryHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class LibraryHarness {

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
                String[] records = {"diary computers editor", "fairytale gardening editor", "comix cars author", "comix cars librarian"};
                String[] userGroups = {"employee", "editor", "author"};
                String[] roomRights = {"history", "cars", "computers"};
                int expected__ = 2;

                return verifyCase(casenum__, expected__, new Library().documentAccess(records, userGroups, roomRights));
            }
            case 1: {
                String[] records = {"diary computers editor", "fairytale gardening editor", "comix cars author", "comix cars librarian"};
                String[] userGroups = {"employee", "editor", "author", "librarian"};
                String[] roomRights = {"history", "cars", "computers"};
                int expected__ = 2;

                return verifyCase(casenum__, expected__, new Library().documentAccess(records, userGroups, roomRights));
            }
            case 2: {
                String[] records = {"diary computers editor", "fairytale gardening editor", "comix cars author", "comix cars librarian"};
                String[] userGroups = {"employee", "editor", "author", "librarian"};
                String[] roomRights = {};
                int expected__ = 0;

                return verifyCase(casenum__, expected__, new Library().documentAccess(records, userGroups, roomRights));
            }
            case 3: {
                String[] records = {"a b c", "a b d", "b b c", "b b d", "e c d", "e c b", "e c c", "t d e"};
                String[] userGroups = {"c", "d", "x"};
                String[] roomRights = {"a", "b", "c"};
                int expected__ = 3;

                return verifyCase(casenum__, expected__, new Library().documentAccess(records, userGroups, roomRights));
            }

            // custom cases

            /*      case 4: {
             String[] records          = ;
             String[] userGroups       = ;
             String[] roomRights       = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new Library().documentAccess(records, userGroups, roomRights));
             }*/
            /*      case 5: {
             String[] records          = ;
             String[] userGroups       = ;
             String[] roomRights       = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new Library().documentAccess(records, userGroups, roomRights));
             }*/
            /*      case 6: {
             String[] records          = ;
             String[] userGroups       = ;
             String[] roomRights       = ;
             int expected__            = ;

             return verifyCase(casenum__, expected__, new Library().documentAccess(records, userGroups, roomRights));
             }*/
            default:
                return -1;
        }
    }
}

// END CUT HERE
