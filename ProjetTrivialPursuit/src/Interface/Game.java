package Interface;

import classes.Joueur;
import javax.swing.JFrame;
import classes.Partie;
import classes.Question;
import exception.AucuneQuestionDefinieException;
import exception.PasDeJoueursException;
import exception.QuestionNonRepondueException;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class Game extends JFrame
{
    private Partie currentPartie = null;
    private JLabel currentPlayer = null;
    private AfficheCarte carte = null;
    
    public Game(List<Joueur> participants)
    {
        this.setTitle("Now Playing Trivial Pursuit");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        
        try 
        {
            this.currentPartie = new Partie(participants);
            this.add(this.getAfficheCarte());
        } 
        catch (QuestionNonRepondueException | PasDeJoueursException | AucuneQuestionDefinieException ex) 
        {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erreur fatale", JOptionPane.ERROR_MESSAGE);
            // TODO: changer de Card pour passer au menu principal
        }
    }
    
    public AfficheCarte getAfficheCarte() throws QuestionNonRepondueException, AucuneQuestionDefinieException
    {
        if(this.carte == null)
        {
            this.carte = new AfficheCarte(this.currentPartie.getRandomQuestion());
        }
        return this.carte;
    }
    
    public JLabel getCurrentPlayer()
    {
        if(this.currentPlayer == null)
        {
            this.currentPlayer = new JLabel(this.currentPartie.getTurn().getPseudo());
        }
        return this.currentPlayer;
    }
    
    class AfficheCarte extends JPanel
    {
        private Question ques = null;
        private JLabel question = null;
        private JLabel    categorie = null;
        private ButtonGroup qbg = null;
        private List<JRadioButton> choix = null;
        private JPanel choicesPanel = null;
        private JButton confirm = null;
        private AfficheCarte me = null;
        
        public AfficheCarte(Question q)
        {
            this.setVisible(true);
            this.ques = q;
            this.setLayout(new GridLayout(4, 1, 5, 5));
            this.add(this.getCategorie());
            this.add(this.getQuestion());
            this.add(this.getChoicesPanel());
            this.add(this.getButtonConfirm());
            this.me = this;
        }

        public JLabel getQuestion() 
        {
            if(this.question == null)
            {
                this.question = new JLabel();
                this.question.setText(this.ques.getStatement());
            }
            return question;
        }

        public JLabel getCategorie() 
        {
            if(this.categorie == null)
            {
                this.categorie = new JLabel(this.ques.getCategory().toString());
            }
            return categorie;
        }

        public ButtonGroup getQbg() 
        {
            if(this.qbg == null)
            {
                this.qbg = new ButtonGroup();
            }
            return qbg;
        }

        public List<JRadioButton> getChoix() 
        {
            if(this.choix == null)
            {
                this.choix = new ArrayList<>();
                Set<String> questionsTextes = this.ques.getChoices().keySet();
                for(String qu : questionsTextes)
                {
                    JRadioButton btn = new JRadioButton();
                    btn.setText(qu);
                    this.getQbg().add(btn);
                    this.choix.add(btn);
                }
            }
            return this.choix;
        }

        private JPanel getChoicesPanel() 
        {
            if(this.choicesPanel == null)
            {
                this.choicesPanel = new JPanel(new GridLayout(this.ques.getChoices().size(), 1, 5, 5));
                for(JRadioButton bt : this.getChoix())
                {
                    this.choicesPanel.add(bt);
                }
            }
            return this.choicesPanel;
        }

        private JButton getButtonConfirm() 
        {
            if(this.confirm == null)
            {
                this.confirm = new JButton("Confirmer");
                this.confirm.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        JRadioButton bt;
                        Enumeration<AbstractButton> listeChoix = me.getQbg().getElements();
                        while(listeChoix.hasMoreElements())
                        {
                            bt = (JRadioButton) me.getQbg().getElements().nextElement();
                            if(bt.isSelected())
                            {
                                
                                break;
                            }
                        }
                    }
                    
                });
            }
            return this.confirm;
        }
    }
}
