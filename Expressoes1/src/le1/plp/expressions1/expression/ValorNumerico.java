package le1.plp.expressions1.expression;

import le1.plp.expressions1.util.Tipo;
import le1.plp.expressions2.memory.AmbienteCompilacao;

/**
 * Objetos desta classe encapsulam valor inteiro.
 */
public class ValorNumerico extends ValorConcreto<Double> {

	private Tipo tipo;

	public ValorNumerico(double valor, Tipo tp) {
		super(valor);
		this.tipo = tp;

	}

	@Override
	public Tipo getTipo(AmbienteCompilacao amb) {
		return this.tipo;
	}

}
