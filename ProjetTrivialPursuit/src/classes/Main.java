package classes;

import exception.QuestionDejaPresenteException;
import exception.ReponseDejaPresenteException;

public class Main {
	public static void main(String [] args)
        {
		Question q1=new Question("Deborah",Category.Geography,"Quelle est la capitale de la Belgique?\n");
		Question q2=new Question("Hugo",Category.Economy,"La Belgique est une économié:\n");
		Question q3=new Question("Mélanie",Category.History,"Quand a eu lieu les attentats aux Etats-Unis?\n");
                
		try
                {
                    q1.addChoice("Paris", false); 
                    q1.addChoice("Bruxelles",true);
                    q1.addChoice("Lisbonne",false);
                    q1.addChoice("Berlin",false);
		}
		catch(ReponseDejaPresenteException e)
                {
                    System.out.println(e.toString());
		}
                
		try
                {
                    q2.addChoice("Aucune",false);
                    q2.addChoice("Capitaliste", true);
                    q2.addChoice("Communiste",false);
                    q2.addChoice("Socialiste", false);
		}
		catch(ReponseDejaPresenteException e)
                {
                    System.out.println(e.toString());
		}
                
		try
                {
                    q3.addChoice("11 Janvier", false);
                    q3.addChoice("11 Octobre",false);
                    q3.addChoice("11 Mars",false);
                    q3.addChoice("11 Septembre",true);
		}
		catch(ReponseDejaPresenteException e)
                {
                    System.out.println(e.toString());
		}
                
                Stack littleStack = new Stack();
                try{littleStack.addQuestion(q1);}catch(QuestionDejaPresenteException ex){System.err.println("erreur ajout Q1");};
                try{littleStack.addQuestion(q2);}catch(QuestionDejaPresenteException ex){System.err.println("erreur ajout Q2");};
                try{littleStack.addQuestion(q3);}catch(QuestionDejaPresenteException ex){System.err.println("erreur ajout Q3");};
	}

}
