package modele;
import java.awt.Point;
import java.util.ArrayList;

public class Storage{

	private int size;
	private ArrayList<Point> boats = new ArrayList<Point>();

	public Storage(int size){
		this.size = size;
	}

	public ArrayList<Point> getBoats(){return this.boats;}
	public void addPoint(Point p){
		 boats.add(p);
	}

	public int getSize(){return this.size;}

	public void hit(){
		this.size-=1;
	}
}
