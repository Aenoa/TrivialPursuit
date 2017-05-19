package exception;

public class QuestionDejaPresenteException extends Exception {
	public QuestionDejaPresenteException(){
		super("ATTENTION La question que vous désirez ajouter est déjà présente/!\\\n");
	}

}
