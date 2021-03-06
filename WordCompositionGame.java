public class WordCompositionGame {
   public String score(String[] listA, String[] listB, String[] listC) {
       int cnta=0;
       int cntb = 0;
       int cntc = 0;
       for(int i=0;i<listA.length;i++){
           int tot = 3;
           for(int j=0;j<listB.length;j++){
               if(listA[i].equals(listB[j])){
                   tot--;
                   break;
               }
           }
           for(int j=0;j<listC.length;j++){
               if(listA[i].equals(listC[j])){
                   tot--;
                   break;
               }
           }
           cnta+=tot;
       }
       
       for(int i=0;i<listB.length;i++){
           int tot = 3;
           for(int j=0;j<listA.length;j++){
               if(listB[i].equals(listA[j])){
                   tot--;
                   break;
               }
           }
           for(int j=0;j<listC.length;j++){
               if(listB[i].equals(listC[j])){
                   tot--;
                   break;
               }
           }
           cntb+=tot;
       }
       
       for(int i=0;i<listC.length;i++){
           int tot = 3;
           for(int j=0;j<listA.length;j++){
               if(listC[i].equals(listA[j])){
                   tot--;
                   break;
               }
           }
           for(int j=0;j<listB.length;j++){
               if(listC[i].equals(listB[j])){
                   tot--;
                   break;
               }
           }
           cntc+=tot;
       }
       
       return cnta+"/"+cntb+"/"+cntc;
   }






// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			WordCompositionGameHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				WordCompositionGameHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class WordCompositionGameHarness {
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
	
	static boolean compareOutput(String expected, String result) { return expected.equals(result); }
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
		switch(casenum__) {
		case 0: {
			String[] listA            = {"cat", "dog", "pig", "mouse"};
			String[] listB            = {"cat", "pig"};
			String[] listC            = {"dog", "cat"};
			String expected__         = "8/3/3";

			return verifyCase(casenum__, expected__, new WordCompositionGame().score(listA, listB, listC));
		}
		case 1: {
			String[] listA            = {"mouse"};
			String[] listB            = {"cat", "pig"};
			String[] listC            = {"dog", "cat"};
			String expected__         = "3/5/5";

			return verifyCase(casenum__, expected__, new WordCompositionGame().score(listA, listB, listC));
		}
		case 2: {
			String[] listA            = {"dog", "mouse"};
			String[] listB            = {"dog", "pig"};
			String[] listC            = {"dog", "cat"};
			String expected__         = "4/4/4";

			return verifyCase(casenum__, expected__, new WordCompositionGame().score(listA, listB, listC));
		}
		case 3: {
			String[] listA            = {"bcdbb","aaccd","dacbc","bcbda","cdedc","bbaaa","aecae"};
			String[] listB            = {"bcdbb","ddacb","aaccd","adcab","edbee","aecae","bcbda"};
			String[] listC            = {"dcaab","aadbe","bbaaa","ebeec","eaecb","bcbba","aecae","adcab","bcbda"};
			String expected__         = "14/14/21";

			return verifyCase(casenum__, expected__, new WordCompositionGame().score(listA, listB, listC));
		}

		// custom cases

/*      case 4: {
			String[] listA            = ;
			String[] listB            = ;
			String[] listC            = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new WordCompositionGame().score(listA, listB, listC));
		}*/
/*      case 5: {
			String[] listA            = ;
			String[] listB            = ;
			String[] listC            = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new WordCompositionGame().score(listA, listB, listC));
		}*/
/*      case 6: {
			String[] listA            = ;
			String[] listB            = ;
			String[] listC            = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new WordCompositionGame().score(listA, listB, listC));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
