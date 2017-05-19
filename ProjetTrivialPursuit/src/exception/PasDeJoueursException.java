package exception;

public class PasDeJoueursException extends Exception
{
    public PasDeJoueursException()
    {
        super("Il vous faut au moins un joueur !");
    }
}
