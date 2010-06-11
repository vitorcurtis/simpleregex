package sistema.expressaoRegular.conversao.conversores;

import java.util.Vector;

import sistema.expressaoRegular.conversao.ParserConversor;
import sistema.expressaoRegular.gramatica.Gramatica;
import sistema.expressaoRegular.gramatica.Producao;
import sistema.expressaoRegular.gramatica.Variavel;
import sistema.expressaoRegular.parser.Nodo;

/**
 * Cria produ��es para ER da forma: A+BY, Y sendo vari�vel que deriva +alfa
 */
public class ER_Var_Ou_VarX implements Conversor {
	private static final Conversor _c;
	
	static { _c = new ER_Var_Ou_VarX(); }

	public static Conversor getInstance() { return _c; }
	
	@Override
	public int converter(Gramatica g, Vector<Variavel> varPendente, Vector<Variavel> ouPendente, ParserConversor p, Nodo n, int terminaisLidos) {
		Variavel X = varPendente.remove(0);
		ouPendente.add(0, X);
		
		Variavel varB = new Variavel();
		g.addVariavel(varB);
		varPendente.add(0, varB);
		
		Variavel varA = new Variavel();
		g.addVariavel(varA);
		varPendente.add(0, varA);
		
		// Produ��o X->A
		Producao _p = new Producao(X, null);
		_p.addSimboloCorpo(varA);
		g.addProducao(_p);
		
		// Produ��o X->B
		_p = new Producao(X, null);
		_p.addSimboloCorpo(varB);
		g.addProducao(_p);
		
		return terminaisLidos;
	}
}