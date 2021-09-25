package BibliTeX;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Controla as tranformações
 * @author vanderson
 *
 */
public class TransformaTexto {
	
//___________________atributos__________________________
	/**
	 * atributo que contém a quantidade de tranformações realizadas
	 */
	private int contaTransformacao;
	/**
	 * armazena as tranformações realizadas para consulta posteriormente 
	 */
	private List<String> historico;
	/**
	 * armazena os textos recebidos que serão tranformados
	 */
	private Set<String> originais; 
	/**
	 * armazena as transformações, o nome e a instância do objeto de cada transformação. 
	 */
	private Map<String, AlgoritmoTransformacao> transformacoes;
	/**
	 * armazena a instância do Logger
	 */
	private Logger logger;
	
	/**
	 * registra momento
	 */
	private long momento; 
	
//_______________________construtores____________________________
	/**
	 * Construtor que inicia as operações
	 */
	public TransformaTexto() {
		this.contaTransformacao = 0;
		this.historico = new ArrayList<String>();
		this.originais = new HashSet<>();
		this.transformacoes = new HashMap<>();
		this.iniciaTranformacoesPadroes();
	}
	
	public TransformaTexto(Logger lg) {
		this.contaTransformacao = 0;
		this.historico = new ArrayList<String>();
		this.originais = new HashSet<>();
		this.transformacoes = new HashMap<>();
		this.iniciaTranformacoesPadroes();
		this.logger = lg;
		this.momento = System.currentTimeMillis();
	}

//_______________________métodos ________________________
	
	/**
	 * Método que instância os algoritmos e cadastra as tranformações padrões
	 */
	public void iniciaTranformacoesPadroes() {
		AlgoritmoTransformacao meuClean = new Clean();
		cadastraTransformacao("clean", meuClean);
		AlgoritmoTransformacao meuConverteInterrogacoesParaPontos = new ConverteInterrogacoesParaPontos();
		cadastraTransformacao("InterrogaPraPontos", meuConverteInterrogacoesParaPontos);
		AlgoritmoTransformacao meuUpperCase = new UpperCase();
		cadastraTransformacao("upperCase", meuUpperCase);
		AlgoritmoTransformacao meuCleanSpaces = new CleanSpaces();
		cadastraTransformacao("cleanSpaces", meuCleanSpaces);
		AlgoritmoTransformacao meuTrocaEspaco = new Troca_Espaco();
		cadastraTransformacao("troca_espaco", meuTrocaEspaco);
		AlgoritmoTransformacao meuCaMeLcAsEfY = new CaMeLcAsEfY();
		cadastraTransformacao("CaMeLcAsEfY", meuCaMeLcAsEfY);
	}
	
	/**
	 *cadastra as tranformações no mapa 
	 * @param transformacao
	 * @param meuAlgoritmo
	 */
	public void cadastraTransformacao(String transformacao, AlgoritmoTransformacao meuAlgoritmo) {
		this.transformacoes.put(transformacao, meuAlgoritmo);
	}
	
	/**
	 * realiza as transformações com os algoritmos armazenados no mapa
	 * @param transformacao
	 * @param texto
	 * @return a transformação do texto realizada pelo algoritmo escolhido
	 */
	public String transforma(String transformacao, String texto) {
		originais.add(texto);
		contaTransformacao+=1;
		AlgoritmoTransformacao algoritmo = this.transformacoes.get(transformacao);
		historico.add(texto+" "+transformacao+" -> "+algoritmo.transforma(texto));
		if (this.logger!=null) {
			long diferenca = System.currentTimeMillis() - this.momento;
			return this.logger.imprimeLogger(transformacao, diferenca, "transforma")+algoritmo.transforma(texto);
		}
		return algoritmo.transforma(texto);
	}
	
	/**
	 * retorna o valor de transformações realizadas 
	 * @return quantidade de vezes que foi realizado transformações
	 */
	public String contaTransformacao() {
		String numString = Integer.toString(this.contaTransformacao);
		if (this.logger!=null) {
			long diferenca = System.currentTimeMillis() - this.momento;
			return this.logger.imprimeLogger(numString, diferenca, "contaTransformacao")+numString;
		}
		return numString;
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public String historico(int index) {
		String numString = Integer.toString(index);
		if (this.logger!=null) {
			long diferenca = System.currentTimeMillis() - this.momento;
			return this.logger.imprimeLogger(numString, diferenca, "historico")+historico.get(index);
		}
		return historico.get(index);
	}
	
	/**
	 * lista textos originais 
	 * @return string com os textos utilizados sem repetição
	 */
	public String listarOriginais() {
		String saida = "";
		for (String original: originais) {
			saida += original+ System.lineSeparator();
		}
		return saida;
	}
	
	/**
	 * Lista as transformações do sistema
	 * primeiro é armazenado os nomes em uma lista 
	 * depois é ordenado a lista
	 * @return uma string com o nome de todas as transformações
	 */
	public String listarTransformacoes() {
		List<String> ordenarAlgoritmos = new ArrayList<>();
		
		for (AlgoritmoTransformacao algoritmo: this.transformacoes.values()) {
			ordenarAlgoritmos.add(algoritmo.getNome());
	    }

		String saida = "";
		Collections.sort(ordenarAlgoritmos);
		for (String transformacao: ordenarAlgoritmos) {
			saida += transformacao+ System.lineSeparator();
		}
		return saida;
	}
}
