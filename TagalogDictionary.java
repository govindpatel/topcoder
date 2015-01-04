
import java.util.Arrays;

public class TagalogDictionary {

    public String[] sortWords(String[] words) {
        String[] arr = new String[]{"a", "b", "k", "d", "e", "g", "h", "i",
            "l", "m", "n", "ng", "o", "p", "r", "s", "t", "u", "w", "y"};
        String[] newWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            newWords[i] = "";
            while (words[i].length() > 0) {
                if (words[i].startsWith("ng")) {
                    newWords[i] += (char) ('a' + 11);
                    words[i] = words[i].substring(2);
                } else {
                    for (int j = 0; j < arr.length; j++) {
                        if (words[i].startsWith(arr[j])) {
                            newWords[i] += (char) ('a' + j);
                        }
                    }
                    words[i] = words[i].substring(1);
                }
            }
        }

        Arrays.sort(newWords);

        for (int i = 0; i < words.length; i++) {
            words[i] = "";
            for (int j = 0; j < newWords[i].length(); j++) {
                words[i] += arr[newWords[i].charAt(j) - 'a'];
            }
        }
        return words;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            TagalogDictionaryHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                TagalogDictionaryHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class TagalogDictionaryHarness {

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

    static boolean compareOutput(String[] expected, String[] result) {
        if (expected.length != result.length) {
            return false;
        }
        for (int i = 0; i < expected.length; ++i) {
            if (!expected[i].equals(result[i])) {
                return false;
            }
        }
        return true;
    }

    static String formatResult(String[] res) {
        String ret = "";
        ret += "{";
        for (int i = 0; i < res.length; ++i) {
            if (i > 0) {
                ret += ",";
            }
            ret += String.format(" \"%s\"", res[i]);
        }
        ret += " }";
        return ret;
    }

    static int verifyCase(int casenum, String[] expected, String[] received) {
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
                String[] words = {"abakada", "alpabet", "tagalog", "ako"};
                String[] expected__ = {"abakada", "ako", "alpabet", "tagalog"};

                return verifyCase(casenum__, expected__, new TagalogDictionary().sortWords(words));
            }
            case 1: {
                String[] words = {"ang", "ano", "anim", "alak", "alam", "alab"};
                String[] expected__ = {"alab", "alak", "alam", "anim", "ano", "ang"};

                return verifyCase(casenum__, expected__, new TagalogDictionary().sortWords(words));
            }
            case 2: {
                String[] words = {"siya", "niya", "kaniya", "ikaw", "ito", "iyon"};
                String[] expected__ = {"kaniya", "ikaw", "ito", "iyon", "niya", "siya"};

                return verifyCase(casenum__, expected__, new TagalogDictionary().sortWords(words));
            }
            case 3: {
                String[] words = {"kaba", "baka", "naba", "ngipin", "nipin"};
                String[] expected__ = {"baka", "kaba", "naba", "nipin", "ngipin"};

                return verifyCase(casenum__, expected__, new TagalogDictionary().sortWords(words));
            }
            case 4: {
                String[] words = {"knilngiggnngginggn", "ingkigningg", "kingkong", "dingdong", "dindong", "dingdont", "ingkblot"};
                String[] expected__ = {"kingkong", "knilngiggnngginggn", "dindong", "dingdont", "dingdong", "ingkblot", "ingkigningg"};

                return verifyCase(casenum__, expected__, new TagalogDictionary().sortWords(words));
            }
            case 5: {
                String[] words = {"silangang", "baka", "bada", "silang"};
                String[] expected__ = {"baka", "bada", "silang", "silangang"};

                return verifyCase(casenum__, expected__, new TagalogDictionary().sortWords(words));
            }

            // custom cases

            /*      case 6: {
             String[] words            = ;
             String[] expected__       = ;

             return verifyCase(casenum__, expected__, new TagalogDictionary().sortWords(words));
             }*/
            /*      case 7: {
             String[] words            = ;
             String[] expected__       = ;

             return verifyCase(casenum__, expected__, new TagalogDictionary().sortWords(words));
             }*/
            /*      case 8: {
             String[] words            = ;
             String[] expected__       = ;

             return verifyCase(casenum__, expected__, new TagalogDictionary().sortWords(words));
             }*/
            default:
                return -1;
        }
    }
}
// END CUT HERE

