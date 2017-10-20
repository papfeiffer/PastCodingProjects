import java.util.*;

/**
 * Created by paigepfeiffer on 4/5/17.
 */
public class TeamBuildBruteForce {

    public static void main(String[] args) {

        ArrayList<Player> initialPlayers;                    // List of players (soon to be turned into Map objects
        int numPlayers;                                      // Ask user for total number of potential players
        int teamSize;                                        // Ask user for number of players per team


        // Start timing the program
        final long startTime = System.currentTimeMillis();


        // Ideally, if people wanted to use this algorithm with their own data,
        // the program would include a Scanner system so that users can manually
        // enter the players' data and desired team size


        // Generate random players
        Player player1 = new Player("P", 7, 7, 4);
        Player player2 = new Player("Z", 3, 7, 1);
        Player player3 = new Player("A", 9, 10, 10);
        Player player4 = new Player("B", 6, 5, 4);
        Player player5 = new Player("C", 1, 1, 1);
        Player player6 = new Player("D", 10, 10, 10);
        Player player7 = new Player("E", 8, 7, 2);
        Player player8 = new Player("F", 5, 5, 7);
        Player player9 = new Player("G", 2, 5, 9);
        Player player10 = new Player("H", 9, 9, 9);
        Player player11 = new Player("I", 6, 7, 8);
        Player player12 = new Player("J", 4, 1, 1);
        Player player13 = new Player("K", 3, 8, 4);
        Player player14 = new Player("L", 5, 8, 10);
        Player player15 = new Player("M", 3, 1, 2);
        Player player16 = new Player("N", 8, 3, 8);
        Player player17 = new Player("O", 6, 8, 3);
        Player player18 = new Player("P", 5, 1, 7);
        Player player19 = new Player("Q", 9, 7, 8);
        Player player20 = new Player("R", 7, 4, 2);


        // Make list of Player objects
        initialPlayers = new ArrayList<Player>();
        initialPlayers.add(player1);
        initialPlayers.add(player2);
        initialPlayers.add(player3);
        initialPlayers.add(player4);
        initialPlayers.add(player5);
        initialPlayers.add(player6);
        initialPlayers.add(player7);
        initialPlayers.add(player8);
        initialPlayers.add(player9);
        initialPlayers.add(player10);
        initialPlayers.add(player11);
        initialPlayers.add(player12);
        initialPlayers.add(player13);
        initialPlayers.add(player14);
        initialPlayers.add(player15);
        initialPlayers.add(player16);
        initialPlayers.add(player17);
        initialPlayers.add(player18);
        initialPlayers.add(player19);
        initialPlayers.add(player20);


        // Get the number of players
        numPlayers = initialPlayers.size();

        // Decide how big a typical team should be (we considered sizes 1-11)
        teamSize = 11;

        // Generate all combinations (team possibilities)
        ArrayList<ArrayList<Player>> allCombos = new ArrayList<ArrayList<Player>>();
        allCombos = combinations(initialPlayers, numPlayers, teamSize);

        //Goes through all possible team combinations and assigns each a score
        ArrayList<Map<ArrayList, Integer>> calculatedTeams = calculateTeamScore(allCombos, teamSize);

        //Gives the best team possible based on their overall score
        Map<ArrayList, Integer> theBest = bestTeam(calculatedTeams);


        //Finish timing
        final long endTime = System.currentTimeMillis();

        //Print the best team, its score, and the overall time of the program
        System.out.println(theBest);
        System.out.println(endTime - startTime);

    }


    /** Generates all possible teams given a set of players to choose from. For instance, this method could
     *  generate all possible combinations of 5 players from a full set of 20 players.
     *  @param initialPlayers, numPlayers, teamSize
     *  @return results
     */
    public static ArrayList<ArrayList<Player>> combinations(ArrayList<Player> initialPlayers, int numPlayers, int teamSize) {

        ArrayList<ArrayList<Player>> results = new ArrayList<ArrayList<Player>>();
        ArrayList<Player> item = new ArrayList<Player>();

        dfs(initialPlayers, numPlayers, teamSize, 1, item, results);

        return results;
    }

    private static void dfs(ArrayList<Player> initialPlayers, int numPlayers, int teamSize, int start, ArrayList<Player> item, ArrayList<ArrayList<Player>> results) {

        if (item.size() == teamSize) {
            results.add(new ArrayList<Player>(item));
            return;
        }

        for (int i = start; i <= numPlayers - 1; i++) {
            Player player = initialPlayers.get(i);
            initialPlayers.set(i, player);
            item.add(initialPlayers.get(i));
            dfs(initialPlayers, numPlayers, teamSize, i + 1, item, results);
            item.remove(item.size() - 1);
        }

    }


     /**
      * Calculates the score for each combination we have generated.
      * Score = totalTeamScore (all player's role scores for that team) * Balance
      * Balance = proper proportion of how many people are playing each type of role
      * (i.e. 6 players on offense is worse than 2 players on offense/2 on structure/2 on
      * defense )
      * @param teamCombos, teamSize
      * @return scoredTeams
     */

    public static ArrayList<Map<ArrayList, Integer>> calculateTeamScore(ArrayList<ArrayList<Player>> teamCombos, int teamSize)
    {
        ArrayList<Map<ArrayList, Integer>> scoredTeams = new ArrayList<Map<ArrayList, Integer>>();

        for (ArrayList<Player> teamCombo : teamCombos) {
            int numOff = 0;
            int numDef = 0;
            int numSup = 0;
            int numOrg = 0;
            int idealNumRolePlayers = teamSize / 4; // For example, if numPlayers = 8 --> should be 2 players in each role
            int TeamRoleScore = 0;                  // Add up skill scores of all players
            double teamBalance = 0;                 // Team's balance score
            double totalTeamScore;                  // Combined scores of all players on one team


            for (int j = 0; j < teamCombos.get(j).size(); j++)   //Goes through each individual player in team
            {
                if (teamCombo.get(j).getRole().equals("Off")) {
                    numOff++;                                               //Add to number of offense for that team
                }
                if (teamCombo.get(j).getRole().equals("Def")) {
                    numDef++;
                }
                if (teamCombo.get(j).getRole().equals("Sup")) {
                    numSup++;
                }
                if (teamCombo.get(j).getRole().equals("Org")) {
                    numOrg++;
                }
                TeamRoleScore += teamCombo.get(j).getTotal();  //Add individual player's total score
            }

            if (numOff <= idealNumRolePlayers) {
                teamBalance += 0.25;
            }
            if (numDef <= idealNumRolePlayers) {
                teamBalance += 0.25;
            }
            if (numSup <= idealNumRolePlayers) {
                teamBalance += 0.25;
            }
            if (numOrg <= idealNumRolePlayers) {
                teamBalance += 0.25;
            }

            //Calculate team's score
            totalTeamScore = teamBalance * TeamRoleScore;

            //Create new map here
            Map<ArrayList, Integer> definedTeam = new HashMap<ArrayList, Integer>();

            //Initialize map
            definedTeam.put(teamCombo, (int) totalTeamScore);
            scoredTeams.add(definedTeam);
        }

        return scoredTeams;
    }


    /**
     * Now that we have scored each possible team, this method returns the best team possible
     * from all of the combinations we have generated.
     * @param calculatedTeams
     * @return bestCombo
     */

    public static Map<ArrayList, Integer> bestTeam(ArrayList<Map<ArrayList, Integer>> calculatedTeams)
    {
        Map<ArrayList, Integer> bestCombo = new HashMap<ArrayList, Integer>();  //Holds the best team
        int bestScore = 0;                                                      //Keeps track of best score

        for (Map<ArrayList, Integer> calculatedTeam : calculatedTeams) {

            Map<ArrayList, Integer> oneCombo = new HashMap<ArrayList, Integer>();
            oneCombo = calculatedTeam;                                      //Equals individual map

            for (Map.Entry<ArrayList, Integer> entry : oneCombo.entrySet()) {
                int score = entry.getValue();

                if (score > bestScore) {
                    bestScore = score;
                    bestCombo = oneCombo;
                }
            }

        }
        return bestCombo;
    }

}



















