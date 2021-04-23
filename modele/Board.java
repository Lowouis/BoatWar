package modele;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;



public class Board{

	private ArrayList<Storage> allBoats = new ArrayList<Storage>();
	public ArrayList<Point> boatsPoints = new ArrayList<Point>();
	public Boat[][] board = new Boat[10][10];
	public int[] boatsSize = {2,3,3,4,5};

	public Board(){
		initBoat();
	}

	public Boat[][] getBoard(){return this.board;}
	public int[] getBoardSize(){return boatsSize;}
	public ArrayList<Point> getPos(){return this.boatsPoints;}
	public ArrayList<Storage> getAllBoats(){return this.allBoats;}
	public void initBoat(){
		for(int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				this.board[i][j] = new Boat(false,false,false);
				}
			}
		boatsPlacements();
	}

	public boolean checkPlacement(int x, int y, int size, boolean v){

		for(int i = 0; i < size;i++){
			if(v && this.board[x+i][y].getBoat()){
				return false;
			}
			if(v == false && this.board[x][y+i].getBoat()){
				return false;
			}
		}
		return true;
		}

	public ArrayList<ArrayList<Point>> isBoatDown(){
		ArrayList<ArrayList<Point>> boatsHit = new ArrayList<ArrayList<Point>>();
		if(allBoats.size() > 0){
			for(int i = 0; i < allBoats.size();i++){
				ArrayList<Point> tmp = allBoats.get(i).getBoats();
				boolean stop=true;
				for(int j = 0; j < tmp.size();j++){
					if(board[tmp.get(j).x][tmp.get(j).y].getHit() == false){
						stop = false;
					}

				}
				if(stop){
					ArrayList<Point> forDraw = new ArrayList<Point>();
					forDraw.add(new Point(tmp.get(0)));
					forDraw.add(new Point(tmp.get(tmp.size()-1)));
					boatsHit.add(forDraw);
				}
			}
		}

		return boatsHit;
	}






	public void boatsPlacements(){
		Random r = new Random();
		int x;boolean v;int y;
		for(int i = 0; i < boatsSize.length;i++){
			v = r.nextBoolean();
			Storage stock = new Storage(boatsSize[i]);
				if(v==true){
					int n = 10-boatsSize[i];
					x = r.nextInt(n);
					y = r.nextInt(10);
					if(checkPlacement(x,y,boatsSize[i],v)){
						for(int a = 0; a < boatsSize[i];a++){
							stock.addPoint(new Point(x+a,y));
							boatsPoints.add(new Point(x+a,y));
							this.board[x+a][y].setBoat(true);
						}
					}
					else{i--;}

				}
				if(v==false){
					int n = 10-boatsSize[i];
					y = r.nextInt(n);
					x = r.nextInt(10);
					if(checkPlacement(x,y,boatsSize[i],v)){
						for(int a = 0; a < boatsSize[i];a++){

							stock.addPoint(new Point(x, y+a));
							boatsPoints.add(new Point(x, y+a));

							boatsPoints.add(new Point(x,y+a));
							this.board[x][y+a].setBoat(true);
						}
					}
					else{i--;}

				}
				if(stock.getBoats().size() != 0){
					allBoats.add(stock);
				}


		}

	}
	public boolean isOver(){

		for(int i = 0; i < 10;i++){
			for(int j = 0; j < 10; j++){
				if(this.board[i][j].getBoat() == true & this.board[i][j].getHit() == false){
					return false;
				}
			}
		}
		return true;
	}
}
