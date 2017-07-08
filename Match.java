
public class Match {
	
	private int rank;
	private int won;
	
	Match(int rank, int won){
		this.rank = rank;
		if (this.rank < 0) this.rank = 0;
		this.won = won;
	}
	
	public int getRank() { return rank; }
	public int won() { return won; }
	
	public String toString() {
		String msg = "lost(";
		if ( won == 1 ) msg = "won(";
		
		return msg + rank + ")";
	}
}
