public class DigitsSum {
   public int lastDigit(int n) {
	while(n>9){
            int sum = 0;
            while(n>0){
                sum += n%10;
                n = n/10;
            }
            n = sum;
        }
        return n;
   }






// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			DigitsSumHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				DigitsSumHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class DigitsSumHarness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum + " does not exist.");
			return;
		}
		
		int correct = 0, total = 0;
		for (int i=0;; ++i) {
			int x = runTestCase(i);
			if (x == -1) {
				if (i >= 100) break;
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
	
	static boolean compareOutput(int expected, int result) { return expected == result; }
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
		switch(casenum__) {
		case 0: {
			int n                     = 12345;
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new DigitsSum().lastDigit(n));
		}
		case 1: {
			int n                     = 6;
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new DigitsSum().lastDigit(n));
		}
		case 2: {
			int n                     = 999999999;
			int expected__            = 9;

			return verifyCase(casenum__, expected__, new DigitsSum().lastDigit(n));
		}
		case 3: {
			int n                     = 213413512;
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new DigitsSum().lastDigit(n));
		}
		case 4: {
			int n                     = 314;
			int expected__            = 8;

			return verifyCase(casenum__, expected__, new DigitsSum().lastDigit(n));
		}
		case 5: {
			int n                     = 2147483647;
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new DigitsSum().lastDigit(n));
		}

		// custom cases

/*      case 6: {
			int n                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new DigitsSum().lastDigit(n));
		}*/
/*      case 7: {
			int n                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new DigitsSum().lastDigit(n));
		}*/
/*      case 8: {
			int n                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new DigitsSum().lastDigit(n));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
