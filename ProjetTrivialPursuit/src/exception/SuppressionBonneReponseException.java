package exception;

public class SuppressionBonneReponseException extends Exception {
	public SuppressionBonneReponseException(){
		super("ATTENTION vous désirez supprimer la bonne réponse à la question/!\\\n");
	}

}
