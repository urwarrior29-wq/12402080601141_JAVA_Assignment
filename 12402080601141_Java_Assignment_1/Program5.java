// Program5-> Cricket match using inheritance and command line arguments

// parent class
class Cricket {
    
    String team1, team2;

    // constructor
    Cricket(String t1, String t2) {
        team1 = t1;
        team2 = t2;
    }

    void showTeams() {
        System.out.println("Team 1: " + team1);
        System.out.println("Team 2: " + team2);
    }
}

// child class
class Match extends Cricket {

    int score1, score2;

    // constructor
    Match(String t1, String t2, int s1, int s2) {
        super(t1, t2);   // calling parent constructor
        score1 = s1;
        score2 = s2;
    }

    void result() {
        // checking winner
        if(score1 > score2) {
            System.out.println(team1 + " won the match");
        }
        else if(score2 > score1) {
            System.out.println(team2 + " won the match");
        }
        else {
            System.out.println("Match is Draw");
        }
    }

    void showScore() {
        System.out.println(team1 + " Score: " + score1);
        System.out.println(team2 + " Score: " + score2);
    }
}

// main class
public class Program5 {
    public static void main(String args[]) {

        // taking input from command line
        // args[0] = team1
        // args[1] = team2
        // args[2] = score1
        // args[3] = score2

        String t1 = args[0];
        String t2 = args[1];
        int s1 = Integer.parseInt(args[2]);
        int s2 = Integer.parseInt(args[3]);

        Match m = new Match(t1, t2, s1, s2);

        m.showTeams();
        m.showScore();
        m.result();
    }
}