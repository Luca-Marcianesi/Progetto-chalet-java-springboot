package ProgettoOOP.chalet;

	import static org.junit.jupiter.api.Assertions.*;
	import org.junit.jupiter.api.AfterEach;
	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;
	import org.springframework.boot.test.context.SpringBootTest;
	import ProgettoOOP.chalet.Model.OtherClass.*;

	@SpringBootTest
	public class TestSuiLogin {

			Chalet chalet = new Chalet();
			
			
			@BeforeEach
			 void setUp() {
				chalet.server.creaAccount("luca", "ciao");
			}
			
			@AfterEach
			void tearDown() {
				
			}

			@Test
			void test() {
				assertTrue(chalet.server.login("admin", "admin"));
				assertTrue(chalet.server.login("luca", "ciao"));
			}
			
			@Test
			void test2() {
				assertFalse(chalet.server.login("luca", "hello"));
			}

		}

