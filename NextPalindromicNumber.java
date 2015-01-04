
public class NextPalindromicNumber {

    public String getNext(String n) {
        char[] arr = n.toCharArray();
        int size = arr.length;
        boolean allNine = true;
        for (int i = 0; i < size; i++) {
            if (n.charAt(i) != '9') {
                allNine = false;
            }
        }
        if (allNine) {
            String res = "1";
            for (int i = 1; i < size; i++) {
                res += "0";
            }
            res += "1";
            return res;
        }
        //copy
        for (int i = size / 2; i < size; i++) {
            arr[i] = arr[size - i - 1];
        }
//        for (int i = 0; i < size; i++) {
//           System.err.print(arr[i]);
//        }
//        System.out.println();


        if (compare(arr, n.toCharArray()) == 1) {
            //System.out.println("check1");
            return toString(arr);
        } else {
            //System.out.println("check2");
            int left, right;
            if (size % 2 == 0) {
                left = (size - 1) / 2;
                right = (size) / 2;
            } else {
                left = size / 2;
                right = size / 2;
            }
            //System.out.println(n + " " + left + " " + right);
            while (left >= 0) {

                if (arr[left] >= '0' && arr[left] <= '8') {
                    arr[left] = (char) (arr[left] + 1);
                    arr[right] = arr[left];
                    break;
                } else {
                    arr[left] = '0';
                    arr[right] = '0';
                }
                left--;
                right++;
            }
        }

        return toString(arr);
    }

    String toString(char[] a) {
        String ret = "";
        for (int i = 0; i < a.length; i++) {
            ret += a[i];
        }
        return ret;
    }

    int compare(char[] a, char[] b) {
        if (a.length > b.length) {
            return 1;
        }
        if (a.length < b.length) {
            return -1;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] < b[i]) {
                return -1;
            }
            if (a[i] > b[i]) {
                return 1;
            }
        }
        return 0;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            NextPalindromicNumberHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                NextPalindromicNumberHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class NextPalindromicNumberHarness {

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

    static boolean compareOutput(String expected, String result) {
        return expected.equals(result);
    }

    static String formatResult(String res) {
        return String.format("\"%s\"", res);
    }

    static int verifyCase(int casenum, String expected, String received) {
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
                String n = "12345";
                String expected__ = "12421";

                return verifyCase(casenum__, expected__, new NextPalindromicNumber().getNext(n));
            }
            case 1: {
                String n = "858";
                String expected__ = "868";

                return verifyCase(casenum__, expected__, new NextPalindromicNumber().getNext(n));
            }
            case 2: {
                String n = "1999";
                String expected__ = "2002";

                return verifyCase(casenum__, expected__, new NextPalindromicNumber().getNext(n));
            }
            case 3: {
                String n = "1";
                String expected__ = "2";

                return verifyCase(casenum__, expected__, new NextPalindromicNumber().getNext(n));
            }
            case 4: {
                String n = "9999";
                String expected__ = "10001";

                return verifyCase(casenum__, expected__, new NextPalindromicNumber().getNext(n));
            }

            // custom cases

            /*      case 5: {
             String n                  = ;
             String expected__         = ;

             return verifyCase(casenum__, expected__, new NextPalindromicNumber().getNext(n));
             }*/
            /*      case 6: {
             String n                  = ;
             String expected__         = ;

             return verifyCase(casenum__, expected__, new NextPalindromicNumber().getNext(n));
             }*/
            /*      case 7: {
             String n                  = ;
             String expected__         = ;

             return verifyCase(casenum__, expected__, new NextPalindromicNumber().getNext(n));
             }*/
            default:
                return -1;
        }
    }
}

// END CUT HERE
