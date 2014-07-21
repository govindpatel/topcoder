public class HuffmanDecoding {
   public String decode(String archive, String[] dictionary) {
	String result = "";
        while(archive.length()>0){
            for(int i=0;i<dictionary.length;i++){
                if(archive.startsWith(dictionary[i])){
                    archive = archive.substring(dictionary[i].length());
                    result += (char)('A'+i);
                    continue;
                }
            }
        }
        return result;
   }






// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			HuffmanDecodingHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				HuffmanDecodingHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class HuffmanDecodingHarness {
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
			String archive            = "101101";
			String[] dictionary       = {"00","10","01","11"};
			String expected__         = "BDC";

			return verifyCase(casenum__, expected__, new HuffmanDecoding().decode(archive, dictionary));
		}
		case 1: {
			String archive            = "10111010";
			String[] dictionary       = {"0","111","10"};
			String expected__         = "CBAC";

			return verifyCase(casenum__, expected__, new HuffmanDecoding().decode(archive, dictionary));
		}
		case 2: {
			String archive            = "0001001100100111001";
			String[] dictionary       = {"1","0"};
			String expected__         = "BBBABBAABBABBAAABBA";

			return verifyCase(casenum__, expected__, new HuffmanDecoding().decode(archive, dictionary));
		}
		case 3: {
			String archive            = "111011011000100110";
			String[] dictionary       = {"010","00","0110","0111","11","100","101"};
			String expected__         = "EGGFAC";

			return verifyCase(casenum__, expected__, new HuffmanDecoding().decode(archive, dictionary));
		}
		case 4: {
			String archive            = "001101100101100110111101011001011001010";
			String[] dictionary       = {"110","011","10","0011","00011","111","00010","0010","010","0000"};
			String expected__         = "DBHABBACAIAIC";

			return verifyCase(casenum__, expected__, new HuffmanDecoding().decode(archive, dictionary));
		}

		// custom cases

/*      case 5: {
			String archive            = ;
			String[] dictionary       = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new HuffmanDecoding().decode(archive, dictionary));
		}*/
/*      case 6: {
			String archive            = ;
			String[] dictionary       = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new HuffmanDecoding().decode(archive, dictionary));
		}*/
/*      case 7: {
			String archive            = ;
			String[] dictionary       = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new HuffmanDecoding().decode(archive, dictionary));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
