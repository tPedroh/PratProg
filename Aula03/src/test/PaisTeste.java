package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PaisTeste {
	class TestePais {

		Pais pais = new Pais();
		Pais copia = new Pais();
		static int id = 1;
		
		@BeforeEach
		void setUp() throws Exception {
			System.out.println("setup");
			pais = new Pais(id, "Russia", 999999, 999999);
			copia = new Pais(id, "Mexico", 1111, 1111 );
			System.out.println(pais);
			System.out.println(copia);
			System.out.println(id);
		}
		
		@Test
		public void Carregar() {
			System.out.println("carregar");
			Pais fixture = new Pais(1, "Brasil", 15125121,
			512512412);
			Pais novo = new Pais(1, null, 0, 0);
			novo.carregar();
			assertEquals("testa inclusao", novo, fixture);
		}
		
		@Test
		public void Criar() {
			System.out.println("criar");
			pais.criar();
			id = pais.getId();
			System.out.println(id);
			copia.setId(id);
			assertEquals("testa criacao", pais, copia);
		}
		
		@Test
		public void Atualizar() {
			System.out.println("atualizar");
			pais.setPopulacao(999999);
			copia.setPopulacao(1111);
			pais.atualizar();
			pais.carregar();
			assertEquals("testa atualizacao", pais, copia);
		}
		
		@Test
		public void Excluir() {
			System.out.println("excluir");
			copia.setId(-1);
			copia.setNome("");
			copia.setPopulacao(0);
			copia.setArea(0);
			pais.excluir();
			pais.carregar();
			assertEquals("testa exclusao", pais, copia);
		}
	}
	


}
