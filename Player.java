import java.awt.Rectangle;

//the player class extends the sprite class
public class Player extends Sprite{
	protected int moveCount;
	protected boolean alive;
	private int score;
	
	public Player() {
		
		//height of 250, width of 100, and 10 hp
		super("playerSprite.png", 75, 75, 10);
		//super  sets the variables for sprite
		
		moveCount = 0; //counting how many moves the player made, this is used for triggering moveBullet(),
		//and for the player's score
		alive = true;
		
	}
	
	public int getMoveCount() {
		return moveCount;
	}
	public void setMoveCount(int tempMoveCount) {
		moveCount = tempMoveCount;
	}
	
	public boolean getAlive() {
		return alive;
	}
	public void setAlive(boolean tempAlive) {
		alive = tempAlive;
	}
	
	//function for incrementing move counter
	public void Moved() {
		moveCount++;
	}
	
	public void Die(int tempScore) {
		alive = false;
		score = tempScore;
		//DATABASE THEORY BELOW, NONE OF THIS HAS BEEN TESTED
		/*the database has three columns: id, score, and time stamp
		 * Connection con; //needs import
		 * Statement stmt
		 * 
		 * try{
		 *	//db driver
		 * 	Class.forName("com.mysql.jdbc.Driver");
		 * 	
		 * //connection string
		 * 	String url = "jdbc:mysql://127.0.0.1:8889/dodgeBulletDB";
		 * 	
		 * //connect to DB
		 * 	con = DriverManager.getConnection(url, "homestead", "secret")
		 * 
		 *	//initialize
		 *	stmt = con.createStatement();
		 * 
		 * 	//execute sql
		 * 	String  sql = "INSERT INTO scores (score)" + "VALUES ('"+score+'")"
		 * 	stmt.execute(sql);
		 * 
		 * }
		 * 
		 */
		
		
	}
	//collision detection for obstructions
	public boolean DetectCollision(Rectangle ObsR) {
		boolean collision = false;
		
		
		if(r.intersects(ObsR)) {
			//System.out.println("PLAYER AND OBSTRUCTION");
			collision = true;
		}
		
		return collision;
	}
	
	
	public void Display() {
		System.out.println("Moves: " + moveCount);
	}
	
	
}