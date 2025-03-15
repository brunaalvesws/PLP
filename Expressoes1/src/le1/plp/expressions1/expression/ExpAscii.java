package le1.plp.expressions1.expression;

import le1.plp.expressions1.util.Tipo;
import le1.plp.expressions1.util.TipoPrimitivo;
import le1.plp.expressions2.memory.AmbienteCompilacao;
import le1.plp.expressions2.memory.AmbienteExecucao;

/**
 * Um objeto desta classe representa uma Expressao que retorna o valor na tabela
 * ASCII de um Caracter
 */
public class ExpAscii extends ExpUnaria {

	/**
	 * Controi uma Expressao de tamanho com a expressao especificada
	 * assume-se que <code>exp</code> &eacute; uma expressao cuja avaliacao
	 * resulta num <code>ValorString</code>
	 */
	public ExpAscii(Expressao exp) {
		super(exp, "ascii");
	}

	/**
	 * Retorna o valor da Expressao que diz o valor na tabela ascii de um char.
	 * 
	 * @param amb
	 *            o ambiente de execu��o.
	 */
	public Valor avaliar(AmbienteExecucao amb) {
		return new ValorInteiro((int) ((ValorChar) getExp().avaliar(amb)).valor());
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
		return (getExp().getTipo(amb).eChar());
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
		return TipoPrimitivo.INTEIRO;
	}

}
