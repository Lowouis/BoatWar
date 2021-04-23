package controler;
import modele.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickListener extends MouseAdapter {
	
	@Override
	public void mouseClicked(MouseEvent e){
		System.out.println("(" + e.getX() + ", " + e.getY() + ")" );
	}
}
