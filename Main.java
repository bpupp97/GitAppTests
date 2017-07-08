import java.util.LinkedList;
import java.util.Scanner;


public class Main {

	private static final int TOLERANCE = 300;
	
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		
		int rank = 750; // rank not needed to calculate rank, but is useful to find competitors
		int maxRank = rank;
		int minRank = rank;
		int game = 10;
		LinkedList<Match> recentMatches = new LinkedList<Match>();
		// add, then pop 
		for (int i = 0; i < 15; i++) {
			recentMatches.add(new Match(
					(int) (Math.random() * 2 * TOLERANCE + rank - TOLERANCE),
					(int) (Math.random() * 2)
					));
		}
		
		while (!stdin.nextLine().equals("exit")) {			
			recentMatches.add(new Match(
				(int) (Math.random() * 2 * TOLERANCE + rank - TOLERANCE),
				(int) (Math.random() * 2)
				));
			recentMatches.pop(); 
			//System.out.println(recentMatches);
			game++;
			rank = getRank(recentMatches);
			if ( rank < minRank ){
				minRank = rank;
				System.out.println("game: " + game + " --> " + minRank + ", " + maxRank);
			}
			if ( rank > maxRank ){
				maxRank = rank;
				System.out.println("game: " + game + " --> " + minRank + ", " + maxRank);
			}
		}
	}
	
	private static int getRank(LinkedList<Match> matches){
		
		int totalRank = 0;
		int totalGames = matches.size();
		int totalWins = 0;
		
		if ( totalGames == 0 ) return 750; // catch div by 0, return default score
		
		for (int i = 0; i < totalGames; i++){
			totalRank += matches.get(i).getRank();	// get total rank played against
			totalWins += matches.get(i).won();		// get amount of matches that are wins
		}
		
		// calculate and return rank
		return ( totalRank + 400 * ( 2 * totalWins - totalGames ) ) / totalGames;
	}
}
