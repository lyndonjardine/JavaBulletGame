import java.awt.Rectangle;

//Advanced OOP Game Project
//Lyndon Jardine
public class Sprite {
	protected int spriteX, spriteY;
	protected int spriteH, spriteW;
	protected String spriteName;
	protected Rectangle r;
	protected int spriteHP; //sprite hit points
	
	
	
	//GETTERS AND SETTERS
	//sprite X
	public int getSpriteX() {
			return spriteX;
	}
	public void setSpriteX(int spriteX) {
			this.spriteX = spriteX;
	}
		
	//sprite Y
	public int getSpriteY() {
			return spriteY;
	}
	public void setSpriteY(int spriteY) {
			this.spriteY = spriteY;
	}
		
	//Sprite Height
	public int getSpriteH() {
			return spriteH;
	}
	public void setSpriteH(int spriteH) {
			this.spriteH = spriteH;
	}
		
	//Sprite Width
	public int getSpriteW() {
			return spriteW;
	}
	public void setSpriteW(int spriteW) {
			this.spriteW = spriteW;
	}
		
	//Sprite Name
	public String getSpriteName() {
			return spriteName;
	}
	public void setSpriteName(String spriteName) {
			this.spriteName = spriteName;
	}
	
	
	public Rectangle getRectangle() {
		return r;
	}
	//setter for rectangle
	public void updateRectanglePosition(int x, int y) {
		r.x = x;
		r.y = y;
	}
	
	//hit points
	public int getSpriteHP() {
		return spriteHP;
	}
	public void setSpriteHP(int spriteHP) {
		this.spriteHP = spriteHP;
	}
	
	
	//CONSTRUCTORS
	//default sprite constructor
	public Sprite() {
		//super();
		spriteX= 0;
		spriteY= 0;
		spriteH= 0;
		spriteW= 0;
		spriteName= "";
		this.r = new Rectangle(this.spriteX,this.spriteY,this.spriteW,this.spriteH);
		spriteHP = 1; //hp should not be 0
	}
	
	//secondary 
	public Sprite(int spriteX, int spriteY, int spriteH, int spriteW, String spriteName, int spriteHP) {
		//super();
		this.spriteX = spriteX;
		this.spriteY = spriteY;
		this.spriteH = spriteH;
		this.spriteW = spriteW;
		this.spriteName = spriteName;
		//create the hit box rectangle
		this.r = new Rectangle(this.spriteX,this.spriteY,this.spriteW,this.spriteH);
		this.spriteHP = spriteHP;
		}
	
	//constructor for name, height, width, and hp
	public Sprite(String spriteName, int spriteH, int spriteW, int spriteHP) {
		super();
		//this.spriteX = spriteX;
		//this.spriteY = spriteY;
		this.spriteH = spriteH;
		this.spriteW = spriteW;
		this.spriteName = spriteName;
		this.r = new Rectangle(this.spriteX,this.spriteY, //not sure about x and y
				this.spriteW,this.spriteH);
		this.spriteHP = spriteHP;
	}
	
	//DISPLAY
	public void Display() {
		System.out.println("X: " + this.spriteX +
						   "Y: " + this.spriteY);
	}
}
