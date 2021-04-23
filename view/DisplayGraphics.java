package view;
import modele.*;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class DisplayGraphics extends Canvas implements MouseListener{


	private static final long serialVersionUID = 1L;
	private static final int N = 10;
	public static String[] alpha = {"A","B","C","D","E","F","G","H","I","J"};
	public static String[] beta = {"1","2","3","4","5","6","7","8","9","10"};
	public static int[] edge = {0,1,2,4,5,7,8,11,12,16};
	public static int x=0;
	public static int y=0;
	public Board b;
	public Board b1;

	public DisplayGraphics(Board b, Board b1){
		this.b = b;
		this.b1 = b1;
		this.setPreferredSize(new Dimension(1400,700));
		this.addMouseListener(this);
	}

	public void setBoard(Board b, Board b1){this.b=b;this.b1=b1;repaint();}




    public void paint(Graphics g){

    	g.drawRect(60,60,600,600);
    	g.drawRect(730,60,600,600);

    	for(int i=0; i < 10;i++){
    		for(int j=0; j < 10;j++){
    			g.drawRect(60*(i)+60,60*(j+1), 60,60);
    			g.drawRect(60*(i)+730,60*(j+1), 60,60);
    		}
    	}



    	for(int i=0;i < b.getAllBoats().size() ; i++){
    		drawBoats(g,b.getAllBoats().get(i).getBoats().get(0),b.getAllBoats().get(i).getBoats().get(b.getAllBoats().get(i).getSize()-1),1,1);
    	}



    	for(int a = 0; a < b1.isBoatDown().size(); a++){
    		drawBoats(g,b1.isBoatDown().get(a).get(0),b1.isBoatDown().get(a).get(1),730,1);
    	}





    	for(int i=0; i < N; i++){
    		for(int j=0; j < N;j++){

    			if(b.getBoard()[i][j].getBoat() && b1.getBoard()[i][j].getClick()){
    				g.setColor(Color.RED);
    				g.fillOval(60*(i+1)+15,60*(j+1)+15,30,30);
    			}
    			if(b.getBoard()[i][j].getHit()){
    				g.setColor(Color.GREEN);
    				g.fillOval(60*(i+1)+15,60*(j+1)+15,30,30);
    			}

    			if(b1.getBoard()[i][j].getHit()){
        			g.setColor(Color.GREEN);
        			g.fillOval(60*(i)+745,60*(j+1)+15,30,30);
        		}
    			if(b1.getBoard()[i][j].getBoat() && b1.getBoard()[i][j].getClick()){
        			g.setColor(Color.RED);
        			g.fillOval(60*(i)+745,60*(j+1)+15,30,30);
        		}
    		}
    	}




    	g.setColor(Color.BLACK);
    	for(int j = 1; j < N+1; j++){
    		g.setColor(Color.BLACK);

    		g.drawString(alpha[j-1],j*60+30,40);
    		g.drawString(beta[j-1],40,j*60+30);

    		g.drawString(alpha[j-1],j*60+700,40);
    		g.drawString(beta[j-1],40+670,j*60+30);

    		}
    }

    public void drawBoats(Graphics g, Point a, Point b, int vx, int vy){

    	int LARGEUR = (int)b.getX()+1 - (int)a.getX();
    	int HAUTEUR = (int)b.getY()+1 - (int)a.getY();
    	g.setColor(Color.BLACK);
    	if(vx == 1){
    		g.fillRoundRect((a.x+vx)*60,(a.y+1)*60,LARGEUR*60,HAUTEUR*60,60,60);
    	}
    	else{
    		g.fillRoundRect(a.x*60+vx,(a.y+1)*60,LARGEUR*60,HAUTEUR*60,60,60);

    		}
    }


	@Override
	public void mouseClicked(MouseEvent e){

		int x = ((e.getX() - 730)) / 60;
		int y = ((e.getY()- 60)) / 60;
		if(x >= 0 && x <= 9 && y >= 0 && y <= 9){
			Random r = new Random();
			b1.getBoard()[x][y].setHit(true);
			b1.getBoard()[x][y].setClick(true);
			int a = r.nextInt(10);
			int b = r.nextInt(10);
			this.b.getBoard()[a][b].setHit(true);
			this.b.getBoard()[a][b].setClick(true);

			this.repaint();
		}
		if(b.isOver() | b1.isOver()){
			setBoard(new Board(), new Board());

		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
