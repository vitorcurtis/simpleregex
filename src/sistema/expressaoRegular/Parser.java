package sistema.expressaoRegular;

import sistema.expressaoRegular.gramatica.Gramatica;
import sistema.expressaoRegular.gramatica.Terminal;
import sistema.expressaoRegular.gramatica.Variavel;
import sistema.expressaoRegular.parser.GenericParser;
import sistema.expressaoRegular.parser.TabelaLL1.ColunasLL1;

public class Parser extends GenericParser{
	private String stringEstrada;
	private Gramatica _G;

	public Parser(Gramatica _g) {
		super();
		
		_G = _g;
		gerarFirstFollow();
	}
	
	private void gerarFirstFollow() {
		System.out.println("Gerar First and Follow");
	}
	
	public void iniciar(String stringEntrada) {
		this.stringEstrada = stringEntrada;
		
		super.iniciar(stringEntrada.length(), _G._VariavelInicial);
	}
	
	@Override
	protected ColunasLL1 getDerivacoesLL1(Variavel linha, int charFirst) {
		return _G._TabLL1.getDerivacoesLL1(linha, new Terminal(stringEstrada.charAt(charFirst)));
	}
	
	@Override
	protected boolean itMatch(Terminal t, int charACasar) {
		return t.equals(stringEstrada.charAt(charACasar));
	}
}