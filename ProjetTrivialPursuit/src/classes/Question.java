package classes;

import java.util.HashMap;
import java.util.Map.Entry;

import exception.ReponseDejaPresenteException;
import exception.SuppressionBonneReponseException;

public class Question 
{
	private String Author;
	private Category Category;
	private String Statement;
	private HashMap<String,Boolean> Choices;
	
	public Question(String aut, Category cat, String stat)
        {
            this.Author=aut;
            this.Category=cat;
            this.Statement=stat;
            Choices=new HashMap<>();
	}
	
        //Methode qui ajoute un choix possible a la question
	public void addChoice(String choix,boolean rep)throws ReponseDejaPresenteException
        {
            if(Choices.containsKey(choix) || (rep == true && Choices.containsValue(true)))
            {
                throw new ReponseDejaPresenteException();
            }
            Choices.put(choix,rep);
	}
	
	public boolean deleteChoice(String choix) throws SuppressionBonneReponseException
        {
            if(Choices.containsKey(choix))
            {
                if(!Choices.get(choix))
                {
                    return Choices.remove(choix);
                }
                else
                {
                    throw new SuppressionBonneReponseException();
                }
            }
            return false;
	}
        
	public String getAuthor() 
        {
		return Author;
	}
        
	public Category getCategory() 
        {
		return Category;
	}
        
	public String getStatement() 
        {
		return Statement;
	}
        
	public String showMap()
        {
            String tmp="";
            for(Entry<String,Boolean>rep:Choices.entrySet())
            {
                    tmp+=rep+"\n";
            }
            return tmp;
	}
        
        public HashMap<String, Boolean> getChoices()
        {
            HashMap<String, Boolean> c = (HashMap<String, Boolean>) Choices.clone();
            return c;
	}
	
	@Override
	public boolean equals(Object o)
        {
            if(o instanceof Question)
            {
                    Question q=(Question)o;
                    return this.Statement.equals(q.Statement);
            }
            return false;
	}
	
}
