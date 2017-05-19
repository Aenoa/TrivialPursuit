package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import classes.Joueur;
import Interface.Connection.MenuCentral;

public class MenuJeu extends JFrame {
	class NewGame extends JPanel{
		private JButton NewGame;
		
		public NewGame()
		{
			this.setLayout(new FlowLayout(FlowLayout.CENTER));
			this.setOpaque(false);
			this.setBackground(new Color(0,0,0,65));
			this.add(this.getNewGame());
		
		}

		public JButton getNewGame() {
			if(NewGame==null){
				NewGame=new JButton("New game!");
				NewGame.setPreferredSize(new Dimension(110,50));
				this.setOpaque(false);
			}
			return NewGame;
		}
		
	}
	class ContinueGame extends JPanel{
		private JButton Continue;
		
		public ContinueGame(){
			this.setLayout(new FlowLayout(FlowLayout.CENTER));
			this.setOpaque(false);
			this.setBackground(new Color(0,0,0,65));
			this.add(this.getContinue());
		}

		public JButton getContinue() {
			if(Continue==null){
				Continue=new JButton("Continue!");
				Continue.setPreferredSize(new Dimension(110,50));
			}
			return Continue;
		}
		
	}
	class Option extends JPanel{
		private JButton option;
		
		public Option(){
			this.setLayout(new FlowLayout(FlowLayout.CENTER));
			this.setOpaque(false);
			this.setBackground(new Color(0,0,0,65));
			this.add(this.getOption());
		}

		public JButton getOption() {
			if(option==null){
				option=new JButton("Options");
				option.setPreferredSize(new Dimension(110,50));
			}
			return option;
		}
		
	}
	class MenuCentralLine0 extends JPanel{
		private JLabel jlEspace;
		
		public MenuCentralLine0(){
			this.setLayout(new FlowLayout(FlowLayout.CENTER));
			this.setOpaque(false);
			this.setBackground(new Color(0,0,0,65));
			this.add(this.getJlEspace());
		}
		
		public JLabel getJlEspace(){
			if(jlEspace==null){
				jlEspace=new JLabel("");
			}
			return jlEspace;
		}
	}
	class ChoiceGame extends JPanel{
		private MenuCentralLine0 Ligne0;
		private NewGame newGame;
		private ContinueGame Continue;
		private Option options;
		private MenuInferieur menu;
		private ShowScore score;
		
		public ChoiceGame(){
			this.setLayout(new GridLayout(6, 2));
			this.setOpaque(false);
			this.setBackground(new Color(0,0,0,65));
			this.add(this.getLigne0());
			this.add(this.getNewGame());
			this.add(this.getContinue());
			this.add(this.getOption());
			this.add(this.getScore());
			this.add(this.getMenu());
		}
		public MenuCentralLine0 getLigne0(){
			if(Ligne0==null){
				Ligne0=new MenuCentralLine0();
			}
			return Ligne0;
		}
		public ShowScore getScore(){
			if(score==null){
				score=new ShowScore();
			}
			return score;
		}
		
		public MenuInferieur getMenu() {
			if(menu==null){
				menu=new MenuInferieur();
			}
			return menu;
		}

		public Option getOption(){
			if(options==null){
				options=new Option();
			}
			return options;
		}

		public NewGame getNewGame() {
			if(newGame==null){
				newGame=new NewGame();
			}
			return newGame;
		}

		public ContinueGame getContinue() {
			if(Continue==null){
				Continue=new ContinueGame();
			}
			return Continue;
		}
		
	}
	class MenuInferieur extends JPanel
	{
		private JButton jbQuit;
		
		public MenuInferieur()
		{
			this.setLayout(new FlowLayout(FlowLayout.CENTER));
			this.setOpaque(false);
			this.setBackground(new Color(0,0,0,65));
			this.add(this.getJbQuit());
		}


		public JButton getJbQuit() {
			if(jbQuit == null)
			{
				this.jbQuit = new JButton("Quit");
				this.jbQuit.setPreferredSize(new Dimension(110, 50));
				jbQuit.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent arg0) {
						// TODO Auto-generated method stub
						System.exit(0);;
						
					}
				});
			}
			return jbQuit;
		}
	}
	class ShowScore extends JPanel{
		private JButton score;
		
		public ShowScore(){
			this.setLayout(new FlowLayout(FlowLayout.CENTER));
			this.setOpaque(false);
			this.setBackground(new Color(0,0,0,65));
			this.add(this.getScore());
		}

		public JButton getScore() {
			if(score==null){
				score=new JButton("Scores");
				score.setPreferredSize(new Dimension(110, 50));
			}
			return score;
		}
		
	}
	
public MenuJeu(){
		
		super("Choice the option that you want: ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension currentScreen = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		Dimension wantedResolution = new Dimension((int)currentScreen.getWidth() -500, (int) currentScreen.getHeight() -250);
		
		this.setSize(wantedResolution);
		this.setMinimumSize(wantedResolution);
		this.setMaximumSize(wantedResolution);
		this.setResizable(false);
		
		this.setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("PursuitFont.jpg")))); 
		  this.setLayout(new BorderLayout());
		
		this.add(new ChoiceGame(), BorderLayout.CENTER);
		//this.add(new MenuInferieur(), BorderLayout.SOUTH);
	}

}
