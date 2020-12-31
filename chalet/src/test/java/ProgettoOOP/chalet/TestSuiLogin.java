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
				chalet.server.Crea_Account("luca", "ciao");
			}
			
			@AfterEach
			void tearDown() {
				
			}

			@Test
			void test() {
				assertTrue(chalet.server.Login("admin", "admin"));
				assertTrue(chalet.server.Login("luca", "ciao"));
			}
			
			@Test
			void test2() {
				assertFalse(chalet.server.Login("luca", "hello"));
			}

		}

