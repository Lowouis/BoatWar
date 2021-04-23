package view;

import modele.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controler.Controler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class View extends JFrame implements ActionListener{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Controler presenter;
	public static DisplayGraphics DP;

	public View(DisplayGraphics DP){
		super("Bataille naval");
		setSize(new Dimension(1400,960));
		Container cp = this.getContentPane();
		JPanel panel = new JPanel();
		cp.setLayout(new BorderLayout());

		cp.add(DP, BorderLayout.CENTER);
		cp.add(panel, BorderLayout.SOUTH);
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				DP.setBoard(new Board(),new Board());

			}
		});


		panel.add(reset);
		panel.setLayout(new GridLayout(1,2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setVisible(true);
	}



	public void setPresenter(Controler p){
		presenter = p;
	}

	public static DisplayGraphics getDP(){
		return DP;
	}

	public Controler getPresenter(){
		return this.presenter;
	}

	public void Update(){
		DP.repaint();
	}


	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
