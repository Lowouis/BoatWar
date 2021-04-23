package controler;
import javax.swing.text.View;

import modele.*;
import view.DisplayGraphics;
public class main{
	
	public static void main(String[] args){
		Board b = new Board();
		Board b1 = new Board();
		View view = new View(new DisplayGraphics(b,b1)); 
		view.setPresenter(new Controler(new Modele(), view));
		
	}

}
