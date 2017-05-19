package exception;

public class QuestionInexistanteException extends Exception{
	public QuestionInexistanteException(){
		super("ATTENTION La question que vous désirez supprimer est inexistante/!\\\n");
	}

}
