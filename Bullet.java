import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Advanced OOP Game Project
//Lyndon Jardine
public class Bullet extends Sprite implements Runnable {
	
	private Thread tBullet;
	private Boolean moving;
	private JLabel bulletLabel;
	private Player myPlayer;
	private JLabel playerLabel;
	private ImageIcon playerGameOver;
	private Boolean gameOver = false;
	private JPanel gameOverPanel;
	private JLabel gameOverLabel;
	
	

	public Bullet(Player tempPlayer, JLabel tempBulletLabel, JLabel tempPlayerLabel, JPanel tempGameOverPanel, JLabel tempGameOverLabel) {
		//height of 250, width of 100, and 10 hp
		super("bulletSprite.png", 5, 5, 10);
		//moving = false;
		bulletLabel = tempBulletLabel;
		myPlayer = tempPlayer;
		playerLabel = tempPlayerLabel;
		//super  sets the variables for sprite
		gameOverPanel = tempGameOverPanel;
		gameOverLabel = tempGameOverLabel;
		
		

	}
	
	//get and set moving
	public boolean getMoving() {
		return moving;
	}
	public void setMoving(boolean moveTemp) {
		this.moving = moveTemp;
	}
	
	public boolean getGameOver() {
		return gameOver;
	}
	public void setGameOver(boolean tempGameOver) {
		this.gameOver = tempGameOver;
	}
	
	
	
	//thread to move bullet
	
	public void moveBullet() {
		tBullet = new Thread(this, "Move Bullet");
		tBullet.start();
		//System.out.println("Thread started");
	}
	
	
	public void Display() {
		System.out.println("X,Y: " + this.spriteX + ", " + this.spriteY);
		System.out.println("Moving: " + this.moving);
	}
	
	
	
	//detect collision with target
	private void detectCollision() {
		if(r.intersects(myPlayer.getRectangle())) {
			//System.out.println("HIT!!!");
			//change the player sprite
			myPlayer.Die(myPlayer.getMoveCount());
			myPlayer.setSpriteName("playerSprite2.png");
			
			playerGameOver = new ImageIcon(getClass().getResource(myPlayer.getSpriteName()));
			
			playerLabel.setIcon(playerGameOver);
			//trigger game over
			//gameOver = true;
			gameOverPanel.setVisible(true);
			gameOverLabel.setText("<html><body>GAME OVER<br/><br/>Your Score is: "+ myPlayer.getMoveCount()+" </body></html>");
			gameOverPanel.add(gameOverLabel);
			
		}
	}
	
	/*
	//set game over, stops the bullets from moving
	public void bulletGameOver() {
		moving = false;
	}
	*/
	
	
	@Override
	public void run() {
		
		moving = true;
		
		bulletLabel.setIcon(new ImageIcon(getClass().getResource("bulletSprite.png")));

		//while count is less than 10 thread sleep
		while(myPlayer.getMoveCount() < 10) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		while(moving) {
			
			//MOVEMENT CALCULATION
			
			//System.out.println("BEFORE X: " + this.spriteX);
			//grab the bullet sprites x and y
			int bulletX = this.spriteX;
			int bulletY = this.spriteY;
			
			//grab the player's xy, plus 37 so its tracked by the center of the player, not the top left corner
			int playerX = (myPlayer.getSpriteX()) + 37;
			int playerY = (myPlayer.getSpriteY())+ 37;
			
			//calculate the difference between myPlayer and the bullet
			int diffX = bulletX - playerX;
			int diffY = bulletY - playerY;
			//System.out.println("DIFFX = " + diffX);
			//System.out.println("DIFFY = " + diffY);
			
			//if the difference in X is greater than the difference in Y
			
			
			if(diffX > diffY) {
				//System.out.println("X IS GREATER");
				//iff the difference is negative, the bullet is to the left of the player so X should be incremented
				
				//if diff y is a negative, check if the negative y is greater than the positive x if multiplied by -1
				if(diffY < 0 && (diffY * -1) > diffX) {
					bulletY = bulletY + 2;
				}else {
				
					if(diffX < 0) {
						bulletX = bulletX + 2;
					}else {
						//else the bullet is to the right of the player, so X should be un-incremented
						bulletX = bulletX - 2;
				}
				}
			}
			if(diffY > diffX) {
				//System.out.println("Y IS GREATER");
				//iff the difference is negative, the bullet is to the left of the player so X should be incremented
				if(diffX < 0 && (diffX * -1) > diffY) {
					bulletX = bulletX + 2;
				}else {
				
					if(diffY < 0) {
						bulletY = bulletY +2;
					}else {
						//else the bullet is to the right of the player, so X should be un-incremented
						bulletY = bulletY -2;
					}
				}
			}
			
			if(diffX == diffY) {
				if(diffX < 0) {
					bulletX = bulletX + 1;
				}else {
					bulletX = bulletX - 1;
				}
			}
			
			
			
			//update the sprite's xy
			this.spriteX = bulletX;
			this.spriteY = bulletY;
			
			this.updateRectanglePosition(getSpriteX(), getSpriteY());
			bulletLabel.setLocation(getSpriteX(), getSpriteY());
			
			this.detectCollision();
			
			
			
			//moving = false;
			//System.out.println("stopping...");
			
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			if(myPlayer.getAlive() == false) {
				moving = false;
			}
			
			
		}
		//System.out.println("STOPPED");
		
		//System.out.println("AFTER X: " + this.spriteX);
	}
}