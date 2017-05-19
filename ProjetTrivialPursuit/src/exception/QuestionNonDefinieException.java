package classes;

class QuestionNonDefinieException extends Exception 
{
    public QuestionNonDefinieException() 
    {
        super("Impossible de répondre car aucune question n'es actuellement sélectionnée.");
    }
}
