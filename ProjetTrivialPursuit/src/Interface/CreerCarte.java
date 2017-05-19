package Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import classes.Category;
import classes.Question;
import exception.ReponseDejaPresenteException;

public class CreerCarte extends JFrame{
	class MenuSuperieur extends JPanel
	{
		private JLabel jlStatement;
		private JLabel jlCategory;
		private JTextField jtStatement;
		private JComboBox jcbCategory;
		
		public MenuSuperieur()
		{
			this.setLayout(new FlowLayout(FlowLayout.LEFT));
			this.add(this.getJlStatement());
			this.add(this.getJtStatement());
			this.add(this.getJlCategory());
			this.add(this.getJcbCategory());
		}

		public JLabel getJlStatement() {
			if(jlStatement == null)
			{
				jlStatement = new JLabel("Statement: ");
			}
			return jlStatement;
		}

		public JLabel getJlCategory() {
			if(jlCategory == null)
			{
				jlCategory = new JLabel("Category: ");
			}
			return jlCategory;
		}

		public JTextField getJtStatement() {
			if(jtStatement == null)
			{
				jtStatement = new JTextField(30);
			}
			return jtStatement;
		}

		public JComboBox getJcbCategory() {
			if(jcbCategory == null)
			{
				jcbCategory = new JComboBox(Category.values());
			}
			return jcbCategory;
		}
	}
	
	class MenuCentralLine extends JPanel
	{
		private JRadioButton	jrTrue;
		private JRadioButton	jrFalse;
		private JTextField		jtData;
		private JLabel			jlChoice;
		private ButtonGroup		bgp;
		
		public MenuCentralLine()
		{
			this.setLayout(new FlowLayout(FlowLayout.LEFT));
			this.initBgp();
			this.add(this.getJlChoice());
			this.add(this.getJtData());
			this.add(this.getJrTrue());
			this.add(this.getJrFalse());
		}

		public void initBgp() {
			if(this.bgp == null)
			{
				this.bgp = new ButtonGroup();
			}
		}
		
		public JRadioButton getJrTrue() {
			if(jrTrue == null)
			{
				this.jrTrue = new JRadioButton();
				this.jrTrue.setText("True");
				this.bgp.add(jrTrue);
			}
			return jrTrue;
		}

		public JRadioButton getJrFalse() {
			if(jrFalse == null)
			{
				this.jrFalse = new JRadioButton();
				this.jrFalse.setText("False");
				this.bgp.add(jrFalse);
			}
			return jrFalse;
		}

		public JTextField getJtData() {
			if(jtData == null)
			{
				this.jtData = new JTextField(30);
			}
			return jtData;
		}

		public JLabel getJlChoice() {
			if(jlChoice == null)
			{
				this.jlChoice = new JLabel("Choice: ");
			}
			return jlChoice;
		}
		
		public ButtonGroup getJbt()
		{
			if(this.bgp == null)
			{
				this.initBgp();
			}
			return this.bgp;
		}
	}
	
	class MenuCentral extends JPanel
	{
		private MenuCentralLine ligne1, ligne2, ligne3, ligne4;
		private JSeparator jsp;
		
		public MenuCentral()
		{
			this.setLayout(new GridLayout(8, 1, 5, 5));
			this.add(this.getJsp());
			this.add(this.getLigne1());
			this.add(this.getLigne2());
			this.add(this.getLigne3());
			this.add(this.getLigne4());
		}

		public MenuCentralLine getLigne1() {
			if(this.ligne1 == null)
			{
				this.ligne1 = new MenuCentralLine();
			}
			return ligne1;
		}

		public MenuCentralLine getLigne2() {
			if(this.ligne2 == null)
			{
				this.ligne2 = new MenuCentralLine();
			}
			return ligne2;
		}

		public MenuCentralLine getLigne3() {
			if(this.ligne3 == null)
			{
				this.ligne3 = new MenuCentralLine();
			}
			return ligne3;
		}

		public MenuCentralLine getLigne4() {
			if(this.ligne4 == null)
			{
				this.ligne4 = new MenuCentralLine();
			}
			return ligne4;
		}

		public JSeparator getJsp() {
			if(this.jsp == null)
			{
				this.jsp = new JSeparator();
			}
			return jsp;
		}
	}
	class MdpOublie extends JPanel{
		private JLabel jlMDP;
		
		public MdpOublie(){
			this.add(this.getJlMDP());
		}

		public JLabel getJlMDP() {
			if(jlMDP==null){
				jlMDP=new JLabel("Mot de passe oublié? ");
			}
			return jlMDP;
		}
		
	}
	class MenuInferieur extends JPanel
	{
		private JButton jbSave;
		private MenuSuperieur ms;
		private MenuCentral mc;
		
		public MenuInferieur(MenuSuperieur menu, MenuCentral mc)
		{
			this.ms=menu;
                        this.mc=mc;
			this.setLayout(new FlowLayout(FlowLayout.RIGHT));
			this.add(this.getJbSave());
		}

		public JButton getJbSave() {
			if(jbSave == null)
			{
				this.jbSave = new JButton("Create");
				this.jbSave.setPreferredSize(new Dimension(150, 30));
				this.jbSave.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						Question q=new Question("Florquin", (Category)ms.getJcbCategory().getSelectedItem(), ms.getJtStatement().getText());
						try {
                                                    String quest = mc.getLigne1().getJtData().getText();
                                                    boolean val = mc.getLigne1().getJrTrue().isSelected();
                                                    q.addChoice(quest, val);
                                                    
						} catch (ReponseDejaPresenteException | NullPointerException e) {
							JOptionPane.showMessageDialog(mc, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
						}
						try {
                                                    String quest = mc.getLigne2().getJtData().getText();
                                                    boolean val = mc.getLigne2().getJrTrue().isSelected();
                                                    q.addChoice(quest, val);
						} catch (ReponseDejaPresenteException | NullPointerException e) {
							JOptionPane.showMessageDialog(mc, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
						}
						try {
                                                    String quest = mc.getLigne3().getJtData().getText();
                                                    boolean val = mc.getLigne3().getJrTrue().isSelected();
                                                    q.addChoice(quest, val);
						} catch (ReponseDejaPresenteException | NullPointerException e) {
							JOptionPane.showMessageDialog(mc, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
						}
						try {
                                                    String quest = mc.getLigne4().getJtData().getText();
                                                    boolean val = mc.getLigne4().getJrTrue().isSelected();
                                                    q.addChoice(quest, val);
						} catch (ReponseDejaPresenteException | NullPointerException e) {
							JOptionPane.showMessageDialog(mc, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
						}
						JOptionPane.showMessageDialog(mc, "Question ajoutée avec succès!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
						
					}
					
				});
			}
			return jbSave;
		}

	}
	
	class MenuCentralGL extends JPanel
	{
		private GroupLayout gl;
		private JLabel choice1, choice2, choice3, choice4;
		private JRadioButton jrt1, jrf1, jrt2, jrf2, jrt3, jrf3, jrt4, jrf4;	
		private ButtonGroup bg1, bg2, bg3, bg4;
		private JTextField jtf1, jtf2, jtf3, jtf4;
		
		public MenuCentralGL()
		{
			jrt1 = new JRadioButton();
			jrt1.setText("true");
			jrf1 = new JRadioButton();
			jrf1.setText("false");
			
			jrt2 = new JRadioButton();
			jrt2.setText("true");
			jrf2 = new JRadioButton();
			jrf2.setText("false");
			
			jrt3 = new JRadioButton();
			jrt3.setText("true");
			jrf3 = new JRadioButton();
			jrf3.setText("false");
			
			jrt4 = new JRadioButton();
			jrt4.setText("true");
			jrf4 = new JRadioButton();
			jrf4.setText("false");
			
			jtf1 = new JTextField();
			jtf2 = new JTextField();
			jtf3 = new JTextField();
			jtf4 = new JTextField();
			
			bg1 = new ButtonGroup();
			bg1.add(jrt1);
			bg1.add(jrf1);
			
			bg2 = new ButtonGroup();
			bg2.add(jrt2);
			bg2.add(jrf2);
			
			bg3 = new ButtonGroup();
			bg3.add(jrt3);
			bg3.add(jrf3);
			
			bg4 = new ButtonGroup();
			bg4.add(jrt4);
			bg4.add(jrf4);
			
			choice1 = new JLabel("Choice: ");
			choice2 = new JLabel("Choice: ");
			choice3 = new JLabel("Choice: ");
			choice4 = new JLabel("Choice: ");
			
			gl = new GroupLayout(this);
			this.setLayout(gl);
			
			gl.setHorizontalGroup(gl.createSequentialGroup()
					.addGroup(gl.createParallelGroup()
						.addGap(30)
						.addGap(30)
						.addGap(30)
						.addGap(30)
						.addGap(30)
							)
				.addGroup(gl.createParallelGroup()
					.addComponent(choice1)
					.addComponent(choice2)
					.addComponent(choice3)
					.addComponent(choice4)
				)
				.addGroup(gl.createParallelGroup()
					.addComponent(jtf1)
					.addComponent(jtf2)
					.addComponent(jtf3)
					.addComponent(jtf4)
				)	
				.addGroup(gl.createParallelGroup()
					.addComponent(jrt1)
					.addComponent(jrt2)
					.addComponent(jrt3)
					.addComponent(jrt4)
				)	
				.addGroup(gl.createParallelGroup()
					.addComponent(jrf1)
					.addComponent(jrf2)
					.addComponent(jrf3)
					.addComponent(jrf4)
				)
			);
			
			gl.setVerticalGroup(gl.createSequentialGroup()
					.addGroup(gl.createParallelGroup()
						.addGap(30)
						.addComponent(choice1)
						.addComponent(jtf1,30,30,30)
						.addComponent(jrt1,30,30,30)
						.addComponent(jrf1,30,30,30)
					)
					.addGroup(gl.createParallelGroup()
						.addGap(30)
						.addComponent(choice2)
						.addComponent(jtf2,30,30,30)
						.addComponent(jrt2,30,30,30)
						.addComponent(jrf2,30,30,30)	
					)
					.addGroup(gl.createParallelGroup()
						.addGap(30)
						.addComponent(choice3)
						.addComponent(jtf3,30,30,30)
						.addComponent(jrt3,30,30,30)
						.addComponent(jrf3,30,30,30)	
					)
					.addGroup(gl.createParallelGroup()
						.addGap(30)
						.addComponent(choice4)
						.addComponent(jtf4,30,30,30)
						.addComponent(jrt4,30,30,30)
						.addComponent(jrf4,30,30,30)	
					)
			);
			
			gl.setAutoCreateGaps(true);
		}
	}
        
        
	public MenuSuperieur getMenuSuperieur(){
		if(ms==null){
			ms=new MenuSuperieur();
		}
		return ms;
	}
	public MenuCentral getMenuCentral(){
		if(mc==null){
			mc=new MenuCentral();
		}
		return mc;
	}
        private MenuInferieur getMenuInferieur()
        {
            if(this.mi == null)
            {
                this.mi = new MenuInferieur(this.getMenuSuperieur(), this.getMenuCentral());
            }
            return this.mi;
        }
        
	private MenuSuperieur ms=null;
	private MenuCentral mc=null;
        private MenuInferieur mi = null;
        
	public CreerCarte()
	{
		super("Creation de la carte");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension currentScreen = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		Dimension wantedResolution = new Dimension((int)currentScreen.getWidth() -500, (int) currentScreen.getHeight() -250);
		
		this.setSize(wantedResolution);
		this.setMinimumSize(wantedResolution);
		this.setMaximumSize(wantedResolution);
		this.setResizable(false);
		
		this.setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("PursuitFont.jpg")))); 
		this.setLayout(new BorderLayout());
		
		this.add(this.getMenuSuperieur(), BorderLayout.NORTH);
		this.add(this.getMenuCentral(), BorderLayout.CENTER);
		this.add(this.getMenuInferieur(), BorderLayout.SOUTH);
	}

}
