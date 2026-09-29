import java.util.Scanner;
public class Main {
    // Array Format: {team a, team b; team c; team d}
    static int[] teamPoints = {0, 0, 0, 0};
    static int[] teamDraws = {0, 0, 0, 0};
    static int[] teamWins = {0, 0, 0, 0};
    static int[] teamLosses = {0, 0, 0, 0};
    static int[] goalsForT = {0, 0, 0, 0};
    static int[] goalsAgainstT = {0, 0, 0, 0};
    static String[] teamNames = {"Team A", "Team B", "Team C", "Team D"};
    static int teamA = 0;
    static int teamB = 1;
    static int teamC = 2;
    static int teamD = 3;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("MATCH LIST:\nMatch 1: team A vs team B\nMatch 2: team A vs team C\nMatch 3: team A vs team D" + "\nMatch 4: team B vs team C\nMatch 5: team B vs team D\nMatch 6: team C vs team D\n");
        int[][] scores = new int[4][4];
        int matchNumber = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                    System.out.printf("Match %d: %s vs %s\n enter %s goals: \n", matchNumber, teamNames[i], teamNames[j], teamNames[i]);
                    int goals1 = input.nextInt();
                    goalsForT[i] += goals1;
                    goalsAgainstT[j] += goals1;
                    scores[i][j] = goals1;
                    System.out.printf("Enter %s goals: \n", teamNames[j]);
                    int goals2 = input.nextInt();
                    goalsForT[j] += goals2;
                    goalsAgainstT[i] += goals2;
                    scores[j][i] = goals2;
                    matchNumber++;
                    calcMatch(i, j, scores[i][j], scores[j][i]);
            }
        }
        int[] teamsGoalDif = {goalsForT[0]-goalsAgainstT[0], goalsForT[1]-goalsAgainstT[1], goalsForT[2]-goalsAgainstT[2], goalsForT[3]-goalsAgainstT[3]};
        System.out.println("Entered scores:\nteam A scores: " + scores[0][1] + ", " + scores[0][2] + ", " + scores[0][3] + "\nteam B scores: " + scores[1][0] + ", " + scores[1][2] + ", " + scores[1][3] + "\nteam C scores: " + scores[2][0] + ", " + scores[2][1] + ", " + scores[2][3] + "\nteam D scores: " + scores[3][0] + ", " + scores[3][1] + ", " + scores[3][2]);
        System.out.println("\n=======================================================\n                     " + "STANDING TABLE\n=======================================================\n");
        System.out.println("TEAM A - 3 matches played\nwins: " + teamWins[0] + ", draws: " + teamDraws[0] + ", losses: " + teamLosses[0] + "\ntotal points: " + teamPoints[0] + "\nGoal difference: " + teamsGoalDif[0] + "\n");
        System.out.println("TEAM B - 3 matches played\nwins: " + teamWins[1] + ", draws: " + teamDraws[1] + ", losses: " + teamLosses[1] + "\ntotal points: " + teamPoints[1] + "\nGoal difference: " + teamsGoalDif[1] + "\n");
        System.out.println("TEAM C - 3 matches played\nwins: " + teamWins[2] + ", draws: " + teamDraws[2] + ", losses: " + teamLosses[2] + "\ntotal points: " + teamPoints[2] + "\nGoal difference: " + teamsGoalDif[2] + "\n");
        System.out.println("TEAM D - 3 matches played\nwins: " + teamWins[3] + ", draws: " + teamDraws[3] + ", losses: " + teamLosses[3] + "\ntotal points: " + teamPoints[3] + "\nGoal difference: " + teamsGoalDif[3] + "\n");
        int[] points = {teamPoints[0],teamPoints[1],teamPoints[2],teamPoints[3],};
        int[] goalDif = {teamsGoalDif[0], teamsGoalDif[1], teamsGoalDif[2], teamsGoalDif[3]};
        int champion = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i] > points[champion] || (points[i] == points[champion] && goalDif[i] > goalDif[champion])) {
                champion = i;
            }
        }
        switch (champion) {
            case 0: System.out.println("\n=======================================================\nThe Tournament Champion is: Team A!");break;
            case 1: System.out.println("\n=======================================================\nThe Tournament Champion is: Team B!");break;
            case 2: System.out.println("\n=======================================================\nThe Tournament Champion is: Team C!");break;
            case 3: System.out.println("\n=======================================================\nThe Tournament Champion is: Team D!");break;
        }
    }
    static void calcMatch (int team1, int team2, int goals1, int goals2) {
        if (goals1>goals2) {
            teamPoints[team1] += 3;
            teamWins[team1]++;
            teamLosses[team2]++;
        }else if (goals1==goals2) {
            teamPoints[team1]++;
            teamPoints[team2]++;
            teamDraws[team1]++;
            teamDraws[team2]++;
        }else {
            teamPoints[team2] += 3;
            teamWins[team2]++;
            teamLosses[team1]++;
        }
    }
}