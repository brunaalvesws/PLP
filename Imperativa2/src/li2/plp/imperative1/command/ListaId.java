package li2.plp.imperative1.command;

import java.util.LinkedList;
import java.util.List;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions2.expression.Expressao;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2.plp.imperative1.memory.ListaValor;
import li2.plp.imperative1.util.Lista;

public class ListaId extends Lista<Expressao> {

	public ListaId() {

	}

	public ListaId(Expressao expressao) {
		super(expressao, new ListaId());
	}

	public ListaId(Expressao expressao, ListaId listaId) {
		super(expressao, listaId);
	}

	public ListaValor avaliar(AmbienteExecucaoImperativa ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		if (length() >= 2)
			return new ListaValor(getHead().avaliar(ambiente),
					((ListaId) getTail()).avaliar(ambiente));
		else if (length() == 1)
			return new ListaValor(getHead().avaliar(ambiente));
		else
			return new ListaValor();
	}

	public List<Tipo> getTipos(AmbienteCompilacaoImperativa ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {

		List<Tipo> result = new LinkedList<Tipo>();

		if (this.length() >= 2) {
			result.add(getHead().getTipo(ambiente));
			result.addAll(((ListaId) getTail()).getTipos(ambiente));
		} else if (length() == 1) {
			result.add(getHead().getTipo(ambiente));
		}
		return result;
	}

}
