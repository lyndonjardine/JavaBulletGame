/* NOT USED
public class Target extends Sprite implements Runnable{
	
	private Boolean hit;
	private Thread t1;
	
	// set and get
	public Boolean getHit() {
		return hit;
	}
	public void setHit(Boolean tempHit) {
		this.hit = tempHit;
	}
	
	
	public Target() {
		super("targetSprite.png", 75,75,10);
		this.hit = false;
	}
	
	public void spawnTarget() {
		t1 = new Thread(this, "Spawn Target");
		t1.start();
	}
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
*/
