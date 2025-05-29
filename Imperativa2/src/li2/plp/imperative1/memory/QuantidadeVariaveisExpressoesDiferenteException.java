package li2.plp.imperative1.memory;

public class QuantidadeVariaveisExpressoesDiferenteException extends Exception {

	public QuantidadeVariaveisExpressoesDiferenteException() {
		super("Tipo do valor de entrada lido incomp�tivel");
	}

	public QuantidadeVariaveisExpressoesDiferenteException(String msg) {
		super(msg);
	}

}
