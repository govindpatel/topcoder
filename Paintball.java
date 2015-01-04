
import java.util.*;

public class Paintball {

    class Team implements Comparable<Team> {

        String teamName;
        int score;
        ArrayList<Player> players;

        Team(String name) {
            teamName = name;
            score = 0;
            players = new ArrayList<Player>();
        }

        public void addPlayer(String name) {
            Player p = new Player(name);
            players.add(p);
        }

        public int compareTo(Team other) {
            if (score != other.score) {
                return -(score - other.score);
            }
            return teamName.compareTo(other.teamName);
        }

        public ArrayList<Player> getPlayerList() {
            Collections.sort(players);
            return players;
        }

        void addScore(String name, int d) {
            score += d;
            for (Player p : players) {
                if (p.name.equals(name)) {
                    p.addScore(d);
                }
            }
        }

        public String toString() {
            return teamName + " " + score;
        }
    }

    class Player implements Comparable<Player> {

        String name;
        int score;

        Player(String n) {
            name = n;
            score = 0;
        }

        void addScore(int d) {
            score += d;
        }

        public int compareTo(Player other) {
            if (score != other.score) {
                return -(score - other.score);
            }
            return name.compareTo(other.name);
        }

        public String toString() {
            return "  " + name + " " + score;
        }
    }

    public String[] getLeaderboard(String[] players, String[] messages) {
        HashMap<String, Team> team = new HashMap<String, Team>();
        HashMap<String, String> player_team = new HashMap<String, String>();
        ArrayList<Team> ordered_team = new ArrayList<Team>();
        for (String player : players) {
            StringTokenizer st = new StringTokenizer(player);
            String pName = st.nextToken();
            String tName = st.nextToken();
            if (!team.containsKey(tName)) {
                Team t = new Team(tName);
                team.put(tName, t);
                ordered_team.add(t);
            }
            team.get(tName).addPlayer(pName);
            player_team.put(pName, tName);
        }
        for (String message : messages) {
            StringTokenizer st = new StringTokenizer(message);
            String winner = st.nextToken();
            st.nextToken();
            String losser = st.nextToken();
            Team wTeam = team.get(player_team.get(winner));
            Team lTeam = team.get(player_team.get(losser));
            if (wTeam.equals(lTeam)) {
                wTeam.addScore(winner, -1);
            } else {
                wTeam.addScore(winner, 1);
                lTeam.addScore(losser, -1);
            }
        }
        Collections.sort(ordered_team);
        ArrayList<String> ret = new ArrayList<String>();
        for (Team t : ordered_team) {
            ret.add(t.toString());
            ArrayList<Player> player = t.getPlayerList();
            for (Player p : player) {
                ret.add(p.toString());
            }
        }
        return ret.toArray(new String[ret.size()]);
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            PaintballHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                PaintballHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
// END CUT HERE
}

// BEGIN CUT HERE
class PaintballHarness {

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
                String[] players = {"A RED", "B BLUE"};
                String[] messages = {"A SPLATTERED B"};
                String[] expected__ = {"RED 1", "  A 1", "BLUE -1", "  B -1"};

                return verifyCase(casenum__, expected__, new Paintball().getLeaderboard(players, messages));
            }
            case 1: {
                String[] players = {"LISA RED", "BART RED", "HOMER BLUE", "MARGE BLUE", "MAGGIE GREEN"};
                String[] messages = {"MAGGIE SPLATTERED HOMER", "MAGGIE SPLATTERED MARGE"};
                String[] expected__ = {"GREEN 2", "  MAGGIE 2", "RED 0", "  BART 0", "  LISA 0", "BLUE -2", "  HOMER -1", "  MARGE -1"};

                return verifyCase(casenum__, expected__, new Paintball().getLeaderboard(players, messages));
            }
            case 2: {
                String[] players = {"TODD STRIKEFORCE",
                    "BART OMEGA",
                    "DATA STRIKEFORCE",
                    "MILHOUSE OMEGA",
                    "NELSON DISCOVERYCHANNEL",
                    "MARTIN DISCOVERYCHANNEL"};
                String[] messages = {"BART SPLATTERED MARTIN", "TODD SPLATTERED MARTIN"};
                String[] expected__ = {"OMEGA 1", "  BART 1", "  MILHOUSE 0", "STRIKEFORCE 1", "  TODD 1", "  DATA 0", "DISCOVERYCHANNEL -2", "  NELSON 0", "  MARTIN -2"};

                return verifyCase(casenum__, expected__, new Paintball().getLeaderboard(players, messages));
            }
            case 3: {
                String[] players = {"DR COHO", "ST COHO", "PE COHO"};
                String[] messages = {"DR SPLATTERED ST",
                    "ST SPLATTERED PE"};
                String[] expected__ = {"COHO -2", "  PE 0", "  DR -1", "  ST -1"};

                return verifyCase(casenum__, expected__, new Paintball().getLeaderboard(players, messages));
            }
            case 4: {
                String[] players = {"A B", "AA AA", "AAA AAA"};
                String[] messages = {"A SPLATTERED AAA", "A SPLATTERED AAA", "A SPLATTERED AAA",
                    "AA SPLATTERED AAA", "AA SPLATTERED AAA"};
                String[] expected__ = {"B 3", "  A 3", "AA 2", "  AA 2", "AAA -5", "  AAA -5"};

                return verifyCase(casenum__, expected__, new Paintball().getLeaderboard(players, messages));
            }

            // custom cases

            /*      case 5: {
             String[] players          = ;
             String[] messages         = ;
             String[] expected__       = ;

             return verifyCase(casenum__, expected__, new Paintball().getLeaderboard(players, messages));
             }*/
            /*      case 6: {
             String[] players          = ;
             String[] messages         = ;
             String[] expected__       = ;

             return verifyCase(casenum__, expected__, new Paintball().getLeaderboard(players, messages));
             }*/
            /*      case 7: {
             String[] players          = ;
             String[] messages         = ;
             String[] expected__       = ;

             return verifyCase(casenum__, expected__, new Paintball().getLeaderboard(players, messages));
             }*/
            default:
                return -1;
        }
    }
}
// END CUT HERE

