package le1.plp.expressions1.expression;

import le1.plp.expressions1.util.Tipo;
import le1.plp.expressions1.util.TipoPrimitivo;
import le1.plp.expressions2.memory.AmbienteCompilacao;
import le1.plp.expressions2.memory.AmbienteExecucao;

/**
 * Um objeto desta classe representa uma Expressao de Soma.
 */
public class ExpSoma extends ExpBinaria {

	/**
	 * Controi uma Expressao de Soma com as sub-expressoes especificadas.
	 * Assume-se que estas sub-expressoes resultam em <code>ValorInteiro</code>
	 * quando avaliadas.
	 * 
	 * @param esq Expressao da esquerda
	 * @param dir Expressao da direita
	 */
	public ExpSoma(Expressao esq, Expressao dir) {
		super(esq, dir, "+");
	}

	/**
	 * Retorna o valor da Expressao de Soma
	 * 
	 * @param amb
	 *            o ambiente de execu��o.
	 */
	public Valor avaliar(AmbienteExecucao amb) {
		return new ValorNumerico(
				((ValorNumerico) getEsq().avaliar(amb)).valor() +
						((ValorNumerico) getDir().avaliar(amb)).valor(),
				getEsq() instanceof ValorInteiro && getDir() instanceof ValorInteiro ? TipoPrimitivo.INTEIRO
						: TipoPrimitivo.REAL);
	}

	/**
	 * Realiza a verificacao de tipos desta expressao.
	 *
	 * @param amb
	 *            o ambiente de compila��o.
	 *
	 * @return <code>true</code> se os tipos da expressao sao validos;
	 *         <code>false</code> caso contrario.
	 */
	protected boolean checaTipoElementoTerminal(AmbienteCompilacao amb) {
		return ((getEsq().getTipo(amb).eInteiro() || getEsq().getTipo(amb).eReal())
				&& (getDir().getTipo(amb).eInteiro() || getDir().getTipo(amb).eReal()));
	}

	/**
	 * Retorna os tipos possiveis desta expressao.
	 * 
	 * @param amb
	 *            o ambiente de compila��o.
	 * 
	 * @return os tipos possiveis desta expressao.
	 */
	public Tipo getTipo(AmbienteCompilacao amb) {
		return getEsq().getTipo(amb).eInteiro() && getDir().getTipo(amb).eInteiro() ? TipoPrimitivo.INTEIRO
				: TipoPrimitivo.REAL;
	}

}
