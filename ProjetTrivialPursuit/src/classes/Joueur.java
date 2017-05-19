package classes;

public class Joueur{
	private String Pseudo;
	private String Mdp;
	private String adresseMail;
	private int Score;
	
	public Joueur(String pseu, String mdp, String addMail, int score)
        {
            this.Pseudo=pseu;
            this.Mdp=mdp;
            this.adresseMail=addMail;
            if(score>=0)
            {
                this.Score=score;
            }
	}
	
	public String getPseudo() 
        {
            return Pseudo;
	}

	public String getMdp() 
        {
            return Mdp;
	}

	public String getAdresseMail() 
        {
            return adresseMail;
	}

	public int getScore() 
        {
            return Score;
	}
        
        @Override
	public boolean equals(Object o)
        {
            if(o instanceof Joueur)
            {
                    Joueur j=(Joueur)o;
                    return j.getPseudo().equals(this.Pseudo);
            }
            return false;
	}
}
