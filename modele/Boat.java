package modele;
public class Boat {
	public boolean hit = false;
	public boolean b = false;
	public boolean click = false;


	public Boat(boolean hit, boolean b, boolean click){
		this.hit = hit;
		this.b = b;
		this.click = click;
	}

	public void setBoat(boolean b){
		this.b = b;
	}
	public void setClick(boolean click){
		this.click = click;
	}
	public boolean getClick(){
		return this.click;
	}

	public boolean getBoat(){
		return this.b;
	}

	public boolean getHit(){
		return this.hit;
	}

	public void setHit(boolean hit){
		this.hit = hit;
	}
}
