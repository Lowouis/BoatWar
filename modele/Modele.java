package modele;

public class Modele{


	//INIT GAME

	public Board b;
	public Board b1;

	public Modele(){
		this.b = new Board();
		this.b1 = new Board();
	}

	public Board getBoard(){
		return this.b;
	}

	public boolean isOver(){

		for(int i = 0; i < 10;i++){
			for(int j = 0; j < 10; j++){
				if(this.b.getBoard()[i][j].getBoat() == true & this.b.getBoard()[i][j].getHit() == false){
					return false;
				}
			}
		}
		return true;
	}

}
