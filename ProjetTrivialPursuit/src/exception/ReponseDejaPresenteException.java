package exception;

public class ReponseDejaPresenteException extends Exception{
	public ReponseDejaPresenteException(){
		super("ATTENTION La bonne réponse à la question existe déjà/!\\\n");
	}

}
