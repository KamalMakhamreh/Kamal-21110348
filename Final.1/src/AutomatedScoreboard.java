import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * This class represents 
 * A team has a name, an ID, a score, and a time.
 */
class Team {
    private String name;
    private int id;
    private int score;
    private int time;

    /**
     * Constructs a new team with the given name and ID.
     * The score and time are initialized to 0.
     */
    public Team(String name, int id) {
        this.name = name;
        this.id = id;
        this.score = 0;
        this.time = 0;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public int getTime() {
        return time;
    }

    /**
     * Increases the score and time of the team by the given amount,
     * if the time is less than the contest duration.
     */
    public void solveQuestion(int time, int contestDuration) {
    	 if (this.time + time <= contestDuration) {
    		 
    		 Random random = new Random();
				this.score += random.nextInt(11);
    	        this.time += time;
    	    }
    	}

    @Override
    public String toString() {
        return this.name + "\t\t" + this.id + "\t\t" + this.score + "\t\t\t" + this.time ;
    }
}

/**
 * This class represents the Automated Scoreboard (ASB) system
 * for the Jordan Collegiate Programming Contest (JCPC).
 * The ASB records and displays the scores of the competing teams.
 */
class AutomatedScoreboard {
    private int numberOfTeams;
    private int contestDuration;
    private List<Team> teams;

    /**
     * Constructs a new ASB system with the given number of teams
     * and the duration of the contest.
     */
    public AutomatedScoreboard(int numberOfTeams, int contestDuration) {
        this.numberOfTeams = numberOfTeams;
        this.contestDuration = contestDuration;
        this.teams = new ArrayList<>();
    }

    /**
     * Adds a new team to the ASB system.
     */
    public void addTeam(Team team) {
        teams.add(team);
    }

    /**
     * Records the score and time of a team that has solved a question.
     */
    public void solveQuestion(int teamId, int time) {
        for (Team team : teams) {
            if (team.getId() == teamId) {
                team.solveQuestion(time, contestDuration);
            }
        }
    }

    /**
     * Displays the results of the contest in a sorted order,
     * showing the team with the highest score first, then the team with next highest score, and so on.
     * If scores are the same, teams will be sorted by questions solved in the least amount of time.
     */
    public void displayResults() {
        Collections.sort(teams, (team1, team2) -> {
            if (team1.getScore() == team2.getScore()) {
                return team1.getTime() - team2.getTime();
            }
            return team2.getScore() - team1.getScore();
        });
        System.out.println("Team Name\tTeam ID\\\tScore"+"                   "+"Time");
        for (Team team : teams) {
            System.out.println(team);
        }
    }

    public static void main(String[] args) {
        AutomatedScoreboard asb = new AutomatedScoreboard(10, 300);
        Random random = new Random();

        for (int i = 1; i <= 7; i++) {
            Team team = new Team("Team " + i, i);
            asb.addTeam(team);
        }

        for (int i = 0; i < 10; i++) {
            int teamId = random.nextInt(10);
            int time = random.nextInt(300);
            asb.solveQuestion(teamId, time);
        }

        asb.displayResults();
    }
}