package li2.plp.imperative1.memory;

public class VariavelRepetidaException extends Exception {

	public VariavelRepetidaException() {
		super("Tipo do valor de entrada lido incomp�tivel");
	}

	public VariavelRepetidaException(String msg) {
		super(msg);
	}

}
