package db;

 //Exception personalizada para acesso a dados

public class DBException extends RuntimeException {

	// Serial version padr�o � o n�mero 1
	private static final long serialVersionUID = 1L;

	public DBException(String msg) {
		super(msg);       //transmitindo a mensagem para a runtime exception
	}
}
