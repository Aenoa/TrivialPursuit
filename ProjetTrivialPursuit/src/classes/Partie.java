package classes;

import exception.AucuneQuestionDefinieException;
import exception.PasDeJoueursException;
import exception.QuestionNonRepondueException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Partie 
{
    
    private Date datePartie = null;
    private HashMap<Joueur, Camembert> scores = null;
    private List<Joueur> order = null;
    private Joueur turn = null;
    private Stack listeQuestions = null;
    private Question currentQuestion = null;
    
    public Partie(List<Joueur> joueurs) throws PasDeJoueursException
    {
        if(joueurs == null || joueurs.isEmpty())
        {
            throw new PasDeJoueursException();
        }
        
        this.scores = new HashMap<>();
        this.order = new ArrayList<>();
        this.datePartie = new Date();
        this.listeQuestions = new Stack();
        
        for(Joueur j : joueurs)
        {
            this.scores.put(j, new Camembert());
            this.order.add(j);
        }
    }
    
    public Question getRandomQuestion() throws QuestionNonRepondueException, AucuneQuestionDefinieException
    {
        if(this.currentQuestion != null)
        {
            throw new QuestionNonRepondueException();
        }
        this.currentQuestion = this.listeQuestions.getRandomQuestion();
        return this.currentQuestion;
    }
    
    public boolean answerQuestion(String reply) throws QuestionNonDefinieException
    {
        if(this.currentQuestion == null)
        {
            throw new QuestionNonDefinieException();
        }
        
        boolean goodReply = this.currentQuestion.getChoices().get(reply);
        
        if(goodReply)
        {
            this.scores.get(this.turn).switchCamembert(this.currentQuestion.getCategory());
        }
        this.currentQuestion = null;
        return goodReply;
    }
    
    public Joueur nextTurn() throws QuestionNonRepondueException
    {
        if(this.currentQuestion != null)
        {
            throw new QuestionNonRepondueException();
        }
        this.turn = (this.order.size()-1) == this.order.indexOf(this.turn) ? this.order.get(0) : this.order.get(this.order.indexOf(this.turn)+1);
        return this.turn;
    }

    public Date getDatePartie() 
    {
        return datePartie;
    }

    public HashMap<Joueur, Camembert> getScores() 
    {
        return scores;
    }

    public List<Joueur> getOrder() 
    {
        return order;
    }

    public Joueur getTurn() 
    {
        return turn;
    }
}
