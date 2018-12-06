import java.awt.Rectangle;

public class Obstruction {
	protected int obsX, obsY;
	protected int obsH, obsW;
	protected String obsName;
	protected Rectangle r;
	//obstruction class is very similar to the sprite class, the obstructions can be edited in game properties
	
	public int getObsX() {
		return obsX;
	}
	public void setObsX(int obsX) {
		this.obsX = obsX;
	}
	public int getObsY() {
		return obsY;
	}
	public void setObsY(int obsY) {
		this.obsY = obsY;
	}
	public int getObsH() {
		return obsH;
	}
	public void setObsH(int obsH) {
		this.obsH = obsH;
	}
	public int getObsW() {
		return obsW;
	}
	public void setObsW(int obsW) {
		this.obsW = obsW;
	}
	
	public String getObsName() {
		return obsName;
	}
	public void setObsName(String obsName) {
		this.obsName = obsName;
	}	
	
	
	public Rectangle getR() {
		return r;
	}
	public void setR(Rectangle r) {
		this.r = r;
	}
	
	public void setSize(int w, int h) {
		this.obsW = w;
		this.obsH = h;
	}
	public void setLocation(int x, int y) {
		this.obsX = x;
		this.obsY = y;
	}
	
	//default
	public Obstruction() {
		this.obsX = 0;
		this.obsY = 0;
		this.obsH = 0;
		this.obsW = 0;
		this.obsName = "";
	}
	
	//constructor
	public Obstruction(int obsX, int obsY, int obsW, int obsH) {
		super();
		this.obsX = obsX;
		this.obsY = obsY;
		this.obsH = obsH;
		this.obsW = obsW;
		//create the rectangle
		this.r = new Rectangle(this.obsX, this.obsY, this.obsW, this.obsH);
		
	}
	
	//display
	public void Display() {
		System.out.println("/n X: " + this.obsX +
						   "/n Y: " + this.obsY+
						   "/n W: " + this.obsW+
						   "/n H: " + this.obsH);
	}

}
