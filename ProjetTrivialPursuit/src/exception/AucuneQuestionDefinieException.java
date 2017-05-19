package exception;

public class AucuneQuestionDefinieException extends Exception
{
    public AucuneQuestionDefinieException()
    {
        super("Aucune question n'a été entrée dans la stack !");
    }
}
