package BibliTeX;
/**
 * Tranformação
 * @author vanderson
 *
 */
public class CaMeLcAsEfY implements AlgoritmoTransformacao{

	private String nome;
	
	/**
	 * construtor 
	 */
	public CaMeLcAsEfY(){
		this.nome = "CaMeLcAsEfY";
	}
	
	/**
	 * método que válida entradas
	 * @param entrada
	 */
	private void validacao(String entrada) {
		if (entrada == null) {
			throw new NullPointerException("ENTRADA NULA NÃO PODE!");
		}else if(entrada.isBlank()) {
			throw new IllegalArgumentException("ENTRADA VAZIA!");
		}
	}
	
	/**
	 * Transforma letras em maisculas e minusculas
	 */
	@Override
	public String transforma(String original) {
		validacao(original);
		String novaString = "";
		String[] letras = original.split("");
		for (int i=0; i<letras.length; i++) {
			if (i%2==0) {
				novaString += letras[i].toUpperCase();
			}
			else {
				novaString += letras[i].toLowerCase();
			}
		}
		return novaString;
	}

	/**
	 * metodo para acessra o nome da trasnformação
	 */
	@Override
	public String getNome() {
		return this.nome;
	}
	
	

}
