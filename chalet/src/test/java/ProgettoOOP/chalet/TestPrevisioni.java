package ProgettoOOP.chalet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ProgettoOOP.chalet.Model.OtherClass.*;



@SpringBootTest
public class TestPrevisioni {
	UsaApi a  = new UsaApi() ;
	Previsioni previsioneOggi;
	Previsioni previsioneGiorno;
	LocalDate oggi = LocalDate.now();
	LocalDate giornoPassato =  LocalDate.of(2020, 12, 2);
	
	@BeforeEach
	 void setUp() {
		previsioneOggi = a.valorizzaPrevisione(oggi);
		previsioneGiorno = a.valorizzaPrevisione(giornoPassato);
	}
	
	@AfterEach
	void tearDown() {
		
	}

	@Test
	void test() {
		assertEquals("Bel tempo",previsioneOggi.getPrincipale());
	}
	
	@Test
	void test2() {
		assertEquals("Previsioni non disponibili",previsioneGiorno.getPrincipale());
	}

}




