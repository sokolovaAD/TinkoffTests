import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int numberOfWinners = scanNumberOfTeams();
        ArrayList<HashSet<String>> teams = getTeams(numberOfWinners);

        int maxWinnersCount = 1;
        for(HashSet<String> teamToCheck: teams) {
            int currentWinnersCount = countWinsOfTeam(teamToCheck, teams);

            if (needToChangeMaxCount(currentWinnersCount, maxWinnersCount)) {
                maxWinnersCount = currentWinnersCount;
            }
        }

        System.out.println(maxWinnersCount);


    }

    public static int scanNumberOfTeams() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static ArrayList<HashSet<String>> getTeams(int numberOfWinners) {
        ArrayList<HashSet<String>> teams = new ArrayList<>();
        int peoplePerTeam = 3;
        for(int i=0; i< numberOfWinners; i++) {
            teams.add(scanTeam(peoplePerTeam));
        }
        return teams;
    }

    public static HashSet<String> scanTeam(int peoplePerTeam) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> teamWinner = new HashSet<>();
        for(int k=0; k<peoplePerTeam; k++) {
            teamWinner.add(sc.next());
        }
        return teamWinner;
    }

    public static int countWinsOfTeam(HashSet<String> teamToCheck, ArrayList<HashSet<String>> allTeams) {
        int winnersCount = 0;

        for(HashSet<String> otherTeam: allTeams) {
            if(teamToCheck.containsAll(otherTeam)) {
                winnersCount ++;
            }
        }
        return winnersCount;
    }

    public static boolean needToChangeMaxCount(int currentWinnersCount, int maxWinnersCount) {
        return currentWinnersCount > maxWinnersCount;
    }

}
