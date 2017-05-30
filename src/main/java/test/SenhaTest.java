package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.CorInvalidaException;
import exceptions.PosicaoInvalidaException;
import jogo.Senha;

public class SenhaTest {

	private static Senha senha;
	Senha senhaNaoSetada;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		senha = new Senha();
	}
	
	@Before
	public void setUp(){
		String[] pinos = {"azul","amarelo","roxo","verde"}; 
		senha.setSenha(pinos);
		senhaNaoSetada = new Senha();
	}
	 
	@Test
	public void testaInicializaoSenha() throws PosicaoInvalidaException{
		assertEquals("nenhum", senhaNaoSetada.getPino(0));
		assertEquals("nenhum", senhaNaoSetada.getPino(1));
		assertEquals("nenhum", senhaNaoSetada.getPino(2));
		assertEquals("nenhum", senhaNaoSetada.getPino(3));
	}
	
	@Test
	public void testaAdicinarPinoSucesso() throws CorInvalidaException, PosicaoInvalidaException{
		senhaNaoSetada.adicionarPino("azul");
		assertEquals("azul", senhaNaoSetada.getPino(0));
		assertEquals("nenhum", senhaNaoSetada.getPino(1));
		assertEquals("nenhum", senhaNaoSetada.getPino(2));
		assertEquals("nenhum", senhaNaoSetada.getPino(3));
		senhaNaoSetada.adicionarPino("amarelo");
		assertEquals("azul", senhaNaoSetada.getPino(0));
		assertEquals("amarelo", senhaNaoSetada.getPino(1));
		assertEquals("nenhum", senhaNaoSetada.getPino(2));
		assertEquals("nenhum", senhaNaoSetada.getPino(3));
		senhaNaoSetada.adicionarPino("verde");
		assertEquals("azul", senhaNaoSetada.getPino(0));
		assertEquals("amarelo", senhaNaoSetada.getPino(1));
		assertEquals("verde", senhaNaoSetada.getPino(2));
		assertEquals("nenhum", senhaNaoSetada.getPino(3));
		senhaNaoSetada.adicionarPino("roxo");
		assertEquals("azul", senhaNaoSetada.getPino(0));
		assertEquals("amarelo", senhaNaoSetada.getPino(1));
		assertEquals("verde", senhaNaoSetada.getPino(2));
		assertEquals("roxo", senhaNaoSetada.getPino(3));
	}
	
	@Test(expected=CorInvalidaException.class)
	public void testeCorInvalida() throws CorInvalidaException{
		senhaNaoSetada.adicionarPino("azul");
		senhaNaoSetada.adicionarPino("vinho");
	}
	
	@Test
	public void testaPosicaoCorreta() throws PosicaoInvalidaException{
		assertEquals("azul", senha.getPino(0));
		assertEquals("amarelo", senha.getPino(1));
		assertEquals("roxo", senha.getPino(2));
		assertEquals("verde", senha.getPino(3));
	}
	
	@Test(expected=PosicaoInvalidaException.class)
	public void testaPosicaoUnderFlow() throws PosicaoInvalidaException{
		senha.getPino(-1);
	}
	
	@Test(expected=PosicaoInvalidaException.class)
	public void testaPosicaoOverFlow() throws PosicaoInvalidaException{
		senha.getPino(4);
	}
	
	@Test
	public void testaQuantidade() throws CorInvalidaException{
		assertEquals(4, senha.getPinosInseridos());
		assertEquals(0, senhaNaoSetada.getPinosInseridos());
		senhaNaoSetada.adicionarPino("azul");
		assertEquals(1, senhaNaoSetada.getPinosInseridos());
		senhaNaoSetada.adicionarPino("amarelo");
		assertEquals(2, senhaNaoSetada.getPinosInseridos());
		senhaNaoSetada.adicionarPino("verde");
		assertEquals(3, senhaNaoSetada.getPinosInseridos());
		senhaNaoSetada.adicionarPino("roxo");
		assertEquals(4, senhaNaoSetada.getPinosInseridos());
	}

}
