package TestBiblitex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import BibliTeX.TransformaTexto;

class TestTransformaTexto {

private TransformaTexto tt;
	
	@BeforeEach
	void iniciaTransformacao() {
		this.tt = new TransformaTexto();
	}
	
	@Test
	void testTransformaCaMeLcAsEfY() {
		assertEquals(tt.transforma("CaMeLcAsEfY", "oi, como vc vai?"),"Oi, CoMo vC VaI?");
	}
	
	@Test
	void testTransformaclean() {
		assertEquals(tt.transforma("clean", "oi, como vc vai?"),"oi como vc vai");
	}
	
	@Test
	void testTransformaInterrogaPraPontos() {
		assertEquals(tt.transforma("InterrogaPraPontos", "oi, como vc vai?"),"oi, como vc vai.");
	}
	
	@Test
	void testTransformaupperCase() {
		assertEquals(tt.transforma("upperCase", "oi, como vc vai?"),"OI, COMO VC VAI?");
	}
	
	@Test
	void testTransformacleanSpaces() {
		assertEquals(tt.transforma("cleanSpaces", "oi, como vc vai?"),"oi,comovcvai?");
	}
	
	@Test
	void testContaTransformacao() {
		TransformaTexto transformac =  new TransformaTexto();
		transformac.transforma("clean", "oi, como vc vai?");
		transformac.transforma("clean", "oi, como vc vai?");
		assertEquals(transformac.contaTransformacao(), "2");
	}

	@Test
	void testHistorico() {
		tt.transforma("CaMeLcAsEfY", "oi, como vc vai?");
		assertEquals(tt.historico(0), "oi, como vc vai? CaMeLcAsEfY -> Oi, CoMo vC VaI?");
	}

	@Test
	void testListarOriginais() {
		TransformaTexto transforma =  new TransformaTexto();
		transforma.transforma("clean", "Oi, como vc vai?");
		assertEquals(transforma.listarOriginais(), "Oi, como vc vai?\n");
	}

	@Test
	void testListarTransformacoes() {
		TransformaTexto transforma =  new TransformaTexto();
		assertEquals(transforma.listarTransformacoes(), "CaMeLcAsEfY\n"+"ConverteInterrogacoesParaPontos\n"+"clean\n"+"cleanSpaces\n"+"troca_espaco\n"+"upperCase\n");
	}

}
