package exception;

public class QuestionNonRepondueException extends Exception
{
    public QuestionNonRepondueException()
    {
        super("Impossible de changer de question si la question n'a pas été répondue !");
    }
}
