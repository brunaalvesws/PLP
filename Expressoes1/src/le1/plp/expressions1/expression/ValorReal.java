package le1.plp.expressions1.expression;

import le1.plp.expressions1.util.TipoPrimitivo;

/**
 * Objetos desta classe encapsulam valor inteiro.
 */
public class ValorReal extends ValorNumerico {

	public ValorReal(Double valor) {
		super(valor, TipoPrimitivo.REAL);
	}

}
