import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Advanced OOP Game Project
//Lyndon Jardine
public class Game extends JFrame implements KeyListener{
	
	//sprite instances
	private Player myPlayer;
	
	//not implemented yet
	//private Enemy myEnemy;
	//private Enemy enemy2;
	//private Enemy enemy3;
	
	
	//--images--
	private ImageIcon playerImage;
	//private ImageIcon enemyImage;
	//private ImageIcon obstructionImage;
	//private ImageIcon targetImage;
	private ImageIcon bulletImage;
	
	//--swing--
	private JLabel playerLabel;
	//private JLabel enemyLabel;
	
	private Container content;
	
	//array of obstructions with 10 indexes
	private Obstruction[] obstructionArray = new Obstruction[5];
	//obstructionArray = new Obstruction[5];
	
	//array of jlabels for obstructions
	private JPanel[] obstructionPanel = new JPanel[5];
	
	private static Bullet[] bulletArray = new Bullet[GameProperties.BULLET_NUM];
	private JLabel[] bulletLabel = new JLabel[GameProperties.BULLET_NUM];
	
	private int bulletX;
	private int bulletY;

	//gameover message
	private JPanel gameOverPanel;
	private JLabel gameOverLabel;
	
	
	//constructor
	public Game() {
		//player
		myPlayer = new Player();
		playerImage = new ImageIcon(
			getClass().getResource(myPlayer.getSpriteName())
		);
		
		
		
		playerLabel = new JLabel();
		
		/*
		//enemy1
		myEnemy = new Enemy();
		enemyImage = new ImageIcon(
					getClass().getResource(myEnemy.getSpriteName())
				);
		enemyLabel = new JLabel();
		*/
		
		content = getContentPane();
		
		//Setting up GUI
		//screen size
		//content.setBackground(Color.black);
		setSize(GameProperties.SCREEN_WIDTH, GameProperties.SCREEN_HEIGHT);
		
		//set layout to null because we dont want the default flow layout
		setLayout(null);
		
		
		//add player
		//set location
		myPlayer.setSpriteY(0);
		myPlayer.setSpriteX(0);
		//set hitbox rectangle location
		myPlayer.updateRectanglePosition(myPlayer.getSpriteX(), myPlayer.getSpriteY());
		//set image icon
		playerLabel.setIcon(playerImage);
		//set sprite label size
		playerLabel.setSize(myPlayer.getSpriteW(),myPlayer.getSpriteH());
		//set sprite label location
		playerLabel.setLocation(myPlayer.getSpriteX(),myPlayer.getSpriteY());
		
		add(playerLabel);
		
		
		//OBSTRUCTIONS
		//create an array of objects
		
		//initalize all indexes,
		for(int i=0; i<obstructionArray.length; i++) {
			
			
			//the x y h w for each obstruction is stored in game properties, use a switch to grab the correct properties for each obstruction
			switch(i) {
			
			case 0: obstructionArray[i] = new Obstruction(GameProperties.OBS0X,GameProperties.OBS0Y,GameProperties.OBS0W,GameProperties.OBS0H);
			break;
			
			case 1: obstructionArray[i] = new Obstruction(GameProperties.OBS1X,GameProperties.OBS1Y,GameProperties.OBS1W,GameProperties.OBS1H);
			break;
			
			case 2: obstructionArray[i] = new Obstruction(GameProperties.OBS2X,GameProperties.OBS2Y,GameProperties.OBS2W,GameProperties.OBS2H);
			break;
			
			case 3: obstructionArray[i] = new Obstruction(GameProperties.OBS3X,GameProperties.OBS3Y,GameProperties.OBS3W,GameProperties.OBS3H);
			break;
			
			case 4: obstructionArray[i] = new Obstruction(GameProperties.OBS4X,GameProperties.OBS4Y,GameProperties.OBS4W,GameProperties.OBS4H);
			break;
			
			default: System.out.println("something isnt right");
			break;
			}


		}
	
		//create panels for each obstruction
		for(int i=0; i<obstructionPanel.length; i++) {
			content.add(obstructionPanel[i] = new JPanel());
			
			//set the vars for each obstruction
			obstructionPanel[i].setSize(obstructionArray[i].getObsW(), obstructionArray[i].getObsH());
			obstructionPanel[i].setLocation(obstructionArray[i].getObsX(), obstructionArray[i].getObsY());
			obstructionPanel[i].setBackground(Color.BLACK);
			
		}
		
		//game over message
		gameOverPanel = new JPanel();
		gameOverPanel.setSize(200, 75);
		gameOverPanel.setLocation(500, 363);
		gameOverPanel.setBackground(Color.RED);
		
		gameOverLabel = new JLabel();
		//gameOverLabel.setText("<html><body>GAME OVER<br/><br/>Your Score is: "+ myPlayer.getMoveCount()+" </body></html>");
		//gameOverPanel.add(gameOverLabel);
		
		content.add(gameOverPanel);
		
		gameOverPanel.setVisible(false);
		//bullets
		
				//initalize all indexes,
				for(int i=0; i<bulletArray.length; i++) {
					bulletLabel[i] = new JLabel();
					bulletArray[i] = new Bullet(myPlayer, bulletLabel[i], playerLabel, gameOverPanel, gameOverLabel);
					bulletLabel[i].setSize(5, 5);
					
					bulletImage = new ImageIcon(
							getClass().getResource(bulletArray[i].getSpriteName())
					);
					
					bulletLabel[i].setIcon(bulletImage);
					//bulletLabel[i].setLocation(bulletArray[i].getSpriteX(),bulletArray[i].getSpriteY());
					
					if(i == 0) {
						bulletX = GameProperties.SCREEN_WIDTH;
						bulletY = GameProperties.SCREEN_HEIGHT;
						bulletArray[i].setSpriteX(bulletX);
						bulletArray[i].setSpriteY(bulletY);
					}
					
					if(i == 1) {
						bulletX = GameProperties.SCREEN_WIDTH;
						bulletY = 400;
						bulletArray[i].setSpriteX(bulletX);
						bulletArray[i].setSpriteY(bulletY);
					}
					
					if(i == 2) {
						bulletX = GameProperties.SCREEN_WIDTH;
						bulletY = 0;
						bulletArray[i].setSpriteX(bulletX);
						bulletArray[i].setSpriteY(bulletY);
					}
					
					if(i == 3) {
						bulletX = 900;
						bulletY = GameProperties.SCREEN_HEIGHT;
						bulletArray[i].setSpriteX(bulletX);
						bulletArray[i].setSpriteY(bulletY);
					}
					
					if(i == 4) {
						bulletX = 600;
						bulletY = GameProperties.SCREEN_HEIGHT;
						bulletArray[i].setSpriteX(bulletX);
						bulletArray[i].setSpriteY(bulletY);
					}
					
					if(i == 5) {
						bulletX = 300;
						bulletY = GameProperties.SCREEN_HEIGHT;
						bulletArray[i].setSpriteX(bulletX);
						bulletArray[i].setSpriteY(bulletY);
					}
					
					if(i == 6) {
						bulletX = 0;
						bulletY = GameProperties.SCREEN_HEIGHT;
						bulletArray[i].setSpriteX(bulletX);
						bulletArray[i].setSpriteY(bulletY);
					}
					
					if(i == 7) {
						bulletX = 0;
						bulletY = 400;
						bulletArray[i].setSpriteX(bulletX);
						bulletArray[i].setSpriteY(bulletY);
					}
					
					if(i == 8) {
						bulletX = 0;
						bulletY = 0;
						bulletArray[i].setSpriteX(bulletX);
						bulletArray[i].setSpriteY(bulletY);
					}

					
					bulletLabel[i].setLocation(bulletX, bulletY);
					content.add(bulletLabel[i]);
					//System.out.println("STOP");
					

						}
		
		
		
		//set up for key events
		
		content.addKeyListener(this);
		content.setFocusable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for(int b=0; b<bulletArray.length; b++) {
			bulletArray[b].moveBullet();
		}
	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game myGame = new Game();
		myGame.setVisible(true);
		myGame.setResizable(false);
		
		
		
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		//not used
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		//get your sprite's current location
		int x = myPlayer.getSpriteX();
		int y = myPlayer.getSpriteY();
		
		//initialize obstructed as false
		boolean obstructed = false;
		

		//if up key is pressed
		if(e.getKeyCode()==KeyEvent.VK_W && myPlayer.alive == true) {
			y -= GameProperties.CHARACTER_STEP;
			myPlayer.Moved();
			
			//if sprite is at the border of the screen, bring it back
			if(y + myPlayer.getSpriteH() < 0) {
				y += GameProperties.CHARACTER_STEP;
			}
			myPlayer.updateRectanglePosition(x, y); //update the rectangle so collision detection works
			
			//if detect collision returns true, undo the movement
			for(int o=0; o<obstructionArray.length; o++) {
				if(myPlayer.DetectCollision(obstructionArray[o].getR()) == true) {
					y += GameProperties.CHARACTER_STEP;
				}
			}
			
			
		}
			
			//if down key is pressed
			if(e.getKeyCode()==KeyEvent.VK_S && myPlayer.alive == true) {
				y += GameProperties.CHARACTER_STEP;
				myPlayer.Moved();
				
					//if sprite is at the border of the screen, bring it back
					if(y > GameProperties.SCREEN_HEIGHT){
						y -= GameProperties.CHARACTER_STEP;
					}
					
					myPlayer.updateRectanglePosition(x, y); //update the rectangle so collision detection works
					
					//if detect collision returns true, undo the movement
					for(int o=0; o<obstructionArray.length; o++) {
						if(myPlayer.DetectCollision(obstructionArray[o].getR()) == true) {
							y -= GameProperties.CHARACTER_STEP;
						}
					}
					
				}
			
			//if the left key was pressed move left
			if(e.getKeyCode() == KeyEvent.VK_A && myPlayer.alive == true) {
				x -= GameProperties.CHARACTER_STEP;
				myPlayer.Moved();
				
				
				if (x + myPlayer.getSpriteW() < 0) {
					x += GameProperties.CHARACTER_STEP;
				}
				
				myPlayer.updateRectanglePosition(x, y); //update the rectangle so collision detection works
				
				//if detect collision returns true, undo the movement
				for(int o=0; o<obstructionArray.length; o++) {
					if(myPlayer.DetectCollision(obstructionArray[o].getR()) == true) {
						x += GameProperties.CHARACTER_STEP;
					}
				}
				
			}
			
			//if the right key was pressed move right
			if(e.getKeyCode() == KeyEvent.VK_D && myPlayer.alive == true) {
				x += GameProperties.CHARACTER_STEP;
				myPlayer.Moved();
				if(x> GameProperties.SCREEN_WIDTH) {
					x -= GameProperties.CHARACTER_STEP;
				}
				
				myPlayer.updateRectanglePosition(x, y); //update the rectangle so collision detection works
				
				//if detect collision returns true, undo the movement
				for(int o=0; o<obstructionArray.length; o++) {
					if(myPlayer.DetectCollision(obstructionArray[o].getR()) == true) {
						x-= GameProperties.CHARACTER_STEP;
					}
				}
				
			}
			
			/*
			//start bullets
			if (moveCount >= 5) {
				System.out.println("BULLETS SHOULD START NOW");
				for(int b=0; b<bulletArray.length; b++) {
					//bulletArray[b].run();
					bulletArray[b].moveBullet();
				}
			}
			*/
			
			
			
			
			
			
			/*
			 
			for(int o=0; o<obstructionArray.length; o++) {
				if(myPlayer.DetectCollision(obstructionArray[o].getR()) == true) {
					obstructed = true;
				}
			}
			
			*/
			
			//System.out.println(obstructed);
			
			//update sprites state
			myPlayer.setSpriteX(x);
			myPlayer.setSpriteY(y);
			myPlayer.updateRectanglePosition(x, y);
			playerLabel.setLocation(x,y);

			}
	
	
	
	
	
	//bullets
	

	
	
	
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
		}