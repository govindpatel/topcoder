
import java.util.*;

public class BracketExpressions {
//hack this... I know there is something wrong....

    char[] sets = new char[]{'(', ')', '{', '}', '[', ']'};
    boolean flag = false;

    public String ifPossible(String expression) {
        run(expression);
        if (flag) {
            return "possible";
        }
        return "impossible";
    }

    void run(String expression) {
        int i = 0;
        if (expression.indexOf('X') >= 0) {
            i = expression.indexOf('X');
            String first = expression.substring(0, i);
            String last = expression.substring(i + 1);
            for (int j = 0; j < sets.length; j++) {
                run(first + sets[j] + last);
            }
        } else {
            flag = flag || check(expression);
            //System.out.println(expression);
        }
    }

    boolean check(String in) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < in.length(); i++) {
            char now = in.charAt(i);
            if (stack.isEmpty()) {
                if (now == '}' || now == ')' || now == ']') {
                    return false;
                }
                stack.push(now);
            } else {
                char last = stack.peek();
                if (last == '(' && now == ')') {
                    stack.pop();
                    continue;
                }
                if (last == '{' && now == '}') {
                    stack.pop();
                    continue;
                }
                if (last == '[' && now == ']') {
                    stack.pop();
                    continue;
                }
                if (now == '(' || now == '[' || now == '{') {
                    stack.push(now);
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            BracketExpressionsHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                BracketExpressionsHarness.run_test(Integer.valueOf(args[i]));






            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class BracketExpressionsHarness {

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
                String expression = "([]{})";
                String expected__ = "possible";

                return verifyCase(casenum__, expected__, new BracketExpressions().ifPossible(expression));
            }
            case 1: {
                String expression = "(())[]";
                String expected__ = "possible";

                return verifyCase(casenum__, expected__, new BracketExpressions().ifPossible(expression));
            }
            case 2: {
                String expression = "({])";
                String expected__ = "impossible";

                return verifyCase(casenum__, expected__, new BracketExpressions().ifPossible(expression));
            }
            case 3: {
                String expression = "[]X";
                String expected__ = "impossible";

                return verifyCase(casenum__, expected__, new BracketExpressions().ifPossible(expression));
            }
            case 4: {
                String expression = "([]X()[()]XX}[])X{{}}]";
                String expected__ = "possible";

                return verifyCase(casenum__, expected__, new BracketExpressions().ifPossible(expression));
            }

            // custom cases

            /*case 5: {
             String expression = "[[{}{X[]][X][{()(){}[]}[(X[{}{}X()()][{}X{[]}()]()";
             String expected__ = "impossible";

             return verifyCase(casenum__, expected__, new BracketExpressions().ifPossible(expression));
             }*/
            /*      case 6: {
             String expression         = ;
             String expected__         = ;

             return verifyCase(casenum__, expected__, new BracketExpressions().ifPossible(expression));
             }*/
            /*      case 7: {
             String expression         = ;
             String expected__         = ;

             return verifyCase(casenum__, expected__, new BracketExpressions().ifPossible(expression));
             }*/
            default:
                return -1;
        }
    }
}
// END CUT HERE

