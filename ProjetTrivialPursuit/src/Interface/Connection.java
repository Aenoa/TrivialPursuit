package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import classes.Players;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Connection extends JFrame{
	class MenuCentralLine1 extends JPanel{
		private JLabel jlPseudo;
		private JTextField jtPseudo;
		
		public MenuCentralLine1(){
			this.setLayout(new FlowLayout(FlowLayout.CENTER));
			this.setOpaque(false);
			this.setBackground(new Color(0,0,0,65));
			this.add(this.getJlPseudo());
			this.add(this.getJtPseudo());
		}

		public JLabel getJlPseudo() {
			if(jlPseudo==null){
				jlPseudo=new JLabel("Nickname: ");
				jlPseudo.setForeground(Color.WHITE);
				Font font=new Font("Arial",Font.BOLD,15);
				jlPseudo.setFont(font);
			}
			return jlPseudo;
		}

		public JTextField getJtPseudo() {
			if(jtPseudo==null){
				jtPseudo=new JTextField(20);
			}
			return jtPseudo;
		}

		
	}
	class MenuCentralLine2 extends JPanel{
		private JLabel jlMdp;
		private JPasswordField jtMdp;
		
		public MenuCentralLine2(){
			this.setLayout(new FlowLayout(FlowLayout.CENTER));
			this.setOpaque(false);
			this.setBackground(new Color(0,0,0,65));
			this.add(this.getJlMdp());
			this.add(this.getJtMdp());
		}

		public JLabel getJlMdp() {
			if(jlMdp==null){
				jlMdp=new JLabel("Password: ");
				jlMdp.setForeground(Color.WHITE);
				Font font=new Font("Arial",Font.BOLD,15);
				jlMdp.setFont(font);
			}
			return jlMdp;
		}

		public JPasswordField getJtMdp() {
			if(jtMdp==null){
				jtMdp=new JPasswordField(20);
			}
			return jtMdp;
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
	class MdpOublie extends JPanel{
		private JLabel jlMDP;
		
		public MdpOublie(){
			this.setOpaque(false);
			this.setBackground(new Color(0,0,0,65));
			this.add(this.getJlMDP());
		}

		public JLabel getJlMDP() {
			if(jlMDP==null){
				jlMDP=new JLabel("Mot de passe oublié? ");
				jlMDP.setForeground(Color.BLUE);
				Font font=new Font("Arial",Font.ITALIC,15);
				jlMDP.setFont(font);
			}
			return jlMDP;
		}
		
	}
	class MenuCentral extends JPanel{
		private MenuCentralLine0 ligne0;
		private MenuCentralLine1 ligne1;
		private MenuCentralLine2 ligne2;
		private MenuInferieur inf;
		private MdpOublie mdp;
		private Connection parent;
		
		public MenuCentral(Connection parent)
		{
			this.parent = parent;
			this.setLayout(new GridLayout(9, 2));
			this.setOpaque(false);
			this.setBackground(new Color(0,0,0,65));
			this.add(this.getLigne0());
			this.add(this.getLigne1());
			this.add(this.getLigne2());
			this.add(this.getInf());
			this.add(this.getMdp());
		}
		
		public Connection getMyParent()
		{
			return this.parent;
		}
		
		public MdpOublie getMdp() {
			if(mdp==null){
				mdp=new MdpOublie();
			}
			return mdp;
		}
		public MenuCentralLine0 getLigne0(){
			if(ligne0==null){
				ligne0=new MenuCentralLine0();
			}
			return ligne0;
		}

		public MenuCentralLine1 getLigne1() {
			if(ligne1==null){
				ligne1=new MenuCentralLine1();
			}
			return ligne1;
		}

		public MenuCentralLine2 getLigne2() {
			if(ligne2==null){
				ligne2=new MenuCentralLine2();
			}
			return ligne2;
		}

		public MenuInferieur getInf() {
			if(inf==null){
				inf=new MenuInferieur(this);
			}
			return inf;
		}
		
	
	}
	class MenuInferieur extends JPanel
	{
		private JButton jbConnection;
		private JButton jbQuit;
		private MenuCentral parent;
		
		public MenuInferieur(MenuCentral parent)
		{
			this.parent = parent;
			this.setLayout(new FlowLayout(FlowLayout.CENTER));
			this.setOpaque(false);
			this.setBackground(new Color(0,0,0,65));
			this.add(this.getJbConnection());
			this.add(this.getJbQuit());
		}

		public JButton getJbConnection() {
			if(jbConnection == null)
			{
				this.jbConnection = new JButton("Connection");
				this.jbConnection.setPreferredSize(new Dimension(150, 30));
				jbConnection.addMouseListener(new MouseListener() {
					
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
					public void mouseClicked(MouseEvent arg0)
					{
						String pseudo = parent.getLigne1().getJtPseudo().getText();
						String password = "";
						for(int i = 0; i < parent.getLigne2().getJtMdp().getPassword().length; i++)
						{
							password += parent.getLigne2().getJtMdp().getPassword()[i];
						}
						
						if(Players.rechercherJoueur(pseudo, password))
						{
							JOptionPane.showMessageDialog(	
								parent.getMyParent(), 
								"Vous êtes connecté avec succès!", 
								"Connecté", 
								JOptionPane.INFORMATION_MESSAGE
							);
						}
						else
						{
							JOptionPane.showMessageDialog(	
								parent.getMyParent(), 
								"Le nom de compte et/ou mot de passe est incorrect.", 
								"Compte invalide", 
								JOptionPane.ERROR_MESSAGE
							);
						}
					}
				});
			}
			return jbConnection;
		}

		public JButton getJbQuit() {
			if(jbQuit == null)
			{
				this.jbQuit = new JButton("Quit");
				this.jbQuit.setPreferredSize(new Dimension(150, 30));
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
						System.exit(0);
						
					}
				});
			}
			return jbQuit;
		}
	}
        
    private MenuCentral mc;
        
	public Connection(){
		
		super("Trivial Pursuit - Connection");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension currentScreen = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		Dimension wantedResolution = new Dimension((int)currentScreen.getWidth() -500, (int) currentScreen.getHeight() -250);
		
		this.setSize(wantedResolution);
		this.setMinimumSize(wantedResolution);
		this.setMaximumSize(wantedResolution);
		
		this.setResizable(false);
		
		 this.setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("PursuitFont.jpg")))); 
		 this.setLayout(new BorderLayout());
		  
		this.add(this.getMc(), BorderLayout.CENTER);
		//this.add(new MenuInferieur(), BorderLayout.SOUTH);
	}

    public MenuCentral getMc() 
    {
        if(this.mc == null)
        {
            this.mc = new MenuCentral(this);
        }
        return mc;
    }
}

