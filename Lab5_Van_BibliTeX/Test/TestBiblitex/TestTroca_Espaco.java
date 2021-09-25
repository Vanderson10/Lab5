package TestBiblitex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BibliTeX.AlgoritmoTransformacao;
import BibliTeX.Troca_Espaco;

class TestTroca_Espaco {

	private AlgoritmoTransformacao at;

	@BeforeEach
	void iniciaTransformacao() {
		this.at = new Troca_Espaco();
	}
	
	@Test
	void testTransformaCaMeLcAsEfY() {
		System.out.println(at.transforma("oi, como vc vai?"));
	}
	
	@Test
	void testTransformaTextoNull() {
		try {
			at.transforma(null);
			fail("É NULO");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
}
	
	@Test
	void testTransformaTextoVazio() {
		try {
			at.transforma("");
			fail("É vazio e não pode");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
